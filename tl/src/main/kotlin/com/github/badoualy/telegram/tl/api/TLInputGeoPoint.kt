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
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputGeoPoint#48222faf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputGeoPoint() : TLAbsInputGeoPoint() {
    var lat: Double = 0.0

    var _long: Double = 0.0

    var accuracyRadius: Int? = null

    private val _constructor: String = "inputGeoPoint#48222faf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            lat: Double,
            _long: Double,
            accuracyRadius: Int?
    ) : this() {
        this.lat = lat
        this._long = _long
        this.accuracyRadius = accuracyRadius
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(accuracyRadius, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeDouble(lat)
        writeDouble(_long)
        doIfMask(accuracyRadius, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        lat = readDouble()
        _long = readDouble()
        accuracyRadius = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += getIntIfMask(accuracyRadius, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputGeoPoint) return false
        if (other === this) return true

        return _flags == other._flags
                && lat == other.lat
                && _long == other._long
                && accuracyRadius == other.accuracyRadius
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x48222faf.toInt()
    }
}
