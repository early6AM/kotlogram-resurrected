package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdateBusinessLocation() : TLMethod<TLBool>() {
    var geoPoint: TLAbsInputGeoPoint? = null

    var address: String? = null

    private val _constructor: String = "account.updateBusinessLocation#9e6b131a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(geoPoint: TLAbsInputGeoPoint?, address: String?) : this() {
        this.geoPoint = geoPoint
        this.address = address
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(geoPoint, 2)
        updateFlags(address, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, geoPoint, 2) { writeTLObject(it) }
        doIfMask(1, address, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        geoPoint = readIfMask(1, 2) { readTLObject<TLAbsInputGeoPoint>() }
        address = readIfMask(1, 1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, geoPoint, 2) { it.computeSerializedSize() }
        size += getIntIfMask(1, address, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdateBusinessLocation) return false
        if (other === this) return true

        return _flags == other._flags
                && geoPoint == other.geoPoint
                && address == other.address
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9e6b131a.toInt()
    }
}
