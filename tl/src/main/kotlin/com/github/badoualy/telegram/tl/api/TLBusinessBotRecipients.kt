package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * businessBotRecipients#b88cf373
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBusinessBotRecipients() : TLObject() {
    @Transient
    var existingChats: Boolean = false

    @Transient
    var newChats: Boolean = false

    @Transient
    var contacts: Boolean = false

    @Transient
    var nonContacts: Boolean = false

    @Transient
    var excludeSelected: Boolean = false

    var users: TLLongVector? = null

    var excludeUsers: TLLongVector? = null

    private val _constructor: String = "businessBotRecipients#b88cf373"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            existingChats: Boolean,
            newChats: Boolean,
            contacts: Boolean,
            nonContacts: Boolean,
            excludeSelected: Boolean,
            users: TLLongVector?,
            excludeUsers: TLLongVector?
    ) : this() {
        this.existingChats = existingChats
        this.newChats = newChats
        this.contacts = contacts
        this.nonContacts = nonContacts
        this.excludeSelected = excludeSelected
        this.users = users
        this.excludeUsers = excludeUsers
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(existingChats, 1)
        updateFlags(newChats, 2)
        updateFlags(contacts, 4)
        updateFlags(nonContacts, 8)
        updateFlags(excludeSelected, 32)
        updateFlags(users, 16)
        updateFlags(excludeUsers, 64)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, users, 16) { writeTLVector(it) }
        doIfMask(1, excludeUsers, 64) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        existingChats = isMask(1, 1)
        newChats = isMask(1, 2)
        contacts = isMask(1, 4)
        nonContacts = isMask(1, 8)
        excludeSelected = isMask(1, 32)
        users = readIfMask(1, 16) { readTLLongVector() }
        excludeUsers = readIfMask(1, 64) { readTLLongVector() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, users, 16) { it.computeSerializedSize() }
        size += getIntIfMask(1, excludeUsers, 64) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBusinessBotRecipients) return false
        if (other === this) return true

        return _flags == other._flags
                && existingChats == other.existingChats
                && newChats == other.newChats
                && contacts == other.contacts
                && nonContacts == other.nonContacts
                && excludeSelected == other.excludeSelected
                && users == other.users
                && excludeUsers == other.excludeUsers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb88cf373.toInt()
    }
}
