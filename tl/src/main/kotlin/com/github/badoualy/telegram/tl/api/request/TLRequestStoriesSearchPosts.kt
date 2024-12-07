package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsMediaArea
import com.github.badoualy.telegram.tl.api.stories.TLFoundStories
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesSearchPosts() : TLMethod<TLFoundStories>() {
    var hashtag: String? = null

    var area: TLAbsMediaArea? = null

    var offset: String = ""

    var limit: Int = 0

    private val _constructor: String = "stories.searchPosts#6cea116a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hashtag: String?,
            area: TLAbsMediaArea?,
            offset: String,
            limit: Int
    ) : this() {
        this.hashtag = hashtag
        this.area = area
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLFoundStories = tlDeserializer.readTLObject(TLFoundStories::class, TLFoundStories.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(hashtag, 1)
        updateFlags(area, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, hashtag, 1) { writeString(it) }
        doIfMask(1, area, 2) { writeTLObject(it) }
        writeString(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hashtag = readIfMask(1, 1) { readString() }
        area = readIfMask(1, 2) { readTLObject<TLAbsMediaArea>() }
        offset = readString()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, hashtag, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, area, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(offset)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesSearchPosts) return false
        if (other === this) return true

        return _flags == other._flags
                && hashtag == other.hashtag
                && area == other.area
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6cea116a.toInt()
    }
}
