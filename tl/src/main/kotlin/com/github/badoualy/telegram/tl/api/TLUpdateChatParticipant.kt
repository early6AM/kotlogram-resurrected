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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateChatParticipant#d087663a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatParticipant() : TLAbsUpdate() {
    var chatId: Long = 0L

    var date: Int = 0

    var actorId: Long = 0L

    var userId: Long = 0L

    var prevParticipant: TLAbsChatParticipant? = null

    var newParticipant: TLAbsChatParticipant? = null

    var invite: TLAbsExportedChatInvite? = null

    var qts: Int = 0

    private val _constructor: String = "updateChatParticipant#d087663a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Long,
            date: Int,
            actorId: Long,
            userId: Long,
            prevParticipant: TLAbsChatParticipant?,
            newParticipant: TLAbsChatParticipant?,
            invite: TLAbsExportedChatInvite?,
            qts: Int
    ) : this() {
        this.chatId = chatId
        this.date = date
        this.actorId = actorId
        this.userId = userId
        this.prevParticipant = prevParticipant
        this.newParticipant = newParticipant
        this.invite = invite
        this.qts = qts
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(prevParticipant, 1)
        updateFlags(newParticipant, 2)
        updateFlags(invite, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(chatId)
        writeInt(date)
        writeLong(actorId)
        writeLong(userId)
        doIfMask(prevParticipant, 1) { writeTLObject(it) }
        doIfMask(newParticipant, 2) { writeTLObject(it) }
        doIfMask(invite, 4) { writeTLObject(it) }
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chatId = readLong()
        date = readInt()
        actorId = readLong()
        userId = readLong()
        prevParticipant = readIfMask(1) { readTLObject<TLAbsChatParticipant>() }
        newParticipant = readIfMask(2) { readTLObject<TLAbsChatParticipant>() }
        invite = readIfMask(4) { readTLObject<TLAbsExportedChatInvite>() }
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += getIntIfMask(prevParticipant, 1) { it.computeSerializedSize() }
        size += getIntIfMask(newParticipant, 2) { it.computeSerializedSize() }
        size += getIntIfMask(invite, 4) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatParticipant) return false
        if (other === this) return true

        return _flags == other._flags
                && chatId == other.chatId
                && date == other.date
                && actorId == other.actorId
                && userId == other.userId
                && prevParticipant == other.prevParticipant
                && newParticipant == other.newParticipant
                && invite == other.invite
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd087663a.toInt()
    }
}
