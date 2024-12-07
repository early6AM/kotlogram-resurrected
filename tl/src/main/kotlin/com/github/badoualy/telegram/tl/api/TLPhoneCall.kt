package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * phoneCall#30535af5
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

    var customParameters: TLDataJSON? = null

    private val _constructor: String = "phoneCall#30535af5"

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
            startDate: Int,
            customParameters: TLDataJSON?
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
        this.customParameters = customParameters
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(p2pAllowed, 32)
        updateFlags(video, 64)
        updateFlags(customParameters, 128)
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
        doIfMask(1, customParameters, 128) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        p2pAllowed = isMask(1, 32)
        video = isMask(1, 64)
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
        customParameters = readIfMask(1, 128) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
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
        size += getIntIfMask(1, customParameters, 128) { it.computeSerializedSize() }
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
                && customParameters == other.customParameters
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x30535af5.toInt()
    }
}
