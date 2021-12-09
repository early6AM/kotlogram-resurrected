package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateReadChannelOutbox#b75f99a9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadChannelOutbox() : TLAbsUpdate() {
    var channelId: Long = 0L

    var maxId: Int = 0

    private val _constructor: String = "updateReadChannelOutbox#b75f99a9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Long, maxId: Int) : this() {
        this.channelId = channelId
        this.maxId = maxId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeInt(maxId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        maxId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadChannelOutbox) return false
        if (other === this) return true

        return channelId == other.channelId
                && maxId == other.maxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb75f99a9.toInt()
    }
}
