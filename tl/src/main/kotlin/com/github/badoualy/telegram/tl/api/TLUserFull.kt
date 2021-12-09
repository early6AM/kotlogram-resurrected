package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * userFull#d697ff05
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

    var user: TLAbsUser = TLUserEmpty()

    var about: String? = null

    var settings: TLPeerSettings = TLPeerSettings()

    var profilePhoto: TLAbsPhoto? = null

    var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var botInfo: TLBotInfo? = null

    var pinnedMsgId: Int? = null

    var commonChatsCount: Int = 0

    var folderId: Int? = null

    var ttlPeriod: Int? = null

    var themeEmoticon: String? = null

    private val _constructor: String = "userFull#d697ff05"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocked: Boolean,
            phoneCallsAvailable: Boolean,
            phoneCallsPrivate: Boolean,
            canPinMessage: Boolean,
            hasScheduled: Boolean,
            videoCallsAvailable: Boolean,
            user: TLAbsUser,
            about: String?,
            settings: TLPeerSettings,
            profilePhoto: TLAbsPhoto?,
            notifySettings: TLPeerNotifySettings,
            botInfo: TLBotInfo?,
            pinnedMsgId: Int?,
            commonChatsCount: Int,
            folderId: Int?,
            ttlPeriod: Int?,
            themeEmoticon: String?
    ) : this() {
        this.blocked = blocked
        this.phoneCallsAvailable = phoneCallsAvailable
        this.phoneCallsPrivate = phoneCallsPrivate
        this.canPinMessage = canPinMessage
        this.hasScheduled = hasScheduled
        this.videoCallsAvailable = videoCallsAvailable
        this.user = user
        this.about = about
        this.settings = settings
        this.profilePhoto = profilePhoto
        this.notifySettings = notifySettings
        this.botInfo = botInfo
        this.pinnedMsgId = pinnedMsgId
        this.commonChatsCount = commonChatsCount
        this.folderId = folderId
        this.ttlPeriod = ttlPeriod
        this.themeEmoticon = themeEmoticon
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(blocked, 1)
        updateFlags(phoneCallsAvailable, 16)
        updateFlags(phoneCallsPrivate, 32)
        updateFlags(canPinMessage, 128)
        updateFlags(hasScheduled, 4096)
        updateFlags(videoCallsAvailable, 8192)
        updateFlags(about, 2)
        updateFlags(profilePhoto, 4)
        updateFlags(botInfo, 8)
        updateFlags(pinnedMsgId, 64)
        updateFlags(folderId, 2048)
        updateFlags(ttlPeriod, 16384)
        updateFlags(themeEmoticon, 32768)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(user)
        doIfMask(about, 2) { writeString(it) }
        writeTLObject(settings)
        doIfMask(profilePhoto, 4) { writeTLObject(it) }
        writeTLObject(notifySettings)
        doIfMask(botInfo, 8) { writeTLObject(it) }
        doIfMask(pinnedMsgId, 64) { writeInt(it) }
        writeInt(commonChatsCount)
        doIfMask(folderId, 2048) { writeInt(it) }
        doIfMask(ttlPeriod, 16384) { writeInt(it) }
        doIfMask(themeEmoticon, 32768) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blocked = isMask(1)
        phoneCallsAvailable = isMask(16)
        phoneCallsPrivate = isMask(32)
        canPinMessage = isMask(128)
        hasScheduled = isMask(4096)
        videoCallsAvailable = isMask(8192)
        user = readTLObject<TLAbsUser>()
        about = readIfMask(2) { readString() }
        settings = readTLObject<TLPeerSettings>(TLPeerSettings::class, TLPeerSettings.CONSTRUCTOR_ID)
        profilePhoto = readIfMask(4) { readTLObject<TLAbsPhoto>() }
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        botInfo = readIfMask(8) { readTLObject<TLBotInfo>(TLBotInfo::class, TLBotInfo.CONSTRUCTOR_ID) }
        pinnedMsgId = readIfMask(64) { readInt() }
        commonChatsCount = readInt()
        folderId = readIfMask(2048) { readInt() }
        ttlPeriod = readIfMask(16384) { readInt() }
        themeEmoticon = readIfMask(32768) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += user.computeSerializedSize()
        size += getIntIfMask(about, 2) { computeTLStringSerializedSize(it) }
        size += settings.computeSerializedSize()
        size += getIntIfMask(profilePhoto, 4) { it.computeSerializedSize() }
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(botInfo, 8) { it.computeSerializedSize() }
        size += getIntIfMask(pinnedMsgId, 64) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(folderId, 2048) { SIZE_INT32 }
        size += getIntIfMask(ttlPeriod, 16384) { SIZE_INT32 }
        size += getIntIfMask(themeEmoticon, 32768) { computeTLStringSerializedSize(it) }
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
                && user == other.user
                && about == other.about
                && settings == other.settings
                && profilePhoto == other.profilePhoto
                && notifySettings == other.notifySettings
                && botInfo == other.botInfo
                && pinnedMsgId == other.pinnedMsgId
                && commonChatsCount == other.commonChatsCount
                && folderId == other.folderId
                && ttlPeriod == other.ttlPeriod
                && themeEmoticon == other.themeEmoticon
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd697ff05.toInt()
    }
}
