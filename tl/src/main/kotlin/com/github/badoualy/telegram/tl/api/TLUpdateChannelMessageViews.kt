package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChannelMessageViews#f226ac08
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelMessageViews() : TLAbsUpdate() {
    var channelId: Long = 0L

    var id: Int = 0

    var views: Int = 0

    private val _constructor: String = "updateChannelMessageViews#f226ac08"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            id: Int,
            views: Int
    ) : this() {
        this.channelId = channelId
        this.id = id
        this.views = views
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(channelId)
        writeInt(id)
        writeInt(views)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readLong()
        id = readInt()
        views = readInt()
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
        if (other !is TLUpdateChannelMessageViews) return false
        if (other === this) return true

        return channelId == other.channelId
                && id == other.id
                && views == other.views
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf226ac08.toInt()
    }
}
