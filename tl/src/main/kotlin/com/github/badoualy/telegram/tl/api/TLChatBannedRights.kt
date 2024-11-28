package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * chatBannedRights#9f120418
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatBannedRights() : TLObject() {
    @Transient
    var viewMessages: Boolean = false

    @Transient
    var sendMessages: Boolean = false

    @Transient
    var sendMedia: Boolean = false

    @Transient
    var sendStickers: Boolean = false

    @Transient
    var sendGifs: Boolean = false

    @Transient
    var sendGames: Boolean = false

    @Transient
    var sendInline: Boolean = false

    @Transient
    var embedLinks: Boolean = false

    @Transient
    var sendPolls: Boolean = false

    @Transient
    var changeInfo: Boolean = false

    @Transient
    var inviteUsers: Boolean = false

    @Transient
    var pinMessages: Boolean = false

    @Transient
    var manageTopics: Boolean = false

    @Transient
    var sendPhotos: Boolean = false

    @Transient
    var sendVideos: Boolean = false

    @Transient
    var sendRoundvideos: Boolean = false

    @Transient
    var sendAudios: Boolean = false

    @Transient
    var sendVoices: Boolean = false

    @Transient
    var sendDocs: Boolean = false

    @Transient
    var sendPlain: Boolean = false

    var untilDate: Int = 0

    private val _constructor: String = "chatBannedRights#9f120418"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viewMessages: Boolean,
            sendMessages: Boolean,
            sendMedia: Boolean,
            sendStickers: Boolean,
            sendGifs: Boolean,
            sendGames: Boolean,
            sendInline: Boolean,
            embedLinks: Boolean,
            sendPolls: Boolean,
            changeInfo: Boolean,
            inviteUsers: Boolean,
            pinMessages: Boolean,
            manageTopics: Boolean,
            sendPhotos: Boolean,
            sendVideos: Boolean,
            sendRoundvideos: Boolean,
            sendAudios: Boolean,
            sendVoices: Boolean,
            sendDocs: Boolean,
            sendPlain: Boolean,
            untilDate: Int
    ) : this() {
        this.viewMessages = viewMessages
        this.sendMessages = sendMessages
        this.sendMedia = sendMedia
        this.sendStickers = sendStickers
        this.sendGifs = sendGifs
        this.sendGames = sendGames
        this.sendInline = sendInline
        this.embedLinks = embedLinks
        this.sendPolls = sendPolls
        this.changeInfo = changeInfo
        this.inviteUsers = inviteUsers
        this.pinMessages = pinMessages
        this.manageTopics = manageTopics
        this.sendPhotos = sendPhotos
        this.sendVideos = sendVideos
        this.sendRoundvideos = sendRoundvideos
        this.sendAudios = sendAudios
        this.sendVoices = sendVoices
        this.sendDocs = sendDocs
        this.sendPlain = sendPlain
        this.untilDate = untilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(viewMessages, 1)
        updateFlags(sendMessages, 2)
        updateFlags(sendMedia, 4)
        updateFlags(sendStickers, 8)
        updateFlags(sendGifs, 16)
        updateFlags(sendGames, 32)
        updateFlags(sendInline, 64)
        updateFlags(embedLinks, 128)
        updateFlags(sendPolls, 256)
        updateFlags(changeInfo, 1024)
        updateFlags(inviteUsers, 32768)
        updateFlags(pinMessages, 131072)
        updateFlags(manageTopics, 262144)
        updateFlags(sendPhotos, 524288)
        updateFlags(sendVideos, 1048576)
        updateFlags(sendRoundvideos, 2097152)
        updateFlags(sendAudios, 4194304)
        updateFlags(sendVoices, 8388608)
        updateFlags(sendDocs, 16777216)
        updateFlags(sendPlain, 33554432)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(untilDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viewMessages = isMask(1)
        sendMessages = isMask(2)
        sendMedia = isMask(4)
        sendStickers = isMask(8)
        sendGifs = isMask(16)
        sendGames = isMask(32)
        sendInline = isMask(64)
        embedLinks = isMask(128)
        sendPolls = isMask(256)
        changeInfo = isMask(1024)
        inviteUsers = isMask(32768)
        pinMessages = isMask(131072)
        manageTopics = isMask(262144)
        sendPhotos = isMask(524288)
        sendVideos = isMask(1048576)
        sendRoundvideos = isMask(2097152)
        sendAudios = isMask(4194304)
        sendVoices = isMask(8388608)
        sendDocs = isMask(16777216)
        sendPlain = isMask(33554432)
        untilDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatBannedRights) return false
        if (other === this) return true

        return _flags == other._flags
                && viewMessages == other.viewMessages
                && sendMessages == other.sendMessages
                && sendMedia == other.sendMedia
                && sendStickers == other.sendStickers
                && sendGifs == other.sendGifs
                && sendGames == other.sendGames
                && sendInline == other.sendInline
                && embedLinks == other.embedLinks
                && sendPolls == other.sendPolls
                && changeInfo == other.changeInfo
                && inviteUsers == other.inviteUsers
                && pinMessages == other.pinMessages
                && manageTopics == other.manageTopics
                && sendPhotos == other.sendPhotos
                && sendVideos == other.sendVideos
                && sendRoundvideos == other.sendRoundvideos
                && sendAudios == other.sendAudios
                && sendVoices == other.sendVoices
                && sendDocs == other.sendDocs
                && sendPlain == other.sendPlain
                && untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9f120418.toInt()
    }
}
