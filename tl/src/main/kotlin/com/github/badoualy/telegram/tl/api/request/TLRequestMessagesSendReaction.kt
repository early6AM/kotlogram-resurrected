package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsReaction
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
class TLRequestMessagesSendReaction() : TLMethod<TLAbsUpdates>() {
    @Transient
    var big: Boolean = false

    @Transient
    var addToRecent: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var reaction: TLObjectVector<TLAbsReaction>? = TLObjectVector()

    private val _constructor: String = "messages.sendReaction#d30d78d4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            big: Boolean,
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            reaction: TLObjectVector<TLAbsReaction>?
    ) : this() {
        this.big = big
        this.addToRecent = addToRecent
        this.peer = peer
        this.msgId = msgId
        this.reaction = reaction
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(big, 2)
        updateFlags(addToRecent, 4)
        updateFlags(reaction, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(msgId)
        doIfMask(reaction, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        big = isMask(2)
        addToRecent = isMask(4)
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        reaction = readIfMask(1) { readTLVector<TLAbsReaction>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(reaction, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendReaction) return false
        if (other === this) return true

        return _flags == other._flags
                && big == other.big
                && addToRecent == other.addToRecent
                && peer == other.peer
                && msgId == other.msgId
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd30d78d4.toInt()
    }
}
