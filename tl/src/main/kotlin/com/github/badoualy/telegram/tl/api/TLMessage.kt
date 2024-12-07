package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * message#94345242
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessage() : TLAbsMessage() {
    @Transient
    var out: Boolean = false

    @Transient
    var mentioned: Boolean = false

    @Transient
    var mediaUnread: Boolean = false

    @Transient
    var silent: Boolean = false

    @Transient
    var post: Boolean = false

    @Transient
    var fromScheduled: Boolean = false

    @Transient
    var legacy: Boolean = false

    @Transient
    var editHide: Boolean = false

    @Transient
    var pinned: Boolean = false

    @Transient
    var noforwards: Boolean = false

    @Transient
    var invertMedia: Boolean = false

    @Transient
    var offline: Boolean = false

    override var id: Int = 0

    var fromId: TLAbsPeer? = null

    var fromBoostsApplied: Int? = null

    var peerId: TLAbsPeer = TLPeerChat()

    var savedPeerId: TLAbsPeer? = null

    var fwdFrom: TLMessageFwdHeader? = null

    var viaBotId: Long? = null

    var viaBusinessBotId: Long? = null

    var replyTo: TLAbsMessageReplyHeader? = null

    var date: Int = 0

    var message: String = ""

    var media: TLAbsMessageMedia? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var views: Int? = null

    var forwards: Int? = null

    var replies: TLMessageReplies? = null

    var editDate: Int? = null

    var postAuthor: String? = null

    var groupedId: Long? = null

    var reactions: TLMessageReactions? = null

    var restrictionReason: TLObjectVector<TLRestrictionReason>? = TLObjectVector()

    var ttlPeriod: Int? = null

    var quickReplyShortcutId: Int? = null

    var effect: Long? = null

    var factcheck: TLFactCheck? = null

    private val _constructor: String = "message#94345242"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            mentioned: Boolean,
            mediaUnread: Boolean,
            silent: Boolean,
            post: Boolean,
            fromScheduled: Boolean,
            legacy: Boolean,
            editHide: Boolean,
            pinned: Boolean,
            noforwards: Boolean,
            invertMedia: Boolean,
            offline: Boolean,
            id: Int,
            fromId: TLAbsPeer?,
            fromBoostsApplied: Int?,
            peerId: TLAbsPeer,
            savedPeerId: TLAbsPeer?,
            fwdFrom: TLMessageFwdHeader?,
            viaBotId: Long?,
            viaBusinessBotId: Long?,
            replyTo: TLAbsMessageReplyHeader?,
            date: Int,
            message: String,
            media: TLAbsMessageMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            views: Int?,
            forwards: Int?,
            replies: TLMessageReplies?,
            editDate: Int?,
            postAuthor: String?,
            groupedId: Long?,
            reactions: TLMessageReactions?,
            restrictionReason: TLObjectVector<TLRestrictionReason>?,
            ttlPeriod: Int?,
            quickReplyShortcutId: Int?,
            effect: Long?,
            factcheck: TLFactCheck?
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.post = post
        this.fromScheduled = fromScheduled
        this.legacy = legacy
        this.editHide = editHide
        this.pinned = pinned
        this.noforwards = noforwards
        this.invertMedia = invertMedia
        this.offline = offline
        this.id = id
        this.fromId = fromId
        this.fromBoostsApplied = fromBoostsApplied
        this.peerId = peerId
        this.savedPeerId = savedPeerId
        this.fwdFrom = fwdFrom
        this.viaBotId = viaBotId
        this.viaBusinessBotId = viaBusinessBotId
        this.replyTo = replyTo
        this.date = date
        this.message = message
        this.media = media
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.views = views
        this.forwards = forwards
        this.replies = replies
        this.editDate = editDate
        this.postAuthor = postAuthor
        this.groupedId = groupedId
        this.reactions = reactions
        this.restrictionReason = restrictionReason
        this.ttlPeriod = ttlPeriod
        this.quickReplyShortcutId = quickReplyShortcutId
        this.effect = effect
        this.factcheck = factcheck
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(post, 16384)
        updateFlags(fromScheduled, 262144)
        updateFlags(legacy, 524288)
        updateFlags(editHide, 2097152)
        updateFlags(pinned, 16777216)
        updateFlags(noforwards, 67108864)
        updateFlags(invertMedia, 134217728)
        updateFlags(offline, 2)
        updateFlags(fromId, 256)
        updateFlags(fromBoostsApplied, 536870912)
        updateFlags(savedPeerId, 268435456)
        updateFlags(fwdFrom, 4)
        updateFlags(viaBotId, 2048)
        updateFlags(viaBusinessBotId, 1)
        updateFlags(replyTo, 8)
        updateFlags(media, 512)
        updateFlags(replyMarkup, 64)
        updateFlags(entities, 128)
        updateFlags(views, 1024)
        updateFlags(forwards, 1024)
        updateFlags(replies, 8388608)
        updateFlags(editDate, 32768)
        updateFlags(postAuthor, 65536)
        updateFlags(groupedId, 131072)
        updateFlags(reactions, 1048576)
        updateFlags(restrictionReason, 4194304)
        updateFlags(ttlPeriod, 33554432)
        updateFlags(quickReplyShortcutId, 1073741824)
        updateFlags(effect, 4)
        updateFlags(factcheck, 8)

        // Following parameters might be forced to true by another field that updated the flags
        out = isMask(1, 2)
        offline = isMask(2, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(_flags2)
        writeInt(id)
        doIfMask(1, fromId, 256) { writeTLObject(it) }
        doIfMask(1, fromBoostsApplied, 536870912) { writeInt(it) }
        writeTLObject(peerId)
        doIfMask(1, savedPeerId, 268435456) { writeTLObject(it) }
        doIfMask(1, fwdFrom, 4) { writeTLObject(it) }
        doIfMask(1, viaBotId, 2048) { writeLong(it) }
        doIfMask(2, viaBusinessBotId, 1) { writeLong(it) }
        doIfMask(1, replyTo, 8) { writeTLObject(it) }
        writeInt(date)
        writeString(message)
        doIfMask(1, media, 512) { writeTLObject(it) }
        doIfMask(1, replyMarkup, 64) { writeTLObject(it) }
        doIfMask(1, entities, 128) { writeTLVector(it) }
        doIfMask(1, views, 1024) { writeInt(it) }
        doIfMask(1, forwards, 1024) { writeInt(it) }
        doIfMask(1, replies, 8388608) { writeTLObject(it) }
        doIfMask(1, editDate, 32768) { writeInt(it) }
        doIfMask(1, postAuthor, 65536) { writeString(it) }
        doIfMask(1, groupedId, 131072) { writeLong(it) }
        doIfMask(1, reactions, 1048576) { writeTLObject(it) }
        doIfMask(1, restrictionReason, 4194304) { writeTLVector(it) }
        doIfMask(1, ttlPeriod, 33554432) { writeInt(it) }
        doIfMask(1, quickReplyShortcutId, 1073741824) { writeInt(it) }
        doIfMask(2, effect, 4) { writeLong(it) }
        doIfMask(2, factcheck, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(1, 2)
        mentioned = isMask(1, 16)
        mediaUnread = isMask(1, 32)
        silent = isMask(1, 8192)
        post = isMask(1, 16384)
        fromScheduled = isMask(1, 262144)
        legacy = isMask(1, 524288)
        editHide = isMask(1, 2097152)
        pinned = isMask(1, 16777216)
        noforwards = isMask(1, 67108864)
        invertMedia = isMask(1, 134217728)
        _flags2 = readInt()
        offline = isMask(2, 2)
        id = readInt()
        fromId = readIfMask(1, 256) { readTLObject<TLAbsPeer>() }
        fromBoostsApplied = readIfMask(1, 536870912) { readInt() }
        peerId = readTLObject<TLAbsPeer>()
        savedPeerId = readIfMask(1, 268435456) { readTLObject<TLAbsPeer>() }
        fwdFrom = readIfMask(1, 4) { readTLObject<TLMessageFwdHeader>(TLMessageFwdHeader::class, TLMessageFwdHeader.CONSTRUCTOR_ID) }
        viaBotId = readIfMask(1, 2048) { readLong() }
        viaBusinessBotId = readIfMask(2, 1) { readLong() }
        replyTo = readIfMask(1, 8) { readTLObject<TLAbsMessageReplyHeader>() }
        date = readInt()
        message = readString()
        media = readIfMask(1, 512) { readTLObject<TLAbsMessageMedia>() }
        replyMarkup = readIfMask(1, 64) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(1, 128) { readTLVector<TLAbsMessageEntity>() }
        views = readIfMask(1, 1024) { readInt() }
        forwards = readIfMask(1, 1024) { readInt() }
        replies = readIfMask(1, 8388608) { readTLObject<TLMessageReplies>(TLMessageReplies::class, TLMessageReplies.CONSTRUCTOR_ID) }
        editDate = readIfMask(1, 32768) { readInt() }
        postAuthor = readIfMask(1, 65536) { readString() }
        groupedId = readIfMask(1, 131072) { readLong() }
        reactions = readIfMask(1, 1048576) { readTLObject<TLMessageReactions>(TLMessageReactions::class, TLMessageReactions.CONSTRUCTOR_ID) }
        restrictionReason = readIfMask(1, 4194304) { readTLVector<TLRestrictionReason>() }
        ttlPeriod = readIfMask(1, 33554432) { readInt() }
        quickReplyShortcutId = readIfMask(1, 1073741824) { readInt() }
        effect = readIfMask(2, 4) { readLong() }
        factcheck = readIfMask(2, 8) { readTLObject<TLFactCheck>(TLFactCheck::class, TLFactCheck.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, fromId, 256) { it.computeSerializedSize() }
        size += getIntIfMask(1, fromBoostsApplied, 536870912) { SIZE_INT32 }
        size += peerId.computeSerializedSize()
        size += getIntIfMask(1, savedPeerId, 268435456) { it.computeSerializedSize() }
        size += getIntIfMask(1, fwdFrom, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, viaBotId, 2048) { SIZE_INT64 }
        size += getIntIfMask(2, viaBusinessBotId, 1) { SIZE_INT64 }
        size += getIntIfMask(1, replyTo, 8) { it.computeSerializedSize() }
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(1, media, 512) { it.computeSerializedSize() }
        size += getIntIfMask(1, replyMarkup, 64) { it.computeSerializedSize() }
        size += getIntIfMask(1, entities, 128) { it.computeSerializedSize() }
        size += getIntIfMask(1, views, 1024) { SIZE_INT32 }
        size += getIntIfMask(1, forwards, 1024) { SIZE_INT32 }
        size += getIntIfMask(1, replies, 8388608) { it.computeSerializedSize() }
        size += getIntIfMask(1, editDate, 32768) { SIZE_INT32 }
        size += getIntIfMask(1, postAuthor, 65536) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, groupedId, 131072) { SIZE_INT64 }
        size += getIntIfMask(1, reactions, 1048576) { it.computeSerializedSize() }
        size += getIntIfMask(1, restrictionReason, 4194304) { it.computeSerializedSize() }
        size += getIntIfMask(1, ttlPeriod, 33554432) { SIZE_INT32 }
        size += getIntIfMask(1, quickReplyShortcutId, 1073741824) { SIZE_INT32 }
        size += getIntIfMask(2, effect, 4) { SIZE_INT64 }
        size += getIntIfMask(2, factcheck, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && mentioned == other.mentioned
                && mediaUnread == other.mediaUnread
                && silent == other.silent
                && post == other.post
                && fromScheduled == other.fromScheduled
                && legacy == other.legacy
                && editHide == other.editHide
                && pinned == other.pinned
                && noforwards == other.noforwards
                && invertMedia == other.invertMedia
                && _flags2 == other._flags2
                && offline == other.offline
                && id == other.id
                && fromId == other.fromId
                && fromBoostsApplied == other.fromBoostsApplied
                && peerId == other.peerId
                && savedPeerId == other.savedPeerId
                && fwdFrom == other.fwdFrom
                && viaBotId == other.viaBotId
                && viaBusinessBotId == other.viaBusinessBotId
                && replyTo == other.replyTo
                && date == other.date
                && message == other.message
                && media == other.media
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && views == other.views
                && forwards == other.forwards
                && replies == other.replies
                && editDate == other.editDate
                && postAuthor == other.postAuthor
                && groupedId == other.groupedId
                && reactions == other.reactions
                && restrictionReason == other.restrictionReason
                && ttlPeriod == other.ttlPeriod
                && quickReplyShortcutId == other.quickReplyShortcutId
                && effect == other.effect
                && factcheck == other.factcheck
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x94345242.toInt()
    }
}
