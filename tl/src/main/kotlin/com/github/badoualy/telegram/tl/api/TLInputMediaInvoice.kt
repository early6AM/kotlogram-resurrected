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
 * inputMediaInvoice#405fef0d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaInvoice() : TLAbsInputMedia() {
    var title: String = ""

    var description: String = ""

    var photo: TLInputWebDocument? = null

    var invoice: TLInvoice = TLInvoice()

    var payload: TLBytes = TLBytes.EMPTY

    var provider: String? = null

    var providerData: TLDataJSON = TLDataJSON()

    var startParam: String? = null

    var extendedMedia: TLAbsInputMedia? = null

    private val _constructor: String = "inputMediaInvoice#405fef0d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            description: String,
            photo: TLInputWebDocument?,
            invoice: TLInvoice,
            payload: TLBytes,
            provider: String?,
            providerData: TLDataJSON,
            startParam: String?,
            extendedMedia: TLAbsInputMedia?
    ) : this() {
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.payload = payload
        this.provider = provider
        this.providerData = providerData
        this.startParam = startParam
        this.extendedMedia = extendedMedia
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 1)
        updateFlags(provider, 8)
        updateFlags(startParam, 2)
        updateFlags(extendedMedia, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(photo, 1) { writeTLObject(it) }
        writeTLObject(invoice)
        writeTLBytes(payload)
        doIfMask(provider, 8) { writeString(it) }
        writeTLObject(providerData)
        doIfMask(startParam, 2) { writeString(it) }
        doIfMask(extendedMedia, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        description = readString()
        photo = readIfMask(1) { readTLObject<TLInputWebDocument>(TLInputWebDocument::class, TLInputWebDocument.CONSTRUCTOR_ID) }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        payload = readTLBytes()
        provider = readIfMask(8) { readString() }
        providerData = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
        startParam = readIfMask(2) { readString() }
        extendedMedia = readIfMask(4) { readTLObject<TLAbsInputMedia>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += computeTLBytesSerializedSize(payload)
        size += getIntIfMask(provider, 8) { computeTLStringSerializedSize(it) }
        size += providerData.computeSerializedSize()
        size += getIntIfMask(startParam, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(extendedMedia, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && payload == other.payload
                && provider == other.provider
                && providerData == other.providerData
                && startParam == other.startParam
                && extendedMedia == other.extendedMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x405fef0d.toInt()
    }
}
