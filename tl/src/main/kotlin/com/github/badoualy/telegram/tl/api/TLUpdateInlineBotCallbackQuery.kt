package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * updateInlineBotCallbackQuery#691e9052
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateInlineBotCallbackQuery() : TLAbsUpdate() {
    var queryId: Long = 0L

    var userId: Long = 0L

    var msgId: TLAbsInputBotInlineMessageID = TLInputBotInlineMessageID()

    var chatInstance: Long = 0L

    var data: TLBytes? = null

    var gameShortName: String? = null

    private val _constructor: String = "updateInlineBotCallbackQuery#691e9052"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            userId: Long,
            msgId: TLAbsInputBotInlineMessageID,
            chatInstance: Long,
            data: TLBytes?,
            gameShortName: String?
    ) : this() {
        this.queryId = queryId
        this.userId = userId
        this.msgId = msgId
        this.chatInstance = chatInstance
        this.data = data
        this.gameShortName = gameShortName
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(data, 1)
        updateFlags(gameShortName, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        writeLong(userId)
        writeTLObject(msgId)
        writeLong(chatInstance)
        doIfMask(data, 1) { writeTLBytes(it) }
        doIfMask(gameShortName, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        queryId = readLong()
        userId = readLong()
        msgId = readTLObject<TLAbsInputBotInlineMessageID>()
        chatInstance = readLong()
        data = readIfMask(1) { readTLBytes() }
        gameShortName = readIfMask(2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += msgId.computeSerializedSize()
        size += SIZE_INT64
        size += getIntIfMask(data, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(gameShortName, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateInlineBotCallbackQuery) return false
        if (other === this) return true

        return _flags == other._flags
                && queryId == other.queryId
                && userId == other.userId
                && msgId == other.msgId
                && chatInstance == other.chatInstance
                && data == other.data
                && gameShortName == other.gameShortName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x691e9052.toInt()
    }
}
