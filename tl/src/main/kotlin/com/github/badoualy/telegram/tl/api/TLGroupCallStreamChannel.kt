package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * groupCallStreamChannel#80eb48af
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupCallStreamChannel() : TLObject() {
    var channel: Int = 0

    var scale: Int = 0

    var lastTimestampMs: Long = 0L

    private val _constructor: String = "groupCallStreamChannel#80eb48af"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: Int,
            scale: Int,
            lastTimestampMs: Long
    ) : this() {
        this.channel = channel
        this.scale = scale
        this.lastTimestampMs = lastTimestampMs
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channel)
        writeInt(scale)
        writeLong(lastTimestampMs)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readInt()
        scale = readInt()
        lastTimestampMs = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupCallStreamChannel) return false
        if (other === this) return true

        return channel == other.channel
                && scale == other.scale
                && lastTimestampMs == other.lastTimestampMs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x80eb48af.toInt()
    }
}
