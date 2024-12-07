package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputBotInlineMessageMediaInvoice#d7e78225
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineMessageMediaInvoice() : TLAbsInputBotInlineMessage() {
    var title: String = ""

    var description: String = ""

    var photo: TLInputWebDocument? = null

    var invoice: TLInvoice = TLInvoice()

    var payload: TLBytes = TLBytes.EMPTY

    var provider: String = ""

    var providerData: TLDataJSON = TLDataJSON()

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "inputBotInlineMessageMediaInvoice#d7e78225"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            description: String,
            photo: TLInputWebDocument?,
            invoice: TLInvoice,
            payload: TLBytes,
            provider: String,
            providerData: TLDataJSON,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.payload = payload
        this.provider = provider
        this.providerData = providerData
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
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
        writeTLObject(invoice)
        writeTLBytes(payload)
        writeString(provider)
        writeTLObject(providerData)
        doIfMask(1, replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        description = readString()
        photo = readIfMask(1, 1) { readTLObject<TLInputWebDocument>(TLInputWebDocument::class, TLInputWebDocument.CONSTRUCTOR_ID) }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        payload = readTLBytes()
        provider = readString()
        providerData = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
        replyMarkup = readIfMask(1, 4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(1, photo, 1) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += computeTLBytesSerializedSize(payload)
        size += computeTLStringSerializedSize(provider)
        size += providerData.computeSerializedSize()
        size += getIntIfMask(1, replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineMessageMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && payload == other.payload
                && provider == other.provider
                && providerData == other.providerData
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd7e78225.toInt()
    }
}
