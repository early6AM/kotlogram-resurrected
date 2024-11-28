package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.stats.TLPublicForwards
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
class TLRequestStatsGetMessagePublicForwards() : TLMethod<TLPublicForwards>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var msgId: Int = 0

    var offset: String = ""

    var limit: Int = 0

    private val _constructor: String = "stats.getMessagePublicForwards#5f150144"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            msgId: Int,
            offset: String,
            limit: Int
    ) : this() {
        this.channel = channel
        this.msgId = msgId
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPublicForwards = tlDeserializer.readTLObject(TLPublicForwards::class, TLPublicForwards.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeInt(msgId)
        writeString(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        msgId = readInt()
        offset = readString()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        size += computeTLStringSerializedSize(offset)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStatsGetMessagePublicForwards) return false
        if (other === this) return true

        return channel == other.channel
                && msgId == other.msgId
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5f150144.toInt()
    }
}
