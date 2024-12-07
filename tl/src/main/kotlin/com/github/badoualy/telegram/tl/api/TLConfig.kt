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
import kotlin.jvm.Transient

/**
 * config#cc1a241e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLConfig() : TLObject() {
    @Transient
    var defaultP2pContacts: Boolean = false

    @Transient
    var preloadFeaturedStickers: Boolean = false

    @Transient
    var revokePmInbox: Boolean = false

    @Transient
    var blockedMode: Boolean = false

    @Transient
    var forceTryIpv6: Boolean = false

    var date: Int = 0

    var expires: Int = 0

    var testMode: Boolean = false

    var thisDc: Int = 0

    var dcOptions: TLObjectVector<TLDcOption> = TLObjectVector()

    var dcTxtDomainName: String = ""

    var chatSizeMax: Int = 0

    var megagroupSizeMax: Int = 0

    var forwardedCountMax: Int = 0

    var onlineUpdatePeriodMs: Int = 0

    var offlineBlurTimeoutMs: Int = 0

    var offlineIdleTimeoutMs: Int = 0

    var onlineCloudTimeoutMs: Int = 0

    var notifyCloudDelayMs: Int = 0

    var notifyDefaultDelayMs: Int = 0

    var pushChatPeriodMs: Int = 0

    var pushChatLimit: Int = 0

    var editTimeLimit: Int = 0

    var revokeTimeLimit: Int = 0

    var revokePmTimeLimit: Int = 0

    var ratingEDecay: Int = 0

    var stickersRecentLimit: Int = 0

    var channelsReadMediaPeriod: Int = 0

    var tmpSessions: Int? = null

    var callReceiveTimeoutMs: Int = 0

    var callRingTimeoutMs: Int = 0

    var callConnectTimeoutMs: Int = 0

    var callPacketTimeoutMs: Int = 0

    var meUrlPrefix: String = ""

    var autoupdateUrlPrefix: String? = null

    var gifSearchUsername: String? = null

    var venueSearchUsername: String? = null

    var imgSearchUsername: String? = null

    var staticMapsProvider: String? = null

    var captionLengthMax: Int = 0

    var messageLengthMax: Int = 0

    var webfileDcId: Int = 0

    var suggestedLangCode: String? = null

    var langPackVersion: Int? = null

    var baseLangPackVersion: Int? = null

    var reactionsDefault: TLAbsReaction? = null

    var autologinToken: String? = null

    private val _constructor: String = "config#cc1a241e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            defaultP2pContacts: Boolean,
            preloadFeaturedStickers: Boolean,
            revokePmInbox: Boolean,
            blockedMode: Boolean,
            forceTryIpv6: Boolean,
            date: Int,
            expires: Int,
            testMode: Boolean,
            thisDc: Int,
            dcOptions: TLObjectVector<TLDcOption>,
            dcTxtDomainName: String,
            chatSizeMax: Int,
            megagroupSizeMax: Int,
            forwardedCountMax: Int,
            onlineUpdatePeriodMs: Int,
            offlineBlurTimeoutMs: Int,
            offlineIdleTimeoutMs: Int,
            onlineCloudTimeoutMs: Int,
            notifyCloudDelayMs: Int,
            notifyDefaultDelayMs: Int,
            pushChatPeriodMs: Int,
            pushChatLimit: Int,
            editTimeLimit: Int,
            revokeTimeLimit: Int,
            revokePmTimeLimit: Int,
            ratingEDecay: Int,
            stickersRecentLimit: Int,
            channelsReadMediaPeriod: Int,
            tmpSessions: Int?,
            callReceiveTimeoutMs: Int,
            callRingTimeoutMs: Int,
            callConnectTimeoutMs: Int,
            callPacketTimeoutMs: Int,
            meUrlPrefix: String,
            autoupdateUrlPrefix: String?,
            gifSearchUsername: String?,
            venueSearchUsername: String?,
            imgSearchUsername: String?,
            staticMapsProvider: String?,
            captionLengthMax: Int,
            messageLengthMax: Int,
            webfileDcId: Int,
            suggestedLangCode: String?,
            langPackVersion: Int?,
            baseLangPackVersion: Int?,
            reactionsDefault: TLAbsReaction?,
            autologinToken: String?
    ) : this() {
        this.defaultP2pContacts = defaultP2pContacts
        this.preloadFeaturedStickers = preloadFeaturedStickers
        this.revokePmInbox = revokePmInbox
        this.blockedMode = blockedMode
        this.forceTryIpv6 = forceTryIpv6
        this.date = date
        this.expires = expires
        this.testMode = testMode
        this.thisDc = thisDc
        this.dcOptions = dcOptions
        this.dcTxtDomainName = dcTxtDomainName
        this.chatSizeMax = chatSizeMax
        this.megagroupSizeMax = megagroupSizeMax
        this.forwardedCountMax = forwardedCountMax
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs
        this.notifyCloudDelayMs = notifyCloudDelayMs
        this.notifyDefaultDelayMs = notifyDefaultDelayMs
        this.pushChatPeriodMs = pushChatPeriodMs
        this.pushChatLimit = pushChatLimit
        this.editTimeLimit = editTimeLimit
        this.revokeTimeLimit = revokeTimeLimit
        this.revokePmTimeLimit = revokePmTimeLimit
        this.ratingEDecay = ratingEDecay
        this.stickersRecentLimit = stickersRecentLimit
        this.channelsReadMediaPeriod = channelsReadMediaPeriod
        this.tmpSessions = tmpSessions
        this.callReceiveTimeoutMs = callReceiveTimeoutMs
        this.callRingTimeoutMs = callRingTimeoutMs
        this.callConnectTimeoutMs = callConnectTimeoutMs
        this.callPacketTimeoutMs = callPacketTimeoutMs
        this.meUrlPrefix = meUrlPrefix
        this.autoupdateUrlPrefix = autoupdateUrlPrefix
        this.gifSearchUsername = gifSearchUsername
        this.venueSearchUsername = venueSearchUsername
        this.imgSearchUsername = imgSearchUsername
        this.staticMapsProvider = staticMapsProvider
        this.captionLengthMax = captionLengthMax
        this.messageLengthMax = messageLengthMax
        this.webfileDcId = webfileDcId
        this.suggestedLangCode = suggestedLangCode
        this.langPackVersion = langPackVersion
        this.baseLangPackVersion = baseLangPackVersion
        this.reactionsDefault = reactionsDefault
        this.autologinToken = autologinToken
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(defaultP2pContacts, 8)
        updateFlags(preloadFeaturedStickers, 16)
        updateFlags(revokePmInbox, 64)
        updateFlags(blockedMode, 256)
        updateFlags(forceTryIpv6, 16384)
        updateFlags(tmpSessions, 1)
        updateFlags(autoupdateUrlPrefix, 128)
        updateFlags(gifSearchUsername, 512)
        updateFlags(venueSearchUsername, 1024)
        updateFlags(imgSearchUsername, 2048)
        updateFlags(staticMapsProvider, 4096)
        updateFlags(suggestedLangCode, 4)
        updateFlags(langPackVersion, 4)
        updateFlags(baseLangPackVersion, 4)
        updateFlags(reactionsDefault, 32768)
        updateFlags(autologinToken, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(date)
        writeInt(expires)
        writeBoolean(testMode)
        writeInt(thisDc)
        writeTLVector(dcOptions)
        writeString(dcTxtDomainName)
        writeInt(chatSizeMax)
        writeInt(megagroupSizeMax)
        writeInt(forwardedCountMax)
        writeInt(onlineUpdatePeriodMs)
        writeInt(offlineBlurTimeoutMs)
        writeInt(offlineIdleTimeoutMs)
        writeInt(onlineCloudTimeoutMs)
        writeInt(notifyCloudDelayMs)
        writeInt(notifyDefaultDelayMs)
        writeInt(pushChatPeriodMs)
        writeInt(pushChatLimit)
        writeInt(editTimeLimit)
        writeInt(revokeTimeLimit)
        writeInt(revokePmTimeLimit)
        writeInt(ratingEDecay)
        writeInt(stickersRecentLimit)
        writeInt(channelsReadMediaPeriod)
        doIfMask(1, tmpSessions, 1) { writeInt(it) }
        writeInt(callReceiveTimeoutMs)
        writeInt(callRingTimeoutMs)
        writeInt(callConnectTimeoutMs)
        writeInt(callPacketTimeoutMs)
        writeString(meUrlPrefix)
        doIfMask(1, autoupdateUrlPrefix, 128) { writeString(it) }
        doIfMask(1, gifSearchUsername, 512) { writeString(it) }
        doIfMask(1, venueSearchUsername, 1024) { writeString(it) }
        doIfMask(1, imgSearchUsername, 2048) { writeString(it) }
        doIfMask(1, staticMapsProvider, 4096) { writeString(it) }
        writeInt(captionLengthMax)
        writeInt(messageLengthMax)
        writeInt(webfileDcId)
        doIfMask(1, suggestedLangCode, 4) { writeString(it) }
        doIfMask(1, langPackVersion, 4) { writeInt(it) }
        doIfMask(1, baseLangPackVersion, 4) { writeInt(it) }
        doIfMask(1, reactionsDefault, 32768) { writeTLObject(it) }
        doIfMask(1, autologinToken, 65536) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        defaultP2pContacts = isMask(1, 8)
        preloadFeaturedStickers = isMask(1, 16)
        revokePmInbox = isMask(1, 64)
        blockedMode = isMask(1, 256)
        forceTryIpv6 = isMask(1, 16384)
        date = readInt()
        expires = readInt()
        testMode = readBoolean()
        thisDc = readInt()
        dcOptions = readTLVector<TLDcOption>()
        dcTxtDomainName = readString()
        chatSizeMax = readInt()
        megagroupSizeMax = readInt()
        forwardedCountMax = readInt()
        onlineUpdatePeriodMs = readInt()
        offlineBlurTimeoutMs = readInt()
        offlineIdleTimeoutMs = readInt()
        onlineCloudTimeoutMs = readInt()
        notifyCloudDelayMs = readInt()
        notifyDefaultDelayMs = readInt()
        pushChatPeriodMs = readInt()
        pushChatLimit = readInt()
        editTimeLimit = readInt()
        revokeTimeLimit = readInt()
        revokePmTimeLimit = readInt()
        ratingEDecay = readInt()
        stickersRecentLimit = readInt()
        channelsReadMediaPeriod = readInt()
        tmpSessions = readIfMask(1, 1) { readInt() }
        callReceiveTimeoutMs = readInt()
        callRingTimeoutMs = readInt()
        callConnectTimeoutMs = readInt()
        callPacketTimeoutMs = readInt()
        meUrlPrefix = readString()
        autoupdateUrlPrefix = readIfMask(1, 128) { readString() }
        gifSearchUsername = readIfMask(1, 512) { readString() }
        venueSearchUsername = readIfMask(1, 1024) { readString() }
        imgSearchUsername = readIfMask(1, 2048) { readString() }
        staticMapsProvider = readIfMask(1, 4096) { readString() }
        captionLengthMax = readInt()
        messageLengthMax = readInt()
        webfileDcId = readInt()
        suggestedLangCode = readIfMask(1, 4) { readString() }
        langPackVersion = readIfMask(1, 4) { readInt() }
        baseLangPackVersion = readIfMask(1, 4) { readInt() }
        reactionsDefault = readIfMask(1, 32768) { readTLObject<TLAbsReaction>() }
        autologinToken = readIfMask(1, 65536) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += SIZE_INT32
        size += dcOptions.computeSerializedSize()
        size += computeTLStringSerializedSize(dcTxtDomainName)
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, tmpSessions, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(meUrlPrefix)
        size += getIntIfMask(1, autoupdateUrlPrefix, 128) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, gifSearchUsername, 512) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, venueSearchUsername, 1024) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, imgSearchUsername, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, staticMapsProvider, 4096) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, suggestedLangCode, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, langPackVersion, 4) { SIZE_INT32 }
        size += getIntIfMask(1, baseLangPackVersion, 4) { SIZE_INT32 }
        size += getIntIfMask(1, reactionsDefault, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(1, autologinToken, 65536) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLConfig) return false
        if (other === this) return true

        return _flags == other._flags
                && defaultP2pContacts == other.defaultP2pContacts
                && preloadFeaturedStickers == other.preloadFeaturedStickers
                && revokePmInbox == other.revokePmInbox
                && blockedMode == other.blockedMode
                && forceTryIpv6 == other.forceTryIpv6
                && date == other.date
                && expires == other.expires
                && testMode == other.testMode
                && thisDc == other.thisDc
                && dcOptions == other.dcOptions
                && dcTxtDomainName == other.dcTxtDomainName
                && chatSizeMax == other.chatSizeMax
                && megagroupSizeMax == other.megagroupSizeMax
                && forwardedCountMax == other.forwardedCountMax
                && onlineUpdatePeriodMs == other.onlineUpdatePeriodMs
                && offlineBlurTimeoutMs == other.offlineBlurTimeoutMs
                && offlineIdleTimeoutMs == other.offlineIdleTimeoutMs
                && onlineCloudTimeoutMs == other.onlineCloudTimeoutMs
                && notifyCloudDelayMs == other.notifyCloudDelayMs
                && notifyDefaultDelayMs == other.notifyDefaultDelayMs
                && pushChatPeriodMs == other.pushChatPeriodMs
                && pushChatLimit == other.pushChatLimit
                && editTimeLimit == other.editTimeLimit
                && revokeTimeLimit == other.revokeTimeLimit
                && revokePmTimeLimit == other.revokePmTimeLimit
                && ratingEDecay == other.ratingEDecay
                && stickersRecentLimit == other.stickersRecentLimit
                && channelsReadMediaPeriod == other.channelsReadMediaPeriod
                && tmpSessions == other.tmpSessions
                && callReceiveTimeoutMs == other.callReceiveTimeoutMs
                && callRingTimeoutMs == other.callRingTimeoutMs
                && callConnectTimeoutMs == other.callConnectTimeoutMs
                && callPacketTimeoutMs == other.callPacketTimeoutMs
                && meUrlPrefix == other.meUrlPrefix
                && autoupdateUrlPrefix == other.autoupdateUrlPrefix
                && gifSearchUsername == other.gifSearchUsername
                && venueSearchUsername == other.venueSearchUsername
                && imgSearchUsername == other.imgSearchUsername
                && staticMapsProvider == other.staticMapsProvider
                && captionLengthMax == other.captionLengthMax
                && messageLengthMax == other.messageLengthMax
                && webfileDcId == other.webfileDcId
                && suggestedLangCode == other.suggestedLangCode
                && langPackVersion == other.langPackVersion
                && baseLangPackVersion == other.baseLangPackVersion
                && reactionsDefault == other.reactionsDefault
                && autologinToken == other.autologinToken
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcc1a241e.toInt()
    }
}
