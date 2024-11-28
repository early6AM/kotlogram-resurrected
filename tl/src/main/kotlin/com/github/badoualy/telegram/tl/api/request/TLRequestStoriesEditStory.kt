package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule
import com.github.badoualy.telegram.tl.api.TLAbsMediaArea
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesEditStory() : TLMethod<TLAbsUpdates>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var media: TLAbsInputMedia? = null

    var mediaAreas: TLObjectVector<TLAbsMediaArea>? = TLObjectVector()

    var caption: String? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var privacyRules: TLObjectVector<TLAbsInputPrivacyRule>? = TLObjectVector()

    private val _constructor: String = "stories.editStory#b583ba46"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            id: Int,
            media: TLAbsInputMedia?,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>?
    ) : this() {
        this.peer = peer
        this.id = id
        this.media = media
        this.mediaAreas = mediaAreas
        this.caption = caption
        this.entities = entities
        this.privacyRules = privacyRules
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(media, 1)
        updateFlags(mediaAreas, 8)
        updateFlags(caption, 2)
        updateFlags(entities, 2)
        updateFlags(privacyRules, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(media, 1) { writeTLObject(it) }
        doIfMask(mediaAreas, 8) { writeTLVector(it) }
        doIfMask(caption, 2) { writeString(it) }
        doIfMask(entities, 2) { writeTLVector(it) }
        doIfMask(privacyRules, 4) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        media = readIfMask(1) { readTLObject<TLAbsInputMedia>() }
        mediaAreas = readIfMask(8) { readTLVector<TLAbsMediaArea>() }
        caption = readIfMask(2) { readString() }
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
        privacyRules = readIfMask(4) { readTLVector<TLAbsInputPrivacyRule>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(media, 1) { it.computeSerializedSize() }
        size += getIntIfMask(mediaAreas, 8) { it.computeSerializedSize() }
        size += getIntIfMask(caption, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        size += getIntIfMask(privacyRules, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesEditStory) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && id == other.id
                && media == other.media
                && mediaAreas == other.mediaAreas
                && caption == other.caption
                && entities == other.entities
                && privacyRules == other.privacyRules
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb583ba46.toInt()
    }
}
