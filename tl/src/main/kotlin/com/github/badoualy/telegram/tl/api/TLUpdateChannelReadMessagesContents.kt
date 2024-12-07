package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
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
 * updateChannelReadMessagesContents#ea29055d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelReadMessagesContents() : TLAbsUpdate() {
    var channelId: Long = 0L

    var topMsgId: Int? = null

    var messages: TLIntVector = TLIntVector()

    private val _constructor: String = "updateChannelReadMessagesContents#ea29055d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Long,
            topMsgId: Int?,
            messages: TLIntVector
    ) : this() {
        this.channelId = channelId
        this.topMsgId = topMsgId
        this.messages = messages
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(topMsgId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(channelId)
        doIfMask(1, topMsgId, 1) { writeInt(it) }
        writeTLVector(messages)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channelId = readLong()
        topMsgId = readIfMask(1, 1) { readInt() }
        messages = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, topMsgId, 1) { SIZE_INT32 }
        size += messages.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelReadMessagesContents) return false
        if (other === this) return true

        return _flags == other._flags
                && channelId == other.channelId
                && topMsgId == other.topMsgId
                && messages == other.messages
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea29055d.toInt()
    }
}
