package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsForumTopic
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
import kotlin.jvm.Transient

/**
 * messages.forumTopics#367617d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLForumTopics() : TLObject() {
    @Transient
    var orderByCreateDate: Boolean = false

    var count: Int = 0

    var topics: TLObjectVector<TLAbsForumTopic> = TLObjectVector()

    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var pts: Int = 0

    private val _constructor: String = "messages.forumTopics#367617d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            orderByCreateDate: Boolean,
            count: Int,
            topics: TLObjectVector<TLAbsForumTopic>,
            messages: TLObjectVector<TLAbsMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            pts: Int
    ) : this() {
        this.orderByCreateDate = orderByCreateDate
        this.count = count
        this.topics = topics
        this.messages = messages
        this.chats = chats
        this.users = users
        this.pts = pts
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(orderByCreateDate, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeTLVector(topics)
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
        writeInt(pts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        orderByCreateDate = isMask(1)
        count = readInt()
        topics = readTLVector<TLAbsForumTopic>()
        messages = readTLVector<TLAbsMessage>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        pts = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += topics.computeSerializedSize()
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLForumTopics) return false
        if (other === this) return true

        return _flags == other._flags
                && orderByCreateDate == other.orderByCreateDate
                && count == other.count
                && topics == other.topics
                && messages == other.messages
                && chats == other.chats
                && users == other.users
                && pts == other.pts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x367617d3.toInt()
    }
}
