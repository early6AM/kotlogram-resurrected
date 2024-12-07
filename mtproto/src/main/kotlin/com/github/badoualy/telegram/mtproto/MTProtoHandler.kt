package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.AuthKeyInvalidException
import com.github.badoualy.telegram.mtproto.exception.ContainerInvalidException
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.net.MTProtoConnectionFactory
import com.github.badoualy.telegram.mtproto.net.MTProtoTcpConnectionFactory
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLApiContext
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import com.github.badoualy.telegram.tl.serialization.TLSerializerFactory
import com.github.badoualy.telegram.tl.serialization.TLStreamSerializerFactory
import com.github.badoualy.telegram.tl.stream.readConstructorId
import com.github.badoualy.telegram.tl.stream.readInt
import com.github.badoualy.telegram.tl.stream.toHexString
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import java.io.IOException
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

class MTProtoHandler {

    private var connection: MTProtoConnection
    var authKey: AuthKey
        private set
    var session: MTSession
        private set

    private val requestByIdMap = ConcurrentHashMap<Long, TLMethod<*>>(10)
    private val sentMessageList = CopyOnWriteArrayList<MTProtoMessage>()
    private var ackBuffer = MTBuffer<Long>(ACK_BUFFER_SIZE, ACK_BUFFER_TIMEOUT, TimeUnit.SECONDS)

    private var messageSubject: Subject<Pair<MTProtoMessage, TLObject>> =
        PublishSubject.create<Pair<MTProtoMessage, TLObject>>().toSerialized()
    private var updateSubject: Subject<TLAbsUpdates> = PublishSubject.create<TLAbsUpdates>().toSerialized()
    private var rpcResultSubject: Subject<MTRpcResult> = PublishSubject.create<MTRpcResult>().toSerialized()
    private val compositeDisposable = CompositeDisposable()

    private val tag: LogTag
        get() = session.tag

    /** An observable emitting an item for each received [TLAbsUpdates] */
    val updatesObservable: Observable<TLAbsUpdates>
        get() = updateSubject.hide()

    internal val rpcResultObservable: Observable<MTRpcResult>
        get() = rpcResultSubject.hide()

    constructor(authResult: AuthResult) {
        authKey = authResult.authKey
        connection = authResult.connection
        session = newSession(connection.dataCenter)
        session.salt = authResult.serverSalt
        connection.tag = session.tag
        ackBuffer.tag = session.tag
        println("${Thread.currentThread().id} $tag Created from auth result ${authKey.keyIdAsLong}")
    }

    @Throws(IOException::class)
    constructor(dataCenter: DataCenter, authKey: AuthKey, session: MTSession?) {
        this.authKey = authKey
        this.session = session ?: newSession(dataCenter)
        connection = connectionFactory.create(dataCenter, this.session.tag)
        ackBuffer.tag = this.session.tag
        println("${Thread.currentThread().id} $tag Created from existing key (new session? ${session == null}}  ${authKey.keyIdAsLong}")
    }

    /** Start listening for incoming messages. You need to call this before executing any method */
    fun start() {
        if (messageSubject.hasObservers()) {
            println("${Thread.currentThread().id} $tag Handler already started")
            return
        }

        println("${Thread.currentThread().id} $tag startWatchdog()")
        connection.getMessageObservable()
            .observeOn(Schedulers.computation())
            .flatMap {
                flatMapMessage(it)
            }
            .map {
                deserializePayload(it)
            }
            .subscribeBy(
                onError = messageSubject::onError,
                onComplete = messageSubject::onComplete,
                onNext = messageSubject::onNext
            )
            .let(compositeDisposable::add)

        messageSubject
            .observeOn(Schedulers.computation())
            .subscribeBy(
                onNext = onMessageReceived(),
                onError = {
                    System.err.println("${Thread.currentThread().id} $tag messageSubject onErrorReceived() $it")
                    // TODO: enable?
                    resetConnection()
                },
                onComplete = {
                    println("${Thread.currentThread().id} $tag messageSubject onComplete()")
                })
            .let { compositeDisposable.add(it) }

        ackBuffer.observable
            .map { newAckMessage(it) }
            .observeOn(Schedulers.io())
            .subscribeBy(onNext = { sendMessage(it) })
            .let { compositeDisposable.add(it) }
    }

