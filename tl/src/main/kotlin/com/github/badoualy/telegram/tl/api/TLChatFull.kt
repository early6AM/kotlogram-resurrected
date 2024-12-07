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
 * chatFull#2633421b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatFull() : TLAbsChatFull() {
    @Transient
    var canSetUsername: Boolean = false

    @Transient
    var hasScheduled: Boolean = false

    @Transient
    var translationsDisabled: Boolean = false

    override var id: Long = 0L

    override var about: String = ""

    var participants: TLAbsChatParticipants = TLChatParticipants()

    var chatPhoto: TLAbsPhoto? = null

    override var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var exportedInvite: TLAbsExportedChatInvite? = null

    var botInfo: TLObjectVector<TLBotInfo>? = TLObjectVector()

    var pinnedMsgId: Int? = null

    override var folderId: Int? = null

    var call: TLInputGroupCall? = null

    var ttlPeriod: Int? = null

    var groupcallDefaultJoinAs: TLAbsPeer? = null

    var themeEmoticon: String? = null

    var requestsPending: Int? = null

    var recentRequesters: TLLongVector? = null

    var availableReactions: TLAbsChatReactions? = null

    var reactionsLimit: Int? = null

    private val _constructor: String = "chatFull#2633421b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canSetUsername: Boolean,
            hasScheduled: Boolean,
            translationsDisabled: Boolean,
            id: Long,
            about: String,
            participants: TLAbsChatParticipants,
            chatPhoto: TLAbsPhoto?,
            notifySettings: TLPeerNotifySettings,
            exportedInvite: TLAbsExportedChatInvite?,
            botInfo: TLObjectVector<TLBotInfo>?,
            pinnedMsgId: Int?,
            folderId: Int?,
            call: TLInputGroupCall?,
            ttlPeriod: Int?,
            groupcallDefaultJoinAs: TLAbsPeer?,
            themeEmoticon: String?,
            requestsPending: Int?,
            recentRequesters: TLLongVector?,
            availableReactions: TLAbsChatReactions?,
            reactionsLimit: Int?
    ) : this() {
        this.canSetUsername = canSetUsername
        this.hasScheduled = hasScheduled
        this.translationsDisabled = translationsDisabled
        this.id = id
        this.about = about
        this.participants = participants
        this.chatPhoto = chatPhoto
        this.notifySettings = notifySettings
        this.exportedInvite = exportedInvite
        this.botInfo = botInfo
        this.pinnedMsgId = pinnedMsgId
        this.folderId = folderId
        this.call = call
        this.ttlPeriod = ttlPeriod
        this.groupcallDefaultJoinAs = groupcallDefaultJoinAs
        this.themeEmoticon = themeEmoticon
        this.requestsPending = requestsPending
        this.recentRequesters = recentRequesters
        this.availableReactions = availableReactions
        this.reactionsLimit = reactionsLimit
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(canSetUsername, 128)
        updateFlags(hasScheduled, 256)
        updateFlags(translationsDisabled, 524288)
        updateFlags(chatPhoto, 4)
        updateFlags(exportedInvite, 8192)
        updateFlags(botInfo, 8)
        updateFlags(pinnedMsgId, 64)
        updateFlags(folderId, 2048)
        updateFlags(call, 4096)
        updateFlags(ttlPeriod, 16384)
        updateFlags(groupcallDefaultJoinAs, 32768)
        updateFlags(themeEmoticon, 65536)
        updateFlags(requestsPending, 131072)
        updateFlags(recentRequesters, 131072)
        updateFlags(availableReactions, 262144)
        updateFlags(reactionsLimit, 1048576)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(about)
        writeTLObject(participants)
        doIfMask(1, chatPhoto, 4) { writeTLObject(it) }
        writeTLObject(notifySettings)
        doIfMask(1, exportedInvite, 8192) { writeTLObject(it) }
        doIfMask(1, botInfo, 8) { writeTLVector(it) }
        doIfMask(1, pinnedMsgId, 64) { writeInt(it) }
        doIfMask(1, folderId, 2048) { writeInt(it) }
        doIfMask(1, call, 4096) { writeTLObject(it) }
        doIfMask(1, ttlPeriod, 16384) { writeInt(it) }
        doIfMask(1, groupcallDefaultJoinAs, 32768) { writeTLObject(it) }
        doIfMask(1, themeEmoticon, 65536) { writeString(it) }
        doIfMask(1, requestsPending, 131072) { writeInt(it) }
        doIfMask(1, recentRequesters, 131072) { writeTLVector(it) }
        doIfMask(1, availableReactions, 262144) { writeTLObject(it) }
        doIfMask(1, reactionsLimit, 1048576) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canSetUsername = isMask(1, 128)
        hasScheduled = isMask(1, 256)
        translationsDisabled = isMask(1, 524288)
        id = readLong()
        about = readString()
        participants = readTLObject<TLAbsChatParticipants>()
        chatPhoto = readIfMask(1, 4) { readTLObject<TLAbsPhoto>() }
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        exportedInvite = readIfMask(1, 8192) { readTLObject<TLAbsExportedChatInvite>() }
        botInfo = readIfMask(1, 8) { readTLVector<TLBotInfo>() }
        pinnedMsgId = readIfMask(1, 64) { readInt() }
        folderId = readIfMask(1, 2048) { readInt() }
        call = readIfMask(1, 4096) { readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID) }
        ttlPeriod = readIfMask(1, 16384) { readInt() }
        groupcallDefaultJoinAs = readIfMask(1, 32768) { readTLObject<TLAbsPeer>() }
        themeEmoticon = readIfMask(1, 65536) { readString() }
        requestsPending = readIfMask(1, 131072) { readInt() }
        recentRequesters = readIfMask(1, 131072) { readTLLongVector() }
        availableReactions = readIfMask(1, 262144) { readTLObject<TLAbsChatReactions>() }
        reactionsLimit = readIfMask(1, 1048576) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(about)
        size += participants.computeSerializedSize()
        size += getIntIfMask(1, chatPhoto, 4) { it.computeSerializedSize() }
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(1, exportedInvite, 8192) { it.computeSerializedSize() }
        size += getIntIfMask(1, botInfo, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, pinnedMsgId, 64) { SIZE_INT32 }
        size += getIntIfMask(1, folderId, 2048) { SIZE_INT32 }
        size += getIntIfMask(1, call, 4096) { it.computeSerializedSize() }
        size += getIntIfMask(1, ttlPeriod, 16384) { SIZE_INT32 }
        size += getIntIfMask(1, groupcallDefaultJoinAs, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(1, themeEmoticon, 65536) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, requestsPending, 131072) { SIZE_INT32 }
        size += getIntIfMask(1, recentRequesters, 131072) { it.computeSerializedSize() }
        size += getIntIfMask(1, availableReactions, 262144) { it.computeSerializedSize() }
        size += getIntIfMask(1, reactionsLimit, 1048576) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatFull) return false
        if (other === this) return true

        return _flags == other._flags
                && canSetUsername == other.canSetUsername
                && hasScheduled == other.hasScheduled
                && translationsDisabled == other.translationsDisabled
                && id == other.id
                && about == other.about
                && participants == other.participants
                && chatPhoto == other.chatPhoto
                && notifySettings == other.notifySettings
                && exportedInvite == other.exportedInvite
                && botInfo == other.botInfo
                && pinnedMsgId == other.pinnedMsgId
                && folderId == other.folderId
                && call == other.call
                && ttlPeriod == other.ttlPeriod
                && groupcallDefaultJoinAs == other.groupcallDefaultJoinAs
                && themeEmoticon == other.themeEmoticon
                && requestsPending == other.requestsPending
                && recentRequesters == other.recentRequesters
                && availableReactions == other.availableReactions
                && reactionsLimit == other.reactionsLimit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2633421b.toInt()
    }
}
