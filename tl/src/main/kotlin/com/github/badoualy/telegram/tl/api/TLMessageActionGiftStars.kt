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
 * messageActionGiftStars#45d5b021
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionGiftStars() : TLAbsMessageAction() {
    var currency: String = ""

    var amount: Long = 0L

    var stars: Long = 0L

    var cryptoCurrency: String? = null

    var cryptoAmount: Long? = null

    var transactionId: String? = null

    private val _constructor: String = "messageActionGiftStars#45d5b021"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            currency: String,
            amount: Long,
            stars: Long,
            cryptoCurrency: String?,
            cryptoAmount: Long?,
            transactionId: String?
    ) : this() {
        this.currency = currency
        this.amount = amount
        this.stars = stars
        this.cryptoCurrency = cryptoCurrency
        this.cryptoAmount = cryptoAmount
        this.transactionId = transactionId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(cryptoCurrency, 1)
        updateFlags(cryptoAmount, 1)
        updateFlags(transactionId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(currency)
        writeLong(amount)
        writeLong(stars)
        doIfMask(1, cryptoCurrency, 1) { writeString(it) }
        doIfMask(1, cryptoAmount, 1) { writeLong(it) }
        doIfMask(1, transactionId, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        currency = readString()
        amount = readLong()
        stars = readLong()
        cryptoCurrency = readIfMask(1, 1) { readString() }
        cryptoAmount = readIfMask(1, 1) { readLong() }
        transactionId = readIfMask(1, 2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += SIZE_INT64
        size += getIntIfMask(1, cryptoCurrency, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, cryptoAmount, 1) { SIZE_INT64 }
        size += getIntIfMask(1, transactionId, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionGiftStars) return false
        if (other === this) return true

        return _flags == other._flags
                && currency == other.currency
                && amount == other.amount
                && stars == other.stars
                && cryptoCurrency == other.cryptoCurrency
                && cryptoAmount == other.cryptoAmount
                && transactionId == other.transactionId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x45d5b021.toInt()
    }
}
