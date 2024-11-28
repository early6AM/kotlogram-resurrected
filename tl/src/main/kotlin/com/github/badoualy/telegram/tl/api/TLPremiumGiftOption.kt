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
 * premiumGiftOption#74c34319
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPremiumGiftOption() : TLObject() {
    var months: Int = 0

    var currency: String = ""

    var amount: Long = 0L

    var botUrl: String = ""

    var storeProduct: String? = null

    private val _constructor: String = "premiumGiftOption#74c34319"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            months: Int,
            currency: String,
            amount: Long,
            botUrl: String,
            storeProduct: String?
    ) : this() {
        this.months = months
        this.currency = currency
        this.amount = amount
        this.botUrl = botUrl
        this.storeProduct = storeProduct
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(storeProduct, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(months)
        writeString(currency)
        writeLong(amount)
        writeString(botUrl)
        doIfMask(storeProduct, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        months = readInt()
        currency = readString()
        amount = readLong()
        botUrl = readString()
        storeProduct = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(botUrl)
        size += getIntIfMask(storeProduct, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPremiumGiftOption) return false
        if (other === this) return true

        return _flags == other._flags
                && months == other.months
                && currency == other.currency
                && amount == other.amount
                && botUrl == other.botUrl
                && storeProduct == other.storeProduct
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x74c34319.toInt()
    }
}
