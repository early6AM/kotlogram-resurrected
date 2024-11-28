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
import kotlin.jvm.Transient

/**
 * messageReplyHeader#afbc09db
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageReplyHeader() : TLAbsMessageReplyHeader() {
    @Transient
    var replyToScheduled: Boolean = false

    @Transient
    var forumTopic: Boolean = false

    @Transient
    var quote: Boolean = false

    var replyToMsgId: Int? = null

    var replyToPeerId: TLAbsPeer? = null

    var replyFrom: TLMessageFwdHeader? = null

    var replyMedia: TLAbsMessageMedia? = null

    var replyToTopId: Int? = null

    var quoteText: String? = null

    var quoteEntities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var quoteOffset: Int? = null

    private val _constructor: String = "messageReplyHeader#afbc09db"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            replyToScheduled: Boolean,
            forumTopic: Boolean,
            quote: Boolean,
            replyToMsgId: Int?,
            replyToPeerId: TLAbsPeer?,
            replyFrom: TLMessageFwdHeader?,
            replyMedia: TLAbsMessageMedia?,
            replyToTopId: Int?,
            quoteText: String?,
            quoteEntities: TLObjectVector<TLAbsMessageEntity>?,
            quoteOffset: Int?
    ) : this() {
        this.replyToScheduled = replyToScheduled
        this.forumTopic = forumTopic
        this.quote = quote
        this.replyToMsgId = replyToMsgId
        this.replyToPeerId = replyToPeerId
        this.replyFrom = replyFrom
        this.replyMedia = replyMedia
        this.replyToTopId = replyToTopId
        this.quoteText = quoteText
        this.quoteEntities = quoteEntities
        this.quoteOffset = quoteOffset
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(replyToScheduled, 4)
        updateFlags(forumTopic, 8)
        updateFlags(quote, 512)
        updateFlags(replyToMsgId, 16)
        updateFlags(replyToPeerId, 1)
        updateFlags(replyFrom, 32)
        updateFlags(replyMedia, 256)
        updateFlags(replyToTopId, 2)
        updateFlags(quoteText, 64)
        updateFlags(quoteEntities, 128)
        updateFlags(quoteOffset, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(replyToMsgId, 16) { writeInt(it) }
        doIfMask(replyToPeerId, 1) { writeTLObject(it) }
        doIfMask(replyFrom, 32) { writeTLObject(it) }
        doIfMask(replyMedia, 256) { writeTLObject(it) }
        doIfMask(replyToTopId, 2) { writeInt(it) }
        doIfMask(quoteText, 64) { writeString(it) }
        doIfMask(quoteEntities, 128) { writeTLVector(it) }
        doIfMask(quoteOffset, 1024) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        replyToScheduled = isMask(4)
        forumTopic = isMask(8)
        quote = isMask(512)
        replyToMsgId = readIfMask(16) { readInt() }
        replyToPeerId = readIfMask(1) { readTLObject<TLAbsPeer>() }
        replyFrom = readIfMask(32) { readTLObject<TLMessageFwdHeader>(TLMessageFwdHeader::class, TLMessageFwdHeader.CONSTRUCTOR_ID) }
        replyMedia = readIfMask(256) { readTLObject<TLAbsMessageMedia>() }
        replyToTopId = readIfMask(2) { readInt() }
        quoteText = readIfMask(64) { readString() }
        quoteEntities = readIfMask(128) { readTLVector<TLAbsMessageEntity>() }
        quoteOffset = readIfMask(1024) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(replyToMsgId, 16) { SIZE_INT32 }
        size += getIntIfMask(replyToPeerId, 1) { it.computeSerializedSize() }
        size += getIntIfMask(replyFrom, 32) { it.computeSerializedSize() }
        size += getIntIfMask(replyMedia, 256) { it.computeSerializedSize() }
        size += getIntIfMask(replyToTopId, 2) { SIZE_INT32 }
        size += getIntIfMask(quoteText, 64) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(quoteEntities, 128) { it.computeSerializedSize() }
        size += getIntIfMask(quoteOffset, 1024) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageReplyHeader) return false
        if (other === this) return true

        return _flags == other._flags
                && replyToScheduled == other.replyToScheduled
                && forumTopic == other.forumTopic
                && quote == other.quote
                && replyToMsgId == other.replyToMsgId
                && replyToPeerId == other.replyToPeerId
                && replyFrom == other.replyFrom
                && replyMedia == other.replyMedia
                && replyToTopId == other.replyToTopId
                && quoteText == other.quoteText
                && quoteEntities == other.quoteEntities
                && quoteOffset == other.quoteOffset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xafbc09db.toInt()
    }
}
