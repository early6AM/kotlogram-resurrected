package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.api.TLInputStickerSetEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersSetStickerSetThumb() : TLMethod<TLAbsStickerSet>() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var thumb: TLAbsInputDocument? = null

    var thumbDocumentId: Long? = null

    private val _constructor: String = "stickers.setStickerSetThumb#a76a5392"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            stickerset: TLAbsInputStickerSet,
            thumb: TLAbsInputDocument?,
            thumbDocumentId: Long?
    ) : this() {
        this.stickerset = stickerset
        this.thumb = thumb
        this.thumbDocumentId = thumbDocumentId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(thumb, 1)
        updateFlags(thumbDocumentId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(stickerset)
        doIfMask(1, thumb, 1) { writeTLObject(it) }
        doIfMask(1, thumbDocumentId, 2) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        stickerset = readTLObject<TLAbsInputStickerSet>()
        thumb = readIfMask(1, 1) { readTLObject<TLAbsInputDocument>() }
        thumbDocumentId = readIfMask(1, 2) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += stickerset.computeSerializedSize()
        size += getIntIfMask(1, thumb, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, thumbDocumentId, 2) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersSetStickerSetThumb) return false
        if (other === this) return true

        return _flags == other._flags
                && stickerset == other.stickerset
                && thumb == other.thumb
                && thumbDocumentId == other.thumbDocumentId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa76a5392.toInt()
    }
}
