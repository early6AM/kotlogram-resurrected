package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
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
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsReorderPinnedForumTopics() : TLMethod<TLAbsUpdates>() {
    @Transient
    var force: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var order: TLIntVector = TLIntVector()

    private val _constructor: String = "channels.reorderPinnedForumTopics#2950a18f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            force: Boolean,
            channel: TLAbsInputChannel,
            order: TLIntVector
    ) : this() {
        this.force = force
        this.channel = channel
        this.order = order
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(force, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeTLVector(order)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        force = isMask(1, 1)
        channel = readTLObject<TLAbsInputChannel>()
        order = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += order.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsReorderPinnedForumTopics) return false
        if (other === this) return true

        return _flags == other._flags
                && force == other.force
                && channel == other.channel
                && order == other.order
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2950a18f.toInt()
    }
}
