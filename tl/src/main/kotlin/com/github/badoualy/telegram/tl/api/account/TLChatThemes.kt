package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLChatTheme
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.chatThemes#fe4cbebd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatThemes() : TLAbsChatThemes() {
    var hash: Int = 0

    var themes: TLObjectVector<TLChatTheme> = TLObjectVector()

    private val _constructor: String = "account.chatThemes#fe4cbebd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Int, themes: TLObjectVector<TLChatTheme>) : this() {
        this.hash = hash
        this.themes = themes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(hash)
        writeTLVector(themes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readInt()
        themes = readTLVector<TLChatTheme>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += themes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatThemes) return false
        if (other === this) return true

        return hash == other.hash
                && themes == other.themes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfe4cbebd.toInt()
    }
}
