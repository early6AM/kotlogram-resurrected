package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPaymentCredentials
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPaymentCredentialsApplePay
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsSendPaymentForm() : TLMethod<TLAbsPaymentResult>() {
    var formId: Long = 0L

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var requestedInfoId: String? = null

    var shippingOptionId: String? = null

    var credentials: TLAbsInputPaymentCredentials = TLInputPaymentCredentialsApplePay()

    var tipAmount: Long? = null

    private val _constructor: String = "payments.sendPaymentForm#30c3bc9d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            formId: Long,
            peer: TLAbsInputPeer,
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ) : this() {
        this.formId = formId
        this.peer = peer
        this.msgId = msgId
        this.requestedInfoId = requestedInfoId
        this.shippingOptionId = shippingOptionId
        this.credentials = credentials
        this.tipAmount = tipAmount
    }

    override fun computeFlags() {
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
        writeTLObject(peer)
        writeInt(msgId)
        doIfMask(requestedInfoId, 1) { writeString(it) }
        doIfMask(shippingOptionId, 2) { writeString(it) }
        writeTLObject(credentials)
        doIfMask(tipAmount, 4) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        formId = readLong()
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
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
        size += peer.computeSerializedSize()
        size += SIZE_INT32
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
                && peer == other.peer
                && msgId == other.msgId
                && requestedInfoId == other.requestedInfoId
                && shippingOptionId == other.shippingOptionId
                && credentials == other.credentials
                && tipAmount == other.tipAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x30c3bc9d
    }
}
