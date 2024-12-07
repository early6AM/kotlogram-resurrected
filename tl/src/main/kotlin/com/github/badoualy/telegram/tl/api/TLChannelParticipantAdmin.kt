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
import kotlin.jvm.Transient

/**
 * channelParticipantAdmin#34c3bb53
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantAdmin() : TLAbsChannelParticipant() {
    @Transient
    var canEdit: Boolean = false

    @Transient
    var self: Boolean = false

    var userId: Long = 0L

    var inviterId: Long? = null

    var promotedBy: Long = 0L

    var date: Int = 0

    var adminRights: TLChatAdminRights = TLChatAdminRights()

    var rank: String? = null

    private val _constructor: String = "channelParticipantAdmin#34c3bb53"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canEdit: Boolean,
            self: Boolean,
            userId: Long,
            inviterId: Long?,
            promotedBy: Long,
            date: Int,
            adminRights: TLChatAdminRights,
            rank: String?
    ) : this() {
        this.canEdit = canEdit
        this.self = self
        this.userId = userId
        this.inviterId = inviterId
        this.promotedBy = promotedBy
        this.date = date
        this.adminRights = adminRights
        this.rank = rank
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(canEdit, 1)
        updateFlags(self, 2)
        updateFlags(inviterId, 2)
        updateFlags(rank, 4)

        // Following parameters might be forced to true by another field that updated the flags
        self = isMask(1, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        doIfMask(1, inviterId, 2) { writeLong(it) }
        writeLong(promotedBy)
        writeInt(date)
        writeTLObject(adminRights)
        doIfMask(1, rank, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canEdit = isMask(1, 1)
        self = isMask(1, 2)
        userId = readLong()
        inviterId = readIfMask(1, 2) { readLong() }
        promotedBy = readLong()
        date = readInt()
        adminRights = readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID)
        rank = readIfMask(1, 4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, inviterId, 2) { SIZE_INT64 }
        size += SIZE_INT64
        size += SIZE_INT32
        size += adminRights.computeSerializedSize()
        size += getIntIfMask(1, rank, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantAdmin) return false
        if (other === this) return true

        return _flags == other._flags
                && canEdit == other.canEdit
                && self == other.self
                && userId == other.userId
                && inviterId == other.inviterId
                && promotedBy == other.promotedBy
                && date == other.date
                && adminRights == other.adminRights
                && rank == other.rank
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x34c3bb53.toInt()
    }
}
