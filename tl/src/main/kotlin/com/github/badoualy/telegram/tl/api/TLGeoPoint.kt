package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * geoPoint#b2a2f663
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGeoPoint() : TLAbsGeoPoint() {
    var _long: Double = 0.0

    var lat: Double = 0.0

    var accessHash: Long = 0L

    var accuracyRadius: Int? = null

    private val _constructor: String = "geoPoint#b2a2f663"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            _long: Double,
            lat: Double,
            accessHash: Long,
            accuracyRadius: Int?
    ) : this() {
        this._long = _long
        this.lat = lat
        this.accessHash = accessHash
        this.accuracyRadius = accuracyRadius
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(accuracyRadius, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeDouble(_long)
        writeDouble(lat)
        writeLong(accessHash)
        doIfMask(1, accuracyRadius, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        _long = readDouble()
        lat = readDouble()
        accessHash = readLong()
        accuracyRadius = readIfMask(1, 1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += SIZE_INT64
        size += getIntIfMask(1, accuracyRadius, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGeoPoint) return false
        if (other === this) return true

        return _flags == other._flags
                && _long == other._long
                && lat == other.lat
                && accessHash == other.accessHash
                && accuracyRadius == other.accuracyRadius
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb2a2f663.toInt()
    }
}
