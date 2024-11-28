package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesProlongWebView() : TLMethod<TLBool>() {
    @Transient
    var silent: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var queryId: Long = 0L

    var replyTo: TLAbsInputReplyTo? = null

    var sendAs: TLAbsInputPeer? = null

    private val _constructor: String = "messages.prolongWebView#b0d81a83"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            queryId: Long,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ) : this() {
        this.silent = silent
        this.peer = peer
        this.bot = bot
        this.queryId = queryId
        this.replyTo = replyTo
        this.sendAs = sendAs
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(replyTo, 1)
        updateFlags(sendAs, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(bot)
        writeLong(queryId)
        doIfMask(replyTo, 1) { writeTLObject(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        peer = readTLObject<TLAbsInputPeer>()
        bot = readTLObject<TLAbsInputUser>()
        queryId = readLong()
        replyTo = readIfMask(1) { readTLObject<TLAbsInputReplyTo>() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += bot.computeSerializedSize()
        size += SIZE_INT64
        size += getIntIfMask(replyTo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesProlongWebView) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && peer == other.peer
                && bot == other.bot
                && queryId == other.queryId
                && replyTo == other.replyTo
                && sendAs == other.sendAs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb0d81a83.toInt()
    }
}
