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
 * messageMediaInvoice#f6a548d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaInvoice() : TLAbsMessageMedia() {
    @Transient
    var shippingAddressRequested: Boolean = false

    @Transient
    var test: Boolean = false

    var title: String = ""

    var description: String = ""

    var photo: TLAbsWebDocument? = null

    var receiptMsgId: Int? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    var startParam: String = ""

    var extendedMedia: TLAbsMessageExtendedMedia? = null

    private val _constructor: String = "messageMediaInvoice#f6a548d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            shippingAddressRequested: Boolean,
            test: Boolean,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            receiptMsgId: Int?,
            currency: String,
            totalAmount: Long,
            startParam: String,
            extendedMedia: TLAbsMessageExtendedMedia?
    ) : this() {
        this.shippingAddressRequested = shippingAddressRequested
        this.test = test
        this.title = title
        this.description = description
        this.photo = photo
        this.receiptMsgId = receiptMsgId
        this.currency = currency
        this.totalAmount = totalAmount
        this.startParam = startParam
        this.extendedMedia = extendedMedia
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(shippingAddressRequested, 2)
        updateFlags(test, 8)
        updateFlags(photo, 1)
        updateFlags(receiptMsgId, 4)
        updateFlags(extendedMedia, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(1, photo, 1) { writeTLObject(it) }
        doIfMask(1, receiptMsgId, 4) { writeInt(it) }
        writeString(currency)
        writeLong(totalAmount)
        writeString(startParam)
        doIfMask(1, extendedMedia, 16) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        shippingAddressRequested = isMask(1, 2)
        test = isMask(1, 8)
        title = readString()
        description = readString()
        photo = readIfMask(1, 1) { readTLObject<TLAbsWebDocument>() }
        receiptMsgId = readIfMask(1, 4) { readInt() }
        currency = readString()
        totalAmount = readLong()
        startParam = readString()
        extendedMedia = readIfMask(1, 16) { readTLObject<TLAbsMessageExtendedMedia>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(1, photo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, receiptMsgId, 4) { SIZE_INT32 }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(startParam)
        size += getIntIfMask(1, extendedMedia, 16) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && shippingAddressRequested == other.shippingAddressRequested
                && test == other.test
                && title == other.title
                && description == other.description
                && photo == other.photo
                && receiptMsgId == other.receiptMsgId
                && currency == other.currency
                && totalAmount == other.totalAmount
                && startParam == other.startParam
                && extendedMedia == other.extendedMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf6a548d3.toInt()
    }
}
