package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
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
 * inputStorePaymentPremiumGiveaway#160544ca
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStorePaymentPremiumGiveaway() : TLAbsInputStorePaymentPurpose() {
    @Transient
    var onlyNewSubscribers: Boolean = false

    @Transient
    var winnersAreVisible: Boolean = false

    var boostPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var additionalPeers: TLObjectVector<TLAbsInputPeer>? = TLObjectVector()

    var countriesIso2: TLStringVector? = null

    var prizeDescription: String? = null

    var randomId: Long = 0L

    var untilDate: Int = 0

    var currency: String = ""

    var amount: Long = 0L

    private val _constructor: String = "inputStorePaymentPremiumGiveaway#160544ca"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            onlyNewSubscribers: Boolean,
            winnersAreVisible: Boolean,
            boostPeer: TLAbsInputPeer,
            additionalPeers: TLObjectVector<TLAbsInputPeer>?,
            countriesIso2: TLStringVector?,
            prizeDescription: String?,
            randomId: Long,
            untilDate: Int,
            currency: String,
            amount: Long
    ) : this() {
        this.onlyNewSubscribers = onlyNewSubscribers
        this.winnersAreVisible = winnersAreVisible
        this.boostPeer = boostPeer
        this.additionalPeers = additionalPeers
        this.countriesIso2 = countriesIso2
        this.prizeDescription = prizeDescription
        this.randomId = randomId
        this.untilDate = untilDate
        this.currency = currency
        this.amount = amount
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(onlyNewSubscribers, 1)
        updateFlags(winnersAreVisible, 8)
        updateFlags(additionalPeers, 2)
        updateFlags(countriesIso2, 4)
        updateFlags(prizeDescription, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(boostPeer)
        doIfMask(additionalPeers, 2) { writeTLVector(it) }
        doIfMask(countriesIso2, 4) { writeTLVector(it) }
        doIfMask(prizeDescription, 16) { writeString(it) }
        writeLong(randomId)
        writeInt(untilDate)
        writeString(currency)
        writeLong(amount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        onlyNewSubscribers = isMask(1)
        winnersAreVisible = isMask(8)
        boostPeer = readTLObject<TLAbsInputPeer>()
        additionalPeers = readIfMask(2) { readTLVector<TLAbsInputPeer>() }
        countriesIso2 = readIfMask(4) { readTLStringVector() }
        prizeDescription = readIfMask(16) { readString() }
        randomId = readLong()
        untilDate = readInt()
        currency = readString()
        amount = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += boostPeer.computeSerializedSize()
        size += getIntIfMask(additionalPeers, 2) { it.computeSerializedSize() }
        size += getIntIfMask(countriesIso2, 4) { it.computeSerializedSize() }
        size += getIntIfMask(prizeDescription, 16) { computeTLStringSerializedSize(it) }
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStorePaymentPremiumGiveaway) return false
        if (other === this) return true

        return _flags == other._flags
                && onlyNewSubscribers == other.onlyNewSubscribers
                && winnersAreVisible == other.winnersAreVisible
                && boostPeer == other.boostPeer
                && additionalPeers == other.additionalPeers
                && countriesIso2 == other.countriesIso2
                && prizeDescription == other.prizeDescription
                && randomId == other.randomId
                && untilDate == other.untilDate
                && currency == other.currency
                && amount == other.amount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x160544ca.toInt()
    }
}
