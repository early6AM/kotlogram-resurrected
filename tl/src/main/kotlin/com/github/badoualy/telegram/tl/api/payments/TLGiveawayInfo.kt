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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * payments.giveawayInfo#4367daa0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGiveawayInfo() : TLAbsGiveawayInfo() {
    @Transient
    var participating: Boolean = false

    @Transient
    var preparingResults: Boolean = false

    override var startDate: Int = 0

    var joinedTooEarlyDate: Int? = null

    var adminDisallowedChatId: Long? = null

    var disallowedCountry: String? = null

    private val _constructor: String = "payments.giveawayInfo#4367daa0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            participating: Boolean,
            preparingResults: Boolean,
            startDate: Int,
            joinedTooEarlyDate: Int?,
            adminDisallowedChatId: Long?,
            disallowedCountry: String?
    ) : this() {
        this.participating = participating
        this.preparingResults = preparingResults
        this.startDate = startDate
        this.joinedTooEarlyDate = joinedTooEarlyDate
        this.adminDisallowedChatId = adminDisallowedChatId
        this.disallowedCountry = disallowedCountry
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(participating, 1)
        updateFlags(preparingResults, 8)
        updateFlags(joinedTooEarlyDate, 2)
        updateFlags(adminDisallowedChatId, 4)
        updateFlags(disallowedCountry, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(startDate)
        doIfMask(joinedTooEarlyDate, 2) { writeInt(it) }
        doIfMask(adminDisallowedChatId, 4) { writeLong(it) }
        doIfMask(disallowedCountry, 16) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        participating = isMask(1)
        preparingResults = isMask(8)
        startDate = readInt()
        joinedTooEarlyDate = readIfMask(2) { readInt() }
        adminDisallowedChatId = readIfMask(4) { readLong() }
        disallowedCountry = readIfMask(16) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(joinedTooEarlyDate, 2) { SIZE_INT32 }
        size += getIntIfMask(adminDisallowedChatId, 4) { SIZE_INT64 }
        size += getIntIfMask(disallowedCountry, 16) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGiveawayInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && participating == other.participating
                && preparingResults == other.preparingResults
                && startDate == other.startDate
                && joinedTooEarlyDate == other.joinedTooEarlyDate
                && adminDisallowedChatId == other.adminDisallowedChatId
                && disallowedCountry == other.disallowedCountry
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4367daa0.toInt()
    }
}
