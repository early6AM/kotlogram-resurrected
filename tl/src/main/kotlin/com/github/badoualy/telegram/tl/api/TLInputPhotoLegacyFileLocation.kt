package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * inputPhotoLegacyFileLocation#d83466f3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPhotoLegacyFileLocation() : TLAbsInputFileLocation() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    var volumeId: Long = 0L

    var localId: Int = 0

    var secret: Long = 0L

    private val _constructor: String = "inputPhotoLegacyFileLocation#d83466f3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            fileReference: TLBytes,
            volumeId: Long,
            localId: Int,
            secret: Long
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.fileReference = fileReference
        this.volumeId = volumeId
        this.localId = localId
        this.secret = secret
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeTLBytes(fileReference)
        writeLong(volumeId)
        writeInt(localId)
        writeLong(secret)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        fileReference = readTLBytes()
        volumeId = readLong()
        localId = readInt()
        secret = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPhotoLegacyFileLocation) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && fileReference == other.fileReference
                && volumeId == other.volumeId
                && localId == other.localId
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd83466f3.toInt()
    }
}
