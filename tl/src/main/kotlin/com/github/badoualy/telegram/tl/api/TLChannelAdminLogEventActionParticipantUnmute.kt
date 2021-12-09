package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionParticipantUnmute#e64429c0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantUnmute() : TLAbsChannelAdminLogEventAction() {
    var participant: TLGroupCallParticipant = TLGroupCallParticipant()

    private val _constructor: String = "channelAdminLogEventActionParticipantUnmute#e64429c0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(participant: TLGroupCallParticipant) : this() {
        this.participant = participant
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(participant)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        participant = readTLObject<TLGroupCallParticipant>(TLGroupCallParticipant::class, TLGroupCallParticipant.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += participant.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantUnmute) return false
        if (other === this) return true

        return participant == other.participant
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe64429c0.toInt()
    }
}
