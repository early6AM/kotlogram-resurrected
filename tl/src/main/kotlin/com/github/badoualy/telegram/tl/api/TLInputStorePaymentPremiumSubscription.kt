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
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * inputStorePaymentPremiumSubscription#a6751e66
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStorePaymentPremiumSubscription() : TLAbsInputStorePaymentPurpose() {
    @Transient
    var restore: Boolean = false

    @Transient
    var upgrade: Boolean = false

    private val _constructor: String = "inputStorePaymentPremiumSubscription#a6751e66"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(restore: Boolean, upgrade: Boolean) : this() {
        this.restore = restore
        this.upgrade = upgrade
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(restore, 1)
        updateFlags(upgrade, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        restore = isMask(1, 1)
        upgrade = isMask(1, 2)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStorePaymentPremiumSubscription) return false
        if (other === this) return true

        return _flags == other._flags
                && restore == other.restore
                && upgrade == other.upgrade
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa6751e66.toInt()
    }
}
