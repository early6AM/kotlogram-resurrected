package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsBaseTheme
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme
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
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountInstallTheme() : TLMethod<TLBool>() {
    @Transient
    var dark: Boolean = false

    var theme: TLAbsInputTheme? = null

    var format: String? = null

    var baseTheme: TLAbsBaseTheme? = null

    private val _constructor: String = "account.installTheme#c727bb3b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dark: Boolean,
            theme: TLAbsInputTheme?,
            format: String?,
            baseTheme: TLAbsBaseTheme?
    ) : this() {
        this.dark = dark
        this.theme = theme
        this.format = format
        this.baseTheme = baseTheme
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(dark, 1)
        updateFlags(theme, 2)
        updateFlags(format, 4)
        updateFlags(baseTheme, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(theme, 2) { writeTLObject(it) }
        doIfMask(format, 4) { writeString(it) }
        doIfMask(baseTheme, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1)
        theme = readIfMask(2) { readTLObject<TLAbsInputTheme>() }
        format = readIfMask(4) { readString() }
        baseTheme = readIfMask(8) { readTLObject<TLAbsBaseTheme>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(theme, 2) { it.computeSerializedSize() }
        size += getIntIfMask(format, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(baseTheme, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountInstallTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && theme == other.theme
                && format == other.format
                && baseTheme == other.baseTheme
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc727bb3b.toInt()
    }
}
