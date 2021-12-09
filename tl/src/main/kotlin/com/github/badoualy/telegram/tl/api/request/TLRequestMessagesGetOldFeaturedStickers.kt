package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetOldFeaturedStickers() : TLMethod<TLAbsFeaturedStickers>() {
    var offset: Int = 0

    var limit: Int = 0

    var hash: Long = 0L

    private val _constructor: String = "messages.getOldFeaturedStickers#7ed094a1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            offset: Int,
            limit: Int,
            hash: Long
    ) : this() {
        this.offset = offset
        this.limit = limit
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(offset)
        writeInt(limit)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        offset = readInt()
        limit = readInt()
        hash = readLong()
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
        if (other !is TLRequestMessagesGetOldFeaturedStickers) return false
        if (other === this) return true

        return offset == other.offset
                && limit == other.limit
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7ed094a1
    }
}
