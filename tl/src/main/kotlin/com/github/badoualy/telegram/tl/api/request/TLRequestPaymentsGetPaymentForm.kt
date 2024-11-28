package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputInvoice
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInputInvoiceSlug
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsGetPaymentForm() : TLMethod<TLPaymentForm>() {
    var invoice: TLAbsInputInvoice = TLInputInvoiceSlug()

    var themeParams: TLDataJSON? = null

    private val _constructor: String = "payments.getPaymentForm#37148dbb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(invoice: TLAbsInputInvoice, themeParams: TLDataJSON?) : this() {
        this.invoice = invoice
        this.themeParams = themeParams
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPaymentForm = tlDeserializer.readTLObject(TLPaymentForm::class, TLPaymentForm.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(themeParams, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(invoice)
        doIfMask(themeParams, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        invoice = readTLObject<TLAbsInputInvoice>()
        themeParams = readIfMask(1) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += invoice.computeSerializedSize()
        size += getIntIfMask(themeParams, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && invoice == other.invoice
                && themeParams == other.themeParams
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x37148dbb.toInt()
    }
}
