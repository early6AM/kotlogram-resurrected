package com.github.badoualy.telegram.tl.api.phone

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLGroupCallParticipant
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phone.groupParticipants#f47751b6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupParticipants() : TLObject() {
    var count: Int = 0

    var participants: TLObjectVector<TLGroupCallParticipant> = TLObjectVector()

    var nextOffset: String = ""

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var version: Int = 0

    private val _constructor: String = "phone.groupParticipants#f47751b6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            participants: TLObjectVector<TLGroupCallParticipant>,
            nextOffset: String,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            version: Int
    ) : this() {
        this.count = count
        this.participants = participants
        this.nextOffset = nextOffset
        this.chats = chats
        this.users = users
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(count)
        writeTLVector(participants)
        writeString(nextOffset)
        writeTLVector(chats)
        writeTLVector(users)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        count = readInt()
        participants = readTLVector<TLGroupCallParticipant>()
        nextOffset = readString()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += participants.computeSerializedSize()
        size += computeTLStringSerializedSize(nextOffset)
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupParticipants) return false
        if (other === this) return true

        return count == other.count
                && participants == other.participants
                && nextOffset == other.nextOffset
                && chats == other.chats
                && users == other.users
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf47751b6.toInt()
    }
}
