package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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

/**
 * attachMenuBots#3c4301c0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAttachMenuBots() : TLAbsAttachMenuBots() {
    var hash: Long = 0L

    var bots: TLObjectVector<TLAttachMenuBot> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "attachMenuBots#3c4301c0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hash: Long,
            bots: TLObjectVector<TLAttachMenuBot>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.hash = hash
        this.bots = bots
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(bots)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        bots = readTLVector<TLAttachMenuBot>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += bots.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAttachMenuBots) return false
        if (other === this) return true

        return hash == other.hash
                && bots == other.bots
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3c4301c0.toInt()
    }
}
