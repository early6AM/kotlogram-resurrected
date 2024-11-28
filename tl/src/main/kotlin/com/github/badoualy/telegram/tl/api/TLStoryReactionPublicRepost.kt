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
 * storyReactionPublicRepost#cfcd0f13
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryReactionPublicRepost() : TLAbsStoryReaction() {
    var peerId: TLAbsPeer = TLPeerChat()

    var story: TLAbsStoryItem = TLStoryItemDeleted()

    private val _constructor: String = "storyReactionPublicRepost#cfcd0f13"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peerId: TLAbsPeer, story: TLAbsStoryItem) : this() {
        this.peerId = peerId
        this.story = story
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peerId)
        writeTLObject(story)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peerId = readTLObject<TLAbsPeer>()
        story = readTLObject<TLAbsStoryItem>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peerId.computeSerializedSize()
        size += story.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryReactionPublicRepost) return false
        if (other === this) return true

        return peerId == other.peerId
                && story == other.story
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcfcd0f13.toInt()
    }
}
