package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelParticipantCreator#2fe601d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantCreator() : TLAbsChannelParticipant() {
    var userId: Long = 0L

    var adminRights: TLChatAdminRights = TLChatAdminRights()

    var rank: String? = null

    private val _constructor: String = "channelParticipantCreator#2fe601d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            adminRights: TLChatAdminRights,
            rank: String?
    ) : this() {
        this.userId = userId
        this.adminRights = adminRights
        this.rank = rank
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(rank, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        writeTLObject(adminRights)
        doIfMask(rank, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userId = readLong()
        adminRights = readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID)
        rank = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += adminRights.computeSerializedSize()
        size += getIntIfMask(rank, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantCreator) return false
        if (other === this) return true

        return _flags == other._flags
                && userId == other.userId
                && adminRights == other.adminRights
                && rank == other.rank
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2fe601d3
    }
}
