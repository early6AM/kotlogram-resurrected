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
 * geoPointAddress#de4c5d93
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGeoPointAddress() : TLObject() {
    var countryIso2: String = ""

    var state: String? = null

    var city: String? = null

    var street: String? = null

    private val _constructor: String = "geoPointAddress#de4c5d93"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            countryIso2: String,
            state: String?,
            city: String?,
            street: String?
    ) : this() {
        this.countryIso2 = countryIso2
        this.state = state
        this.city = city
        this.street = street
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(state, 1)
        updateFlags(city, 2)
        updateFlags(street, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(countryIso2)
        doIfMask(state, 1) { writeString(it) }
        doIfMask(city, 2) { writeString(it) }
        doIfMask(street, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        countryIso2 = readString()
        state = readIfMask(1) { readString() }
        city = readIfMask(2) { readString() }
        street = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(countryIso2)
        size += getIntIfMask(state, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(city, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(street, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGeoPointAddress) return false
        if (other === this) return true

        return _flags == other._flags
                && countryIso2 == other.countryIso2
                && state == other.state
                && city == other.city
                && street == other.street
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xde4c5d93.toInt()
    }
}
