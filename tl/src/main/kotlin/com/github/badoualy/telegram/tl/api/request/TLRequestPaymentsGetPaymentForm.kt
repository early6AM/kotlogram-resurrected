package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsGetPaymentForm() : TLMethod<TLPaymentForm>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var themeParams: TLDataJSON? = null

    private val _constructor: String = "payments.getPaymentForm#8a333c8d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            msgId: Int,
            themeParams: TLDataJSON?
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.themeParams = themeParams
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPaymentForm = tlDeserializer.readTLObject(TLPaymentForm::class, TLPaymentForm.CONSTRUCTOR_ID)

    override fun computeFlags() {
        _flags = 0
        updateFlags(themeParams, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(msgId)
        doIfMask(themeParams, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        themeParams = readIfMask(1) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(themeParams, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && msgId == other.msgId
                && themeParams == other.themeParams
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8a333c8d.toInt()
    }
}
