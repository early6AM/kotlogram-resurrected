package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLStringVector
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
 * messageMediaGiveaway#daad85b0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaGiveaway() : TLAbsMessageMedia() {
    @Transient
    var onlyNewSubscribers: Boolean = false

    @Transient
    var winnersAreVisible: Boolean = false

    var channels: TLLongVector = TLLongVector()

    var countriesIso2: TLStringVector? = null

    var prizeDescription: String? = null

    var quantity: Int = 0

    var months: Int = 0

    var untilDate: Int = 0

    private val _constructor: String = "messageMediaGiveaway#daad85b0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            onlyNewSubscribers: Boolean,
            winnersAreVisible: Boolean,
            channels: TLLongVector,
            countriesIso2: TLStringVector?,
            prizeDescription: String?,
            quantity: Int,
            months: Int,
            untilDate: Int
    ) : this() {
        this.onlyNewSubscribers = onlyNewSubscribers
        this.winnersAreVisible = winnersAreVisible
        this.channels = channels
        this.countriesIso2 = countriesIso2
        this.prizeDescription = prizeDescription
        this.quantity = quantity
        this.months = months
        this.untilDate = untilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(onlyNewSubscribers, 1)
        updateFlags(winnersAreVisible, 4)
        updateFlags(countriesIso2, 2)
        updateFlags(prizeDescription, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(channels)
        doIfMask(countriesIso2, 2) { writeTLVector(it) }
        doIfMask(prizeDescription, 8) { writeString(it) }
        writeInt(quantity)
        writeInt(months)
        writeInt(untilDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        onlyNewSubscribers = isMask(1)
        winnersAreVisible = isMask(4)
        channels = readTLLongVector()
        countriesIso2 = readIfMask(2) { readTLStringVector() }
        prizeDescription = readIfMask(8) { readString() }
        quantity = readInt()
        months = readInt()
        untilDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channels.computeSerializedSize()
        size += getIntIfMask(countriesIso2, 2) { it.computeSerializedSize() }
        size += getIntIfMask(prizeDescription, 8) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaGiveaway) return false
        if (other === this) return true

        return _flags == other._flags
                && onlyNewSubscribers == other.onlyNewSubscribers
                && winnersAreVisible == other.winnersAreVisible
                && channels == other.channels
                && countriesIso2 == other.countriesIso2
                && prizeDescription == other.prizeDescription
                && quantity == other.quantity
                && months == other.months
                && untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdaad85b0.toInt()
    }
}
