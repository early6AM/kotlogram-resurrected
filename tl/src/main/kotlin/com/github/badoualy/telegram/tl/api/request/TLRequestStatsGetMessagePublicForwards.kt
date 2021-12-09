package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStatsGetMessagePublicForwards() : TLMethod<TLAbsMessages>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var msgId: Int = 0

    var offsetRate: Int = 0

    var offsetPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var offsetId: Int = 0

    var limit: Int = 0

    private val _constructor: String = "stats.getMessagePublicForwards#5630281b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            msgId: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ) : this() {
        this.channel = channel
        this.msgId = msgId
        this.offsetRate = offsetRate
        this.offsetPeer = offsetPeer
        this.offsetId = offsetId
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeInt(msgId)
        writeInt(offsetRate)
        writeTLObject(offsetPeer)
        writeInt(offsetId)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        msgId = readInt()
        offsetRate = readInt()
        offsetPeer = readTLObject<TLAbsInputPeer>()
        offsetId = readInt()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += offsetPeer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStatsGetMessagePublicForwards) return false
        if (other === this) return true

        return channel == other.channel
                && msgId == other.msgId
                && offsetRate == other.offsetRate
                && offsetPeer == other.offsetPeer
                && offsetId == other.offsetId
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5630281b
    }
}
