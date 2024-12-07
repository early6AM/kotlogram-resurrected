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
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup
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
class TLRequestMessagesEditMessage() : TLMethod<TLAbsUpdates>() {
    @Transient
    var noWebpage: Boolean = false

    @Transient
    var invertMedia: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var message: String? = null

    var media: TLAbsInputMedia? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var scheduleDate: Int? = null

    var quickReplyShortcutId: Int? = null

    private val _constructor: String = "messages.editMessage#dfd14005"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            quickReplyShortcutId: Int?
    ) : this() {
        this.noWebpage = noWebpage
        this.invertMedia = invertMedia
        this.peer = peer
        this.id = id
        this.message = message
        this.media = media
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.scheduleDate = scheduleDate
        this.quickReplyShortcutId = quickReplyShortcutId
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(noWebpage, 2)
        updateFlags(invertMedia, 65536)
        updateFlags(message, 2048)
        updateFlags(media, 16384)
        updateFlags(replyMarkup, 4)
        updateFlags(entities, 8)
        updateFlags(scheduleDate, 32768)
        updateFlags(quickReplyShortcutId, 131072)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(1, message, 2048) { writeString(it) }
        doIfMask(1, media, 16384) { writeTLObject(it) }
        doIfMask(1, replyMarkup, 4) { writeTLObject(it) }
        doIfMask(1, entities, 8) { writeTLVector(it) }
        doIfMask(1, scheduleDate, 32768) { writeInt(it) }
        doIfMask(1, quickReplyShortcutId, 131072) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(1, 2)
        invertMedia = isMask(1, 65536)
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        message = readIfMask(1, 2048) { readString() }
        media = readIfMask(1, 16384) { readTLObject<TLAbsInputMedia>() }
        replyMarkup = readIfMask(1, 4) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(1, 8) { readTLVector<TLAbsMessageEntity>() }
        scheduleDate = readIfMask(1, 32768) { readInt() }
        quickReplyShortcutId = readIfMask(1, 131072) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(1, message, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, media, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(1, replyMarkup, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, entities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, scheduleDate, 32768) { SIZE_INT32 }
        size += getIntIfMask(1, quickReplyShortcutId, 131072) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesEditMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && invertMedia == other.invertMedia
                && peer == other.peer
                && id == other.id
                && message == other.message
                && media == other.media
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && scheduleDate == other.scheduleDate
                && quickReplyShortcutId == other.quickReplyShortcutId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdfd14005.toInt()
    }
}
