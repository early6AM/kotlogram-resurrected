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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * boost#2a1c8c71
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBoost() : TLObject() {
    @Transient
    var gift: Boolean = false

    @Transient
    var giveaway: Boolean = false

    @Transient
    var unclaimed: Boolean = false

    var id: String = ""

    var userId: Long? = null

    var giveawayMsgId: Int? = null

    var date: Int = 0

    var expires: Int = 0

    var usedGiftSlug: String? = null

    var multiplier: Int? = null

    private val _constructor: String = "boost#2a1c8c71"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            gift: Boolean,
            giveaway: Boolean,
            unclaimed: Boolean,
            id: String,
            userId: Long?,
            giveawayMsgId: Int?,
            date: Int,
            expires: Int,
            usedGiftSlug: String?,
            multiplier: Int?
    ) : this() {
        this.gift = gift
        this.giveaway = giveaway
        this.unclaimed = unclaimed
        this.id = id
        this.userId = userId
        this.giveawayMsgId = giveawayMsgId
        this.date = date
        this.expires = expires
        this.usedGiftSlug = usedGiftSlug
        this.multiplier = multiplier
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(gift, 2)
        updateFlags(giveaway, 4)
        updateFlags(unclaimed, 8)
        updateFlags(userId, 1)
        updateFlags(giveawayMsgId, 4)
        updateFlags(usedGiftSlug, 16)
        updateFlags(multiplier, 32)

        // Following parameters might be forced to true by another field that updated the flags
        giveaway = isMask(4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(id)
        doIfMask(userId, 1) { writeLong(it) }
        doIfMask(giveawayMsgId, 4) { writeInt(it) }
        writeInt(date)
        writeInt(expires)
        doIfMask(usedGiftSlug, 16) { writeString(it) }
        doIfMask(multiplier, 32) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        gift = isMask(2)
        giveaway = isMask(4)
        unclaimed = isMask(8)
        id = readString()
        userId = readIfMask(1) { readLong() }
        giveawayMsgId = readIfMask(4) { readInt() }
        date = readInt()
        expires = readInt()
        usedGiftSlug = readIfMask(16) { readString() }
        multiplier = readIfMask(32) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(id)
        size += getIntIfMask(userId, 1) { SIZE_INT64 }
        size += getIntIfMask(giveawayMsgId, 4) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(usedGiftSlug, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(multiplier, 32) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBoost) return false
        if (other === this) return true

        return _flags == other._flags
                && gift == other.gift
                && giveaway == other.giveaway
                && unclaimed == other.unclaimed
                && id == other.id
                && userId == other.userId
                && giveawayMsgId == other.giveawayMsgId
                && date == other.date
                && expires == other.expires
                && usedGiftSlug == other.usedGiftSlug
                && multiplier == other.multiplier
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2a1c8c71.toInt()
    }
}
