package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBusinessBotCallbackQuery#1ea2fda7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBusinessBotCallbackQuery() : TLAbsUpdate() {
    var queryId: Long = 0L

    var userId: Long = 0L

    var connectionId: String = ""

    var message: TLAbsMessage = TLMessageEmpty()

    var replyToMessage: TLAbsMessage? = null

    var chatInstance: Long = 0L

    var data: TLBytes? = null

    private val _constructor: String = "updateBusinessBotCallbackQuery#1ea2fda7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            userId: Long,
            connectionId: String,
            message: TLAbsMessage,
            replyToMessage: TLAbsMessage?,
            chatInstance: Long,
            data: TLBytes?
    ) : this() {
        this.queryId = queryId
        this.userId = userId
        this.connectionId = connectionId
        this.message = message
        this.replyToMessage = replyToMessage
        this.chatInstance = chatInstance
        this.data = data
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(replyToMessage, 4)
        updateFlags(data, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        writeLong(userId)
        writeString(connectionId)
        writeTLObject(message)
        doIfMask(1, replyToMessage, 4) { writeTLObject(it) }
        writeLong(chatInstance)
        doIfMask(1, data, 1) { writeTLBytes(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        queryId = readLong()
        userId = readLong()
        connectionId = readString()
        message = readTLObject<TLAbsMessage>()
        replyToMessage = readIfMask(1, 4) { readTLObject<TLAbsMessage>() }
        chatInstance = readLong()
        data = readIfMask(1, 1) { readTLBytes() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(connectionId)
        size += message.computeSerializedSize()
        size += getIntIfMask(1, replyToMessage, 4) { it.computeSerializedSize() }
        size += SIZE_INT64
        size += getIntIfMask(1, data, 1) { computeTLBytesSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBusinessBotCallbackQuery) return false
        if (other === this) return true

        return _flags == other._flags
                && queryId == other.queryId
                && userId == other.userId
                && connectionId == other.connectionId
                && message == other.message
                && replyToMessage == other.replyToMessage
                && chatInstance == other.chatInstance
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1ea2fda7.toInt()
    }
}
