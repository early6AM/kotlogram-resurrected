package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerification
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerifyPurpose
import com.github.badoualy.telegram.tl.api.TLEmailVerificationApple
import com.github.badoualy.telegram.tl.api.TLEmailVerifyPurposeLoginChange
import com.github.badoualy.telegram.tl.api.account.TLAbsEmailVerified
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
class TLRequestAccountVerifyEmail() : TLMethod<TLAbsEmailVerified>() {
    var purpose: TLAbsEmailVerifyPurpose = TLEmailVerifyPurposeLoginChange()

    var verification: TLAbsEmailVerification = TLEmailVerificationApple()

    private val _constructor: String = "account.verifyEmail#32da4cf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(purpose: TLAbsEmailVerifyPurpose, verification: TLAbsEmailVerification) : this() {
        this.purpose = purpose
        this.verification = verification
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(purpose)
        writeTLObject(verification)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        purpose = readTLObject<TLAbsEmailVerifyPurpose>()
        verification = readTLObject<TLAbsEmailVerification>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += purpose.computeSerializedSize()
        size += verification.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountVerifyEmail) return false
        if (other === this) return true

        return purpose == other.purpose
                && verification == other.verification
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x32da4cf.toInt()
    }
}
