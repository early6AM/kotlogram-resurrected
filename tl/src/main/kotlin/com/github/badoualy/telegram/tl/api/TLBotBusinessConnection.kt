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
 * botBusinessConnection#896433b4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotBusinessConnection() : TLObject() {
    @Transient
    var canReply: Boolean = false

    @Transient
    var disabled: Boolean = false

    var connectionId: String = ""

    var userId: Long = 0L

    var dcId: Int = 0

    var date: Int = 0

    private val _constructor: String = "botBusinessConnection#896433b4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canReply: Boolean,
            disabled: Boolean,
            connectionId: String,
            userId: Long,
            dcId: Int,
            date: Int
    ) : this() {
        this.canReply = canReply
        this.disabled = disabled
        this.connectionId = connectionId
        this.userId = userId
        this.dcId = dcId
        this.date = date
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canReply, 1)
        updateFlags(disabled, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(connectionId)
        writeLong(userId)
        writeInt(dcId)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canReply = isMask(1)
        disabled = isMask(2)
        connectionId = readString()
        userId = readLong()
        dcId = readInt()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(connectionId)
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotBusinessConnection) return false
        if (other === this) return true

        return _flags == other._flags
                && canReply == other.canReply
                && disabled == other.disabled
                && connectionId == other.connectionId
                && userId == other.userId
                && dcId == other.dcId
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x896433b4.toInt()
    }
}
