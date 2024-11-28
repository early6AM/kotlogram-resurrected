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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsDeleteHistory() : TLMethod<TLAbsUpdates>() {
    @Transient
    var forEveryone: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var maxId: Int = 0

    private val _constructor: String = "channels.deleteHistory#9baa9647"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forEveryone: Boolean,
            channel: TLAbsInputChannel,
            maxId: Int
    ) : this() {
        this.forEveryone = forEveryone
        this.channel = channel
        this.maxId = maxId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(forEveryone, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeInt(maxId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forEveryone = isMask(1)
        channel = readTLObject<TLAbsInputChannel>()
        maxId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsDeleteHistory) return false
        if (other === this) return true

        return _flags == other._flags
                && forEveryone == other.forEveryone
                && channel == other.channel
                && maxId == other.maxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9baa9647.toInt()
    }
}
