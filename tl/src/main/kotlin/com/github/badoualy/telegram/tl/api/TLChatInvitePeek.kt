package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * chatInvitePeek#61695cb0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInvitePeek() : TLAbsChatInvite() {
    var chat: TLAbsChat = TLChatEmpty()

    var expires: Int = 0

    private val _constructor: String = "chatInvitePeek#61695cb0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(chat: TLAbsChat, expires: Int) : this() {
        this.chat = chat
        this.expires = expires
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(chat)
        writeInt(expires)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chat = readTLObject<TLAbsChat>()
        expires = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += chat.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInvitePeek) return false
        if (other === this) return true

        return chat == other.chat
                && expires == other.expires
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x61695cb0
    }
}
