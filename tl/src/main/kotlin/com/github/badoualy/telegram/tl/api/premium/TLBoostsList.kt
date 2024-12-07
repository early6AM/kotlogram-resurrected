package com.github.badoualy.telegram.tl.api.premium

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLBoost
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
 * premium.boostsList#86f8613c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBoostsList() : TLObject() {
    var count: Int = 0

    var boosts: TLObjectVector<TLBoost> = TLObjectVector()

    var nextOffset: String? = null

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "premium.boostsList#86f8613c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            boosts: TLObjectVector<TLBoost>,
            nextOffset: String?,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.count = count
        this.boosts = boosts
        this.nextOffset = nextOffset
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(nextOffset, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeTLVector(boosts)
        doIfMask(1, nextOffset, 1) { writeString(it) }
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        count = readInt()
        boosts = readTLVector<TLBoost>()
        nextOffset = readIfMask(1, 1) { readString() }
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += boosts.computeSerializedSize()
        size += getIntIfMask(1, nextOffset, 1) { computeTLStringSerializedSize(it) }
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBoostsList) return false
        if (other === this) return true

        return _flags == other._flags
                && count == other.count
                && boosts == other.boosts
                && nextOffset == other.nextOffset
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86f8613c.toInt()
    }
}
