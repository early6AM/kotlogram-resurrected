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
 * updateChannelViewForumAsMessages#7b68920
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelViewForumAsMessages() : TLAbsUpdate() {
    var channelId: Long = 0L

    var enabled: Boolean = false

    private val _constructor: String = "updateChannelViewForumAsMessages#7b68920"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Long, enabled: Boolean) : this() {
        this.channelId = channelId
        this.enabled = enabled
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeBoolean(enabled)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        enabled = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelViewForumAsMessages) return false
        if (other === this) return true

        return channelId == other.channelId
                && enabled == other.enabled
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7b68920.toInt()
    }
}
