package com.github.badoualy.telegram.tl.api.phone

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsGroupCall
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLGroupCallDiscarded
import com.github.badoualy.telegram.tl.api.TLGroupCallParticipant
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phone.groupCall#9e727aad
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGroupCall() : TLObject() {
    var call: TLAbsGroupCall = TLGroupCallDiscarded()

    var participants: TLObjectVector<TLGroupCallParticipant> = TLObjectVector()

    var participantsNextOffset: String = ""

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "phone.groupCall#9e727aad"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            call: TLAbsGroupCall,
            participants: TLObjectVector<TLGroupCallParticipant>,
            participantsNextOffset: String,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.call = call
        this.participants = participants
        this.participantsNextOffset = participantsNextOffset
        this.chats = chats
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeTLVector(participants)
        writeString(participantsNextOffset)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLAbsGroupCall>()
        participants = readTLVector<TLGroupCallParticipant>()
        participantsNextOffset = readString()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += participants.computeSerializedSize()
        size += computeTLStringSerializedSize(participantsNextOffset)
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGroupCall) return false
        if (other === this) return true

        return call == other.call
                && participants == other.participants
                && participantsNextOffset == other.participantsNextOffset
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9e727aad.toInt()
    }
}
