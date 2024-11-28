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
 * updateDraftMessage#1b49ec6d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDraftMessage() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var topMsgId: Int? = null

    var draft: TLAbsDraftMessage = TLDraftMessageEmpty()

    private val _constructor: String = "updateDraftMessage#1b49ec6d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            topMsgId: Int?,
            draft: TLAbsDraftMessage
    ) : this() {
        this.peer = peer
        this.topMsgId = topMsgId
        this.draft = draft
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(topMsgId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(topMsgId, 1) { writeInt(it) }
        writeTLObject(draft)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsPeer>()
        topMsgId = readIfMask(1) { readInt() }
        draft = readTLObject<TLAbsDraftMessage>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(topMsgId, 1) { SIZE_INT32 }
        size += draft.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateDraftMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && topMsgId == other.topMsgId
                && draft == other.draft
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1b49ec6d.toInt()
    }
}
