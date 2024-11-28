package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation
import com.github.badoualy.telegram.tl.api.TLInputTakeoutFileLocation
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUploadGetFile() : TLMethod<TLAbsFile>() {
    @Transient
    var precise: Boolean = false

    @Transient
    var cdnSupported: Boolean = false

    var location: TLAbsInputFileLocation = TLInputTakeoutFileLocation()

    var offset: Long = 0L

    var limit: Int = 0

    private val _constructor: String = "upload.getFile#be5335be"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            precise: Boolean,
            cdnSupported: Boolean,
            location: TLAbsInputFileLocation,
            offset: Long,
            limit: Int
    ) : this() {
        this.precise = precise
        this.cdnSupported = cdnSupported
        this.location = location
        this.offset = offset
        this.limit = limit
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(precise, 1)
        updateFlags(cdnSupported, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(location)
        writeLong(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        precise = isMask(1)
        cdnSupported = isMask(2)
        location = readTLObject<TLAbsInputFileLocation>()
        offset = readLong()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += location.computeSerializedSize()
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUploadGetFile) return false
        if (other === this) return true

        return _flags == other._flags
                && precise == other.precise
                && cdnSupported == other.cdnSupported
                && location == other.location
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbe5335be.toInt()
    }
}
