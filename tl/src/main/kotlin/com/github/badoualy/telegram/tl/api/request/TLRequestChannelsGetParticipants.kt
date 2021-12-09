package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLChannelParticipantsRecent
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsGetParticipants() : TLMethod<TLAbsChannelParticipants>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var filter: TLAbsChannelParticipantsFilter = TLChannelParticipantsRecent()

    var offset: Int = 0

    var limit: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "channels.getParticipants#77ced9d0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Long
    ) : this() {
        this.channel = channel
        this.filter = filter
        this.offset = offset
        this.limit = limit
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(filter)
        writeInt(offset)
        writeInt(limit)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        filter = readTLObject<TLAbsChannelParticipantsFilter>()
        offset = readInt()
        limit = readInt()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsGetParticipants) return false
        if (other === this) return true

        return channel == other.channel
                && filter == other.filter
                && offset == other.offset
                && limit == other.limit
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x77ced9d0
    }
}
