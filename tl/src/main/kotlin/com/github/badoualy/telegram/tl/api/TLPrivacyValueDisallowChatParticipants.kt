package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * privacyValueDisallowChatParticipants#41c87565
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyValueDisallowChatParticipants() : TLAbsPrivacyRule() {
    var chats: TLLongVector = TLLongVector()

    private val _constructor: String = "privacyValueDisallowChatParticipants#41c87565"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(chats: TLLongVector) : this() {
        this.chats = chats
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(chats)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chats = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += chats.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyValueDisallowChatParticipants) return false
        if (other === this) return true

        return chats == other.chats
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x41c87565
    }
}
