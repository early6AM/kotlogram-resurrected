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
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats
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
class TLRequestStatsGetMessageStats() : TLMethod<TLMessageStats>() {
    @Transient
    var dark: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var msgId: Int = 0

    private val _constructor: String = "stats.getMessageStats#b6e0a3f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dark: Boolean,
            channel: TLAbsInputChannel,
            msgId: Int
    ) : this() {
        this.dark = dark
        this.channel = channel
        this.msgId = msgId
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLMessageStats = tlDeserializer.readTLObject(TLMessageStats::class, TLMessageStats.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(dark, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeInt(msgId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1)
        channel = readTLObject<TLAbsInputChannel>()
        msgId = readInt()
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
        if (other !is TLRequestStatsGetMessageStats) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && channel == other.channel
                && msgId == other.msgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb6e0a3f5.toInt()
    }
}
