package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * pageRelatedArticle#b390dc08
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageRelatedArticle() : TLObject() {
    var url: String = ""

    var webpageId: Long = 0L

    var title: String? = null

    var description: String? = null

    var photoId: Long? = null

    var author: String? = null

    var publishedDate: Int? = null

    private val _constructor: String = "pageRelatedArticle#b390dc08"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            webpageId: Long,
            title: String?,
            description: String?,
            photoId: Long?,
            author: String?,
            publishedDate: Int?
    ) : this() {
        this.url = url
        this.webpageId = webpageId
        this.title = title
        this.description = description
        this.photoId = photoId
        this.author = author
        this.publishedDate = publishedDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 1)
        updateFlags(description, 2)
        updateFlags(photoId, 4)
        updateFlags(author, 8)
        updateFlags(publishedDate, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
        writeLong(webpageId)
        doIfMask(title, 1) { writeString(it) }
        doIfMask(description, 2) { writeString(it) }
        doIfMask(photoId, 4) { writeLong(it) }
        doIfMask(author, 8) { writeString(it) }
        doIfMask(publishedDate, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        url = readString()
        webpageId = readLong()
        title = readIfMask(1) { readString() }
        description = readIfMask(2) { readString() }
        photoId = readIfMask(4) { readLong() }
        author = readIfMask(8) { readString() }
        publishedDate = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT64
        size += getIntIfMask(title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(description, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(photoId, 4) { SIZE_INT64 }
        size += getIntIfMask(author, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(publishedDate, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageRelatedArticle) return false
        if (other === this) return true

        return _flags == other._flags
                && url == other.url
                && webpageId == other.webpageId
                && title == other.title
                && description == other.description
                && photoId == other.photoId
                && author == other.author
                && publishedDate == other.publishedDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb390dc08.toInt()
    }
}
