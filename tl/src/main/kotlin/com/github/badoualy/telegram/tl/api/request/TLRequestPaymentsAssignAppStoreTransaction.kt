package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputStorePaymentPurpose
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputStorePaymentPremiumSubscription
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsAssignAppStoreTransaction() : TLMethod<TLAbsUpdates>() {
    var receipt: TLBytes = TLBytes.EMPTY

    var purpose: TLAbsInputStorePaymentPurpose = TLInputStorePaymentPremiumSubscription()

    private val _constructor: String = "payments.assignAppStoreTransaction#80ed747d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(receipt: TLBytes, purpose: TLAbsInputStorePaymentPurpose) : this() {
        this.receipt = receipt
        this.purpose = purpose
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(receipt)
        writeTLObject(purpose)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        receipt = readTLBytes()
        purpose = readTLObject<TLAbsInputStorePaymentPurpose>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(receipt)
        size += purpose.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsAssignAppStoreTransaction) return false
        if (other === this) return true

        return receipt == other.receipt
                && purpose == other.purpose
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x80ed747d.toInt()
    }
}
