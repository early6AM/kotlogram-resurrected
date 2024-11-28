package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputStorePaymentPurpose
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputStorePaymentPremiumSubscription
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsLaunchPrepaidGiveaway() : TLMethod<TLAbsUpdates>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var giveawayId: Long = 0L

    var purpose: TLAbsInputStorePaymentPurpose = TLInputStorePaymentPremiumSubscription()

    private val _constructor: String = "payments.launchPrepaidGiveaway#5ff58f20"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            giveawayId: Long,
            purpose: TLAbsInputStorePaymentPurpose
    ) : this() {
        this.peer = peer
        this.giveawayId = giveawayId
        this.purpose = purpose
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeLong(giveawayId)
        writeTLObject(purpose)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        giveawayId = readLong()
        purpose = readTLObject<TLAbsInputStorePaymentPurpose>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += purpose.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsLaunchPrepaidGiveaway) return false
        if (other === this) return true

        return peer == other.peer
                && giveawayId == other.giveawayId
                && purpose == other.purpose
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5ff58f20.toInt()
    }
}
