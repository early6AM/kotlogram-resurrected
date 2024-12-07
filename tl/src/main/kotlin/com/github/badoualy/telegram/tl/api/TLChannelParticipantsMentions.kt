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
 * channelParticipantsMentions#e04b5ceb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantsMentions() : TLAbsChannelParticipantsFilter() {
    var q: String? = null

    var topMsgId: Int? = null

    private val _constructor: String = "channelParticipantsMentions#e04b5ceb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(q: String?, topMsgId: Int?) : this() {
        this.q = q
        this.topMsgId = topMsgId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(q, 1)
        updateFlags(topMsgId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, q, 1) { writeString(it) }
        doIfMask(1, topMsgId, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        q = readIfMask(1, 1) { readString() }
        topMsgId = readIfMask(1, 2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, q, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, topMsgId, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantsMentions) return false
        if (other === this) return true

        return _flags == other._flags
                && q == other.q
                && topMsgId == other.topMsgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe04b5ceb.toInt()
    }
}
