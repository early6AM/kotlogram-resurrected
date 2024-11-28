package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestBotsReorderUsernames() : TLMethod<TLBool>() {
    var bot: TLAbsInputUser = TLInputUserEmpty()

    var order: TLStringVector = TLStringVector()

    private val _constructor: String = "bots.reorderUsernames#9709b1c2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(bot: TLAbsInputUser, order: TLStringVector) : this() {
        this.bot = bot
        this.order = order
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(bot)
        writeTLVector(order)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        bot = readTLObject<TLAbsInputUser>()
        order = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += bot.computeSerializedSize()
        size += order.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestBotsReorderUsernames) return false
        if (other === this) return true

        return bot == other.bot
                && order == other.order
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9709b1c2.toInt()
    }
}
