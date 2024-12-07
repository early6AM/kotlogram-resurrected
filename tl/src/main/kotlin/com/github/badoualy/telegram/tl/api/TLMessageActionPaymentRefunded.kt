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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageActionPaymentRefunded#41b3e202
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionPaymentRefunded() : TLAbsMessageAction() {
    var peer: TLAbsPeer = TLPeerChat()

    var currency: String = ""

    var totalAmount: Long = 0L

    var payload: TLBytes? = null

    var charge: TLPaymentCharge = TLPaymentCharge()

    private val _constructor: String = "messageActionPaymentRefunded#41b3e202"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            currency: String,
            totalAmount: Long,
            payload: TLBytes?,
            charge: TLPaymentCharge
    ) : this() {
        this.peer = peer
        this.currency = currency
        this.totalAmount = totalAmount
        this.payload = payload
        this.charge = charge
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(payload, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeString(currency)
        writeLong(totalAmount)
        doIfMask(payload, 1) { writeTLBytes(it) }
        writeTLObject(charge)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsPeer>()
        currency = readString()
        totalAmount = readLong()
        payload = readIfMask(1) { readTLBytes() }
        charge = readTLObject<TLPaymentCharge>(TLPaymentCharge::class, TLPaymentCharge.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += getIntIfMask(payload, 1) { computeTLBytesSerializedSize(it) }
        size += charge.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionPaymentRefunded) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && currency == other.currency
                && totalAmount == other.totalAmount
                && payload == other.payload
                && charge == other.charge
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x41b3e202.toInt()
    }
}
