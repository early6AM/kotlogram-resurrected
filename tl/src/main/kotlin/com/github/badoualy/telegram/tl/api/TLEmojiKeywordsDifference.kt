package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * emojiKeywordsDifference#5cc761bd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmojiKeywordsDifference() : TLObject() {
    var langCode: String = ""

    var fromVersion: Int = 0

    var version: Int = 0

    var keywords: TLObjectVector<TLAbsEmojiKeyword> = TLObjectVector()

    private val _constructor: String = "emojiKeywordsDifference#5cc761bd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            langCode: String,
            fromVersion: Int,
            version: Int,
            keywords: TLObjectVector<TLAbsEmojiKeyword>
    ) : this() {
        this.langCode = langCode
        this.fromVersion = fromVersion
        this.version = version
        this.keywords = keywords
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langCode)
        writeInt(fromVersion)
        writeInt(version)
        writeTLVector(keywords)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCode = readString()
        fromVersion = readInt()
        version = readInt()
        keywords = readTLVector<TLAbsEmojiKeyword>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langCode)
        size += SIZE_INT32
        size += SIZE_INT32
        size += keywords.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmojiKeywordsDifference) return false
        if (other === this) return true

        return langCode == other.langCode
                && fromVersion == other.fromVersion
                && version == other.version
                && keywords == other.keywords
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5cc761bd
    }
}
