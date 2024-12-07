package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * connectedBot#bd068601
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLConnectedBot() : TLObject() {
    @Transient
    var canReply: Boolean = false

    var botId: Long = 0L

    var recipients: TLBusinessBotRecipients = TLBusinessBotRecipients()

    private val _constructor: String = "connectedBot#bd068601"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canReply: Boolean,
            botId: Long,
            recipients: TLBusinessBotRecipients
    ) : this() {
        this.canReply = canReply
        this.botId = botId
        this.recipients = recipients
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canReply, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(botId)
        writeTLObject(recipients)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canReply = isMask(1)
        botId = readLong()
        recipients = readTLObject<TLBusinessBotRecipients>(TLBusinessBotRecipients::class, TLBusinessBotRecipients.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += recipients.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLConnectedBot) return false
        if (other === this) return true

        return _flags == other._flags
                && canReply == other.canReply
                && botId == other.botId
                && recipients == other.recipients
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbd068601.toInt()
    }
}
