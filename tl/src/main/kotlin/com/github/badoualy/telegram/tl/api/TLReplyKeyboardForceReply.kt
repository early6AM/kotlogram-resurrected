package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * replyKeyboardForceReply#86b40b08
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLReplyKeyboardForceReply() : TLAbsReplyMarkup() {
    @Transient
    var singleUse: Boolean = false

    @Transient
    var selective: Boolean = false

    var placeholder: String? = null

    private val _constructor: String = "replyKeyboardForceReply#86b40b08"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            singleUse: Boolean,
            selective: Boolean,
            placeholder: String?
    ) : this() {
        this.singleUse = singleUse
        this.selective = selective
        this.placeholder = placeholder
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(singleUse, 2)
        updateFlags(selective, 4)
        updateFlags(placeholder, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(placeholder, 8) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        singleUse = isMask(2)
        selective = isMask(4)
        placeholder = readIfMask(8) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(placeholder, 8) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLReplyKeyboardForceReply) return false
        if (other === this) return true

        return _flags == other._flags
                && singleUse == other.singleUse
                && selective == other.selective
                && placeholder == other.placeholder
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86b40b08.toInt()
    }
}
