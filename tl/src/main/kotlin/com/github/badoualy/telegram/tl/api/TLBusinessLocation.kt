package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * businessLocation#ac5c1af7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBusinessLocation() : TLObject() {
    var geoPoint: TLAbsGeoPoint? = null

    var address: String = ""

    private val _constructor: String = "businessLocation#ac5c1af7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(geoPoint: TLAbsGeoPoint?, address: String) : this() {
        this.geoPoint = geoPoint
        this.address = address
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(geoPoint, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(geoPoint, 1) { writeTLObject(it) }
        writeString(address)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        geoPoint = readIfMask(1) { readTLObject<TLAbsGeoPoint>() }
        address = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(geoPoint, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(address)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBusinessLocation) return false
        if (other === this) return true

        return _flags == other._flags
                && geoPoint == other.geoPoint
                && address == other.address
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xac5c1af7.toInt()
    }
}
