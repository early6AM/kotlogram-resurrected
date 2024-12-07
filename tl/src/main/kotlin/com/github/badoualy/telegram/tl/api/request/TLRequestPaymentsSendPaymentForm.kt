package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice
import com.github.badoualy.telegram.tl.api.TLAbsInputPaymentCredentials
import com.github.badoualy.telegram.tl.api.TLInputInvoiceStars
import com.github.badoualy.telegram.tl.api.TLInputPaymentCredentialsApplePay
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsSendPaymentForm() : TLMethod<TLAbsPaymentResult>() {
    var formId: Long = 0L

    var invoice: TLAbsInputInvoice = TLInputInvoiceStars()

    var requestedInfoId: String? = null

    var shippingOptionId: String? = null

    var credentials: TLAbsInputPaymentCredentials = TLInputPaymentCredentialsApplePay()

    var tipAmount: Long? = null

    private val _constructor: String = "payments.sendPaymentForm#2d03522f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            formId: Long,
            invoice: TLAbsInputInvoice,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ) : this() {
        this.formId = formId
        this.invoice = invoice
        this.requestedInfoId = requestedInfoId
        this.shippingOptionId = shippingOptionId
        this.credentials = credentials
        this.tipAmount = tipAmount
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(requestedInfoId, 1)
        updateFlags(shippingOptionId, 2)
        updateFlags(tipAmount, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(formId)
        writeTLObject(invoice)
        doIfMask(requestedInfoId, 1) { writeString(it) }
        doIfMask(shippingOptionId, 2) { writeString(it) }
        writeTLObject(credentials)
        doIfMask(tipAmount, 4) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        formId = readLong()
        invoice = readTLObject<TLAbsInputInvoice>()
        requestedInfoId = readIfMask(1) { readString() }
        shippingOptionId = readIfMask(2) { readString() }
        credentials = readTLObject<TLAbsInputPaymentCredentials>()
        tipAmount = readIfMask(4) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += invoice.computeSerializedSize()
        size += getIntIfMask(requestedInfoId, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(shippingOptionId, 2) { computeTLStringSerializedSize(it) }
        size += credentials.computeSerializedSize()
        size += getIntIfMask(tipAmount, 4) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsSendPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && formId == other.formId
                && invoice == other.invoice
                && requestedInfoId == other.requestedInfoId
                && shippingOptionId == other.shippingOptionId
                && credentials == other.credentials
                && tipAmount == other.tipAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2d03522f.toInt()
    }
}