    /** Closes the connection and re-open another one immediately, this should fix most connection issues */
    fun resetConnection() {
        println("${session.tag} resetConnection()")
        close()

        session = newSession(connection.dataCenter)
        connection = connectionFactory.create(connection.dataCenter, session.tag)
        messageSubject = PublishSubject.create()
        start()
    }

    /** Closes the connection and associated resources. The handler can still be used after being closed. */
    fun close() {
        println("${Thread.currentThread().id} $tag close()")
        dispose() // Dispose before closing to avoid propagating errors!
        connection.close()

        requestByIdMap.clear()
        sentMessageList.clear()
        ackBuffer.reset()
        println("${Thread.currentThread().id} $tag close() full")
    }

    private fun dispose() {
        compositeDisposable.clear()
        if (messageSubject.hasObservers()) {
            messageSubject.onComplete() // Завершить только если есть подписчики
        }
    }

    @Deprecated(message = "TO REMOVE", replaceWith = ReplaceWith("rx"))
    fun <T : TLObject> executeMethodSync(method: TLMethod<T>): T =
        executeMethod(method).blockingGet()

    @Deprecated(message = "TO REMOVE", replaceWith = ReplaceWith("rx"))
    fun <T : TLObject> executeMethodsSync(methods: List<TLMethod<T>>): List<T> =
        executeMethods(methods).blockingIterable().toList()

    /**
     * @return a Single emitting the response upon success.
     * The rpc call will be made only when subscribing to the returned [Single]
     */
    fun <T : TLObject> executeMethod(method: TLMethod<T>): Single<T> = executeMethods(
        listOf(method)
    ).singleOrError()

    /**
     * @return an [Observable] emitting one object per method (the original ordered is not assured!!)
     * or throwing an [RpcErrorException] if an error was returned.
     * The rpc call will be made only when subscribing to the returned [Observable]
     */
    fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T> {
        println("${Thread.currentThread().id} methods for observable $methods")
        try {
            return methods.takeIf {
                println("${Thread.currentThread().id} check is not empty: $it")
                it.isNotEmpty()
            }?.let {
                rpcResultSubject
                    .filter { methods.contains(requestByIdMap[it.messageId]) }
                    .take(methods.size.toLong())
                    .doOnSubscribe { executeMethods_(methods) }
                    .subscribeOn(Schedulers.io())
                    .flatMapMaybe {
                        try {
                            mapResult(it)
                        } catch (e: RpcErrorException) {
                            System.err.println("${Thread.currentThread().id} $tag mapResult() error: $e")
                            if (e.code == 420) {
                                System.err.println("${Thread.currentThread().id} $tag Too many requests, retrying...")
                                Observable.timer(5, TimeUnit.SECONDS)
                                    .blockingSubscribe()
                                executeMethods_(methods)
                            }
                            Maybe.empty()
                        }
                    }
                    .sorted { o1, o2 ->
                        val index1 = methods.indexOfFirst { it.response === o1 }
                        val index2 = methods.indexOfFirst { it.response === o2 }
                        Integer.compare(index1, index2)
                    }
                    .map {
                        @Suppress("UNCHECKED_CAST")
                        it as T
                    }
            } ?: Observable.empty<T>()
        } catch (e: java.util.NoSuchElementException) {
            System.err.println("executeMethods() catch exception and we don't know $methods")
            throw e
        }
    }

    /** Runs the code to execute the given methods (actually sends them NOW) */
    private fun executeMethods_(methods: List<TLMethod<*>>) {
        println("${Thread.currentThread().id} executeMethods ${methods.joinToString { it.toString() }}")

        val messages = ArrayList<MTProtoMessage>(methods.size)

        // Methods
        methods.mapTo(messages) { newMethodMessage(it) }

        // Add ACK messages
        messages.add(getAckMessage())

        // Queue method
        messages.addAll(getQueuedToSend())

        // Wrap in container or send as single
        val message =
            if (messages.size > 1) {
                println("${Thread.currentThread().id} Sending container with ${messages.size} items")
                newMessage(MTMessagesContainer(messages))
            } else {
                println("${Thread.currentThread().id} $tag Sending only one message")
                messages.firstOrNull()
            }

        message?.let { sendMessage(it) }
    }

    /** Sends the given [MTProtoMessage] after encrypting it */
    @Throws(IOException::class)
    private fun sendMessage(message: MTProtoMessage) {
        println("${Thread.currentThread().id} $tag Sending message with msgId ${message.messageId} and seqNo ${message.seqNo}")

        val encryptedMessage = MTProtoMessageEncryption.generateEncryptedMessage(
            authKey,
            session.id,
            session.salt,
            message
        )

        sendMessage(encryptedMessage.data)
        sentMessageList.add(message)
    }

