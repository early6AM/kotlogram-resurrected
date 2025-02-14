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
 * phoneCallWaiting#c5226f17
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallWaiting() : TLAbsPhoneCall() {
    @Transient
    var video: Boolean = false

    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Long = 0L

    var participantId: Long = 0L

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    var receiveDate: Int? = null

    private val _constructor: String = "phoneCallWaiting#c5226f17"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            video: Boolean,
            id: Long,
            accessHash: Long,
            date: Int,
            adminId: Long,
            participantId: Long,
            protocol: TLPhoneCallProtocol,
            receiveDate: Int?
    ) : this() {
        this.video = video
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.protocol = protocol
        this.receiveDate = receiveDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(video, 64)
        updateFlags(receiveDate, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeInt(date)
        writeLong(adminId)
        writeLong(participantId)
        writeTLObject(protocol)
        doIfMask(receiveDate, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        video = isMask(64)
        id = readLong()
        accessHash = readLong()
        date = readInt()
        adminId = readLong()
        participantId = readLong()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
        receiveDate = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += protocol.computeSerializedSize()
        size += getIntIfMask(receiveDate, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallWaiting) return false
        if (other === this) return true

        return _flags == other._flags
                && video == other.video
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && protocol == other.protocol
                && receiveDate == other.receiveDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc5226f17.toInt()
    }
}
