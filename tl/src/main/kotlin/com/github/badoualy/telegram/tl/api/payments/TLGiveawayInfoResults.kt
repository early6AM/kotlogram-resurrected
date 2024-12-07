package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * payments.giveawayInfoResults#cd5570
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGiveawayInfoResults() : TLAbsGiveawayInfo() {
    @Transient
    var winner: Boolean = false

    @Transient
    var refunded: Boolean = false

    override var startDate: Int = 0

    var giftCodeSlug: String? = null

    var finishDate: Int = 0

    var winnersCount: Int = 0

    var activatedCount: Int = 0

    private val _constructor: String = "payments.giveawayInfoResults#cd5570"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            winner: Boolean,
            refunded: Boolean,
            startDate: Int,
            giftCodeSlug: String?,
            finishDate: Int,
            winnersCount: Int,
            activatedCount: Int
    ) : this() {
        this.winner = winner
        this.refunded = refunded
        this.startDate = startDate
        this.giftCodeSlug = giftCodeSlug
        this.finishDate = finishDate
        this.winnersCount = winnersCount
        this.activatedCount = activatedCount
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(winner, 1)
        updateFlags(refunded, 2)
        updateFlags(giftCodeSlug, 1)

        // Following parameters might be forced to true by another field that updated the flags
        winner = isMask(1, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(startDate)
        doIfMask(1, giftCodeSlug, 1) { writeString(it) }
        writeInt(finishDate)
        writeInt(winnersCount)
        writeInt(activatedCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        winner = isMask(1, 1)
        refunded = isMask(1, 2)
        startDate = readInt()
        giftCodeSlug = readIfMask(1, 1) { readString() }
        finishDate = readInt()
        winnersCount = readInt()
        activatedCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, giftCodeSlug, 1) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGiveawayInfoResults) return false
        if (other === this) return true

        return _flags == other._flags
                && winner == other.winner
                && refunded == other.refunded
                && startDate == other.startDate
                && giftCodeSlug == other.giftCodeSlug
                && finishDate == other.finishDate
                && winnersCount == other.winnersCount
                && activatedCount == other.activatedCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcd5570.toInt()
    }
}