    /** Sends the given [ByteArray] message as is*/
    @Throws(IOException::class)
    internal fun sendMessage(message: ByteArray) {
        println("${Thread.currentThread().id} sendMessage() as ${message.readConstructorId()}")
        connection.sendMessage(message)
    }

    /**
     * Resends the message sent with the given messageId (generating a new message id if needed)
     * @param messageId id of the message to resend
     * @param updateMessageId if true the message id will be updated, else the same message id is kept
     */
    @Throws(IOException::class)
    @Synchronized
    private fun resendMessage(messageId: Long, updateMessageId: Boolean) {
        println("${Thread.currentThread().id} resendMessage $messageId")

        val sentMessage = sentMessageList.firstOrNull { it.messageId == messageId }
        if (sentMessage != null) {
            if (updateMessageId) {
                // Update map and generate new msgId
                val request = requestByIdMap.remove(sentMessage.messageId)
                sentMessage.messageId = session.generateMessageId()
                request?.let { requestByIdMap.put(sentMessage.messageId, it) }
            }

            println("${Thread.currentThread().id} ${tag} Re-sending message $messageId with msgId ${sentMessage.messageId}")
            sendMessage(sentMessage)
        } else {
            println("${Thread.currentThread().id} $tag Couldn't find sentMessage in history with msgId $messageId")
        }
    }

    /**
     * Transforms a received message (network message) into an Observable of [MTProtoMessage].
     * Data received from Telegram can be a [MTMessagesContainer] containing multiple [MTProtoMessage].
     * This function will map the data received into an observable emitting 1 item per [MTProtoMessage].
     *
     * - If the message payload is a container, the observable will emit each contained messages
     * - If the message payload is not a container, the observable will emit the message
     * - If the AUTH_KEY_INVALID error is received, an [AuthKeyInvalidException] will be thrown
     * - If any other error occurs at some point, the observable will emit nothing
     *
     * @return an observable emitting zero to multiple [MTProtoMessage], each being guaranteed to not be a [MTMessagesContainer].
     */
    @Throws(AuthKeyInvalidException::class)
    private fun flatMapMessage(bytes: ByteArray): Observable<MTProtoMessage> {
        if (bytes.size == 4)
            throw AuthKeyInvalidException(bytes.readInt())

        return try {
            val message = MTProtoMessageEncryption.extractMessage(authKey, session.id, bytes)
            println("${Thread.currentThread().id} $tag Received msg ${message.messageId} with seqNo ${message.seqNo}")

            when (message.payload.readConstructorId()) {
                MTMessagesContainer.CONSTRUCTOR_ID -> {
                    val container = readTLObject(
                        message.payload, mtProtoContext,
                        MTMessagesContainer::class,
                        MTMessagesContainer.CONSTRUCTOR_ID
                    )
                    println("${Thread.currentThread().id} $tag Container has ${container.messages.size} items")

                    // Ensure valid container
                    container.messages.toList().foldRight(message.messageId, { m, id ->
                        m.messageId.takeIf { it < id } ?: throw ContainerInvalidException(container)
                    })

                    container.messages.toObservable()
                }

                else -> Observable.just(message)
            }
        } catch (e: Exception) {
            // This is not a terminal event, don't kill observable
            println("${Thread.currentThread().id} $tag Error while extracting message $e")
            println("${Thread.currentThread().id} $tag Dump:\n" + bytes.toHexString())
            Observable.empty<MTProtoMessage>()
        }
    }

    /**
     * @return a function that handles a received [MTProtoMessage] to a [Pair] of the same
     * [MTProtoMessage] and its deserialized [TLObject] content
     */
    private fun deserializePayload(message: MTProtoMessage): Pair<MTProtoMessage, TLObject> {
        val clazzId = message.payload.readConstructorId()
        println("${Thread.currentThread().id} ${session.tag} Payload: #${message.payload}")
        println("${Thread.currentThread().id} ${session.tag} Payload constructor id: #${Integer.toHexString(clazzId)}")

        val context =
            if (mtProtoContext.contains(clazzId)) {
                println("${Thread.currentThread().id} $tag $clazzId is supported by MTProtoContext")
                mtProtoContext
            } else {
                println("${Thread.currentThread().id} $tag $clazzId is not supported by MTProtoContext")
                apiContext
            }

        return Pair(message, readTLObject(message.payload, context))
    }

