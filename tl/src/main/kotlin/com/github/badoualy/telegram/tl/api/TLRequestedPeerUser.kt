package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * requestedPeerUser#d62ff46a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestedPeerUser() : TLAbsRequestedPeer() {
    var userId: Long = 0L

    var firstName: String? = null

    var lastName: String? = null

    var username: String? = null

    override var photo: TLAbsPhoto? = null

    private val _constructor: String = "requestedPeerUser#d62ff46a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            firstName: String?,
            lastName: String?,
            username: String?,
            photo: TLAbsPhoto?
    ) : this() {
        this.userId = userId
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.photo = photo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(firstName, 1)
        updateFlags(lastName, 1)
        updateFlags(username, 2)
        updateFlags(photo, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        doIfMask(firstName, 1) { writeString(it) }
        doIfMask(lastName, 1) { writeString(it) }
        doIfMask(username, 2) { writeString(it) }
        doIfMask(photo, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userId = readLong()
        firstName = readIfMask(1) { readString() }
        lastName = readIfMask(1) { readString() }
        username = readIfMask(2) { readString() }
        photo = readIfMask(4) { readTLObject<TLAbsPhoto>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(firstName, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(lastName, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(username, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(photo, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestedPeerUser) return false
        if (other === this) return true

        return _flags == other._flags
                && userId == other.userId
                && firstName == other.firstName
                && lastName == other.lastName
                && username == other.username
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd62ff46a.toInt()
    }
}
