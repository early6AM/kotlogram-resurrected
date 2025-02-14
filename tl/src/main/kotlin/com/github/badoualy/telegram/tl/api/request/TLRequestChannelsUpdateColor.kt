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
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsUpdateColor() : TLMethod<TLAbsUpdates>() {
    @Transient
    var forProfile: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var color: Int? = null

    var backgroundEmojiId: Long? = null

    private val _constructor: String = "channels.updateColor#d8aa3671"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forProfile: Boolean,
            channel: TLAbsInputChannel,
            color: Int?,
            backgroundEmojiId: Long?
    ) : this() {
        this.forProfile = forProfile
        this.channel = channel
        this.color = color
        this.backgroundEmojiId = backgroundEmojiId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(forProfile, 2)
        updateFlags(color, 4)
        updateFlags(backgroundEmojiId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        doIfMask(color, 4) { writeInt(it) }
        doIfMask(backgroundEmojiId, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forProfile = isMask(2)
        channel = readTLObject<TLAbsInputChannel>()
        color = readIfMask(4) { readInt() }
        backgroundEmojiId = readIfMask(1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += getIntIfMask(color, 4) { SIZE_INT32 }
        size += getIntIfMask(backgroundEmojiId, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsUpdateColor) return false
        if (other === this) return true

        return _flags == other._flags
                && forProfile == other.forProfile
                && channel == other.channel
                && color == other.color
                && backgroundEmojiId == other.backgroundEmojiId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd8aa3671.toInt()
    }
}
