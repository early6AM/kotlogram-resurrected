package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * chatFull#4dbdc099
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatFull() : TLAbsChatFull() {
    @Transient
    var canSetUsername: Boolean = false

    @Transient
    var hasScheduled: Boolean = false

    override var id: Long = 0L

    override var about: String = ""

    var participants: TLAbsChatParticipants = TLChatParticipantsForbidden()

    var chatPhoto: TLAbsPhoto? = null

    override var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var exportedInvite: TLChatInviteExported? = null

    var botInfo: TLObjectVector<TLBotInfo>? = TLObjectVector()

    var pinnedMsgId: Int? = null

    override var folderId: Int? = null

    var call: TLInputGroupCall? = null

    var ttlPeriod: Int? = null

    var groupcallDefaultJoinAs: TLAbsPeer? = null

    var themeEmoticon: String? = null

    private val _constructor: String = "chatFull#4dbdc099"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canSetUsername: Boolean,
            hasScheduled: Boolean,
            id: Long,
            about: String,
            participants: TLAbsChatParticipants,
            chatPhoto: TLAbsPhoto?,
            notifySettings: TLPeerNotifySettings,
            exportedInvite: TLChatInviteExported?,
            botInfo: TLObjectVector<TLBotInfo>?,
            pinnedMsgId: Int?,
            folderId: Int?,
            call: TLInputGroupCall?,
            ttlPeriod: Int?,
            groupcallDefaultJoinAs: TLAbsPeer?,
            themeEmoticon: String?
    ) : this() {
        this.canSetUsername = canSetUsername
        this.hasScheduled = hasScheduled
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
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(canSetUsername, 128)
        updateFlags(hasScheduled, 256)
        updateFlags(chatPhoto, 4)
        updateFlags(exportedInvite, 8192)
        updateFlags(botInfo, 8)
        updateFlags(pinnedMsgId, 64)
        updateFlags(folderId, 2048)
        updateFlags(call, 4096)
        updateFlags(ttlPeriod, 16384)
        updateFlags(groupcallDefaultJoinAs, 32768)
        updateFlags(themeEmoticon, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(about)
        writeTLObject(participants)
        doIfMask(chatPhoto, 4) { writeTLObject(it) }
        writeTLObject(notifySettings)
        doIfMask(exportedInvite, 8192) { writeTLObject(it) }
        doIfMask(botInfo, 8) { writeTLVector(it) }
        doIfMask(pinnedMsgId, 64) { writeInt(it) }
        doIfMask(folderId, 2048) { writeInt(it) }
        doIfMask(call, 4096) { writeTLObject(it) }
        doIfMask(ttlPeriod, 16384) { writeInt(it) }
        doIfMask(groupcallDefaultJoinAs, 32768) { writeTLObject(it) }
        doIfMask(themeEmoticon, 65536) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canSetUsername = isMask(128)
        hasScheduled = isMask(256)
        id = readLong()
        about = readString()
        participants = readTLObject<TLAbsChatParticipants>()
        chatPhoto = readIfMask(4) { readTLObject<TLAbsPhoto>() }
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        exportedInvite = readIfMask(8192) { readTLObject<TLChatInviteExported>(TLChatInviteExported::class, TLChatInviteExported.CONSTRUCTOR_ID) }
        botInfo = readIfMask(8) { readTLVector<TLBotInfo>() }
        pinnedMsgId = readIfMask(64) { readInt() }
        folderId = readIfMask(2048) { readInt() }
        call = readIfMask(4096) { readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID) }
        ttlPeriod = readIfMask(16384) { readInt() }
        groupcallDefaultJoinAs = readIfMask(32768) { readTLObject<TLAbsPeer>() }
        themeEmoticon = readIfMask(65536) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(about)
        size += participants.computeSerializedSize()
        size += getIntIfMask(chatPhoto, 4) { it.computeSerializedSize() }
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(exportedInvite, 8192) { it.computeSerializedSize() }
        size += getIntIfMask(botInfo, 8) { it.computeSerializedSize() }
        size += getIntIfMask(pinnedMsgId, 64) { SIZE_INT32 }
        size += getIntIfMask(folderId, 2048) { SIZE_INT32 }
        size += getIntIfMask(call, 4096) { it.computeSerializedSize() }
        size += getIntIfMask(ttlPeriod, 16384) { SIZE_INT32 }
        size += getIntIfMask(groupcallDefaultJoinAs, 32768) { it.computeSerializedSize() }
        size += getIntIfMask(themeEmoticon, 65536) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatFull) return false
        if (other === this) return true

        return _flags == other._flags
                && canSetUsername == other.canSetUsername
                && hasScheduled == other.hasScheduled
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4dbdc099
    }
}
