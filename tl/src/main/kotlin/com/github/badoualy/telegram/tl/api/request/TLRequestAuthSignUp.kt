package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthSignUp() : TLMethod<TLAbsAuthorization>() {
    var phoneNumber: String = ""

    var phoneCodeHash: String = ""

    var firstName: String = ""

    var lastName: String = ""

    private val _constructor: String = "auth.signUp#80eee427"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            phoneCodeHash: String,
            firstName: String,
            lastName: String
    ) : this() {
        this.phoneNumber = phoneNumber
        this.phoneCodeHash = phoneCodeHash
        this.firstName = firstName
        this.lastName = lastName
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeString(phoneCodeHash)
        writeString(firstName)
        writeString(lastName)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        phoneCodeHash = readString()
        firstName = readString()
        lastName = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthSignUp) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && phoneCodeHash == other.phoneCodeHash
                && firstName == other.firstName
                && lastName == other.lastName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x80eee427.toInt()
    }
}
