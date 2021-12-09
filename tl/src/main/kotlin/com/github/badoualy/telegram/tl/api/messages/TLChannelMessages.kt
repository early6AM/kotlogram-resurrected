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
 * messages.channelMessages#64479808
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelMessages() : TLAbsMessages() {
    @Transient
    var inexact: Boolean = false

    var pts: Int = 0

    var count: Int = 0

    var offsetIdOffset: Int? = null

    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.channelMessages#64479808"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inexact: Boolean,
            pts: Int,
            count: Int,
            offsetIdOffset: Int?,
            messages: TLObjectVector<TLAbsMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.inexact = inexact
        this.pts = pts
        this.count = count
        this.offsetIdOffset = offsetIdOffset
        this.messages = messages
        this.chats = chats
        this.users = users
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(inexact, 2)
        updateFlags(offsetIdOffset, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(pts)
        writeInt(count)
        doIfMask(offsetIdOffset, 4) { writeInt(it) }
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inexact = isMask(2)
        pts = readInt()
        count = readInt()
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
        size += SIZE_INT32
        size += getIntIfMask(offsetIdOffset, 4) { SIZE_INT32 }
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelMessages) return false
        if (other === this) return true

        return _flags == other._flags
                && inexact == other.inexact
                && pts == other.pts
                && count == other.count
                && offsetIdOffset == other.offsetIdOffset
                && messages == other.messages
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x64479808
    }
}
