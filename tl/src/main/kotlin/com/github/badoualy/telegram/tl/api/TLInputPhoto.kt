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
 * inputPhoto#3bb3b94a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPhoto() : TLAbsInputPhoto() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var fileReference: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "inputPhoto#3bb3b94a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            fileReference: TLBytes
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.fileReference = fileReference
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeTLBytes(fileReference)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        fileReference = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(fileReference)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPhoto) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && fileReference == other.fileReference
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3bb3b94a.toInt()
    }
}
