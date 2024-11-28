package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerifyPurpose
import com.github.badoualy.telegram.tl.api.TLEmailVerifyPurposeLoginChange
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode
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
class TLRequestAccountSendVerifyEmailCode() : TLMethod<TLSentEmailCode>() {
    var purpose: TLAbsEmailVerifyPurpose = TLEmailVerifyPurposeLoginChange()

    var email: String = ""

    private val _constructor: String = "account.sendVerifyEmailCode#98e037bb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(purpose: TLAbsEmailVerifyPurpose, email: String) : this() {
        this.purpose = purpose
        this.email = email
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSentEmailCode = tlDeserializer.readTLObject(TLSentEmailCode::class, TLSentEmailCode.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(purpose)
        writeString(email)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        purpose = readTLObject<TLAbsEmailVerifyPurpose>()
        email = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += purpose.computeSerializedSize()
        size += computeTLStringSerializedSize(email)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSendVerifyEmailCode) return false
        if (other === this) return true

        return purpose == other.purpose
                && email == other.email
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98e037bb.toInt()
    }
}
