package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

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

    override fun computeFlags() {
        _flags = 0
        updateFlags(q, 1)
        updateFlags(topMsgId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(q, 1) { writeString(it) }
        doIfMask(topMsgId, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        q = readIfMask(1) { readString() }
        topMsgId = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(q, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(topMsgId, 2) { SIZE_INT32 }
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
