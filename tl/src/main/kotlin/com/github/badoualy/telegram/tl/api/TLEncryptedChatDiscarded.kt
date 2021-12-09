package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * encryptedChatDiscarded#1e1c7c45
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedChatDiscarded() : TLAbsEncryptedChat() {
    @Transient
    var historyDeleted: Boolean = false

    override var id: Int = 0

    private val _constructor: String = "encryptedChatDiscarded#1e1c7c45"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(historyDeleted: Boolean, id: Int) : this() {
        this.historyDeleted = historyDeleted
        this.id = id
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(historyDeleted, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        historyDeleted = isMask(1)
        id = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedChatDiscarded) return false
        if (other === this) return true

        return _flags == other._flags
                && historyDeleted == other.historyDeleted
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1e1c7c45
    }
}
