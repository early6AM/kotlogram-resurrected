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
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInvoice
import com.github.badoualy.telegram.tl.api.TLPaymentFormMethod
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.api.TLPaymentSavedCredentialsCard
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
import kotlin.jvm.Transient

/**
 * payments.paymentForm#a0058751
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentForm() : TLAbsPaymentForm() {
    @Transient
    var canSaveCredentials: Boolean = false

    @Transient
    var passwordMissing: Boolean = false

    override var formId: Long = 0L

    override var botId: Long = 0L

    override var title: String = ""

    override var description: String = ""

    override var photo: TLAbsWebDocument? = null

    override var invoice: TLInvoice = TLInvoice()

    var providerId: Long = 0L

    var url: String = ""

    var nativeProvider: String? = null

    var nativeParams: TLDataJSON? = null

    var additionalMethods: TLObjectVector<TLPaymentFormMethod>? = TLObjectVector()

    var savedInfo: TLPaymentRequestedInfo? = null

    var savedCredentials: TLObjectVector<TLPaymentSavedCredentialsCard>? = TLObjectVector()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentForm#a0058751"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canSaveCredentials: Boolean,
            passwordMissing: Boolean,
            formId: Long,
            botId: Long,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            invoice: TLInvoice,
            providerId: Long,
            url: String,
            nativeProvider: String?,
            nativeParams: TLDataJSON?,
            additionalMethods: TLObjectVector<TLPaymentFormMethod>?,
            savedInfo: TLPaymentRequestedInfo?,
            savedCredentials: TLObjectVector<TLPaymentSavedCredentialsCard>?,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.canSaveCredentials = canSaveCredentials
        this.passwordMissing = passwordMissing
        this.formId = formId
        this.botId = botId
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.providerId = providerId
        this.url = url
        this.nativeProvider = nativeProvider
        this.nativeParams = nativeParams
        this.additionalMethods = additionalMethods
        this.savedInfo = savedInfo
        this.savedCredentials = savedCredentials
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canSaveCredentials, 4)
        updateFlags(passwordMissing, 8)
        updateFlags(photo, 32)
        updateFlags(nativeProvider, 16)
        updateFlags(nativeParams, 16)
        updateFlags(additionalMethods, 64)
        updateFlags(savedInfo, 1)
        updateFlags(savedCredentials, 2)
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
        writeLong(providerId)
        writeString(url)
        doIfMask(nativeProvider, 16) { writeString(it) }
        doIfMask(nativeParams, 16) { writeTLObject(it) }
        doIfMask(additionalMethods, 64) { writeTLVector(it) }
        doIfMask(savedInfo, 1) { writeTLObject(it) }
        doIfMask(savedCredentials, 2) { writeTLVector(it) }
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canSaveCredentials = isMask(4)
        passwordMissing = isMask(8)
        formId = readLong()
        botId = readLong()
        title = readString()
        description = readString()
        photo = readIfMask(32) { readTLObject<TLAbsWebDocument>() }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        providerId = readLong()
        url = readString()
        nativeProvider = readIfMask(16) { readString() }
        nativeParams = readIfMask(16) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        additionalMethods = readIfMask(64) { readTLVector<TLPaymentFormMethod>() }
        savedInfo = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        savedCredentials = readIfMask(2) { readTLVector<TLPaymentSavedCredentialsCard>() }
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
        size += SIZE_INT64
        size += computeTLStringSerializedSize(url)
        size += getIntIfMask(nativeProvider, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(nativeParams, 16) { it.computeSerializedSize() }
        size += getIntIfMask(additionalMethods, 64) { it.computeSerializedSize() }
        size += getIntIfMask(savedInfo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(savedCredentials, 2) { it.computeSerializedSize() }
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && canSaveCredentials == other.canSaveCredentials
                && passwordMissing == other.passwordMissing
                && formId == other.formId
                && botId == other.botId
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && providerId == other.providerId
                && url == other.url
                && nativeProvider == other.nativeProvider
                && nativeParams == other.nativeParams
                && additionalMethods == other.additionalMethods
                && savedInfo == other.savedInfo
                && savedCredentials == other.savedCredentials
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa0058751.toInt()
    }
}
