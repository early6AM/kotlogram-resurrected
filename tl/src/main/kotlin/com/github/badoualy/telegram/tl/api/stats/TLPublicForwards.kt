package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsPublicForward
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * stats.publicForwards#93037e20
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPublicForwards() : TLObject() {
    var count: Int = 0

    var forwards: TLObjectVector<TLAbsPublicForward> = TLObjectVector()

    var nextOffset: String? = null

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "stats.publicForwards#93037e20"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            forwards: TLObjectVector<TLAbsPublicForward>,
            nextOffset: String?,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.count = count
        this.forwards = forwards
        this.nextOffset = nextOffset
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nextOffset, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeTLVector(forwards)
        doIfMask(nextOffset, 1) { writeString(it) }
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        count = readInt()
        forwards = readTLVector<TLAbsPublicForward>()
        nextOffset = readIfMask(1) { readString() }
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += forwards.computeSerializedSize()
        size += getIntIfMask(nextOffset, 1) { computeTLStringSerializedSize(it) }
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPublicForwards) return false
        if (other === this) return true

        return _flags == other._flags
                && count == other.count
                && forwards == other.forwards
                && nextOffset == other.nextOffset
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x93037e20.toInt()
    }
}