    /**
     * @return a function that handles the received messages.
     * - Queue the ack if needed
     * - Propagate the updates if it is one
     * - Handles bad messages
     */
    @Throws(IOException::class)
    private fun onMessageReceived(): (Pair<MTProtoMessage, TLObject>) -> Unit = { (message, payload) ->
        println("${Thread.currentThread().id} $tag handle $payload")

        when (payload) {
            is MTMsgsAck -> {
                // TODO: MessageACK will not get an ack, it'll stack in sentMessageList...
                sentMessageList.removeAll { payload.messages.contains(it.messageId) }
                println("${Thread.currentThread().id} $tag Received ack for ${payload.messages.joinToString()}")
            }

            is MTRpcResult -> {
                queueMessageAck(message.messageId)
                rpcResultSubject.onNext(payload)
            }

            is TLAbsUpdates -> {
                queueMessageAck(message.messageId)
                updateSubject.onNext(payload)
            }

            is MTNewSessionCreated -> {
                //session.salt = messageContent.serverSalt
                queueMessageAck(message.messageId)
            }

            is MTBadMessageNotification -> {
                handleBadMessage(payload, message)
            }

            is MTBadServerSalt -> {
                println("${Thread.currentThread().id} $tag ${payload.toPrettyString()}")

                // Message contains a good salt to use
                session.salt = payload.newSalt
                resendMessage(payload.badMsgId, false)
            }

            is MTNeedResendMessage -> {
                println("${Thread.currentThread().id} $tag TODO MTNeedResendMessage")
                // TODO
            }

            is MTNewMessageDetailedInfo -> {
                println("${Thread.currentThread().id} $tag TODO MTNewMessageDetailedInfo")
                // TODO
            }

            is MTMessageDetailedInfo -> {
                println("${Thread.currentThread().id} $tag TODO MTMessageDetailedInfo")
                // TODO
            }

            is MTFutureSalts -> {
                println("${Thread.currentThread().id} $tag TODO MTFutureSalts")
                // TODO
            }

            else -> println("${Thread.currentThread().id} $tag Unsupported constructor in handleMessage() $payload")
        }
    }

    /**
     * @return a function mapping the a [MTRpcResult] to its result content.
     * Or throw an exception if an error is received instead of the response
     * @throws RpcErrorException if the result is a [MTRpcError]
     */
    @Throws(RpcErrorException::class)
    internal fun mapResult(result: MTRpcResult): Maybe<out TLObject> {
        println("${Thread.currentThread().id} $tag Got result for msgId ${result.messageId}")

        val request =
            if (requestByIdMap.containsKey(result.messageId)) {
                requestByIdMap.remove(result.messageId)!!
            } else {
                println("${Thread.currentThread().id} $tag No request found for msgId ${result.messageId}")
                null
            }

        val clazzId = result.content.readConstructorId()
        println("${Thread.currentThread().id} $tag Response constructor id: #${Integer.toHexString(clazzId)}")

        val resultObject = when {
            mtProtoContext.contains(clazzId) -> {
                val content = readTLObject<TLObject>(result.content, mtProtoContext)
                if (content is MTRpcError) {
                    println("${Thread.currentThread().id} ${tag} rpcError ${content.code}: ${content.message}")
                    throw RpcErrorException(content.code, content.message)
                } else {
                    println("${Thread.currentThread().id} $tag Unsupported content $content")
                    null
                }
            }

            request != null -> request.deserializeResponse(result.content, apiContext)
            else -> {
                // Fallback, this will error if object is a non-TLObject vector (int, long, String)
                println("${Thread.currentThread().id} $tag Attempting to deserialize without knowing the type")
                readTLObject(result.content, apiContext)
            }
        }

        println("${Thread.currentThread().id} result: $resultObject")
        return resultObject?.let { Maybe.just(it) } ?: Maybe.empty()
    }

