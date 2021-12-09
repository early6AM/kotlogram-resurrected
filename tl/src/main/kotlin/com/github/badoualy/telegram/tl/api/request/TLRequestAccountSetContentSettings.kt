package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountSetContentSettings() : TLMethod<TLBool>() {
    @Transient
    var sensitiveEnabled: Boolean = false

    private val _constructor: String = "account.setContentSettings#b574b16b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(sensitiveEnabled: Boolean) : this() {
        this.sensitiveEnabled = sensitiveEnabled
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(sensitiveEnabled, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        sensitiveEnabled = isMask(1)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSetContentSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && sensitiveEnabled == other.sensitiveEnabled
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb574b16b.toInt()
    }
}
