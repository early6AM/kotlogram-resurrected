package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * help.country#c3878e23
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCountry() : TLObject() {
    @Transient
    var hidden: Boolean = false

    var iso2: String = ""

    var defaultName: String = ""

    var name: String? = null

    var countryCodes: TLObjectVector<TLCountryCode> = TLObjectVector()

    private val _constructor: String = "help.country#c3878e23"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hidden: Boolean,
            iso2: String,
            defaultName: String,
            name: String?,
            countryCodes: TLObjectVector<TLCountryCode>
    ) : this() {
        this.hidden = hidden
        this.iso2 = iso2
        this.defaultName = defaultName
        this.name = name
        this.countryCodes = countryCodes
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(hidden, 1)
        updateFlags(name, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(iso2)
        writeString(defaultName)
        doIfMask(1, name, 2) { writeString(it) }
        writeTLVector(countryCodes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hidden = isMask(1, 1)
        iso2 = readString()
        defaultName = readString()
        name = readIfMask(1, 2) { readString() }
        countryCodes = readTLVector<TLCountryCode>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(iso2)
        size += computeTLStringSerializedSize(defaultName)
        size += getIntIfMask(1, name, 2) { computeTLStringSerializedSize(it) }
        size += countryCodes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCountry) return false
        if (other === this) return true

        return _flags == other._flags
                && hidden == other.hidden
                && iso2 == other.iso2
                && defaultName == other.defaultName
                && name == other.name
                && countryCodes == other.countryCodes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc3878e23.toInt()
    }
}
