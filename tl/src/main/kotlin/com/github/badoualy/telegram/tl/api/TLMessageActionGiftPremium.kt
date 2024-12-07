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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageActionGiftPremium#c83d6aec
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionGiftPremium() : TLAbsMessageAction() {
    var currency: String = ""

    var amount: Long = 0L

    var months: Int = 0

    var cryptoCurrency: String? = null

    var cryptoAmount: Long? = null

    private val _constructor: String = "messageActionGiftPremium#c83d6aec"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            currency: String,
            amount: Long,
            months: Int,
            cryptoCurrency: String?,
            cryptoAmount: Long?
    ) : this() {
        this.currency = currency
        this.amount = amount
        this.months = months
        this.cryptoCurrency = cryptoCurrency
        this.cryptoAmount = cryptoAmount
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(cryptoCurrency, 1)
        updateFlags(cryptoAmount, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(currency)
        writeLong(amount)
        writeInt(months)
        doIfMask(1, cryptoCurrency, 1) { writeString(it) }
        doIfMask(1, cryptoAmount, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        currency = readString()
        amount = readLong()
        months = readInt()
        cryptoCurrency = readIfMask(1, 1) { readString() }
        cryptoAmount = readIfMask(1, 1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(1, cryptoCurrency, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, cryptoAmount, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionGiftPremium) return false
        if (other === this) return true

        return _flags == other._flags
                && currency == other.currency
                && amount == other.amount
                && months == other.months
                && cryptoCurrency == other.cryptoCurrency
                && cryptoAmount == other.cryptoAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc83d6aec.toInt()
    }
}
