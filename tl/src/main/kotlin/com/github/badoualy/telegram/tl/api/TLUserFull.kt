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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * userFull#cc997720
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserFull() : TLObject() {
    @Transient
    var blocked: Boolean = false

    @Transient
    var phoneCallsAvailable: Boolean = false

    @Transient
    var phoneCallsPrivate: Boolean = false

    @Transient
    var canPinMessage: Boolean = false

    @Transient
    var hasScheduled: Boolean = false

    @Transient
    var videoCallsAvailable: Boolean = false

    @Transient
    var voiceMessagesForbidden: Boolean = false

    @Transient
    var translationsDisabled: Boolean = false

    @Transient
    var storiesPinnedAvailable: Boolean = false

    @Transient
    var blockedMyStoriesFrom: Boolean = false

    @Transient
    var wallpaperOverridden: Boolean = false

    @Transient
    var contactRequirePremium: Boolean = false

    @Transient
    var readDatesPrivate: Boolean = false

    @Transient
    var sponsoredEnabled: Boolean = false

    var id: Long = 0L

    var about: String? = null

    var settings: TLPeerSettings = TLPeerSettings()

    var personalPhoto: TLAbsPhoto? = null

    var profilePhoto: TLAbsPhoto? = null

    var fallbackPhoto: TLAbsPhoto? = null

    var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var botInfo: TLBotInfo? = null

    var pinnedMsgId: Int? = null

    var commonChatsCount: Int = 0

    var folderId: Int? = null

    var ttlPeriod: Int? = null

    var themeEmoticon: String? = null

    var privateForwardName: String? = null

    var botGroupAdminRights: TLChatAdminRights? = null

    var botBroadcastAdminRights: TLChatAdminRights? = null

    var premiumGifts: TLObjectVector<TLPremiumGiftOption>? = TLObjectVector()

    var wallpaper: TLAbsWallPaper? = null

    var stories: TLPeerStories? = null

    var businessWorkHours: TLBusinessWorkHours? = null

    var businessLocation: TLBusinessLocation? = null

    var businessGreetingMessage: TLBusinessGreetingMessage? = null

    var businessAwayMessage: TLBusinessAwayMessage? = null

    var businessIntro: TLBusinessIntro? = null

    var birthday: TLBirthday? = null

    var personalChannelId: Long? = null

    var personalChannelMessage: Int? = null

    private val _constructor: String = "userFull#cc997720"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocked: Boolean,
            phoneCallsAvailable: Boolean,
            phoneCallsPrivate: Boolean,
            canPinMessage: Boolean,
            hasScheduled: Boolean,
            videoCallsAvailable: Boolean,
            voiceMessagesForbidden: Boolean,
            translationsDisabled: Boolean,
            storiesPinnedAvailable: Boolean,
            blockedMyStoriesFrom: Boolean,
            wallpaperOverridden: Boolean,
            contactRequirePremium: Boolean,
            readDatesPrivate: Boolean,
            sponsoredEnabled: Boolean,
            id: Long,
            about: String?,
            settings: TLPeerSettings,
            personalPhoto: TLAbsPhoto?,
            profilePhoto: TLAbsPhoto?,
            fallbackPhoto: TLAbsPhoto?,
            notifySettings: TLPeerNotifySettings,
            botInfo: TLBotInfo?,
            pinnedMsgId: Int?,
            commonChatsCount: Int,
            folderId: Int?,
            ttlPeriod: Int?,
            themeEmoticon: String?,
            privateForwardName: String?,
            botGroupAdminRights: TLChatAdminRights?,
            botBroadcastAdminRights: TLChatAdminRights?,
            premiumGifts: TLObjectVector<TLPremiumGiftOption>?,
            wallpaper: TLAbsWallPaper?,
            stories: TLPeerStories?,
            businessWorkHours: TLBusinessWorkHours?,
            businessLocation: TLBusinessLocation?,
            businessGreetingMessage: TLBusinessGreetingMessage?,
            businessAwayMessage: TLBusinessAwayMessage?,
            businessIntro: TLBusinessIntro?,
            birthday: TLBirthday?,
            personalChannelId: Long?,
            personalChannelMessage: Int?
    ) : this() {
        this.blocked = blocked
        this.phoneCallsAvailable = phoneCallsAvailable
        this.phoneCallsPrivate = phoneCallsPrivate
        this.canPinMessage = canPinMessage
        this.hasScheduled = hasScheduled
        this.videoCallsAvailable = videoCallsAvailable
        this.voiceMessagesForbidden = voiceMessagesForbidden
        this.translationsDisabled = translationsDisabled
        this.storiesPinnedAvailable = storiesPinnedAvailable
        this.blockedMyStoriesFrom = blockedMyStoriesFrom
        this.wallpaperOverridden = wallpaperOverridden
        this.contactRequirePremium = contactRequirePremium
        this.readDatesPrivate = readDatesPrivate
        this.sponsoredEnabled = sponsoredEnabled
        this.id = id
        this.about = about
        this.settings = settings
        this.personalPhoto = personalPhoto
        this.profilePhoto = profilePhoto
        this.fallbackPhoto = fallbackPhoto
        this.notifySettings = notifySettings
        this.botInfo = botInfo
        this.pinnedMsgId = pinnedMsgId
        this.commonChatsCount = commonChatsCount
        this.folderId = folderId
        this.ttlPeriod = ttlPeriod
        this.themeEmoticon = themeEmoticon
        this.privateForwardName = privateForwardName
        this.botGroupAdminRights = botGroupAdminRights
        this.botBroadcastAdminRights = botBroadcastAdminRights
        this.premiumGifts = premiumGifts
        this.wallpaper = wallpaper
        this.stories = stories
        this.businessWorkHours = businessWorkHours
        this.businessLocation = businessLocation
        this.businessGreetingMessage = businessGreetingMessage
        this.businessAwayMessage = businessAwayMessage
        this.businessIntro = businessIntro
        this.birthday = birthday
        this.personalChannelId = personalChannelId
        this.personalChannelMessage = personalChannelMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(blocked, 1)
        updateFlags(phoneCallsAvailable, 16)
        updateFlags(phoneCallsPrivate, 32)
        updateFlags(canPinMessage, 128)
        updateFlags(hasScheduled, 4096)
        updateFlags(videoCallsAvailable, 8192)
        updateFlags(voiceMessagesForbidden, 1048576)
        updateFlags(translationsDisabled, 8388608)
        updateFlags(storiesPinnedAvailable, 67108864)
        updateFlags(blockedMyStoriesFrom, 134217728)
        updateFlags(wallpaperOverridden, 268435456)
        updateFlags(contactRequirePremium, 536870912)
        updateFlags(readDatesPrivate, 1073741824)
        updateFlags(sponsoredEnabled, 128)
        updateFlags(about, 2)
        updateFlags(personalPhoto, 2097152)
        updateFlags(profilePhoto, 4)
        updateFlags(fallbackPhoto, 4194304)
        updateFlags(botInfo, 8)
        updateFlags(pinnedMsgId, 64)
        updateFlags(folderId, 2048)
        updateFlags(ttlPeriod, 16384)
        updateFlags(themeEmoticon, 32768)
        updateFlags(privateForwardName, 65536)
        updateFlags(botGroupAdminRights, 131072)
        updateFlags(botBroadcastAdminRights, 262144)
        updateFlags(premiumGifts, 524288)
        updateFlags(wallpaper, 16777216)
        updateFlags(stories, 33554432)
        updateFlags(businessWorkHours, 1)
        updateFlags(businessLocation, 2)
        updateFlags(businessGreetingMessage, 4)
        updateFlags(businessAwayMessage, 8)
        updateFlags(businessIntro, 16)
        updateFlags(birthday, 32)
        updateFlags(personalChannelId, 64)
        updateFlags(personalChannelMessage, 64)

        // Following parameters might be forced to true by another field that updated the flags
        blocked = isMask(1, 1)
        phoneCallsAvailable = isMask(1, 16)
        phoneCallsPrivate = isMask(1, 32)
        canPinMessage = isMask(1, 128)
        sponsoredEnabled = isMask(2, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(_flags2)
        writeLong(id)
        doIfMask(1, about, 2) { writeString(it) }
        writeTLObject(settings)
        doIfMask(1, personalPhoto, 2097152) { writeTLObject(it) }
        doIfMask(1, profilePhoto, 4) { writeTLObject(it) }
        doIfMask(1, fallbackPhoto, 4194304) { writeTLObject(it) }
        writeTLObject(notifySettings)
        doIfMask(1, botInfo, 8) { writeTLObject(it) }
        doIfMask(1, pinnedMsgId, 64) { writeInt(it) }
        writeInt(commonChatsCount)
        doIfMask(1, folderId, 2048) { writeInt(it) }
        doIfMask(1, ttlPeriod, 16384) { writeInt(it) }
        doIfMask(1, themeEmoticon, 32768) { writeString(it) }
        doIfMask(1, privateForwardName, 65536) { writeString(it) }
        doIfMask(1, botGroupAdminRights, 131072) { writeTLObject(it) }
        doIfMask(1, botBroadcastAdminRights, 262144) { writeTLObject(it) }
        doIfMask(1, premiumGifts, 524288) { writeTLVector(it) }
        doIfMask(1, wallpaper, 16777216) { writeTLObject(it) }
        doIfMask(1, stories, 33554432) { writeTLObject(it) }
        doIfMask(2, businessWorkHours, 1) { writeTLObject(it) }
        doIfMask(2, businessLocation, 2) { writeTLObject(it) }
        doIfMask(2, businessGreetingMessage, 4) { writeTLObject(it) }
        doIfMask(2, businessAwayMessage, 8) { writeTLObject(it) }
        doIfMask(2, businessIntro, 16) { writeTLObject(it) }
        doIfMask(2, birthday, 32) { writeTLObject(it) }
        doIfMask(2, personalChannelId, 64) { writeLong(it) }
        doIfMask(2, personalChannelMessage, 64) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blocked = isMask(1, 1)
        phoneCallsAvailable = isMask(1, 16)
        phoneCallsPrivate = isMask(1, 32)
        canPinMessage = isMask(1, 128)
        hasScheduled = isMask(1, 4096)
        videoCallsAvailable = isMask(1, 8192)
        voiceMessagesForbidden = isMask(1, 1048576)
        translationsDisabled = isMask(1, 8388608)
        storiesPinnedAvailable = isMask(1, 67108864)
        blockedMyStoriesFrom = isMask(1, 134217728)
        wallpaperOverridden = isMask(1, 268435456)
        contactRequirePremium = isMask(1, 536870912)
        readDatesPrivate = isMask(1, 1073741824)
        _flags2 = readInt()
        sponsoredEnabled = isMask(2, 128)
        id = readLong()
        about = readIfMask(1, 2) { readString() }
        settings = readTLObject<TLPeerSettings>(TLPeerSettings::class, TLPeerSettings.CONSTRUCTOR_ID)
        personalPhoto = readIfMask(1, 2097152) { readTLObject<TLAbsPhoto>() }
        profilePhoto = readIfMask(1, 4) { readTLObject<TLAbsPhoto>() }
        fallbackPhoto = readIfMask(1, 4194304) { readTLObject<TLAbsPhoto>() }
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        botInfo = readIfMask(1, 8) { readTLObject<TLBotInfo>(TLBotInfo::class, TLBotInfo.CONSTRUCTOR_ID) }
        pinnedMsgId = readIfMask(1, 64) { readInt() }
        commonChatsCount = readInt()
        folderId = readIfMask(1, 2048) { readInt() }
        ttlPeriod = readIfMask(1, 16384) { readInt() }
        themeEmoticon = readIfMask(1, 32768) { readString() }
        privateForwardName = readIfMask(1, 65536) { readString() }
        botGroupAdminRights = readIfMask(1, 131072) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        botBroadcastAdminRights = readIfMask(1, 262144) { readTLObject<TLChatAdminRights>(TLChatAdminRights::class, TLChatAdminRights.CONSTRUCTOR_ID) }
        premiumGifts = readIfMask(1, 524288) { readTLVector<TLPremiumGiftOption>() }
        wallpaper = readIfMask(1, 16777216) { readTLObject<TLAbsWallPaper>() }
        stories = readIfMask(1, 33554432) { readTLObject<TLPeerStories>(TLPeerStories::class, TLPeerStories.CONSTRUCTOR_ID) }
        businessWorkHours = readIfMask(2, 1) { readTLObject<TLBusinessWorkHours>(TLBusinessWorkHours::class, TLBusinessWorkHours.CONSTRUCTOR_ID) }
        businessLocation = readIfMask(2, 2) { readTLObject<TLBusinessLocation>(TLBusinessLocation::class, TLBusinessLocation.CONSTRUCTOR_ID) }
        businessGreetingMessage = readIfMask(2, 4) { readTLObject<TLBusinessGreetingMessage>(TLBusinessGreetingMessage::class, TLBusinessGreetingMessage.CONSTRUCTOR_ID) }
        businessAwayMessage = readIfMask(2, 8) { readTLObject<TLBusinessAwayMessage>(TLBusinessAwayMessage::class, TLBusinessAwayMessage.CONSTRUCTOR_ID) }
        businessIntro = readIfMask(2, 16) { readTLObject<TLBusinessIntro>(TLBusinessIntro::class, TLBusinessIntro.CONSTRUCTOR_ID) }
        birthday = readIfMask(2, 32) { readTLObject<TLBirthday>(TLBirthday::class, TLBirthday.CONSTRUCTOR_ID) }
        personalChannelId = readIfMask(2, 64) { readLong() }
        personalChannelMessage = readIfMask(2, 64) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(1, about, 2) { computeTLStringSerializedSize(it) }
        size += settings.computeSerializedSize()
        size += getIntIfMask(1, personalPhoto, 2097152) { it.computeSerializedSize() }
        size += getIntIfMask(1, profilePhoto, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, fallbackPhoto, 4194304) { it.computeSerializedSize() }
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(1, botInfo, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, pinnedMsgId, 64) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(1, folderId, 2048) { SIZE_INT32 }
        size += getIntIfMask(1, ttlPeriod, 16384) { SIZE_INT32 }
        size += getIntIfMask(1, themeEmoticon, 32768) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, privateForwardName, 65536) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, botGroupAdminRights, 131072) { it.computeSerializedSize() }
        size += getIntIfMask(1, botBroadcastAdminRights, 262144) { it.computeSerializedSize() }
        size += getIntIfMask(1, premiumGifts, 524288) { it.computeSerializedSize() }
        size += getIntIfMask(1, wallpaper, 16777216) { it.computeSerializedSize() }
        size += getIntIfMask(1, stories, 33554432) { it.computeSerializedSize() }
        size += getIntIfMask(2, businessWorkHours, 1) { it.computeSerializedSize() }
        size += getIntIfMask(2, businessLocation, 2) { it.computeSerializedSize() }
        size += getIntIfMask(2, businessGreetingMessage, 4) { it.computeSerializedSize() }
        size += getIntIfMask(2, businessAwayMessage, 8) { it.computeSerializedSize() }
        size += getIntIfMask(2, businessIntro, 16) { it.computeSerializedSize() }
        size += getIntIfMask(2, birthday, 32) { it.computeSerializedSize() }
        size += getIntIfMask(2, personalChannelId, 64) { SIZE_INT64 }
        size += getIntIfMask(2, personalChannelMessage, 64) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserFull) return false
        if (other === this) return true

        return _flags == other._flags
                && blocked == other.blocked
                && phoneCallsAvailable == other.phoneCallsAvailable
                && phoneCallsPrivate == other.phoneCallsPrivate
                && canPinMessage == other.canPinMessage
                && hasScheduled == other.hasScheduled
                && videoCallsAvailable == other.videoCallsAvailable
                && voiceMessagesForbidden == other.voiceMessagesForbidden
                && translationsDisabled == other.translationsDisabled
                && storiesPinnedAvailable == other.storiesPinnedAvailable
                && blockedMyStoriesFrom == other.blockedMyStoriesFrom
                && wallpaperOverridden == other.wallpaperOverridden
                && contactRequirePremium == other.contactRequirePremium
                && readDatesPrivate == other.readDatesPrivate
                && _flags2 == other._flags2
                && sponsoredEnabled == other.sponsoredEnabled
                && id == other.id
                && about == other.about
                && settings == other.settings
                && personalPhoto == other.personalPhoto
                && profilePhoto == other.profilePhoto
                && fallbackPhoto == other.fallbackPhoto
                && notifySettings == other.notifySettings
                && botInfo == other.botInfo
                && pinnedMsgId == other.pinnedMsgId
                && commonChatsCount == other.commonChatsCount
                && folderId == other.folderId
                && ttlPeriod == other.ttlPeriod
                && themeEmoticon == other.themeEmoticon
                && privateForwardName == other.privateForwardName
                && botGroupAdminRights == other.botGroupAdminRights
                && botBroadcastAdminRights == other.botBroadcastAdminRights
                && premiumGifts == other.premiumGifts
                && wallpaper == other.wallpaper
                && stories == other.stories
                && businessWorkHours == other.businessWorkHours
                && businessLocation == other.businessLocation
                && businessGreetingMessage == other.businessGreetingMessage
                && businessAwayMessage == other.businessAwayMessage
                && businessIntro == other.businessIntro
                && birthday == other.birthday
                && personalChannelId == other.personalChannelId
                && personalChannelMessage == other.personalChannelMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcc997720.toInt()
    }
}
