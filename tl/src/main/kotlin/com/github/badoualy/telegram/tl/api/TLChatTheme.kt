package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * chatTheme#ed0b5c33
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatTheme() : TLObject() {
    var emoticon: String = ""

    var theme: TLTheme = TLTheme()

    var darkTheme: TLTheme = TLTheme()

    private val _constructor: String = "chatTheme#ed0b5c33"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            emoticon: String,
            theme: TLTheme,
            darkTheme: TLTheme
    ) : this() {
        this.emoticon = emoticon
        this.theme = theme
        this.darkTheme = darkTheme
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(emoticon)
        writeTLObject(theme)
        writeTLObject(darkTheme)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        emoticon = readString()
        theme = readTLObject<TLTheme>(TLTheme::class, TLTheme.CONSTRUCTOR_ID)
        darkTheme = readTLObject<TLTheme>(TLTheme::class, TLTheme.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(emoticon)
        size += theme.computeSerializedSize()
        size += darkTheme.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatTheme) return false
        if (other === this) return true

        return emoticon == other.emoticon
                && theme == other.theme
                && darkTheme == other.darkTheme
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xed0b5c33.toInt()
    }
}
