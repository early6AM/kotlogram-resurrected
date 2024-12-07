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
 * channelParticipantBanned#6df8014e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantBanned() : TLAbsChannelParticipant() {
    @Transient
    var left: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var kickedBy: Long = 0L

    var date: Int = 0

    var bannedRights: TLChatBannedRights = TLChatBannedRights()

    private val _constructor: String = "channelParticipantBanned#6df8014e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            left: Boolean,
            peer: TLAbsPeer,
            kickedBy: Long,
            date: Int,
            bannedRights: TLChatBannedRights
    ) : this() {
        this.left = left
        this.peer = peer
        this.kickedBy = kickedBy
        this.date = date
        this.bannedRights = bannedRights
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(left, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeLong(kickedBy)
        writeInt(date)
        writeTLObject(bannedRights)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        left = isMask(1, 1)
        peer = readTLObject<TLAbsPeer>()
        kickedBy = readLong()
        date = readInt()
        bannedRights = readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += SIZE_INT32
        size += bannedRights.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantBanned) return false
        if (other === this) return true

        return _flags == other._flags
                && left == other.left
                && peer == other.peer
                && kickedBy == other.kickedBy
                && date == other.date
                && bannedRights == other.bannedRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6df8014e.toInt()
    }
}
