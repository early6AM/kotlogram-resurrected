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
import kotlin.jvm.Transient

/**
 * messageActionPaymentSent#96163f56
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionPaymentSent() : TLAbsMessageAction() {
    @Transient
    var recurringInit: Boolean = false

    @Transient
    var recurringUsed: Boolean = false

    var currency: String = ""

    var totalAmount: Long = 0L

    var invoiceSlug: String? = null

    private val _constructor: String = "messageActionPaymentSent#96163f56"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            recurringInit: Boolean,
            recurringUsed: Boolean,
            currency: String,
            totalAmount: Long,
            invoiceSlug: String?
    ) : this() {
        this.recurringInit = recurringInit
        this.recurringUsed = recurringUsed
        this.currency = currency
        this.totalAmount = totalAmount
        this.invoiceSlug = invoiceSlug
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(recurringInit, 4)
        updateFlags(recurringUsed, 8)
        updateFlags(invoiceSlug, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(currency)
        writeLong(totalAmount)
        doIfMask(invoiceSlug, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        recurringInit = isMask(4)
        recurringUsed = isMask(8)
        currency = readString()
        totalAmount = readLong()
        invoiceSlug = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += getIntIfMask(invoiceSlug, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionPaymentSent) return false
        if (other === this) return true

        return _flags == other._flags
                && recurringInit == other.recurringInit
                && recurringUsed == other.recurringUsed
                && currency == other.currency
                && totalAmount == other.totalAmount
                && invoiceSlug == other.invoiceSlug
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x96163f56.toInt()
    }
}
