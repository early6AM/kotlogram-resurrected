package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneCallAccepted#3660c311
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallAccepted() : TLAbsPhoneCall() {
    @Transient
    var video: Boolean = false

    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Long = 0L

    var participantId: Long = 0L

    var gB: TLBytes = TLBytes.EMPTY

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    private val _constructor: String = "phoneCallAccepted#3660c311"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            video: Boolean,
            id: Long,
            accessHash: Long,
            date: Int,
            adminId: Long,
            participantId: Long,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ) : this() {
        this.video = video
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.gB = gB
        this.protocol = protocol
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(video, 64)
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
        writeTLBytes(gB)
        writeTLObject(protocol)
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
        gB = readTLBytes()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
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
        size += computeTLBytesSerializedSize(gB)
        size += protocol.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallAccepted) return false
        if (other === this) return true

        return _flags == other._flags
                && video == other.video
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && gB == other.gB
                && protocol == other.protocol
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3660c311
    }
}
