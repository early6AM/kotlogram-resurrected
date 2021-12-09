package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * help.countryCode#4203c5ef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCountryCode() : TLObject() {
    var countryCode: String = ""

    var prefixes: TLStringVector? = null

    var patterns: TLStringVector? = null

    private val _constructor: String = "help.countryCode#4203c5ef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            countryCode: String,
            prefixes: TLStringVector?,
            patterns: TLStringVector?
    ) : this() {
        this.countryCode = countryCode
        this.prefixes = prefixes
        this.patterns = patterns
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(prefixes, 1)
        updateFlags(patterns, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(countryCode)
        doIfMask(prefixes, 1) { writeTLVector(it) }
        doIfMask(patterns, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        countryCode = readString()
        prefixes = readIfMask(1) { readTLStringVector() }
        patterns = readIfMask(2) { readTLStringVector() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(countryCode)
        size += getIntIfMask(prefixes, 1) { it.computeSerializedSize() }
        size += getIntIfMask(patterns, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCountryCode) return false
        if (other === this) return true

        return _flags == other._flags
                && countryCode == other.countryCode
                && prefixes == other.prefixes
                && patterns == other.patterns
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4203c5ef
    }
}
