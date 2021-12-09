package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputPaymentCredentialsGooglePay#8ac32801
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPaymentCredentialsGooglePay() : TLAbsInputPaymentCredentials() {
    var paymentToken: TLDataJSON = TLDataJSON()

    private val _constructor: String = "inputPaymentCredentialsGooglePay#8ac32801"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(paymentToken: TLDataJSON) : this() {
        this.paymentToken = paymentToken
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(paymentToken)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        paymentToken = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += paymentToken.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPaymentCredentialsGooglePay) return false
        if (other === this) return true

        return paymentToken == other.paymentToken
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8ac32801.toInt()
    }
}
