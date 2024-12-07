package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * messages.discussionMessage#a6341782
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDiscussionMessage() : TLObject() {
    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var maxId: Int? = null

    var readInboxMaxId: Int? = null

    var readOutboxMaxId: Int? = null

    var unreadCount: Int = 0

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.discussionMessage#a6341782"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            messages: TLObjectVector<TLAbsMessage>,
            maxId: Int?,
            readInboxMaxId: Int?,
            readOutboxMaxId: Int?,
            unreadCount: Int,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.messages = messages
        this.maxId = maxId
        this.readInboxMaxId = readInboxMaxId
        this.readOutboxMaxId = readOutboxMaxId
        this.unreadCount = unreadCount
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(maxId, 1)
        updateFlags(readInboxMaxId, 2)
        updateFlags(readOutboxMaxId, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(messages)
        doIfMask(1, maxId, 1) { writeInt(it) }
        doIfMask(1, readInboxMaxId, 2) { writeInt(it) }
        doIfMask(1, readOutboxMaxId, 4) { writeInt(it) }
        writeInt(unreadCount)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        messages = readTLVector<TLAbsMessage>()
        maxId = readIfMask(1, 1) { readInt() }
        readInboxMaxId = readIfMask(1, 2) { readInt() }
        readOutboxMaxId = readIfMask(1, 4) { readInt() }
        unreadCount = readInt()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += messages.computeSerializedSize()
        size += getIntIfMask(1, maxId, 1) { SIZE_INT32 }
        size += getIntIfMask(1, readInboxMaxId, 2) { SIZE_INT32 }
        size += getIntIfMask(1, readOutboxMaxId, 4) { SIZE_INT32 }
        size += SIZE_INT32
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDiscussionMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && messages == other.messages
                && maxId == other.maxId
                && readInboxMaxId == other.readInboxMaxId
                && readOutboxMaxId == other.readOutboxMaxId
                && unreadCount == other.unreadCount
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa6341782.toInt()
    }
}
