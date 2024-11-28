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
 * inputStorePaymentGiftPremium#616f7fe8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStorePaymentGiftPremium() : TLAbsInputStorePaymentPurpose() {
    var userId: TLAbsInputUser = TLInputUserEmpty()

    var currency: String = ""

    var amount: Long = 0L

    private val _constructor: String = "inputStorePaymentGiftPremium#616f7fe8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: TLAbsInputUser,
            currency: String,
            amount: Long
    ) : this() {
        this.userId = userId
        this.currency = currency
        this.amount = amount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(userId)
        writeString(currency)
        writeLong(amount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readTLObject<TLAbsInputUser>()
        currency = readString()
        amount = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += userId.computeSerializedSize()
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStorePaymentGiftPremium) return false
        if (other === this) return true

        return userId == other.userId
                && currency == other.currency
                && amount == other.amount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x616f7fe8.toInt()
    }
}
