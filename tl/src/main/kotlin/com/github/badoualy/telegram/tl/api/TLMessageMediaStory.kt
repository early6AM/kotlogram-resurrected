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
import kotlin.jvm.Transient

/**
 * messageMediaStory#68cb6283
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaStory() : TLAbsMessageMedia() {
    @Transient
    var viaMention: Boolean = false

    var peer: TLAbsPeer = TLPeerChat()

    var id: Int = 0

    var story: TLAbsStoryItem? = null

    private val _constructor: String = "messageMediaStory#68cb6283"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viaMention: Boolean,
            peer: TLAbsPeer,
            id: Int,
            story: TLAbsStoryItem?
    ) : this() {
        this.viaMention = viaMention
        this.peer = peer
        this.id = id
        this.story = story
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(viaMention, 2)
        updateFlags(story, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(story, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viaMention = isMask(2)
        peer = readTLObject<TLAbsPeer>()
        id = readInt()
        story = readIfMask(1) { readTLObject<TLAbsStoryItem>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(story, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaStory) return false
        if (other === this) return true

        return _flags == other._flags
                && viaMention == other.viaMention
                && peer == other.peer
                && id == other.id
                && story == other.story
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x68cb6283.toInt()
    }
}
