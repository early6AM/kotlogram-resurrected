package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * requestPeerTypeChat#c9f06e1b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPeerTypeChat() : TLAbsRequestPeerType() {
    @Transient
    var creator: Boolean = false

    @Transient
    var botParticipant: Boolean = false

    var hasUsername: Boolean? = null

    var forum: Boolean? = null

    var userAdminRights: TLChatAdminRights? = null

    var botAdminRights: TLChatAdminRights? = null

    private val _constructor: String = "requestPeerTypeChat#c9f06e1b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            botParticipant: Boolean,
            hasUsername: Boolean?,
            forum: Boolean?,
            userAdminRights: TLChatAdminRights?,
            botAdminRights: TLChatAdminRights?
    ) : this() {
        this.creator = creator
        this.botParticipant = botParticipant
        this.hasUsername = hasUsername
        this.forum = forum
        this.userAdminRights = userAdminRights
        this.botAdminRights = botAdminRights
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(botParticipant, 32)
        updateFlags(hasUsername, 8)
        updateFlags(forum, 16)
        updateFlags(userAdminRights, 2)
        updateFlags(botAdminRights, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(hasUsername, 8) { writeBoolean(it) }
        doIfMask(forum, 16) { writeBoolean(it) }
        doIfMask(userAdminRights, 2) { writeTLObject(it) }
        doIfMask(botAdminRights, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        botParticipant = isMask(32)
        hasUsername = readIfMask(8) { readBoolean() }
        forum = readIfMask(16) { readBoolean() }
        userAdminRights = readIfMask(2) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        botAdminRights = readIfMask(4) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(hasUsername, 8) { SIZE_BOOLEAN }
        size += getIntIfMask(forum, 16) { SIZE_BOOLEAN }
        size += getIntIfMask(userAdminRights, 2) { it.computeSerializedSize() }
        size += getIntIfMask(botAdminRights, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPeerTypeChat) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && botParticipant == other.botParticipant
                && hasUsername == other.hasUsername
                && forum == other.forum
                && userAdminRights == other.userAdminRights
                && botAdminRights == other.botAdminRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9f06e1b.toInt()
    }
}
