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
import com.github.badoualy.telegram.tl.api.TLReactionEmpty
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
class TLRequestStoriesSendReaction() : TLMethod<TLAbsUpdates>() {
    @Transient
    var addToRecent: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var storyId: Int = 0

    var reaction: TLAbsReaction = TLReactionEmpty()

    private val _constructor: String = "stories.sendReaction#7fd736b2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            storyId: Int,
            reaction: TLAbsReaction
    ) : this() {
        this.addToRecent = addToRecent
        this.peer = peer
        this.storyId = storyId
        this.reaction = reaction
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(addToRecent, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(storyId)
        writeTLObject(reaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        addToRecent = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        storyId = readInt()
        reaction = readTLObject<TLAbsReaction>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += reaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesSendReaction) return false
        if (other === this) return true

        return _flags == other._flags
                && addToRecent == other.addToRecent
                && peer == other.peer
                && storyId == other.storyId
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7fd736b2.toInt()
    }
}
