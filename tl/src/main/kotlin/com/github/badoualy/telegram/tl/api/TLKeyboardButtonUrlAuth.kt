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

/**
 * keyboardButtonUrlAuth#10b78d29
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonUrlAuth() : TLAbsKeyboardButton() {
    override var text: String = ""

    var fwdText: String? = null

    var url: String = ""

    var buttonId: Int = 0

    private val _constructor: String = "keyboardButtonUrlAuth#10b78d29"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            text: String,
            fwdText: String?,
            url: String,
            buttonId: Int
    ) : this() {
        this.text = text
        this.fwdText = fwdText
        this.url = url
        this.buttonId = buttonId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fwdText, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        doIfMask(fwdText, 1) { writeString(it) }
        writeString(url)
        writeInt(buttonId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        text = readString()
        fwdText = readIfMask(1) { readString() }
        url = readString()
        buttonId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += getIntIfMask(fwdText, 1) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonUrlAuth) return false
        if (other === this) return true

        return _flags == other._flags
                && text == other.text
                && fwdText == other.fwdText
                && url == other.url
                && buttonId == other.buttonId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x10b78d29.toInt()
    }
}
