package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * inputStorePaymentPremiumGiftCode#a3805f3f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStorePaymentPremiumGiftCode() : TLAbsInputStorePaymentPurpose() {
    var users: TLObjectVector<TLAbsInputUser> = TLObjectVector()

    var boostPeer: TLAbsInputPeer? = null

    var currency: String = ""

    var amount: Long = 0L

    private val _constructor: String = "inputStorePaymentPremiumGiftCode#a3805f3f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            users: TLObjectVector<TLAbsInputUser>,
            boostPeer: TLAbsInputPeer?,
            currency: String,
            amount: Long
    ) : this() {
        this.users = users
        this.boostPeer = boostPeer
        this.currency = currency
        this.amount = amount
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(boostPeer, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(users)
        doIfMask(boostPeer, 1) { writeTLObject(it) }
        writeString(currency)
        writeLong(amount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        users = readTLVector<TLAbsInputUser>()
        boostPeer = readIfMask(1) { readTLObject<TLAbsInputPeer>() }
        currency = readString()
        amount = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += users.computeSerializedSize()
        size += getIntIfMask(boostPeer, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStorePaymentPremiumGiftCode) return false
        if (other === this) return true

        return _flags == other._flags
                && users == other.users
                && boostPeer == other.boostPeer
                && currency == other.currency
                && amount == other.amount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa3805f3f.toInt()
    }
}
