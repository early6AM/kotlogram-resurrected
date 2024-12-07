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
 * payments.paymentReceiptStars#dabbf83a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentReceiptStars() : TLAbsPaymentReceipt() {
    override var date: Int = 0

    override var botId: Long = 0L

    override var title: String = ""

    override var description: String = ""

    override var photo: TLAbsWebDocument? = null

    override var invoice: TLInvoice = TLInvoice()

    override var currency: String = ""

    override var totalAmount: Long = 0L

    var transactionId: String = ""

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentReceiptStars#dabbf83a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            date: Int,
            botId: Long,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            invoice: TLInvoice,
            currency: String,
            totalAmount: Long,
            transactionId: String,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.date = date
        this.botId = botId
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.currency = currency
        this.totalAmount = totalAmount
        this.transactionId = transactionId
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(photo, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(date)
        writeLong(botId)
        writeString(title)
        writeString(description)
        doIfMask(1, photo, 4) { writeTLObject(it) }
        writeTLObject(invoice)
        writeString(currency)
        writeLong(totalAmount)
        writeString(transactionId)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        date = readInt()
        botId = readLong()
        title = readString()
        description = readString()
        photo = readIfMask(1, 4) { readTLObject<TLAbsWebDocument>() }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        currency = readString()
        totalAmount = readLong()
        transactionId = readString()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(1, photo, 4) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(transactionId)
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentReceiptStars) return false
        if (other === this) return true

        return _flags == other._flags
                && date == other.date
                && botId == other.botId
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && currency == other.currency
                && totalAmount == other.totalAmount
                && transactionId == other.transactionId
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdabbf83a.toInt()
    }
}
