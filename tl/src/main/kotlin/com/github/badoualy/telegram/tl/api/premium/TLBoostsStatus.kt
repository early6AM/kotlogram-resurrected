package com.github.badoualy.telegram.tl.api.premium

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLPrepaidGiveaway
import com.github.badoualy.telegram.tl.api.TLStatsPercentValue
import com.github.badoualy.telegram.tl.core.TLIntVector
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
import kotlin.jvm.Transient

/**
 * premium.boostsStatus#4959427a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBoostsStatus() : TLObject() {
    @Transient
    var myBoost: Boolean = false

    var level: Int = 0

    var currentLevelBoosts: Int = 0

    var boosts: Int = 0

    var giftBoosts: Int? = null

    var nextLevelBoosts: Int? = null

    var premiumAudience: TLStatsPercentValue? = null

    var boostUrl: String = ""

    var prepaidGiveaways: TLObjectVector<TLPrepaidGiveaway>? = TLObjectVector()

    var myBoostSlots: TLIntVector? = null

    private val _constructor: String = "premium.boostsStatus#4959427a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            myBoost: Boolean,
            level: Int,
            currentLevelBoosts: Int,
            boosts: Int,
            giftBoosts: Int?,
            nextLevelBoosts: Int?,
            premiumAudience: TLStatsPercentValue?,
            boostUrl: String,
            prepaidGiveaways: TLObjectVector<TLPrepaidGiveaway>?,
            myBoostSlots: TLIntVector?
    ) : this() {
        this.myBoost = myBoost
        this.level = level
        this.currentLevelBoosts = currentLevelBoosts
        this.boosts = boosts
        this.giftBoosts = giftBoosts
        this.nextLevelBoosts = nextLevelBoosts
        this.premiumAudience = premiumAudience
        this.boostUrl = boostUrl
        this.prepaidGiveaways = prepaidGiveaways
        this.myBoostSlots = myBoostSlots
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(myBoost, 4)
        updateFlags(giftBoosts, 16)
        updateFlags(nextLevelBoosts, 1)
        updateFlags(premiumAudience, 2)
        updateFlags(prepaidGiveaways, 8)
        updateFlags(myBoostSlots, 4)

        // Following parameters might be forced to true by another field that updated the flags
        myBoost = isMask(4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(level)
        writeInt(currentLevelBoosts)
        writeInt(boosts)
        doIfMask(giftBoosts, 16) { writeInt(it) }
        doIfMask(nextLevelBoosts, 1) { writeInt(it) }
        doIfMask(premiumAudience, 2) { writeTLObject(it) }
        writeString(boostUrl)
        doIfMask(prepaidGiveaways, 8) { writeTLVector(it) }
        doIfMask(myBoostSlots, 4) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        myBoost = isMask(4)
        level = readInt()
        currentLevelBoosts = readInt()
        boosts = readInt()
        giftBoosts = readIfMask(16) { readInt() }
        nextLevelBoosts = readIfMask(1) { readInt() }
        premiumAudience = readIfMask(2) { readTLObject<TLStatsPercentValue>(TLStatsPercentValue::class, TLStatsPercentValue.CONSTRUCTOR_ID) }
        boostUrl = readString()
        prepaidGiveaways = readIfMask(8) { readTLVector<TLPrepaidGiveaway>() }
        myBoostSlots = readIfMask(4) { readTLIntVector() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(giftBoosts, 16) { SIZE_INT32 }
        size += getIntIfMask(nextLevelBoosts, 1) { SIZE_INT32 }
        size += getIntIfMask(premiumAudience, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(boostUrl)
        size += getIntIfMask(prepaidGiveaways, 8) { it.computeSerializedSize() }
        size += getIntIfMask(myBoostSlots, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBoostsStatus) return false
        if (other === this) return true

        return _flags == other._flags
                && myBoost == other.myBoost
                && level == other.level
                && currentLevelBoosts == other.currentLevelBoosts
                && boosts == other.boosts
                && giftBoosts == other.giftBoosts
                && nextLevelBoosts == other.nextLevelBoosts
                && premiumAudience == other.premiumAudience
                && boostUrl == other.boostUrl
                && prepaidGiveaways == other.prepaidGiveaways
                && myBoostSlots == other.myBoostSlots
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4959427a.toInt()
    }
}
