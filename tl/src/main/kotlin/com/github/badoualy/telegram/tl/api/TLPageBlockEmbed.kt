package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockEmbed#a8718dc5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockEmbed() : TLAbsPageBlock() {
    @Transient
    var fullWidth: Boolean = false

    @Transient
    var allowScrolling: Boolean = false

    var url: String? = null

    var html: String? = null

    var posterPhotoId: Long? = null

    var w: Int? = null

    var h: Int? = null

    var caption: TLPageCaption = TLPageCaption()

    private val _constructor: String = "pageBlockEmbed#a8718dc5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fullWidth: Boolean,
            allowScrolling: Boolean,
            url: String?,
            html: String?,
            posterPhotoId: Long?,
            w: Int?,
            h: Int?,
            caption: TLPageCaption
    ) : this() {
        this.fullWidth = fullWidth
        this.allowScrolling = allowScrolling
        this.url = url
        this.html = html
        this.posterPhotoId = posterPhotoId
        this.w = w
        this.h = h
        this.caption = caption
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(fullWidth, 1)
        updateFlags(allowScrolling, 8)
        updateFlags(url, 2)
        updateFlags(html, 4)
        updateFlags(posterPhotoId, 16)
        updateFlags(w, 32)
        updateFlags(h, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(url, 2) { writeString(it) }
        doIfMask(html, 4) { writeString(it) }
        doIfMask(posterPhotoId, 16) { writeLong(it) }
        doIfMask(w, 32) { writeInt(it) }
        doIfMask(h, 32) { writeInt(it) }
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fullWidth = isMask(1)
        allowScrolling = isMask(8)
        url = readIfMask(2) { readString() }
        html = readIfMask(4) { readString() }
        posterPhotoId = readIfMask(16) { readLong() }
        w = readIfMask(32) { readInt() }
        h = readIfMask(32) { readInt() }
        caption = readTLObject<TLPageCaption>(TLPageCaption::class, TLPageCaption.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(url, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(html, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(posterPhotoId, 16) { SIZE_INT64 }
        size += getIntIfMask(w, 32) { SIZE_INT32 }
        size += getIntIfMask(h, 32) { SIZE_INT32 }
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockEmbed) return false
        if (other === this) return true

        return _flags == other._flags
                && fullWidth == other.fullWidth
                && allowScrolling == other.allowScrolling
                && url == other.url
                && html == other.html
                && posterPhotoId == other.posterPhotoId
                && w == other.w
                && h == other.h
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa8718dc5.toInt()
    }
}
