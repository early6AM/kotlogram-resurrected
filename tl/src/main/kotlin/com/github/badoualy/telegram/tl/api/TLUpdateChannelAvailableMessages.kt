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
 * updateChannelAvailableMessages#b23fc698
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelAvailableMessages() : TLAbsUpdate() {
    var channelId: Long = 0L

    var availableMinId: Int = 0

    private val _constructor: String = "updateChannelAvailableMessages#b23fc698"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Long, availableMinId: Int) : this() {
        this.channelId = channelId
        this.availableMinId = availableMinId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeInt(availableMinId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        availableMinId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelAvailableMessages) return false
        if (other === this) return true

        return channelId == other.channelId
                && availableMinId == other.availableMinId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb23fc698.toInt()
    }
}
