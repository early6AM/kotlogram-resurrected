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
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics
import com.github.badoualy.telegram.tl.core.TLIntVector
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
class TLRequestChannelsGetForumTopicsByID() : TLMethod<TLForumTopics>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var topics: TLIntVector = TLIntVector()

    private val _constructor: String = "channels.getForumTopicsByID#b0831eb9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channel: TLAbsInputChannel, topics: TLIntVector) : this() {
        this.channel = channel
        this.topics = topics
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLForumTopics = tlDeserializer.readTLObject(TLForumTopics::class, TLForumTopics.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLVector(topics)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        topics = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += topics.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsGetForumTopicsByID) return false
        if (other === this) return true

        return channel == other.channel
                && topics == other.topics
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb0831eb9.toInt()
    }
}
