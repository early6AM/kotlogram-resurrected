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
import com.github.badoualy.telegram.tl.api.TLInputMediaEmpty
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStoriesSendStory() : TLMethod<TLAbsUpdates>() {
    @Transient
    var pinned: Boolean = false

    @Transient
    var noforwards: Boolean = false

    @Transient
    var fwdModified: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var media: TLAbsInputMedia = TLInputMediaEmpty()

    var mediaAreas: TLObjectVector<TLAbsMediaArea>? = TLObjectVector()

    var caption: String? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var privacyRules: TLObjectVector<TLAbsInputPrivacyRule> = TLObjectVector()

    var randomId: Long = 0L

    var period: Int? = null

    var fwdFromId: TLAbsInputPeer? = null

    var fwdFromStory: Int? = null

    private val _constructor: String = "stories.sendStory#e4e6694b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pinned: Boolean,
            noforwards: Boolean,
            fwdModified: Boolean,
            peer: TLAbsInputPeer,
            media: TLAbsInputMedia,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>,
            randomId: Long,
            period: Int?,
            fwdFromId: TLAbsInputPeer?,
            fwdFromStory: Int?
    ) : this() {
        this.pinned = pinned
        this.noforwards = noforwards
        this.fwdModified = fwdModified
        this.peer = peer
        this.media = media
        this.mediaAreas = mediaAreas
        this.caption = caption
        this.entities = entities
        this.privacyRules = privacyRules
        this.randomId = randomId
        this.period = period
        this.fwdFromId = fwdFromId
        this.fwdFromStory = fwdFromStory
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(pinned, 4)
        updateFlags(noforwards, 16)
        updateFlags(fwdModified, 128)
        updateFlags(mediaAreas, 32)
        updateFlags(caption, 1)
        updateFlags(entities, 2)
        updateFlags(period, 8)
        updateFlags(fwdFromId, 64)
        updateFlags(fwdFromStory, 64)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(media)
        doIfMask(1, mediaAreas, 32) { writeTLVector(it) }
        doIfMask(1, caption, 1) { writeString(it) }
        doIfMask(1, entities, 2) { writeTLVector(it) }
        writeTLVector(privacyRules)
        writeLong(randomId)
        doIfMask(1, period, 8) { writeInt(it) }
        doIfMask(1, fwdFromId, 64) { writeTLObject(it) }
        doIfMask(1, fwdFromStory, 64) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(1, 4)
        noforwards = isMask(1, 16)
        fwdModified = isMask(1, 128)
        peer = readTLObject<TLAbsInputPeer>()
        media = readTLObject<TLAbsInputMedia>()
        mediaAreas = readIfMask(1, 32) { readTLVector<TLAbsMediaArea>() }
        caption = readIfMask(1, 1) { readString() }
        entities = readIfMask(1, 2) { readTLVector<TLAbsMessageEntity>() }
        privacyRules = readTLVector<TLAbsInputPrivacyRule>()
        randomId = readLong()
        period = readIfMask(1, 8) { readInt() }
        fwdFromId = readIfMask(1, 64) { readTLObject<TLAbsInputPeer>() }
        fwdFromStory = readIfMask(1, 64) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += media.computeSerializedSize()
        size += getIntIfMask(1, mediaAreas, 32) { it.computeSerializedSize() }
        size += getIntIfMask(1, caption, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, entities, 2) { it.computeSerializedSize() }
        size += privacyRules.computeSerializedSize()
        size += SIZE_INT64
        size += getIntIfMask(1, period, 8) { SIZE_INT32 }
        size += getIntIfMask(1, fwdFromId, 64) { it.computeSerializedSize() }
        size += getIntIfMask(1, fwdFromStory, 64) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStoriesSendStory) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && noforwards == other.noforwards
                && fwdModified == other.fwdModified
                && peer == other.peer
                && media == other.media
                && mediaAreas == other.mediaAreas
                && caption == other.caption
                && entities == other.entities
                && privacyRules == other.privacyRules
                && randomId == other.randomId
                && period == other.period
                && fwdFromId == other.fwdFromId
                && fwdFromStory == other.fwdFromStory
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe4e6694b.toInt()
    }
}
