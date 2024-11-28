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
import kotlin.String
import kotlin.jvm.Throws

/**
 * emojiKeywordDeleted#236df622
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmojiKeywordDeleted() : TLAbsEmojiKeyword() {
    override var keyword: String = ""

    override var emoticons: TLStringVector = TLStringVector()

    private val _constructor: String = "emojiKeywordDeleted#236df622"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(keyword: String, emoticons: TLStringVector) : this() {
        this.keyword = keyword
        this.emoticons = emoticons
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(keyword)
        writeTLVector(emoticons)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        keyword = readString()
        emoticons = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(keyword)
        size += emoticons.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmojiKeywordDeleted) return false
        if (other === this) return true

        return keyword == other.keyword
                && emoticons == other.emoticons
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x236df622.toInt()
    }
}
