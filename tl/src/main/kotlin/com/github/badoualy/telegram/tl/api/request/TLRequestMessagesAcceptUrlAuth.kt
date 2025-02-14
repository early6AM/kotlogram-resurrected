package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUrlAuthResult
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesAcceptUrlAuth() : TLMethod<TLAbsUrlAuthResult>() {
    @Transient
    var writeAllowed: Boolean = false

    var peer: TLAbsInputPeer? = null

    var msgId: Int? = null

    var buttonId: Int? = null

    var url: String? = null

    private val _constructor: String = "messages.acceptUrlAuth#b12c7125"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ) : this() {
        this.writeAllowed = writeAllowed
        this.peer = peer
        this.msgId = msgId
        this.buttonId = buttonId
        this.url = url
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(writeAllowed, 1)
        updateFlags(peer, 2)
        updateFlags(msgId, 2)
        updateFlags(buttonId, 2)
        updateFlags(url, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(peer, 2) { writeTLObject(it) }
        doIfMask(msgId, 2) { writeInt(it) }
        doIfMask(buttonId, 2) { writeInt(it) }
        doIfMask(url, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        writeAllowed = isMask(1)
        peer = readIfMask(2) { readTLObject<TLAbsInputPeer>() }
        msgId = readIfMask(2) { readInt() }
        buttonId = readIfMask(2) { readInt() }
        url = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(peer, 2) { it.computeSerializedSize() }
        size += getIntIfMask(msgId, 2) { SIZE_INT32 }
        size += getIntIfMask(buttonId, 2) { SIZE_INT32 }
        size += getIntIfMask(url, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesAcceptUrlAuth) return false
        if (other === this) return true

        return _flags == other._flags
                && writeAllowed == other.writeAllowed
                && peer == other.peer
                && msgId == other.msgId
                && buttonId == other.buttonId
                && url == other.url
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb12c7125.toInt()
    }
}
