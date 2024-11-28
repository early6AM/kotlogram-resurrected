package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLChatBannedRights
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
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
class TLRequestChannelsEditBanned() : TLMethod<TLAbsUpdates>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var participant: TLAbsInputPeer = TLInputPeerEmpty()

    var bannedRights: TLChatBannedRights = TLChatBannedRights()

    private val _constructor: String = "channels.editBanned#96e6cd81"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            bannedRights: TLChatBannedRights
    ) : this() {
        this.channel = channel
        this.participant = participant
        this.bannedRights = bannedRights
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(participant)
        writeTLObject(bannedRights)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        participant = readTLObject<TLAbsInputPeer>()
        bannedRights = readTLObject<TLChatBannedRights>(TLChatBannedRights::class, TLChatBannedRights.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += participant.computeSerializedSize()
        size += bannedRights.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsEditBanned) return false
        if (other === this) return true

        return channel == other.channel
                && participant == other.participant
                && bannedRights == other.bannedRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x96e6cd81.toInt()
    }
}
