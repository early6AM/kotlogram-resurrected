package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * document#1e87342b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocument() : TLAbsDocument() {
    override var id: Long = 0L

    var accessHash: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    var date: Int = 0

    var mimeType: String = ""

    var size: Int = 0

    var thumbs: TLObjectVector<TLAbsPhotoSize>? = TLObjectVector()

    var videoThumbs: TLObjectVector<TLVideoSize>? = TLObjectVector()

    var dcId: Int = 0

    var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    private val _constructor: String = "document#1e87342b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            fileReference: TLBytes,
            date: Int,
            mimeType: String,
            size: Int,
            thumbs: TLObjectVector<TLAbsPhotoSize>?,
            videoThumbs: TLObjectVector<TLVideoSize>?,
            dcId: Int,
            attributes: TLObjectVector<TLAbsDocumentAttribute>
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.fileReference = fileReference
        this.date = date
        this.mimeType = mimeType
        this.size = size
        this.thumbs = thumbs
        this.videoThumbs = videoThumbs
        this.dcId = dcId
        this.attributes = attributes
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(thumbs, 1)
        updateFlags(videoThumbs, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeTLBytes(fileReference)
        writeInt(date)
        writeString(mimeType)
        writeInt(size)
        doIfMask(thumbs, 1) { writeTLVector(it) }
        doIfMask(videoThumbs, 2) { writeTLVector(it) }
        writeInt(dcId)
        writeTLVector(attributes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readLong()
        accessHash = readLong()
        fileReference = readTLBytes()
        date = readInt()
        mimeType = readString()
        size = readInt()
        thumbs = readIfMask(1) { readTLVector<TLAbsPhotoSize>() }
        videoThumbs = readIfMask(2) { readTLVector<TLVideoSize>() }
        dcId = readInt()
        attributes = readTLVector<TLAbsDocumentAttribute>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += SIZE_INT32
        size += getIntIfMask(thumbs, 1) { it.computeSerializedSize() }
        size += getIntIfMask(videoThumbs, 2) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += attributes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocument) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && accessHash == other.accessHash
                && fileReference == other.fileReference
                && date == other.date
                && mimeType == other.mimeType
                && size == other.size
                && thumbs == other.thumbs
                && videoThumbs == other.videoThumbs
                && dcId == other.dcId
                && attributes == other.attributes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1e87342b
    }
}
