package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineResult
import com.github.badoualy.telegram.tl.api.TLInputBotInlineResultGame
import com.github.badoualy.telegram.tl.api.TLWebViewMessageSent
import com.github.badoualy.telegram.tl.core.TLMethod
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
class TLRequestMessagesSendWebViewResultMessage() : TLMethod<TLWebViewMessageSent>() {
    var botQueryId: String = ""

    var result: TLAbsInputBotInlineResult = TLInputBotInlineResultGame()

    private val _constructor: String = "messages.sendWebViewResultMessage#a4314f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(botQueryId: String, result: TLAbsInputBotInlineResult) : this() {
        this.botQueryId = botQueryId
        this.result = result
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLWebViewMessageSent = tlDeserializer.readTLObject(TLWebViewMessageSent::class, TLWebViewMessageSent.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(botQueryId)
        writeTLObject(result)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        botQueryId = readString()
        result = readTLObject<TLAbsInputBotInlineResult>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(botQueryId)
        size += result.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendWebViewResultMessage) return false
        if (other === this) return true

        return botQueryId == other.botQueryId
                && result == other.result
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa4314f5.toInt()
    }
}
