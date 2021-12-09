package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateUserTyping#c01e857f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateUserTyping() : TLAbsUpdate() {
    var userId: Long = 0L

    var action: TLAbsSendMessageAction = TLSendMessageChooseStickerAction()

    private val _constructor: String = "updateUserTyping#c01e857f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Long, action: TLAbsSendMessageAction) : this() {
        this.userId = userId
        this.action = action
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        action = readTLObject<TLAbsSendMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateUserTyping) return false
        if (other === this) return true

        return userId == other.userId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc01e857f.toInt()
    }
}
