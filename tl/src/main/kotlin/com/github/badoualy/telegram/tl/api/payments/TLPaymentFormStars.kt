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
 * payments.paymentFormStars#7bf6b15c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentFormStars() : TLAbsPaymentForm() {
    override var formId: Long = 0L

    override var botId: Long = 0L

    override var title: String = ""

    override var description: String = ""

    override var photo: TLAbsWebDocument? = null

    override var invoice: TLInvoice = TLInvoice()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentFormStars#7bf6b15c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            formId: Long,
            botId: Long,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            invoice: TLInvoice,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.formId = formId
        this.botId = botId
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(formId)
        writeLong(botId)
        writeString(title)
        writeString(description)
        doIfMask(photo, 32) { writeTLObject(it) }
        writeTLObject(invoice)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        formId = readLong()
        botId = readLong()
        title = readString()
        description = readString()
        photo = readIfMask(32) { readTLObject<TLAbsWebDocument>() }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(photo, 32) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentFormStars) return false
        if (other === this) return true

        return _flags == other._flags
                && formId == other.formId
                && botId == other.botId
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7bf6b15c.toInt()
    }
}
