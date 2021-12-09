package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountInstallTheme() : TLMethod<TLBool>() {
    @Transient
    var dark: Boolean = false

    var format: String? = null

    var theme: TLAbsInputTheme? = null

    private val _constructor: String = "account.installTheme#7ae43737"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dark: Boolean,
            format: String?,
            theme: TLAbsInputTheme?
    ) : this() {
        this.dark = dark
        this.format = format
        this.theme = theme
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(dark, 1)
        updateFlags(format, 2)
        updateFlags(theme, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(format, 2) { writeString(it) }
        doIfMask(theme, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1)
        format = readIfMask(2) { readString() }
        theme = readIfMask(2) { readTLObject<TLAbsInputTheme>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(format, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(theme, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountInstallTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && format == other.format
                && theme == other.theme
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7ae43737
    }
}
