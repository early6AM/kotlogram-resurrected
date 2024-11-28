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
 * secureFile#7d09c27e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureFile() : TLAbsSecureFile() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var size: Long = 0L

    var dcId: Int = 0

    var date: Int = 0

    var fileHash: TLBytes = TLBytes.EMPTY

    var secret: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "secureFile#7d09c27e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            size: Long,
            dcId: Int,
            date: Int,
            fileHash: TLBytes,
            secret: TLBytes
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.size = size
        this.dcId = dcId
        this.date = date
        this.fileHash = fileHash
        this.secret = secret
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeLong(size)
        writeInt(dcId)
        writeInt(date)
        writeTLBytes(fileHash)
        writeTLBytes(secret)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        size = readLong()
        dcId = readInt()
        date = readInt()
        fileHash = readTLBytes()
        secret = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(fileHash)
        size += computeTLBytesSerializedSize(secret)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureFile) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && size == other.size
                && dcId == other.dcId
                && date == other.date
                && fileHash == other.fileHash
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7d09c27e.toInt()
    }
}
