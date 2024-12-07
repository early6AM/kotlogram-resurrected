package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice
import com.github.badoualy.telegram.tl.api.TLInputInvoiceStars
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
class TLRequestPaymentsSendStarsForm() : TLMethod<TLAbsPaymentResult>() {
    var formId: Long = 0L

    var invoice: TLAbsInputInvoice = TLInputInvoiceStars()

    private val _constructor: String = "payments.sendStarsForm#2bb731d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(formId: Long, invoice: TLAbsInputInvoice) : this() {
        this.formId = formId
        this.invoice = invoice
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(_flags)
        writeLong(formId)
        writeTLObject(invoice)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        formId = readLong()
        invoice = readTLObject<TLAbsInputInvoice>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += invoice.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsSendStarsForm) return false
        if (other === this) return true

        return _flags == other._flags
                && formId == other.formId
                && invoice == other.invoice
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2bb731d.toInt()
    }
}
