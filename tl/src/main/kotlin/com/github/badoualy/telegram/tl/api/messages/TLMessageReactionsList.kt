package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLMessagePeerReaction
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
 * messages.messageReactionsList#31bd492d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageReactionsList() : TLObject() {
    var count: Int = 0

    var reactions: TLObjectVector<TLMessagePeerReaction> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var nextOffset: String? = null

    private val _constructor: String = "messages.messageReactionsList#31bd492d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            reactions: TLObjectVector<TLMessagePeerReaction>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            nextOffset: String?
    ) : this() {
        this.count = count
        this.reactions = reactions
        this.chats = chats
        this.users = users
        this.nextOffset = nextOffset
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nextOffset, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeTLVector(reactions)
        writeTLVector(chats)
        writeTLVector(users)
        doIfMask(nextOffset, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        count = readInt()
        reactions = readTLVector<TLMessagePeerReaction>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        nextOffset = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += reactions.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += getIntIfMask(nextOffset, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageReactionsList) return false
        if (other === this) return true

        return _flags == other._flags
                && count == other.count
                && reactions == other.reactions
                && chats == other.chats
                && users == other.users
                && nextOffset == other.nextOffset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x31bd492d.toInt()
    }
}