    /**
     * Handles the given badMessage with the appropriate behavior.
     * This method may resend the bad message with fixed parameters, or just ignore it.
     * @param badMessage object received from Telegram
     * @param container the message received from Telegram
     */
    @Throws(IOException::class)
    private fun handleBadMessage(badMessage: MTBadMessageNotification, container: MTProtoMessage) {
        println("${Thread.currentThread().id} $tag ${badMessage.toPrettyString()}")

        when (badMessage.errorCode) {
            MTBadMessage.ERROR_MSG_ID_TOO_LOW, MTBadMessage.ERROR_MSG_ID_TOO_HIGH -> {
                session.lastMessageId = 0
                TimeOverlord.synchronizeTime(connection.dataCenter, container.messageId)

                // Resend message with good id
                resendMessage(badMessage.badMsgId, true)
            }

            MTBadMessage.ERROR_SEQNO_TOO_LOW, MTBadMessage.ERROR_SEQNO_TOO_HIGH -> {
                if (badMessage.errorCode == MTBadMessage.ERROR_MSG_ID_TOO_LOW)
                    session.contentRelatedCount++
                else
                    session.contentRelatedCount--

                // Resend message with good seqno
                resendMessage(badMessage.badMsgId, true)
            }

            MTBadMessage.ERROR_SEQNO_EXPECTED_EVEN -> {
                // Should never happen
                println("${Thread.currentThread().id} $tag ERROR_SEQNO_EXPECTED_EVEN for ${badMessage.badMsgId}")
            }

            MTBadMessage.ERROR_SEQNO_EXPECTED_ODD -> {
                // Should never happen
                println("${Thread.currentThread().id} $tag ERROR_SEQNO_EXPECTED_ODD for ${badMessage.badMsgId}")
            }

            MTBadMessage.ERROR_MSG_ID_MODULO -> {
                // Should never happen
                println("${Thread.currentThread().id} $tag ERROR_MSG_ID_MODULO for ${badMessage.badMsgId}")
            }

            else -> println("${Thread.currentThread().id} $tag Unknown error ${badMessage.toPrettyString()}")
        }
    }

    /** Add the given message id to the queue to be acknowledged to Telegram */
    private fun queueMessageAck(id: Long) {
        ackBuffer.add(id)
    }

    /** @return a [MTProtoMessage] with a [MTMsgsAck] payload for all the message ids waiting to be ack to Telegram */
    private fun getAckMessage(): MTProtoMessage = newAckMessage(ackBuffer.get())

    /** @return queued [MTProtoMessage] waiting to be sent with the next request */
    private fun getQueuedToSend(): List<MTProtoMessage> {
        // TODO
        return emptyList()
    }

    /** @return a new session for the given [DataCenter] (with no salt, reset seqno value ...) */
    private fun newSession(dataCenter: DataCenter) = MTSession(dataCenter).also {
        println("${Thread.currentThread().id} ${it.tag} New session created")
    }

    /** @return a [MTProtoMessage] with a [MTMsgsAck] payload for the given message ids */
    private fun newAckMessage(idList: List<Long>) = newMessage(MTMsgsAck(idList.toLongArray()))

    /** @return a [MTProtoMessage] with the given [TLMethod] as a payload */
    private fun newMethodMessage(method: TLMethod<*>) = newMessage(method).also {
        println("${Thread.currentThread().id} $tag Sending $method with msgId ${it.messageId} and seqNo ${it.seqNo}")
        requestByIdMap.put(it.messageId, method)
    }

    /** @return a [MTProtoMessage] with the given [TLObject] as a payload */
    private fun newMessage(payload: TLObject) = MTProtoMessage(
        session.generateMessageId(),
        session.generateSeqNo(payload),
        payload.serialize()
    )

    companion object {

        private const val ACK_BUFFER_SIZE = 30
        private const val ACK_BUFFER_TIMEOUT = 5L

        private val mtProtoContext = MTProtoContext
        private val apiContext = TLApiContext

        private val connectionFactory: MTProtoConnectionFactory = MTProtoTcpConnectionFactory
        private val tlSerializerFactory: TLSerializerFactory = TLStreamSerializerFactory

        /** Convenience method to create a [com.github.badoualy.telegram.tl.serialization.TLDeserializer] and read a [TLObject] from it */
        private inline fun <reified T : TLObject> readTLObject(payload: ByteArray, context: TLContext): T =
            tlSerializerFactory.createDeserializer(payload, context).readTLObject()

        /** Convenience method to create a [com.github.badoualy.telegram.tl.serialization.TLDeserializer] and read a [TLObject] from it */
        private inline fun <reified T : TLObject> readTLObject(
            payload: ByteArray,
            context: TLContext,
            expectedClazz: KClass<T>?,
            expectedConstructorId: Int
        ): T =
            tlSerializerFactory.createDeserializer(payload, context)
                .readTLObject(expectedClazz, expectedConstructorId)
    }
}