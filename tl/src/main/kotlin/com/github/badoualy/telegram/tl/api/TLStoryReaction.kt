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
 * storyReaction#6090d6d5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryReaction() : TLAbsStoryReaction() {
    var peerId: TLAbsPeer = TLPeerChat()

    var date: Int = 0

    var reaction: TLAbsReaction = TLReactionEmpty()

    private val _constructor: String = "storyReaction#6090d6d5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peerId: TLAbsPeer,
            date: Int,
            reaction: TLAbsReaction
    ) : this() {
        this.peerId = peerId
        this.date = date
        this.reaction = reaction
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peerId)
        writeInt(date)
        writeTLObject(reaction)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peerId = readTLObject<TLAbsPeer>()
        date = readInt()
        reaction = readTLObject<TLAbsReaction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peerId.computeSerializedSize()
        size += SIZE_INT32
        size += reaction.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryReaction) return false
        if (other === this) return true

        return peerId == other.peerId
                && date == other.date
                && reaction == other.reaction
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6090d6d5.toInt()
    }
}
