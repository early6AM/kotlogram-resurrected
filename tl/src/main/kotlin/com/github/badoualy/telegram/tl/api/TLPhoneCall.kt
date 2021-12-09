package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneCall#967f7c67
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCall() : TLAbsPhoneCall() {
    @Transient
    var p2pAllowed: Boolean = false

    @Transient
    var video: Boolean = false

    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Long = 0L

    var participantId: Long = 0L

    var gAOrB: TLBytes = TLBytes.EMPTY

    var keyFingerprint: Long = 0L

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    var connections: TLObjectVector<TLAbsPhoneConnection> = TLObjectVector()

    var startDate: Int = 0

    private val _constructor: String = "phoneCall#967f7c67"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            p2pAllowed: Boolean,
            video: Boolean,
            id: Long,
            accessHash: Long,
            date: Int,
            adminId: Long,
            participantId: Long,
            gAOrB: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol,
            connections: TLObjectVector<TLAbsPhoneConnection>,
            startDate: Int
    ) : this() {
        this.p2pAllowed = p2pAllowed
        this.video = video
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.gAOrB = gAOrB
        this.keyFingerprint = keyFingerprint
        this.protocol = protocol
        this.connections = connections
        this.startDate = startDate
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(p2pAllowed, 32)
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
        writeTLBytes(gAOrB)
        writeLong(keyFingerprint)
        writeTLObject(protocol)
        writeTLVector(connections)
        writeInt(startDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        p2pAllowed = isMask(32)
        video = isMask(64)
        id = readLong()
        accessHash = readLong()
        date = readInt()
        adminId = readLong()
        participantId = readLong()
        gAOrB = readTLBytes()
        keyFingerprint = readLong()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
        connections = readTLVector<TLAbsPhoneConnection>()
        startDate = readInt()
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
        size += computeTLBytesSerializedSize(gAOrB)
        size += SIZE_INT64
        size += protocol.computeSerializedSize()
        size += connections.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCall) return false
        if (other === this) return true

        return _flags == other._flags
                && p2pAllowed == other.p2pAllowed
                && video == other.video
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && gAOrB == other.gAOrB
                && keyFingerprint == other.keyFingerprint
                && protocol == other.protocol
                && connections == other.connections
                && startDate == other.startDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x967f7c67.toInt()
    }
}
