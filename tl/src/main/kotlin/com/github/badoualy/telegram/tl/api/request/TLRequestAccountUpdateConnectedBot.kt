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
import com.github.badoualy.telegram.tl.api.TLInputBusinessBotRecipients
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdateConnectedBot() : TLMethod<TLAbsUpdates>() {
    @Transient
    var canReply: Boolean = false

    @Transient
    var deleted: Boolean = false

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var recipients: TLInputBusinessBotRecipients = TLInputBusinessBotRecipients()

    private val _constructor: String = "account.updateConnectedBot#43d8521d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canReply: Boolean,
            deleted: Boolean,
            bot: TLAbsInputUser,
            recipients: TLInputBusinessBotRecipients
    ) : this() {
        this.canReply = canReply
        this.deleted = deleted
        this.bot = bot
        this.recipients = recipients
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(canReply, 1)
        updateFlags(deleted, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(bot)
        writeTLObject(recipients)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canReply = isMask(1, 1)
        deleted = isMask(1, 2)
        bot = readTLObject<TLAbsInputUser>()
        recipients = readTLObject<TLInputBusinessBotRecipients>(TLInputBusinessBotRecipients::class, TLInputBusinessBotRecipients.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += bot.computeSerializedSize()
        size += recipients.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdateConnectedBot) return false
        if (other === this) return true

        return _flags == other._flags
                && canReply == other.canReply
                && deleted == other.deleted
                && bot == other.bot
                && recipients == other.recipients
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x43d8521d.toInt()
    }
}
