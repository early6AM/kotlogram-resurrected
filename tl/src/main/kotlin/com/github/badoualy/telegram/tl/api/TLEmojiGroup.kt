package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLStringVector
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
 * emojiGroup#7a9abda9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmojiGroup() : TLAbsEmojiGroup() {
    override var title: String = ""

    override var iconEmojiId: Long = 0L

    var emoticons: TLStringVector = TLStringVector()

    private val _constructor: String = "emojiGroup#7a9abda9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            iconEmojiId: Long,
            emoticons: TLStringVector
    ) : this() {
        this.title = title
        this.iconEmojiId = iconEmojiId
        this.emoticons = emoticons
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(title)
        writeLong(iconEmojiId)
        writeTLVector(emoticons)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        title = readString()
        iconEmojiId = readLong()
        emoticons = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(title)
        size += SIZE_INT64
        size += emoticons.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmojiGroup) return false
        if (other === this) return true

        return title == other.title
                && iconEmojiId == other.iconEmojiId
                && emoticons == other.emoticons
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7a9abda9.toInt()
    }
}
