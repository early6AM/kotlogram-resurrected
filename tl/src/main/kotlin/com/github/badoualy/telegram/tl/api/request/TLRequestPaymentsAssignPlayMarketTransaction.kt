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
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInputStorePaymentPremiumSubscription
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
class TLRequestPaymentsAssignPlayMarketTransaction() : TLMethod<TLAbsUpdates>() {
    var receipt: TLDataJSON = TLDataJSON()

    var purpose: TLAbsInputStorePaymentPurpose = TLInputStorePaymentPremiumSubscription()

    private val _constructor: String = "payments.assignPlayMarketTransaction#dffd50d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(receipt: TLDataJSON, purpose: TLAbsInputStorePaymentPurpose) : this() {
        this.receipt = receipt
        this.purpose = purpose
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(receipt)
        writeTLObject(purpose)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        receipt = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
        purpose = readTLObject<TLAbsInputStorePaymentPurpose>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += receipt.computeSerializedSize()
        size += purpose.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsAssignPlayMarketTransaction) return false
        if (other === this) return true

        return receipt == other.receipt
                && purpose == other.purpose
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdffd50d3.toInt()
    }
}
