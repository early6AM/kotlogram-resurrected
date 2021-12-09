package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photo#fb197a65
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoto() : TLAbsPhoto() {
    @Transient
    var hasStickers: Boolean = false

    override var id: Long = 0L

    var accessHash: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    var date: Int = 0

    var sizes: TLObjectVector<TLAbsPhotoSize> = TLObjectVector()

    var videoSizes: TLObjectVector<TLVideoSize>? = TLObjectVector()

    var dcId: Int = 0

    private val _constructor: String = "photo#fb197a65"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasStickers: Boolean,
            id: Long,
            accessHash: Long,
            fileReference: TLBytes,
            date: Int,
            sizes: TLObjectVector<TLAbsPhotoSize>,
            videoSizes: TLObjectVector<TLVideoSize>?,
            dcId: Int
    ) : this() {
        this.hasStickers = hasStickers
        this.id = id
        this.accessHash = accessHash
        this.fileReference = fileReference
        this.date = date
        this.sizes = sizes
        this.videoSizes = videoSizes
        this.dcId = dcId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(hasStickers, 1)
        updateFlags(videoSizes, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeTLBytes(fileReference)
        writeInt(date)
        writeTLVector(sizes)
        doIfMask(videoSizes, 2) { writeTLVector(it) }
        writeInt(dcId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasStickers = isMask(1)
        id = readLong()
        accessHash = readLong()
        fileReference = readTLBytes()
        date = readInt()
        sizes = readTLVector<TLAbsPhotoSize>()
        videoSizes = readIfMask(2) { readTLVector<TLVideoSize>() }
        dcId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        size += SIZE_INT32
        size += sizes.computeSerializedSize()
        size += getIntIfMask(videoSizes, 2) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && hasStickers == other.hasStickers
                && id == other.id
                && accessHash == other.accessHash
                && fileReference == other.fileReference
                && date == other.date
                && sizes == other.sizes
                && videoSizes == other.videoSizes
                && dcId == other.dcId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfb197a65.toInt()
    }
}
