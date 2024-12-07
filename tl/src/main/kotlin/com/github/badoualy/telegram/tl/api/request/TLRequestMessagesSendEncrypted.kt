package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.core.TLBytes
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
class TLRequestMessagesSendEncrypted() : TLMethod<TLAbsSentEncryptedMessage>() {
    @Transient
    var silent: Boolean = false

    var peer: TLInputEncryptedChat = TLInputEncryptedChat()

    var randomId: Long = 0L

    var data: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "messages.sendEncrypted#44fa7a15"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ) : this() {
        this.silent = silent
        this.peer = peer
        this.randomId = randomId
        this.data = data
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(silent, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeLong(randomId)
        writeTLBytes(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(1, 1)
        peer = readTLObject<TLInputEncryptedChat>(TLInputEncryptedChat::class, TLInputEncryptedChat.CONSTRUCTOR_ID)
        randomId = readLong()
        data = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendEncrypted) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && peer == other.peer
                && randomId == other.randomId
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x44fa7a15.toInt()
    }
}
