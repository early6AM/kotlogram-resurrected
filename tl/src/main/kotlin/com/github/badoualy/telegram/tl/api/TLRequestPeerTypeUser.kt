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
 * requestPeerTypeUser#5f3b8a00
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPeerTypeUser() : TLAbsRequestPeerType() {
    var bot: Boolean? = null

    var premium: Boolean? = null

    private val _constructor: String = "requestPeerTypeUser#5f3b8a00"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(bot: Boolean?, premium: Boolean?) : this() {
        this.bot = bot
        this.premium = premium
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(bot, 1)
        updateFlags(premium, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(bot, 1) { writeBoolean(it) }
        doIfMask(premium, 2) { writeBoolean(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        bot = readIfMask(1) { readBoolean() }
        premium = readIfMask(2) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(bot, 1) { SIZE_BOOLEAN }
        size += getIntIfMask(premium, 2) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPeerTypeUser) return false
        if (other === this) return true

        return _flags == other._flags
                && bot == other.bot
                && premium == other.premium
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5f3b8a00.toInt()
    }
}
