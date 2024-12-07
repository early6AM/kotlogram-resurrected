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
import kotlin.jvm.Transient

/**
 * channelParticipantSelf#35a8bfa7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantSelf() : TLAbsChannelParticipant() {
    @Transient
    var viaRequest: Boolean = false

    var userId: Long = 0L

    var inviterId: Long = 0L

    var date: Int = 0

    private val _constructor: String = "channelParticipantSelf#35a8bfa7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viaRequest: Boolean,
            userId: Long,
            inviterId: Long,
            date: Int
    ) : this() {
        this.viaRequest = viaRequest
        this.userId = userId
        this.inviterId = inviterId
        this.date = date
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(viaRequest, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        writeLong(inviterId)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viaRequest = isMask(1, 1)
        userId = readLong()
        inviterId = readLong()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantSelf) return false
        if (other === this) return true

        return _flags == other._flags
                && viaRequest == other.viaRequest
                && userId == other.userId
                && inviterId == other.inviterId
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x35a8bfa7.toInt()
    }
}
