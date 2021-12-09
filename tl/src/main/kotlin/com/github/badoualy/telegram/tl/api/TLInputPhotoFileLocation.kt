package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputPhotoFileLocation#40181ffe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPhotoFileLocation() : TLAbsInputFileLocation() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    var thumbSize: String = ""

    private val _constructor: String = "inputPhotoFileLocation#40181ffe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            fileReference: TLBytes,
            thumbSize: String
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.fileReference = fileReference
        this.thumbSize = thumbSize
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeTLBytes(fileReference)
        writeString(thumbSize)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        fileReference = readTLBytes()
        thumbSize = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        size += computeTLStringSerializedSize(thumbSize)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPhotoFileLocation) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && fileReference == other.fileReference
                && thumbSize == other.thumbSize
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40181ffe
    }
}
