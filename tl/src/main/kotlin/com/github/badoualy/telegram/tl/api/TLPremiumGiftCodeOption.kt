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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * premiumGiftCodeOption#257e962b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPremiumGiftCodeOption() : TLObject() {
    var users: Int = 0

    var months: Int = 0

    var storeProduct: String? = null

    var storeQuantity: Int? = null

    var currency: String = ""

    var amount: Long = 0L

    private val _constructor: String = "premiumGiftCodeOption#257e962b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            users: Int,
            months: Int,
            storeProduct: String?,
            storeQuantity: Int?,
            currency: String,
            amount: Long
    ) : this() {
        this.users = users
        this.months = months
        this.storeProduct = storeProduct
        this.storeQuantity = storeQuantity
        this.currency = currency
        this.amount = amount
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(storeProduct, 1)
        updateFlags(storeQuantity, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(users)
        writeInt(months)
        doIfMask(1, storeProduct, 1) { writeString(it) }
        doIfMask(1, storeQuantity, 2) { writeInt(it) }
        writeString(currency)
        writeLong(amount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        users = readInt()
        months = readInt()
        storeProduct = readIfMask(1, 1) { readString() }
        storeQuantity = readIfMask(1, 2) { readInt() }
        currency = readString()
        amount = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, storeProduct, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, storeQuantity, 2) { SIZE_INT32 }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPremiumGiftCodeOption) return false
        if (other === this) return true

        return _flags == other._flags
                && users == other.users
                && months == other.months
                && storeProduct == other.storeProduct
                && storeQuantity == other.storeQuantity
                && currency == other.currency
                && amount == other.amount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x257e962b.toInt()
    }
}
