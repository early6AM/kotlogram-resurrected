package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.messagesSlice#3a54685e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessagesSlice() : TLAbsMessages() {
    @Transient
    var inexact: Boolean = false

    var count: Int = 0

    var nextRate: Int? = null

    var offsetIdOffset: Int? = null

    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.messagesSlice#3a54685e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inexact: Boolean,
            count: Int,
            nextRate: Int?,
            offsetIdOffset: Int?,
            messages: TLObjectVector<TLAbsMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.inexact = inexact
        this.count = count
        this.nextRate = nextRate
        this.offsetIdOffset = offsetIdOffset
        this.messages = messages
        this.chats = chats
        this.users = users
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(inexact, 2)
        updateFlags(nextRate, 1)
        updateFlags(offsetIdOffset, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        doIfMask(nextRate, 1) { writeInt(it) }
        doIfMask(offsetIdOffset, 4) { writeInt(it) }
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inexact = isMask(2)
        count = readInt()
        nextRate = readIfMask(1) { readInt() }
        offsetIdOffset = readIfMask(4) { readInt() }
        messages = readTLVector<TLAbsMessage>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(nextRate, 1) { SIZE_INT32 }
        size += getIntIfMask(offsetIdOffset, 4) { SIZE_INT32 }
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessagesSlice) return false
        if (other === this) return true

        return _flags == other._flags
                && inexact == other.inexact
                && count == other.count
                && nextRate == other.nextRate
                && offsetIdOffset == other.offsetIdOffset
                && messages == other.messages
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3a54685e
    }
}
