package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelParticipantSelf#28a8bc67
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantSelf() : TLAbsChannelParticipant() {
    var userId: Long = 0L

    var inviterId: Long = 0L

    var date: Int = 0

    private val _constructor: String = "channelParticipantSelf#28a8bc67"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            inviterId: Long,
            date: Int
    ) : this() {
        this.userId = userId
        this.inviterId = inviterId
        this.date = date
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeLong(inviterId)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        inviterId = readLong()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantSelf) return false
        if (other === this) return true

        return userId == other.userId
                && inviterId == other.inviterId
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x28a8bc67
    }
}
