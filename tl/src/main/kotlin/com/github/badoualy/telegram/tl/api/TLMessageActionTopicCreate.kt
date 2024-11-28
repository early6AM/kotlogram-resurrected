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
 * messageActionTopicCreate#d999256
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionTopicCreate() : TLAbsMessageAction() {
    var title: String = ""

    var iconColor: Int = 0

    var iconEmojiId: Long? = null

    private val _constructor: String = "messageActionTopicCreate#d999256"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            iconColor: Int,
            iconEmojiId: Long?
    ) : this() {
        this.title = title
        this.iconColor = iconColor
        this.iconEmojiId = iconEmojiId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(iconEmojiId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeInt(iconColor)
        doIfMask(iconEmojiId, 1) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        iconColor = readInt()
        iconEmojiId = readIfMask(1) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += SIZE_INT32
        size += getIntIfMask(iconEmojiId, 1) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionTopicCreate) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && iconColor == other.iconColor
                && iconEmojiId == other.iconEmojiId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd999256.toInt()
    }
}
