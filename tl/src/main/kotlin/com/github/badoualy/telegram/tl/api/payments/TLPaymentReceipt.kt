package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument
import com.github.badoualy.telegram.tl.api.TLInvoice
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.api.TLShippingOption
import com.github.badoualy.telegram.tl.core.TLObject
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
 * payments.paymentReceipt#70c4fe03
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentReceipt() : TLObject() {
    var date: Int = 0

    var botId: Long = 0L

    var providerId: Long = 0L

    var title: String = ""

    var description: String = ""

    var photo: TLAbsWebDocument? = null

    var invoice: TLInvoice = TLInvoice()

    var info: TLPaymentRequestedInfo? = null

    var shipping: TLShippingOption? = null

    var tipAmount: Long? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    var credentialsTitle: String = ""

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentReceipt#70c4fe03"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            date: Int,
            botId: Long,
            providerId: Long,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            invoice: TLInvoice,
            info: TLPaymentRequestedInfo?,
            shipping: TLShippingOption?,
            tipAmount: Long?,
            currency: String,
            totalAmount: Long,
            credentialsTitle: String,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.date = date
        this.botId = botId
        this.providerId = providerId
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.info = info
        this.shipping = shipping
        this.tipAmount = tipAmount
        this.currency = currency
        this.totalAmount = totalAmount
        this.credentialsTitle = credentialsTitle
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 4)
        updateFlags(info, 1)
        updateFlags(shipping, 2)
        updateFlags(tipAmount, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(date)
        writeLong(botId)
        writeLong(providerId)
        writeString(title)
        writeString(description)
        doIfMask(photo, 4) { writeTLObject(it) }
        writeTLObject(invoice)
        doIfMask(info, 1) { writeTLObject(it) }
        doIfMask(shipping, 2) { writeTLObject(it) }
        doIfMask(tipAmount, 8) { writeLong(it) }
        writeString(currency)
        writeLong(totalAmount)
        writeString(credentialsTitle)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        date = readInt()
        botId = readLong()
        providerId = readLong()
        title = readString()
        description = readString()
        photo = readIfMask(4) { readTLObject<TLAbsWebDocument>() }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        info = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        shipping = readIfMask(2) { readTLObject<TLShippingOption>(TLShippingOption::class, TLShippingOption.CONSTRUCTOR_ID) }
        tipAmount = readIfMask(8) { readLong() }
        currency = readString()
        totalAmount = readLong()
        credentialsTitle = readString()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(photo, 4) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += getIntIfMask(info, 1) { it.computeSerializedSize() }
        size += getIntIfMask(shipping, 2) { it.computeSerializedSize() }
        size += getIntIfMask(tipAmount, 8) { SIZE_INT64 }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(credentialsTitle)
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentReceipt) return false
        if (other === this) return true

        return _flags == other._flags
                && date == other.date
                && botId == other.botId
                && providerId == other.providerId
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && info == other.info
                && shipping == other.shipping
                && tipAmount == other.tipAmount
                && currency == other.currency
                && totalAmount == other.totalAmount
                && credentialsTitle == other.credentialsTitle
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x70c4fe03.toInt()
    }
}
