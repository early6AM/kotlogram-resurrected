package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsValidateRequestedInfo() : TLMethod<TLValidatedRequestedInfo>() {
    @Transient
    var save: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var info: TLPaymentRequestedInfo = TLPaymentRequestedInfo()

    private val _constructor: String = "payments.validateRequestedInfo#db103170"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            save: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ) : this() {
        this.save = save
        this.peer = peer
        this.msgId = msgId
        this.info = info
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLValidatedRequestedInfo = tlDeserializer.readTLObject(TLValidatedRequestedInfo::class, TLValidatedRequestedInfo.CONSTRUCTOR_ID)

    override fun computeFlags() {
        _flags = 0
        updateFlags(save, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(msgId)
        writeTLObject(info)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        save = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        info = readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += info.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsValidateRequestedInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && save == other.save
                && peer == other.peer
                && msgId == other.msgId
                && info == other.info
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdb103170.toInt()
    }
}
