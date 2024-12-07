package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputCheckPasswordEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueWithdrawalUrl
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
class TLRequestPaymentsGetStarsRevenueWithdrawalUrl() : TLMethod<TLStarsRevenueWithdrawalUrl>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var stars: Long = 0L

    var password: TLAbsInputCheckPasswordSRP = TLInputCheckPasswordEmpty()

    private val _constructor: String = "payments.getStarsRevenueWithdrawalUrl#13bbe8b3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            stars: Long,
            password: TLAbsInputCheckPasswordSRP
    ) : this() {
        this.peer = peer
        this.stars = stars
        this.password = password
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStarsRevenueWithdrawalUrl = tlDeserializer.readTLObject(TLStarsRevenueWithdrawalUrl::class, TLStarsRevenueWithdrawalUrl.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeLong(stars)
        writeTLObject(password)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        stars = readLong()
        password = readTLObject<TLAbsInputCheckPasswordSRP>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += password.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsGetStarsRevenueWithdrawalUrl) return false
        if (other === this) return true

        return peer == other.peer
                && stars == other.stars
                && password == other.password
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x13bbe8b3.toInt()
    }
}
