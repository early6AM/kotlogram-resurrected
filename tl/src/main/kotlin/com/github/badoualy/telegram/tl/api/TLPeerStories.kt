package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * peerStories#9a35e999
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerStories() : TLObject() {
    var peer: TLAbsPeer = TLPeerChat()

    var maxReadId: Int? = null

    var stories: TLObjectVector<TLAbsStoryItem> = TLObjectVector()

    private val _constructor: String = "peerStories#9a35e999"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            maxReadId: Int?,
            stories: TLObjectVector<TLAbsStoryItem>
    ) : this() {
        this.peer = peer
        this.maxReadId = maxReadId
        this.stories = stories
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(maxReadId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(maxReadId, 1) { writeInt(it) }
        writeTLVector(stories)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsPeer>()
        maxReadId = readIfMask(1) { readInt() }
        stories = readTLVector<TLAbsStoryItem>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(maxReadId, 1) { SIZE_INT32 }
        size += stories.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerStories) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && maxReadId == other.maxReadId
                && stories == other.stories
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a35e999.toInt()
    }
}
