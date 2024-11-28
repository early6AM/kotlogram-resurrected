package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * updateUserName#a7848924
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateUserName() : TLAbsUpdate() {
    var userId: Long = 0L

    var firstName: String = ""

    var lastName: String = ""

    var usernames: TLObjectVector<TLUsername> = TLObjectVector()

    private val _constructor: String = "updateUserName#a7848924"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            firstName: String,
            lastName: String,
            usernames: TLObjectVector<TLUsername>
    ) : this() {
        this.userId = userId
        this.firstName = firstName
        this.lastName = lastName
        this.usernames = usernames
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeString(firstName)
        writeString(lastName)
        writeTLVector(usernames)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        firstName = readString()
        lastName = readString()
        usernames = readTLVector<TLUsername>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        size += usernames.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateUserName) return false
        if (other === this) return true

        return userId == other.userId
                && firstName == other.firstName
                && lastName == other.lastName
                && usernames == other.usernames
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa7848924.toInt()
    }
}
