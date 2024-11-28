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
 * messageActionTopicEdit#c0944820
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionTopicEdit() : TLAbsMessageAction() {
    var title: String? = null

    var iconEmojiId: Long? = null

    var closed: Boolean? = null

    var hidden: Boolean? = null

    private val _constructor: String = "messageActionTopicEdit#c0944820"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String?,
            iconEmojiId: Long?,
            closed: Boolean?,
            hidden: Boolean?
    ) : this() {
        this.title = title
        this.iconEmojiId = iconEmojiId
        this.closed = closed
        this.hidden = hidden
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 1)
        updateFlags(iconEmojiId, 2)
        updateFlags(closed, 4)
        updateFlags(hidden, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(title, 1) { writeString(it) }
        doIfMask(iconEmojiId, 2) { writeLong(it) }
        doIfMask(closed, 4) { writeBoolean(it) }
        doIfMask(hidden, 8) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readIfMask(1) { readString() }
        iconEmojiId = readIfMask(2) { readLong() }
        closed = readIfMask(4) { readBoolean() }
        hidden = readIfMask(8) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(iconEmojiId, 2) { SIZE_INT64 }
        size += getIntIfMask(closed, 4) { SIZE_BOOLEAN }
        size += getIntIfMask(hidden, 8) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionTopicEdit) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && iconEmojiId == other.iconEmojiId
                && closed == other.closed
                && hidden == other.hidden
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc0944820.toInt()
    }
}
