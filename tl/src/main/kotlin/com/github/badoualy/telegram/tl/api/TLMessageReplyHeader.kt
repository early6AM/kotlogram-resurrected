package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageReplyHeader#a6d57763
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageReplyHeader() : TLObject() {
    var replyToMsgId: Int = 0

    var replyToPeerId: TLAbsPeer? = null

    var replyToTopId: Int? = null

    private val _constructor: String = "messageReplyHeader#a6d57763"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            replyToMsgId: Int,
            replyToPeerId: TLAbsPeer?,
            replyToTopId: Int?
    ) : this() {
        this.replyToMsgId = replyToMsgId
        this.replyToPeerId = replyToPeerId
        this.replyToTopId = replyToTopId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(replyToPeerId, 1)
        updateFlags(replyToTopId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(replyToMsgId)
        doIfMask(replyToPeerId, 1) { writeTLObject(it) }
        doIfMask(replyToTopId, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        replyToMsgId = readInt()
        replyToPeerId = readIfMask(1) { readTLObject<TLAbsPeer>() }
        replyToTopId = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(replyToPeerId, 1) { it.computeSerializedSize() }
        size += getIntIfMask(replyToTopId, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageReplyHeader) return false
        if (other === this) return true

        return _flags == other._flags
                && replyToMsgId == other.replyToMsgId
                && replyToPeerId == other.replyToPeerId
                && replyToTopId == other.replyToTopId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa6d57763.toInt()
    }
}
