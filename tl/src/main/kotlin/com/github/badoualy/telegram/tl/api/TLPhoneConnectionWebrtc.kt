package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneConnectionWebrtc#635fe375
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneConnectionWebrtc() : TLAbsPhoneConnection() {
    @Transient
    var turn: Boolean = false

    @Transient
    var stun: Boolean = false

    override var id: Long = 0L

    override var ip: String = ""

    override var ipv6: String = ""

    override var port: Int = 0

    var username: String = ""

    var password: String = ""

    private val _constructor: String = "phoneConnectionWebrtc#635fe375"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            turn: Boolean,
            stun: Boolean,
            id: Long,
            ip: String,
            ipv6: String,
            port: Int,
            username: String,
            password: String
    ) : this() {
        this.turn = turn
        this.stun = stun
        this.id = id
        this.ip = ip
        this.ipv6 = ipv6
        this.port = port
        this.username = username
        this.password = password
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(turn, 1)
        updateFlags(stun, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(ip)
        writeString(ipv6)
        writeInt(port)
        writeString(username)
        writeString(password)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        turn = isMask(1)
        stun = isMask(2)
        id = readLong()
        ip = readString()
        ipv6 = readString()
        port = readInt()
        username = readString()
        password = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(ipv6)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(username)
        size += computeTLStringSerializedSize(password)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneConnectionWebrtc) return false
        if (other === this) return true

        return _flags == other._flags
                && turn == other.turn
                && stun == other.stun
                && id == other.id
                && ip == other.ip
                && ipv6 == other.ipv6
                && port == other.port
                && username == other.username
                && password == other.password
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x635fe375
    }
}
