package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputReplyToMessage#22c0f6d5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReplyToMessage() : TLAbsInputReplyTo() {
    var replyToMsgId: Int = 0

    var topMsgId: Int? = null

    var replyToPeerId: TLAbsInputPeer? = null

    var quoteText: String? = null

    var quoteEntities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var quoteOffset: Int? = null

    private val _constructor: String = "inputReplyToMessage#22c0f6d5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            replyToMsgId: Int,
            topMsgId: Int?,
            replyToPeerId: TLAbsInputPeer?,
            quoteText: String?,
            quoteEntities: TLObjectVector<TLAbsMessageEntity>?,
            quoteOffset: Int?
    ) : this() {
        this.replyToMsgId = replyToMsgId
        this.topMsgId = topMsgId
        this.replyToPeerId = replyToPeerId
        this.quoteText = quoteText
        this.quoteEntities = quoteEntities
        this.quoteOffset = quoteOffset
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(topMsgId, 1)
        updateFlags(replyToPeerId, 2)
        updateFlags(quoteText, 4)
        updateFlags(quoteEntities, 8)
        updateFlags(quoteOffset, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(replyToMsgId)
        doIfMask(1, topMsgId, 1) { writeInt(it) }
        doIfMask(1, replyToPeerId, 2) { writeTLObject(it) }
        doIfMask(1, quoteText, 4) { writeString(it) }
        doIfMask(1, quoteEntities, 8) { writeTLVector(it) }
        doIfMask(1, quoteOffset, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        replyToMsgId = readInt()
        topMsgId = readIfMask(1, 1) { readInt() }
        replyToPeerId = readIfMask(1, 2) { readTLObject<TLAbsInputPeer>() }
        quoteText = readIfMask(1, 4) { readString() }
        quoteEntities = readIfMask(1, 8) { readTLVector<TLAbsMessageEntity>() }
        quoteOffset = readIfMask(1, 16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, topMsgId, 1) { SIZE_INT32 }
        size += getIntIfMask(1, replyToPeerId, 2) { it.computeSerializedSize() }
        size += getIntIfMask(1, quoteText, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, quoteEntities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, quoteOffset, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReplyToMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && replyToMsgId == other.replyToMsgId
                && topMsgId == other.topMsgId
                && replyToPeerId == other.replyToPeerId
                && quoteText == other.quoteText
                && quoteEntities == other.quoteEntities
                && quoteOffset == other.quoteOffset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x22c0f6d5.toInt()
    }
}
