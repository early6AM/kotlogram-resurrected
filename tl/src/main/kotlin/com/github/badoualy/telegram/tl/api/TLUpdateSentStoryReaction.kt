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
 * updateSentStoryReaction#7d627683
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateSentStoryReaction() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerChat()

    var storyId: Int = 0

    var reaction: TLAbsReaction = TLReactionEmpty()

    private val _constructor: String = "updateSentStoryReaction#7d627683"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            storyId: Int,
            reaction: TLAbsReaction
    ) : this() {
        this.peer = peer
        this.storyId = storyId
        this.reaction = reaction
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(storyId)
        writeTLObject(reaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        storyId = readInt()
        reaction = readTLObject<TLAbsReaction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += reaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateSentStoryReaction) return false
        if (other === this) return true

        return peer == other.peer
                && storyId == other.storyId
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7d627683.toInt()
    }
}
