package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
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
 * channelFull#bbab348d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelFull() : TLAbsChatFull() {
    @Transient
    var canViewParticipants: Boolean = false

    @Transient
    var canSetUsername: Boolean = false

    @Transient
    var canSetStickers: Boolean = false

    @Transient
    var hiddenPrehistory: Boolean = false

    @Transient
    var canSetLocation: Boolean = false

    @Transient
    var hasScheduled: Boolean = false

    @Transient
    var canViewStats: Boolean = false

    @Transient
    var blocked: Boolean = false

    @Transient
    var canDeleteChannel: Boolean = false

    @Transient
    var antispam: Boolean = false

    @Transient
    var participantsHidden: Boolean = false

    @Transient
    var translationsDisabled: Boolean = false

    @Transient
    var storiesPinnedAvailable: Boolean = false

    @Transient
    var viewForumAsMessages: Boolean = false

    @Transient
    var restrictedSponsored: Boolean = false

    @Transient
    var canViewRevenue: Boolean = false

    @Transient
    var paidMediaAllowed: Boolean = false

    @Transient
    var canViewStarsRevenue: Boolean = false

    override var id: Long = 0L

    override var about: String = ""

    var participantsCount: Int? = null

    var adminsCount: Int? = null

    var kickedCount: Int? = null

    var bannedCount: Int? = null

    var onlineCount: Int? = null

    var readInboxMaxId: Int = 0

    var readOutboxMaxId: Int = 0

    var unreadCount: Int = 0

    var chatPhoto: TLAbsPhoto = TLPhotoEmpty()

    override var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var exportedInvite: TLAbsExportedChatInvite? = null

    var botInfo: TLObjectVector<TLBotInfo> = TLObjectVector()

    var migratedFromChatId: Long? = null

    var migratedFromMaxId: Int? = null

    var pinnedMsgId: Int? = null

    var stickerset: TLStickerSet? = null

    var availableMinId: Int? = null

    override var folderId: Int? = null

    var linkedChatId: Long? = null

    var location: TLAbsChannelLocation? = null

    var slowmodeSeconds: Int? = null

    var slowmodeNextSendDate: Int? = null

    var statsDc: Int? = null

    var pts: Int = 0

    var call: TLInputGroupCall? = null

    var ttlPeriod: Int? = null

    var pendingSuggestions: TLStringVector? = null

    var groupcallDefaultJoinAs: TLAbsPeer? = null

    var themeEmoticon: String? = null

    var requestsPending: Int? = null

    var recentRequesters: TLLongVector? = null

    var defaultSendAs: TLAbsPeer? = null

    var availableReactions: TLAbsChatReactions? = null

    var reactionsLimit: Int? = null

    var stories: TLPeerStories? = null

    var wallpaper: TLAbsWallPaper? = null

    var boostsApplied: Int? = null

    var boostsUnrestrict: Int? = null

    var emojiset: TLStickerSet? = null

    private val _constructor: String = "channelFull#bbab348d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canViewParticipants: Boolean,
            canSetUsername: Boolean,
            canSetStickers: Boolean,
            hiddenPrehistory: Boolean,
            canSetLocation: Boolean,
            hasScheduled: Boolean,
            canViewStats: Boolean,
            blocked: Boolean,
            canDeleteChannel: Boolean,
            antispam: Boolean,
            participantsHidden: Boolean,
            translationsDisabled: Boolean,
            storiesPinnedAvailable: Boolean,
            viewForumAsMessages: Boolean,
            restrictedSponsored: Boolean,
            canViewRevenue: Boolean,
            paidMediaAllowed: Boolean,
            canViewStarsRevenue: Boolean,
            id: Long,
            about: String,
            participantsCount: Int?,
            adminsCount: Int?,
            kickedCount: Int?,
            bannedCount: Int?,
            onlineCount: Int?,
            readInboxMaxId: Int,
            readOutboxMaxId: Int,
            unreadCount: Int,
            chatPhoto: TLAbsPhoto,
            notifySettings: TLPeerNotifySettings,
            exportedInvite: TLAbsExportedChatInvite?,
            botInfo: TLObjectVector<TLBotInfo>,
            migratedFromChatId: Long?,
            migratedFromMaxId: Int?,
            pinnedMsgId: Int?,
            stickerset: TLStickerSet?,
            availableMinId: Int?,
            folderId: Int?,
            linkedChatId: Long?,
            location: TLAbsChannelLocation?,
            slowmodeSeconds: Int?,
            slowmodeNextSendDate: Int?,
            statsDc: Int?,
            pts: Int,
            call: TLInputGroupCall?,
            ttlPeriod: Int?,
            pendingSuggestions: TLStringVector?,
            groupcallDefaultJoinAs: TLAbsPeer?,
            themeEmoticon: String?,
            requestsPending: Int?,
            recentRequesters: TLLongVector?,
            defaultSendAs: TLAbsPeer?,
            availableReactions: TLAbsChatReactions?,
            reactionsLimit: Int?,
            stories: TLPeerStories?,
            wallpaper: TLAbsWallPaper?,
            boostsApplied: Int?,
            boostsUnrestrict: Int?,
            emojiset: TLStickerSet?
    ) : this() {
        this.canViewParticipants = canViewParticipants
        this.canSetUsername = canSetUsername
        this.canSetStickers = canSetStickers
        this.hiddenPrehistory = hiddenPrehistory
        this.canSetLocation = canSetLocation
        this.hasScheduled = hasScheduled
        this.canViewStats = canViewStats
        this.blocked = blocked
        this.canDeleteChannel = canDeleteChannel
        this.antispam = antispam
        this.participantsHidden = participantsHidden
        this.translationsDisabled = translationsDisabled
        this.storiesPinnedAvailable = storiesPinnedAvailable
        this.viewForumAsMessages = viewForumAsMessages
        this.restrictedSponsored = restrictedSponsored
        this.canViewRevenue = canViewRevenue
        this.paidMediaAllowed = paidMediaAllowed
        this.canViewStarsRevenue = canViewStarsRevenue
        this.id = id
        this.about = about
        this.participantsCount = participantsCount
        this.adminsCount = adminsCount
        this.kickedCount = kickedCount
        this.bannedCount = bannedCount
        this.onlineCount = onlineCount
        this.readInboxMaxId = readInboxMaxId
        this.readOutboxMaxId = readOutboxMaxId
        this.unreadCount = unreadCount
        this.chatPhoto = chatPhoto
        this.notifySettings = notifySettings
        this.exportedInvite = exportedInvite
        this.botInfo = botInfo
        this.migratedFromChatId = migratedFromChatId
        this.migratedFromMaxId = migratedFromMaxId
        this.pinnedMsgId = pinnedMsgId
        this.stickerset = stickerset
        this.availableMinId = availableMinId
        this.folderId = folderId
        this.linkedChatId = linkedChatId
        this.location = location
        this.slowmodeSeconds = slowmodeSeconds
        this.slowmodeNextSendDate = slowmodeNextSendDate
        this.statsDc = statsDc
        this.pts = pts
        this.call = call
        this.ttlPeriod = ttlPeriod
        this.pendingSuggestions = pendingSuggestions
        this.groupcallDefaultJoinAs = groupcallDefaultJoinAs
        this.themeEmoticon = themeEmoticon
        this.requestsPending = requestsPending
        this.recentRequesters = recentRequesters
        this.defaultSendAs = defaultSendAs
        this.availableReactions = availableReactions
        this.reactionsLimit = reactionsLimit
        this.stories = stories
        this.wallpaper = wallpaper
        this.boostsApplied = boostsApplied
        this.boostsUnrestrict = boostsUnrestrict
        this.emojiset = emojiset
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canViewParticipants, 8)
        updateFlags(canSetUsername, 64)
        updateFlags(canSetStickers, 128)
        updateFlags(hiddenPrehistory, 1024)
        updateFlags(canSetLocation, 65536)
        updateFlags(hasScheduled, 524288)
        updateFlags(canViewStats, 1048576)
        updateFlags(blocked, 4194304)
        updateFlags(canDeleteChannel, 1)
        updateFlags(antispam, 2)
        updateFlags(participantsHidden, 4)
        updateFlags(translationsDisabled, 8)
        updateFlags(storiesPinnedAvailable, 32)
        updateFlags(viewForumAsMessages, 64)
        updateFlags(restrictedSponsored, 2048)
        updateFlags(canViewRevenue, 4096)
        updateFlags(paidMediaAllowed, 16384)
        updateFlags(canViewStarsRevenue, 32768)
        updateFlags(participantsCount, 1)
        updateFlags(adminsCount, 2)
        updateFlags(kickedCount, 4)
        updateFlags(bannedCount, 4)
        updateFlags(onlineCount, 8192)
        updateFlags(exportedInvite, 8388608)
        updateFlags(migratedFromChatId, 16)
        updateFlags(migratedFromMaxId, 16)
        updateFlags(pinnedMsgId, 32)
        updateFlags(stickerset, 256)
        updateFlags(availableMinId, 512)
        updateFlags(folderId, 2048)
        updateFlags(linkedChatId, 16384)
        updateFlags(location, 32768)
        updateFlags(slowmodeSeconds, 131072)
        updateFlags(slowmodeNextSendDate, 262144)
        updateFlags(statsDc, 4096)
        updateFlags(call, 2097152)
        updateFlags(ttlPeriod, 16777216)
        updateFlags(pendingSuggestions, 33554432)
        updateFlags(groupcallDefaultJoinAs, 67108864)
        updateFlags(themeEmoticon, 134217728)
        updateFlags(requestsPending, 268435456)
        updateFlags(recentRequesters, 268435456)
        updateFlags(defaultSendAs, 536870912)
        updateFlags(availableReactions, 1073741824)
        updateFlags(reactionsLimit, 8192)
        updateFlags(stories, 16)
        updateFlags(wallpaper, 128)
        updateFlags(boostsApplied, 256)
        updateFlags(boostsUnrestrict, 512)
        updateFlags(emojiset, 1024)

        // Following parameters might be forced to true by another field that updated the flags
        canViewParticipants = isMask(8)
        canSetUsername = isMask(64)
        canSetStickers = isMask(128)
        hiddenPrehistory = isMask(1024)
        canDeleteChannel = isMask(1)
        antispam = isMask(2)
        participantsHidden = isMask(4)
        translationsDisabled = isMask(8)
        storiesPinnedAvailable = isMask(32)
        viewForumAsMessages = isMask(64)
        restrictedSponsored = isMask(2048)
        canViewRevenue = isMask(4096)
        paidMediaAllowed = isMask(16384)
        canViewStarsRevenue = isMask(32768)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(_flags)
        writeLong(id)
        writeString(about)
        doIfMask(participantsCount, 1) { writeInt(it) }
        doIfMask(adminsCount, 2) { writeInt(it) }
        doIfMask(kickedCount, 4) { writeInt(it) }
        doIfMask(bannedCount, 4) { writeInt(it) }
        doIfMask(onlineCount, 8192) { writeInt(it) }
        writeInt(readInboxMaxId)
        writeInt(readOutboxMaxId)
        writeInt(unreadCount)
        writeTLObject(chatPhoto)
        writeTLObject(notifySettings)
        doIfMask(exportedInvite, 8388608) { writeTLObject(it) }
        writeTLVector(botInfo)
        doIfMask(migratedFromChatId, 16) { writeLong(it) }
        doIfMask(migratedFromMaxId, 16) { writeInt(it) }
        doIfMask(pinnedMsgId, 32) { writeInt(it) }
        doIfMask(stickerset, 256) { writeTLObject(it) }
        doIfMask(availableMinId, 512) { writeInt(it) }
        doIfMask(folderId, 2048) { writeInt(it) }
        doIfMask(linkedChatId, 16384) { writeLong(it) }
        doIfMask(location, 32768) { writeTLObject(it) }
        doIfMask(slowmodeSeconds, 131072) { writeInt(it) }
        doIfMask(slowmodeNextSendDate, 262144) { writeInt(it) }
        doIfMask(statsDc, 4096) { writeInt(it) }
        writeInt(pts)
        doIfMask(call, 2097152) { writeTLObject(it) }
        doIfMask(ttlPeriod, 16777216) { writeInt(it) }
        doIfMask(pendingSuggestions, 33554432) { writeTLVector(it) }
        doIfMask(groupcallDefaultJoinAs, 67108864) { writeTLObject(it) }
        doIfMask(themeEmoticon, 134217728) { writeString(it) }
        doIfMask(requestsPending, 268435456) { writeInt(it) }
        doIfMask(recentRequesters, 268435456) { writeTLVector(it) }
        doIfMask(defaultSendAs, 536870912) { writeTLObject(it) }
        doIfMask(availableReactions, 1073741824) { writeTLObject(it) }
        doIfMask(reactionsLimit, 8192) { writeInt(it) }
        doIfMask(stories, 16) { writeTLObject(it) }
        doIfMask(wallpaper, 128) { writeTLObject(it) }
        doIfMask(boostsApplied, 256) { writeInt(it) }
        doIfMask(boostsUnrestrict, 512) { writeInt(it) }
        doIfMask(emojiset, 1024) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canViewParticipants = isMask(8)
        canSetUsername = isMask(64)
        canSetStickers = isMask(128)
        hiddenPrehistory = isMask(1024)
        canSetLocation = isMask(65536)
        hasScheduled = isMask(524288)
        canViewStats = isMask(1048576)
        blocked = isMask(4194304)
        _flags = readInt()
        canDeleteChannel = isMask(1)
        antispam = isMask(2)
        participantsHidden = isMask(4)
        translationsDisabled = isMask(8)
        storiesPinnedAvailable = isMask(32)
        viewForumAsMessages = isMask(64)
        restrictedSponsored = isMask(2048)
        canViewRevenue = isMask(4096)
        paidMediaAllowed = isMask(16384)
        canViewStarsRevenue = isMask(32768)
        id = readLong()
        about = readString()
        participantsCount = readIfMask(1) { readInt() }
        adminsCount = readIfMask(2) { readInt() }
        kickedCount = readIfMask(4) { readInt() }
        bannedCount = readIfMask(4) { readInt() }
        onlineCount = readIfMask(8192) { readInt() }
        readInboxMaxId = readInt()
        readOutboxMaxId = readInt()
        unreadCount = readInt()
        chatPhoto = readTLObject<TLAbsPhoto>()
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        exportedInvite = readIfMask(8388608) { readTLObject<TLAbsExportedChatInvite>() }
        botInfo = readTLVector<TLBotInfo>()
        migratedFromChatId = readIfMask(16) { readLong() }
        migratedFromMaxId = readIfMask(16) { readInt() }
        pinnedMsgId = readIfMask(32) { readInt() }
        stickerset = readIfMask(256) { readTLObject<TLStickerSet>(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID) }
        availableMinId = readIfMask(512) { readInt() }
        folderId = readIfMask(2048) { readInt() }
        linkedChatId = readIfMask(16384) { readLong() }
        location = readIfMask(32768) { readTLObject<TLAbsChannelLocation>() }
        slowmodeSeconds = readIfMask(131072) { readInt() }
        slowmodeNextSendDate = readIfMask(262144) { readInt() }
        statsDc = readIfMask(4096) { readInt() }
        pts = readInt()
        call = readIfMask(2097152) { readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID) }
        ttlPeriod = readIfMask(16777216) { readInt() }
        pendingSuggestions = readIfMask(33554432) { readTLStringVector() }
        groupcallDefaultJoinAs = readIfMask(67108864) { readTLObject<TLAbsPeer>() }
        themeEmoticon = readIfMask(134217728) { readString() }
        requestsPending = readIfMask(268435456) { readInt() }
        recentRequesters = readIfMask(268435456) { readTLLongVector() }
        defaultSendAs = readIfMask(536870912) { readTLObject<TLAbsPeer>() }
        availableReactions = readIfMask(1073741824) { readTLObject<TLAbsChatReactions>() }
        reactionsLimit = readIfMask(8192) { readInt() }
        stories = readIfMask(16) { readTLObject<TLPeerStories>(TLPeerStories::class, TLPeerStories.CONSTRUCTOR_ID) }
        wallpaper = readIfMask(128) { readTLObject<TLAbsWallPaper>() }
        boostsApplied = readIfMask(256) { readInt() }
        boostsUnrestrict = readIfMask(512) { readInt() }
        emojiset = readIfMask(1024) { readTLObject<TLStickerSet>(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(about)
        size += getIntIfMask(participantsCount, 1) { SIZE_INT32 }
        size += getIntIfMask(adminsCount, 2) { SIZE_INT32 }
        size += getIntIfMask(kickedCount, 4) { SIZE_INT32 }
        size += getIntIfMask(bannedCount, 4) { SIZE_INT32 }
        size += getIntIfMask(onlineCount, 8192) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += chatPhoto.computeSerializedSize()
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(exportedInvite, 8388608) { it.computeSerializedSize() }
        size += botInfo.computeSerializedSize()
        size += getIntIfMask(migratedFromChatId, 16) { SIZE_INT64 }
        size += getIntIfMask(migratedFromMaxId, 16) { SIZE_INT32 }
        size += getIntIfMask(pinnedMsgId, 32) { SIZE_INT32 }
        size += getIntIfMask(stickerset, 256) { it.computeSerializedSize() }
        size += getIntIfMask(availableMinId, 512) { SIZE_INT32 }
        size += getIntIfMask(folderId, 2048) { SIZE_INT32 }
        size += getIntIfMask(linkedChatId, 16384) { SIZE_INT64 }
        size += getIntIfMask(location, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(slowmodeSeconds, 131072) { SIZE_INT32 }
        size += getIntIfMask(slowmodeNextSendDate, 262144) { SIZE_INT32 }
        size += getIntIfMask(statsDc, 4096) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(call, 2097152) { it.computeSerializedSize() }
        size += getIntIfMask(ttlPeriod, 16777216) { SIZE_INT32 }
        size += getIntIfMask(pendingSuggestions, 33554432) { it.computeSerializedSize() }
        size += getIntIfMask(groupcallDefaultJoinAs, 67108864) { it.computeSerializedSize() }
        size += getIntIfMask(themeEmoticon, 134217728) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(requestsPending, 268435456) { SIZE_INT32 }
        size += getIntIfMask(recentRequesters, 268435456) { it.computeSerializedSize() }
        size += getIntIfMask(defaultSendAs, 536870912) { it.computeSerializedSize() }
        size += getIntIfMask(availableReactions, 1073741824) { it.computeSerializedSize() }
        size += getIntIfMask(reactionsLimit, 8192) { SIZE_INT32 }
        size += getIntIfMask(stories, 16) { it.computeSerializedSize() }
        size += getIntIfMask(wallpaper, 128) { it.computeSerializedSize() }
        size += getIntIfMask(boostsApplied, 256) { SIZE_INT32 }
        size += getIntIfMask(boostsUnrestrict, 512) { SIZE_INT32 }
        size += getIntIfMask(emojiset, 1024) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelFull) return false
        if (other === this) return true

        return _flags == other._flags
                && canViewParticipants == other.canViewParticipants
                && canSetUsername == other.canSetUsername
                && canSetStickers == other.canSetStickers
                && hiddenPrehistory == other.hiddenPrehistory
                && canSetLocation == other.canSetLocation
                && hasScheduled == other.hasScheduled
                && canViewStats == other.canViewStats
                && blocked == other.blocked
                && _flags == other._flags
                && canDeleteChannel == other.canDeleteChannel
                && antispam == other.antispam
                && participantsHidden == other.participantsHidden
                && translationsDisabled == other.translationsDisabled
                && storiesPinnedAvailable == other.storiesPinnedAvailable
                && viewForumAsMessages == other.viewForumAsMessages
                && restrictedSponsored == other.restrictedSponsored
                && canViewRevenue == other.canViewRevenue
                && paidMediaAllowed == other.paidMediaAllowed
                && canViewStarsRevenue == other.canViewStarsRevenue
                && id == other.id
                && about == other.about
                && participantsCount == other.participantsCount
                && adminsCount == other.adminsCount
                && kickedCount == other.kickedCount
                && bannedCount == other.bannedCount
                && onlineCount == other.onlineCount
                && readInboxMaxId == other.readInboxMaxId
                && readOutboxMaxId == other.readOutboxMaxId
                && unreadCount == other.unreadCount
                && chatPhoto == other.chatPhoto
                && notifySettings == other.notifySettings
                && exportedInvite == other.exportedInvite
                && botInfo == other.botInfo
                && migratedFromChatId == other.migratedFromChatId
                && migratedFromMaxId == other.migratedFromMaxId
                && pinnedMsgId == other.pinnedMsgId
                && stickerset == other.stickerset
                && availableMinId == other.availableMinId
                && folderId == other.folderId
                && linkedChatId == other.linkedChatId
                && location == other.location
                && slowmodeSeconds == other.slowmodeSeconds
                && slowmodeNextSendDate == other.slowmodeNextSendDate
                && statsDc == other.statsDc
                && pts == other.pts
                && call == other.call
                && ttlPeriod == other.ttlPeriod
                && pendingSuggestions == other.pendingSuggestions
                && groupcallDefaultJoinAs == other.groupcallDefaultJoinAs
                && themeEmoticon == other.themeEmoticon
                && requestsPending == other.requestsPending
                && recentRequesters == other.recentRequesters
                && defaultSendAs == other.defaultSendAs
                && availableReactions == other.availableReactions
                && reactionsLimit == other.reactionsLimit
                && stories == other.stories
                && wallpaper == other.wallpaper
                && boostsApplied == other.boostsApplied
                && boostsUnrestrict == other.boostsUnrestrict
                && emojiset == other.emojiset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbbab348d.toInt()
    }
}
