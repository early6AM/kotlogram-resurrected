package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockPhoto#1759c560
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockPhoto() : TLAbsPageBlock() {
    var photoId: Long = 0L

    var caption: TLPageCaption = TLPageCaption()

    var url: String? = null

    var webpageId: Long? = null

    private val _constructor: String = "pageBlockPhoto#1759c560"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            photoId: Long,
            caption: TLPageCaption,
            url: String?,
            webpageId: Long?
    ) : this() {
        this.photoId = photoId
        this.caption = caption
        this.url = url
        this.webpageId = webpageId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(url, 1)
        updateFlags(webpageId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(photoId)
        writeTLObject(caption)
        doIfMask(url, 1) { writeString(it) }
        doIfMask(webpageId, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        photoId = readLong()
        caption = readTLObject<TLPageCaption>(TLPageCaption::class, TLPageCaption.CONSTRUCTOR_ID)
        url = readIfMask(1) { readString() }
        webpageId = readIfMask(1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += caption.computeSerializedSize()
        size += getIntIfMask(url, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(webpageId, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && photoId == other.photoId
                && caption == other.caption
                && url == other.url
                && webpageId == other.webpageId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1759c560
    }
}
