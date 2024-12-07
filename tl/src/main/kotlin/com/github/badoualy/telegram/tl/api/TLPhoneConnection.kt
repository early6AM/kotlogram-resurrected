package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * phoneConnection#9cc123c7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneConnection() : TLAbsPhoneConnection() {
    @Transient
    var tcp: Boolean = false

    override var id: Long = 0L

    override var ip: String = ""

    override var ipv6: String = ""

    override var port: Int = 0

    var peerTag: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "phoneConnection#9cc123c7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            tcp: Boolean,
            id: Long,
            ip: String,
            ipv6: String,
            port: Int,
            peerTag: TLBytes
    ) : this() {
        this.tcp = tcp
        this.id = id
        this.ip = ip
        this.ipv6 = ipv6
        this.port = port
        this.peerTag = peerTag
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(tcp, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(ip)
        writeString(ipv6)
        writeInt(port)
        writeTLBytes(peerTag)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        tcp = isMask(1, 1)
        id = readLong()
        ip = readString()
        ipv6 = readString()
        port = readInt()
        peerTag = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(ipv6)
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(peerTag)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneConnection) return false
        if (other === this) return true

        return _flags == other._flags
                && tcp == other.tcp
                && id == other.id
                && ip == other.ip
                && ipv6 == other.ipv6
                && port == other.port
                && peerTag == other.peerTag
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9cc123c7.toInt()
    }
}
