package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * updateChannelMessageForwards#d29a27f4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelMessageForwards() : TLAbsUpdate() {
    var channelId: Long = 0L

    var id: Int = 0

    var forwards: Int = 0

    private val _constructor: String = "updateChannelMessageForwards#d29a27f4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            id: Int,
            forwards: Int
    ) : this() {
        this.channelId = channelId
        this.id = id
        this.forwards = forwards
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeInt(id)
        writeInt(forwards)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        id = readInt()
        forwards = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelMessageForwards) return false
        if (other === this) return true

        return channelId == other.channelId
                && id == other.id
                && forwards == other.forwards
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd29a27f4.toInt()
    }
}
