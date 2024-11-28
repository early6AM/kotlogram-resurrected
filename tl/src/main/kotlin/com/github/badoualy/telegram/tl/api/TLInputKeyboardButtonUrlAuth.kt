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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * inputKeyboardButtonUrlAuth#d02e7fd4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputKeyboardButtonUrlAuth() : TLAbsKeyboardButton() {
    @Transient
    var requestWriteAccess: Boolean = false

    override var text: String = ""

    var fwdText: String? = null

    var url: String = ""

    var bot: TLAbsInputUser = TLInputUserEmpty()

    private val _constructor: String = "inputKeyboardButtonUrlAuth#d02e7fd4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            requestWriteAccess: Boolean,
            text: String,
            fwdText: String?,
            url: String,
            bot: TLAbsInputUser
    ) : this() {
        this.requestWriteAccess = requestWriteAccess
        this.text = text
        this.fwdText = fwdText
        this.url = url
        this.bot = bot
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(requestWriteAccess, 1)
        updateFlags(fwdText, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        doIfMask(fwdText, 2) { writeString(it) }
        writeString(url)
        writeTLObject(bot)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        requestWriteAccess = isMask(1)
        text = readString()
        fwdText = readIfMask(2) { readString() }
        url = readString()
        bot = readTLObject<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += getIntIfMask(fwdText, 2) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(url)
        size += bot.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputKeyboardButtonUrlAuth) return false
        if (other === this) return true

        return _flags == other._flags
                && requestWriteAccess == other.requestWriteAccess
                && text == other.text
                && fwdText == other.fwdText
                && url == other.url
                && bot == other.bot
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd02e7fd4.toInt()
    }
}
