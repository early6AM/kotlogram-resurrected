package com.github.badoualy.telegram.tl.api.fragment

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
 * fragment.collectibleInfo#6ebdff91
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCollectibleInfo() : TLObject() {
    var purchaseDate: Int = 0

    var currency: String = ""

    var amount: Long = 0L

    var cryptoCurrency: String = ""

    var cryptoAmount: Long = 0L

    var url: String = ""

    private val _constructor: String = "fragment.collectibleInfo#6ebdff91"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            purchaseDate: Int,
            currency: String,
            amount: Long,
            cryptoCurrency: String,
            cryptoAmount: Long,
            url: String
    ) : this() {
        this.purchaseDate = purchaseDate
        this.currency = currency
        this.amount = amount
        this.cryptoCurrency = cryptoCurrency
        this.cryptoAmount = cryptoAmount
        this.url = url
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(purchaseDate)
        writeString(currency)
        writeLong(amount)
        writeString(cryptoCurrency)
        writeLong(cryptoAmount)
        writeString(url)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        purchaseDate = readInt()
        currency = readString()
        amount = readLong()
        cryptoCurrency = readString()
        cryptoAmount = readLong()
        url = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(cryptoCurrency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(url)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCollectibleInfo) return false
        if (other === this) return true

        return purchaseDate == other.purchaseDate
                && currency == other.currency
                && amount == other.amount
                && cryptoCurrency == other.cryptoCurrency
                && cryptoAmount == other.cryptoAmount
                && url == other.url
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6ebdff91.toInt()
    }
}
