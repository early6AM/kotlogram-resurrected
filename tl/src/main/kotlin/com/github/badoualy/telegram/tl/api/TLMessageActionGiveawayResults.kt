package com.github.badoualy.telegram.tl.api

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

/**
 * messageActionGiveawayResults#2a9fadc5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionGiveawayResults() : TLAbsMessageAction() {
    var winnersCount: Int = 0

    var unclaimedCount: Int = 0

    private val _constructor: String = "messageActionGiveawayResults#2a9fadc5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(winnersCount: Int, unclaimedCount: Int) : this() {
        this.winnersCount = winnersCount
        this.unclaimedCount = unclaimedCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(winnersCount)
        writeInt(unclaimedCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        winnersCount = readInt()
        unclaimedCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionGiveawayResults) return false
        if (other === this) return true

        return winnersCount == other.winnersCount
                && unclaimedCount == other.unclaimedCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2a9fadc5.toInt()
    }
}
