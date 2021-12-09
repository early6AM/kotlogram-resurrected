package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * keyboardButtonCallback#35bbdb6b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonCallback() : TLAbsKeyboardButton() {
    @Transient
    var requiresPassword: Boolean = false

    override var text: String = ""

    var data: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "keyboardButtonCallback#35bbdb6b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            requiresPassword: Boolean,
            text: String,
            data: TLBytes
    ) : this() {
        this.requiresPassword = requiresPassword
        this.text = text
        this.data = data
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(requiresPassword, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        writeTLBytes(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        requiresPassword = isMask(1)
        text = readString()
        data = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += computeTLBytesSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonCallback) return false
        if (other === this) return true

        return _flags == other._flags
                && requiresPassword == other.requiresPassword
                && text == other.text
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x35bbdb6b
    }
}
