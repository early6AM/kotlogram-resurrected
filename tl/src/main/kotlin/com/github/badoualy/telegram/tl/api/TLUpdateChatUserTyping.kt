package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChatUserTyping#83487af0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatUserTyping() : TLAbsUpdate() {
    var chatId: Long = 0L

    var fromId: TLAbsPeer = TLPeerChat()

    var action: TLAbsSendMessageAction = TLSendMessageChooseStickerAction()

    private val _constructor: String = "updateChatUserTyping#83487af0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Long,
            fromId: TLAbsPeer,
            action: TLAbsSendMessageAction
    ) : this() {
        this.chatId = chatId
        this.fromId = fromId
        this.action = action
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(chatId)
        writeTLObject(fromId)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readLong()
        fromId = readTLObject<TLAbsPeer>()
        action = readTLObject<TLAbsSendMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += fromId.computeSerializedSize()
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatUserTyping) return false
        if (other === this) return true

        return chatId == other.chatId
                && fromId == other.fromId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x83487af0.toInt()
    }
}
