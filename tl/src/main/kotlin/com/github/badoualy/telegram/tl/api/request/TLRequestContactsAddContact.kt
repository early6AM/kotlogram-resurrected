package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsAddContact() : TLMethod<TLAbsUpdates>() {
    @Transient
    var addPhonePrivacyException: Boolean = false

    var id: TLAbsInputUser = TLInputUserEmpty()

    var firstName: String = ""

    var lastName: String = ""

    var phone: String = ""

    private val _constructor: String = "contacts.addContact#e8f463d0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            addPhonePrivacyException: Boolean,
            id: TLAbsInputUser,
            firstName: String,
            lastName: String,
            phone: String
    ) : this() {
        this.addPhonePrivacyException = addPhonePrivacyException
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.phone = phone
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(addPhonePrivacyException, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        writeString(firstName)
        writeString(lastName)
        writeString(phone)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        addPhonePrivacyException = isMask(1)
        id = readTLObject<TLAbsInputUser>()
        firstName = readString()
        lastName = readString()
        phone = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        size += computeTLStringSerializedSize(phone)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsAddContact) return false
        if (other === this) return true

        return _flags == other._flags
                && addPhonePrivacyException == other.addPhonePrivacyException
                && id == other.id
                && firstName == other.firstName
                && lastName == other.lastName
                && phone == other.phone
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe8f463d0.toInt()
    }
}
