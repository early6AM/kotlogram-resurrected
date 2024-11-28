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
 * inputFileLocation#dfdaabe1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputFileLocation() : TLAbsInputFileLocation() {
    var volumeId: Long = 0L

    var localId: Int = 0

    var secret: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "inputFileLocation#dfdaabe1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            volumeId: Long,
            localId: Int,
            secret: Long,
            fileReference: TLBytes
    ) : this() {
        this.volumeId = volumeId
        this.localId = localId
        this.secret = secret
        this.fileReference = fileReference
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(volumeId)
        writeInt(localId)
        writeLong(secret)
        writeTLBytes(fileReference)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        volumeId = readLong()
        localId = readInt()
        secret = readLong()
        fileReference = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputFileLocation) return false
        if (other === this) return true

        return volumeId == other.volumeId
                && localId == other.localId
                && secret == other.secret
                && fileReference == other.fileReference
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdfdaabe1.toInt()
    }
}
