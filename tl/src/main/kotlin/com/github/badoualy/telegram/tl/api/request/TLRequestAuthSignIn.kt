package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEmailVerification
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
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
class TLRequestAuthSignIn() : TLMethod<TLAbsAuthorization>() {
    var phoneNumber: String = ""

    var phoneCodeHash: String = ""

    var phoneCode: String? = null

    var emailVerification: TLAbsEmailVerification? = null

    private val _constructor: String = "auth.signIn#8d52a951"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String?,
            emailVerification: TLAbsEmailVerification?
    ) : this() {
        this.phoneNumber = phoneNumber
        this.phoneCodeHash = phoneCodeHash
        this.phoneCode = phoneCode
        this.emailVerification = emailVerification
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(phoneCode, 1)
        updateFlags(emailVerification, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(phoneNumber)
        writeString(phoneCodeHash)
        doIfMask(phoneCode, 1) { writeString(it) }
        doIfMask(emailVerification, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phoneNumber = readString()
        phoneCodeHash = readString()
        phoneCode = readIfMask(1) { readString() }
        emailVerification = readIfMask(2) { readTLObject<TLAbsEmailVerification>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += getIntIfMask(phoneCode, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(emailVerification, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthSignIn) return false
        if (other === this) return true

        return _flags == other._flags
                && phoneNumber == other.phoneNumber
                && phoneCodeHash == other.phoneCodeHash
                && phoneCode == other.phoneCode
                && emailVerification == other.emailVerification
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8d52a951.toInt()
    }
}
