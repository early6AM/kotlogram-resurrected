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
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsValidateRequestedInfo() : TLMethod<TLValidatedRequestedInfo>() {
    @Transient
    var save: Boolean = false

    var invoice: TLAbsInputInvoice = TLInputInvoiceStars()

    var info: TLPaymentRequestedInfo = TLPaymentRequestedInfo()

    private val _constructor: String = "payments.validateRequestedInfo#b6c8f12b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            save: Boolean,
            invoice: TLAbsInputInvoice,
            info: TLPaymentRequestedInfo
    ) : this() {
        this.save = save
        this.invoice = invoice
        this.info = info
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLValidatedRequestedInfo = tlDeserializer.readTLObject(TLValidatedRequestedInfo::class, TLValidatedRequestedInfo.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(save, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(invoice)
        writeTLObject(info)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        save = isMask(1)
        invoice = readTLObject<TLAbsInputInvoice>()
        info = readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += invoice.computeSerializedSize()
        size += info.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsValidateRequestedInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && save == other.save
                && invoice == other.invoice
                && info == other.info
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb6c8f12b.toInt()
    }
}
