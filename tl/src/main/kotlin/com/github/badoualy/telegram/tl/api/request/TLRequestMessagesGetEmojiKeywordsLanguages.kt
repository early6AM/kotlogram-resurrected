package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLEmojiLanguage
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetEmojiKeywordsLanguages() : TLMethod<TLObjectVector<TLEmojiLanguage>>() {
    var langCodes: TLStringVector = TLStringVector()

    private val _constructor: String = "messages.getEmojiKeywordsLanguages#4e9963b2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(langCodes: TLStringVector) : this() {
        this.langCodes = langCodes
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLEmojiLanguage> = tlDeserializer.readTLVector<TLEmojiLanguage>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(langCodes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCodes = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += langCodes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetEmojiKeywordsLanguages) return false
        if (other === this) return true

        return langCodes == other.langCodes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4e9963b2
    }
}
