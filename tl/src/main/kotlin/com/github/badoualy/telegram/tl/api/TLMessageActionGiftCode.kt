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
import kotlin.jvm.Transient

/**
 * messageActionGiftCode#678c2e09
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionGiftCode() : TLAbsMessageAction() {
    @Transient
    var viaGiveaway: Boolean = false

    @Transient
    var unclaimed: Boolean = false

    var boostPeer: TLAbsPeer? = null

    var months: Int = 0

    var slug: String = ""

    var currency: String? = null

    var amount: Long? = null

    var cryptoCurrency: String? = null

    var cryptoAmount: Long? = null

    private val _constructor: String = "messageActionGiftCode#678c2e09"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viaGiveaway: Boolean,
            unclaimed: Boolean,
            boostPeer: TLAbsPeer?,
            months: Int,
            slug: String,
            currency: String?,
            amount: Long?,
            cryptoCurrency: String?,
            cryptoAmount: Long?
    ) : this() {
        this.viaGiveaway = viaGiveaway
        this.unclaimed = unclaimed
        this.boostPeer = boostPeer
        this.months = months
        this.slug = slug
        this.currency = currency
        this.amount = amount
        this.cryptoCurrency = cryptoCurrency
        this.cryptoAmount = cryptoAmount
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(viaGiveaway, 1)
        updateFlags(unclaimed, 4)
        updateFlags(boostPeer, 2)
        updateFlags(currency, 4)
        updateFlags(amount, 4)
        updateFlags(cryptoCurrency, 8)
        updateFlags(cryptoAmount, 8)

        // Following parameters might be forced to true by another field that updated the flags
        unclaimed = isMask(4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(boostPeer, 2) { writeTLObject(it) }
        writeInt(months)
        writeString(slug)
        doIfMask(currency, 4) { writeString(it) }
        doIfMask(amount, 4) { writeLong(it) }
        doIfMask(cryptoCurrency, 8) { writeString(it) }
        doIfMask(cryptoAmount, 8) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viaGiveaway = isMask(1)
        unclaimed = isMask(4)
        boostPeer = readIfMask(2) { readTLObject<TLAbsPeer>() }
        months = readInt()
        slug = readString()
        currency = readIfMask(4) { readString() }
        amount = readIfMask(4) { readLong() }
        cryptoCurrency = readIfMask(8) { readString() }
        cryptoAmount = readIfMask(8) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(boostPeer, 2) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += computeTLStringSerializedSize(slug)
        size += getIntIfMask(currency, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(amount, 4) { SIZE_INT64 }
        size += getIntIfMask(cryptoCurrency, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(cryptoAmount, 8) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionGiftCode) return false
        if (other === this) return true

        return _flags == other._flags
                && viaGiveaway == other.viaGiveaway
                && unclaimed == other.unclaimed
                && boostPeer == other.boostPeer
                && months == other.months
                && slug == other.slug
                && currency == other.currency
                && amount == other.amount
                && cryptoCurrency == other.cryptoCurrency
                && cryptoAmount == other.cryptoAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x678c2e09.toInt()
    }
}
