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
 * updateMessageReactions#5e1b3cb8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateMessageReactions() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var msgId: Int = 0

    var topMsgId: Int? = null

    var reactions: TLMessageReactions = TLMessageReactions()

    private val _constructor: String = "updateMessageReactions#5e1b3cb8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            msgId: Int,
            topMsgId: Int?,
            reactions: TLMessageReactions
    ) : this() {
        this.peer = peer
        this.msgId = msgId
        this.topMsgId = topMsgId
        this.reactions = reactions
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
        writeTLObject(peer)
        writeInt(msgId)
        doIfMask(1, topMsgId, 1) { writeInt(it) }
        writeTLObject(reactions)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsPeer>()
        msgId = readInt()
        topMsgId = readIfMask(1, 1) { readInt() }
        reactions = readTLObject<TLMessageReactions>(TLMessageReactions::class, TLMessageReactions.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, topMsgId, 1) { SIZE_INT32 }
        size += reactions.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateMessageReactions) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && msgId == other.msgId
                && topMsgId == other.topMsgId
                && reactions == other.reactions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5e1b3cb8.toInt()
    }
}
