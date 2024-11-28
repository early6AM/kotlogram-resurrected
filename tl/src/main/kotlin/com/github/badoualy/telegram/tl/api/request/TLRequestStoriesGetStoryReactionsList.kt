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
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.stories.TLStoryReactionsList
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
class TLRequestStoriesGetStoryReactionsList() : TLMethod<TLStoryReactionsList>() {
    @Transient
    var forwardsFirst: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var reaction: TLAbsReaction? = null

    var offset: String? = null

    var limit: Int = 0

    private val _constructor: String = "stories.getStoryReactionsList#b9b2881f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            reaction: TLAbsReaction?,
            offset: String?,
            limit: Int
    ) : this() {
        this.forwardsFirst = forwardsFirst
        this.peer = peer
        this.id = id
        this.reaction = reaction
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStoryReactionsList = tlDeserializer.readTLObject(TLStoryReactionsList::class, TLStoryReactionsList.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(forwardsFirst, 4)
        updateFlags(reaction, 1)
        updateFlags(offset, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(reaction, 1) { writeTLObject(it) }
        doIfMask(offset, 2) { writeString(it) }
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forwardsFirst = isMask(4)
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        reaction = readIfMask(1) { readTLObject<TLAbsReaction>() }
        offset = readIfMask(2) { readString() }
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(reaction, 1) { it.computeSerializedSize() }
        size += getIntIfMask(offset, 2) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesGetStoryReactionsList) return false
        if (other === this) return true

        return _flags == other._flags
                && forwardsFirst == other.forwardsFirst
                && peer == other.peer
                && id == other.id
                && reaction == other.reaction
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb9b2881f.toInt()
    }
}
