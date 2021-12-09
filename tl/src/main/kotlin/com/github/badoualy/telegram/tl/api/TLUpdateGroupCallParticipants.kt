package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateGroupCallParticipants#f2ebdb4e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateGroupCallParticipants() : TLAbsUpdate() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var participants: TLObjectVector<TLGroupCallParticipant> = TLObjectVector()

    var version: Int = 0

    private val _constructor: String = "updateGroupCallParticipants#f2ebdb4e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            call: TLInputGroupCall,
            participants: TLObjectVector<TLGroupCallParticipant>,
            version: Int
    ) : this() {
        this.call = call
        this.participants = participants
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeTLVector(participants)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        participants = readTLVector<TLGroupCallParticipant>()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += participants.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateGroupCallParticipants) return false
        if (other === this) return true

        return call == other.call
                && participants == other.participants
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf2ebdb4e.toInt()
    }
}
