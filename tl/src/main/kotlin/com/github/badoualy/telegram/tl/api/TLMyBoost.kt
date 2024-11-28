package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * myBoost#c448415c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMyBoost() : TLObject() {
    var slot: Int = 0

    var peer: TLAbsPeer? = null

    var date: Int = 0

    var expires: Int = 0

    var cooldownUntilDate: Int? = null

    private val _constructor: String = "myBoost#c448415c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            slot: Int,
            peer: TLAbsPeer?,
            date: Int,
            expires: Int,
            cooldownUntilDate: Int?
    ) : this() {
        this.slot = slot
        this.peer = peer
        this.date = date
        this.expires = expires
        this.cooldownUntilDate = cooldownUntilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(peer, 1)
        updateFlags(cooldownUntilDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(slot)
        doIfMask(peer, 1) { writeTLObject(it) }
        writeInt(date)
        writeInt(expires)
        doIfMask(cooldownUntilDate, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        slot = readInt()
        peer = readIfMask(1) { readTLObject<TLAbsPeer>() }
        date = readInt()
        expires = readInt()
        cooldownUntilDate = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(peer, 1) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(cooldownUntilDate, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMyBoost) return false
        if (other === this) return true

        return _flags == other._flags
                && slot == other.slot
                && peer == other.peer
                && date == other.date
                && expires == other.expires
                && cooldownUntilDate == other.cooldownUntilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc448415c.toInt()
    }
}
