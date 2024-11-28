package com.github.badoualy.telegram.tl.api.account

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
import kotlin.jvm.Transient

/**
 * account.contentSettings#57e28221
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContentSettings() : TLObject() {
    @Transient
    var sensitiveEnabled: Boolean = false

    @Transient
    var sensitiveCanChange: Boolean = false

    private val _constructor: String = "account.contentSettings#57e28221"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(sensitiveEnabled: Boolean, sensitiveCanChange: Boolean) : this() {
        this.sensitiveEnabled = sensitiveEnabled
        this.sensitiveCanChange = sensitiveCanChange
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(sensitiveEnabled, 1)
        updateFlags(sensitiveCanChange, 2)
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
        sensitiveCanChange = isMask(2)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContentSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && sensitiveEnabled == other.sensitiveEnabled
                && sensitiveCanChange == other.sensitiveCanChange
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x57e28221.toInt()
    }
}
