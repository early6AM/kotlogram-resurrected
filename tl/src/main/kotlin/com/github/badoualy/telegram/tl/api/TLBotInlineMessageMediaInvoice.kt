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
 * botInlineMessageMediaInvoice#354a9b09
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInlineMessageMediaInvoice() : TLAbsBotInlineMessage() {
    @Transient
    var shippingAddressRequested: Boolean = false

    @Transient
    var test: Boolean = false

    var title: String = ""

    var description: String = ""

    var photo: TLAbsWebDocument? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "botInlineMessageMediaInvoice#354a9b09"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            shippingAddressRequested: Boolean,
            test: Boolean,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            currency: String,
            totalAmount: Long,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.shippingAddressRequested = shippingAddressRequested
        this.test = test
        this.title = title
        this.description = description
        this.photo = photo
        this.currency = currency
        this.totalAmount = totalAmount
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(shippingAddressRequested, 2)
        updateFlags(test, 8)
        updateFlags(photo, 1)
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(1, photo, 1) { writeTLObject(it) }
        writeString(currency)
        writeLong(totalAmount)
        doIfMask(1, replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        shippingAddressRequested = isMask(1, 2)
        test = isMask(1, 8)
        title = readString()
        description = readString()
        photo = readIfMask(1, 1) { readTLObject<TLAbsWebDocument>() }
        currency = readString()
        totalAmount = readLong()
        replyMarkup = readIfMask(1, 4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(1, photo, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += getIntIfMask(1, replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInlineMessageMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && shippingAddressRequested == other.shippingAddressRequested
                && test == other.test
                && title == other.title
                && description == other.description
                && photo == other.photo
                && currency == other.currency
                && totalAmount == other.totalAmount
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x354a9b09.toInt()
    }
}
