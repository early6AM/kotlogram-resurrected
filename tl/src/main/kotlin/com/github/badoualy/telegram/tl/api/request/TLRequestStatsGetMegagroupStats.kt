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
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats
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
class TLRequestStatsGetMegagroupStats() : TLMethod<TLMegagroupStats>() {
    @Transient
    var dark: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    private val _constructor: String = "stats.getMegagroupStats#dcdf8607"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(dark: Boolean, channel: TLAbsInputChannel) : this() {
        this.dark = dark
        this.channel = channel
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLMegagroupStats = tlDeserializer.readTLObject(TLMegagroupStats::class, TLMegagroupStats.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(dark, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        dark = isMask(1)
        channel = readTLObject<TLAbsInputChannel>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStatsGetMegagroupStats) return false
        if (other === this) return true

        return _flags == other._flags
                && dark == other.dark
                && channel == other.channel
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdcdf8607.toInt()
    }
}
