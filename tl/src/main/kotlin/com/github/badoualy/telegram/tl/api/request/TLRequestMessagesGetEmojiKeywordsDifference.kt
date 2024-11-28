package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLEmojiKeywordsDifference
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
class TLRequestMessagesGetEmojiKeywordsDifference() : TLMethod<TLEmojiKeywordsDifference>() {
    var langCode: String = ""

    var fromVersion: Int = 0

    private val _constructor: String = "messages.getEmojiKeywordsDifference#1508b6af"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(langCode: String, fromVersion: Int) : this() {
        this.langCode = langCode
        this.fromVersion = fromVersion
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLEmojiKeywordsDifference = tlDeserializer.readTLObject(TLEmojiKeywordsDifference::class, TLEmojiKeywordsDifference.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langCode)
        writeInt(fromVersion)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCode = readString()
        fromVersion = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langCode)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetEmojiKeywordsDifference) return false
        if (other === this) return true

        return langCode == other.langCode
                && fromVersion == other.fromVersion
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1508b6af.toInt()
    }
}
