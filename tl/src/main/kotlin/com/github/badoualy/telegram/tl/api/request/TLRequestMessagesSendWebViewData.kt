package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendWebViewData() : TLMethod<TLAbsUpdates>() {
    var bot: TLAbsInputUser = TLInputUserEmpty()

    var randomId: Long = 0L

    var buttonText: String = ""

    var data: String = ""

    private val _constructor: String = "messages.sendWebViewData#dc0242c8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            bot: TLAbsInputUser,
            randomId: Long,
            buttonText: String,
            data: String
    ) : this() {
        this.bot = bot
        this.randomId = randomId
        this.buttonText = buttonText
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(bot)
        writeLong(randomId)
        writeString(buttonText)
        writeString(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        bot = readTLObject<TLAbsInputUser>()
        randomId = readLong()
        buttonText = readString()
        data = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += bot.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLStringSerializedSize(buttonText)
        size += computeTLStringSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendWebViewData) return false
        if (other === this) return true

        return bot == other.bot
                && randomId == other.randomId
                && buttonText == other.buttonText
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdc0242c8.toInt()
    }
}
