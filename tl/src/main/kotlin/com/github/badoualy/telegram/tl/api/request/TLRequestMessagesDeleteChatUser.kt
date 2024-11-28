package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesDeleteChatUser() : TLMethod<TLAbsUpdates>() {
    @Transient
    var revokeHistory: Boolean = false

    var chatId: Long = 0L

    var userId: TLAbsInputUser = TLInputUserEmpty()

    private val _constructor: String = "messages.deleteChatUser#a2185cab"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            revokeHistory: Boolean,
            chatId: Long,
            userId: TLAbsInputUser
    ) : this() {
        this.revokeHistory = revokeHistory
        this.chatId = chatId
        this.userId = userId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(revokeHistory, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(chatId)
        writeTLObject(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        revokeHistory = isMask(1)
        chatId = readLong()
        userId = readTLObject<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += userId.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesDeleteChatUser) return false
        if (other === this) return true

        return _flags == other._flags
                && revokeHistory == other.revokeHistory
                && chatId == other.chatId
                && userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa2185cab.toInt()
    }
}
