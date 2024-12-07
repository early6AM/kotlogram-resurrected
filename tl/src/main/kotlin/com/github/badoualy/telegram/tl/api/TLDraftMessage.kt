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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * draftMessage#2d65321f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDraftMessage() : TLAbsDraftMessage() {
    @Transient
    var noWebpage: Boolean = false

    @Transient
    var invertMedia: Boolean = false

    var replyTo: TLAbsInputReplyTo? = null

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var media: TLAbsInputMedia? = null

    var date: Int = 0

    var effect: Long? = null

    private val _constructor: String = "draftMessage#2d65321f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            invertMedia: Boolean,
            replyTo: TLAbsInputReplyTo?,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            media: TLAbsInputMedia?,
            date: Int,
            effect: Long?
    ) : this() {
        this.noWebpage = noWebpage
        this.invertMedia = invertMedia
        this.replyTo = replyTo
        this.message = message
        this.entities = entities
        this.media = media
        this.date = date
        this.effect = effect
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(invertMedia, 64)
        updateFlags(replyTo, 16)
        updateFlags(entities, 8)
        updateFlags(media, 32)
        updateFlags(effect, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(replyTo, 16) { writeTLObject(it) }
        writeString(message)
        doIfMask(entities, 8) { writeTLVector(it) }
        doIfMask(media, 32) { writeTLObject(it) }
        writeInt(date)
        doIfMask(effect, 128) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        invertMedia = isMask(64)
        replyTo = readIfMask(16) { readTLObject<TLAbsInputReplyTo>() }
        message = readString()
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
        media = readIfMask(32) { readTLObject<TLAbsInputMedia>() }
        date = readInt()
        effect = readIfMask(128) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(replyTo, 16) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(media, 32) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += getIntIfMask(effect, 128) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDraftMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && invertMedia == other.invertMedia
                && replyTo == other.replyTo
                && message == other.message
                && entities == other.entities
                && media == other.media
                && date == other.date
                && effect == other.effect
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2d65321f.toInt()
    }
}
