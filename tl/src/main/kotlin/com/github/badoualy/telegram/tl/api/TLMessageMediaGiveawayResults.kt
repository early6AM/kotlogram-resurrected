package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
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
 * messageMediaGiveawayResults#c6991068
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaGiveawayResults() : TLAbsMessageMedia() {
    @Transient
    var onlyNewSubscribers: Boolean = false

    @Transient
    var refunded: Boolean = false

    var channelId: Long = 0L

    var additionalPeersCount: Int? = null

    var launchMsgId: Int = 0

    var winnersCount: Int = 0

    var unclaimedCount: Int = 0

    var winners: TLLongVector = TLLongVector()

    var months: Int = 0

    var prizeDescription: String? = null

    var untilDate: Int = 0

    private val _constructor: String = "messageMediaGiveawayResults#c6991068"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            onlyNewSubscribers: Boolean,
            refunded: Boolean,
            channelId: Long,
            additionalPeersCount: Int?,
            launchMsgId: Int,
            winnersCount: Int,
            unclaimedCount: Int,
            winners: TLLongVector,
            months: Int,
            prizeDescription: String?,
            untilDate: Int
    ) : this() {
        this.onlyNewSubscribers = onlyNewSubscribers
        this.refunded = refunded
        this.channelId = channelId
        this.additionalPeersCount = additionalPeersCount
        this.launchMsgId = launchMsgId
        this.winnersCount = winnersCount
        this.unclaimedCount = unclaimedCount
        this.winners = winners
        this.months = months
        this.prizeDescription = prizeDescription
        this.untilDate = untilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(onlyNewSubscribers, 1)
        updateFlags(refunded, 4)
        updateFlags(additionalPeersCount, 8)
        updateFlags(prizeDescription, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(channelId)
        doIfMask(1, additionalPeersCount, 8) { writeInt(it) }
        writeInt(launchMsgId)
        writeInt(winnersCount)
        writeInt(unclaimedCount)
        writeTLVector(winners)
        writeInt(months)
        doIfMask(1, prizeDescription, 2) { writeString(it) }
        writeInt(untilDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        onlyNewSubscribers = isMask(1, 1)
        refunded = isMask(1, 4)
        channelId = readLong()
        additionalPeersCount = readIfMask(1, 8) { readInt() }
        launchMsgId = readInt()
        winnersCount = readInt()
        unclaimedCount = readInt()
        winners = readTLLongVector()
        months = readInt()
        prizeDescription = readIfMask(1, 2) { readString() }
        untilDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, additionalPeersCount, 8) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += winners.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, prizeDescription, 2) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaGiveawayResults) return false
        if (other === this) return true

        return _flags == other._flags
                && onlyNewSubscribers == other.onlyNewSubscribers
                && refunded == other.refunded
                && channelId == other.channelId
                && additionalPeersCount == other.additionalPeersCount
                && launchMsgId == other.launchMsgId
                && winnersCount == other.winnersCount
                && unclaimedCount == other.unclaimedCount
                && winners == other.winners
                && months == other.months
                && prizeDescription == other.prizeDescription
                && untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc6991068.toInt()
    }
}
