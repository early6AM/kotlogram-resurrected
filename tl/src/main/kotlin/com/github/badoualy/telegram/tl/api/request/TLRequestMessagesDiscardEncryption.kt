package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesDiscardEncryption() : TLMethod<TLBool>() {
    @Transient
    var deleteHistory: Boolean = false

    var chatId: Int = 0

    private val _constructor: String = "messages.discardEncryption#f393aea0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(deleteHistory: Boolean, chatId: Int) : this() {
        this.deleteHistory = deleteHistory
        this.chatId = chatId
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(deleteHistory, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(chatId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        deleteHistory = isMask(1)
        chatId = readInt()
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
        if (other !is TLRequestMessagesDiscardEncryption) return false
        if (other === this) return true

        return _flags == other._flags
                && deleteHistory == other.deleteHistory
                && chatId == other.chatId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf393aea0.toInt()
    }
}
