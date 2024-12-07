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
 * updateBotEditBusinessMessage#7df587c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotEditBusinessMessage() : TLAbsUpdate() {
    var connectionId: String = ""

    var message: TLAbsMessage = TLMessageEmpty()

    var replyToMessage: TLAbsMessage? = null

    var qts: Int = 0

    private val _constructor: String = "updateBotEditBusinessMessage#7df587c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            connectionId: String,
            message: TLAbsMessage,
            replyToMessage: TLAbsMessage?,
            qts: Int
    ) : this() {
        this.connectionId = connectionId
        this.message = message
        this.replyToMessage = replyToMessage
        this.qts = qts
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(replyToMessage, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(connectionId)
        writeTLObject(message)
        doIfMask(replyToMessage, 1) { writeTLObject(it) }
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        connectionId = readString()
        message = readTLObject<TLAbsMessage>()
        replyToMessage = readIfMask(1) { readTLObject<TLAbsMessage>() }
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(connectionId)
        size += message.computeSerializedSize()
        size += getIntIfMask(replyToMessage, 1) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotEditBusinessMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && connectionId == other.connectionId
                && message == other.message
                && replyToMessage == other.replyToMessage
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7df587c.toInt()
    }
}
