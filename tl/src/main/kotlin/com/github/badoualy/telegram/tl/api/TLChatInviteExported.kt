package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * chatInviteExported#b18105e8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInviteExported() : TLObject() {
    @Transient
    var revoked: Boolean = false

    @Transient
    var permanent: Boolean = false

    var link: String = ""

    var adminId: Long = 0L

    var date: Int = 0

    var startDate: Int? = null

    var expireDate: Int? = null

    var usageLimit: Int? = null

    var usage: Int? = null

    private val _constructor: String = "chatInviteExported#b18105e8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            revoked: Boolean,
            permanent: Boolean,
            link: String,
            adminId: Long,
            date: Int,
            startDate: Int?,
            expireDate: Int?,
            usageLimit: Int?,
            usage: Int?
    ) : this() {
        this.revoked = revoked
        this.permanent = permanent
        this.link = link
        this.adminId = adminId
        this.date = date
        this.startDate = startDate
        this.expireDate = expireDate
        this.usageLimit = usageLimit
        this.usage = usage
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(revoked, 1)
        updateFlags(permanent, 32)
        updateFlags(startDate, 16)
        updateFlags(expireDate, 2)
        updateFlags(usageLimit, 4)
        updateFlags(usage, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(link)
        writeLong(adminId)
        writeInt(date)
        doIfMask(startDate, 16) { writeInt(it) }
        doIfMask(expireDate, 2) { writeInt(it) }
        doIfMask(usageLimit, 4) { writeInt(it) }
        doIfMask(usage, 8) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        revoked = isMask(1)
        permanent = isMask(32)
        link = readString()
        adminId = readLong()
        date = readInt()
        startDate = readIfMask(16) { readInt() }
        expireDate = readIfMask(2) { readInt() }
        usageLimit = readIfMask(4) { readInt() }
        usage = readIfMask(8) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(link)
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(startDate, 16) { SIZE_INT32 }
        size += getIntIfMask(expireDate, 2) { SIZE_INT32 }
        size += getIntIfMask(usageLimit, 4) { SIZE_INT32 }
        size += getIntIfMask(usage, 8) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInviteExported) return false
        if (other === this) return true

        return _flags == other._flags
                && revoked == other.revoked
                && permanent == other.permanent
                && link == other.link
                && adminId == other.adminId
                && date == other.date
                && startDate == other.startDate
                && expireDate == other.expireDate
                && usageLimit == other.usageLimit
                && usage == other.usage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb18105e8.toInt()
    }
}
