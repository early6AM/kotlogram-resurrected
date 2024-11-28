package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * sponsoredMessage#ed5383f7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSponsoredMessage() : TLObject() {
    @Transient
    var recommended: Boolean = false

    @Transient
    var showPeerPhoto: Boolean = false

    var randomId: TLBytes = TLBytes.EMPTY

    var fromId: TLAbsPeer? = null

    var chatInvite: TLAbsChatInvite? = null

    var chatInviteHash: String? = null

    var channelPost: Int? = null

    var startParam: String? = null

    var webpage: TLSponsoredWebPage? = null

    var app: TLAbsBotApp? = null

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var buttonText: String? = null

    var sponsorInfo: String? = null

    var additionalInfo: String? = null

    private val _constructor: String = "sponsoredMessage#ed5383f7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            recommended: Boolean,
            showPeerPhoto: Boolean,
            randomId: TLBytes,
            fromId: TLAbsPeer?,
            chatInvite: TLAbsChatInvite?,
            chatInviteHash: String?,
            channelPost: Int?,
            startParam: String?,
            webpage: TLSponsoredWebPage?,
            app: TLAbsBotApp?,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            buttonText: String?,
            sponsorInfo: String?,
            additionalInfo: String?
    ) : this() {
        this.recommended = recommended
        this.showPeerPhoto = showPeerPhoto
        this.randomId = randomId
        this.fromId = fromId
        this.chatInvite = chatInvite
        this.chatInviteHash = chatInviteHash
        this.channelPost = channelPost
        this.startParam = startParam
        this.webpage = webpage
        this.app = app
        this.message = message
        this.entities = entities
        this.buttonText = buttonText
        this.sponsorInfo = sponsorInfo
        this.additionalInfo = additionalInfo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(recommended, 32)
        updateFlags(showPeerPhoto, 64)
        updateFlags(fromId, 8)
        updateFlags(chatInvite, 16)
        updateFlags(chatInviteHash, 16)
        updateFlags(channelPost, 4)
        updateFlags(startParam, 1)
        updateFlags(webpage, 512)
        updateFlags(app, 1024)
        updateFlags(entities, 2)
        updateFlags(buttonText, 2048)
        updateFlags(sponsorInfo, 128)
        updateFlags(additionalInfo, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLBytes(randomId)
        doIfMask(fromId, 8) { writeTLObject(it) }
        doIfMask(chatInvite, 16) { writeTLObject(it) }
        doIfMask(chatInviteHash, 16) { writeString(it) }
        doIfMask(channelPost, 4) { writeInt(it) }
        doIfMask(startParam, 1) { writeString(it) }
        doIfMask(webpage, 512) { writeTLObject(it) }
        doIfMask(app, 1024) { writeTLObject(it) }
        writeString(message)
        doIfMask(entities, 2) { writeTLVector(it) }
        doIfMask(buttonText, 2048) { writeString(it) }
        doIfMask(sponsorInfo, 128) { writeString(it) }
        doIfMask(additionalInfo, 256) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        recommended = isMask(32)
        showPeerPhoto = isMask(64)
        randomId = readTLBytes()
        fromId = readIfMask(8) { readTLObject<TLAbsPeer>() }
        chatInvite = readIfMask(16) { readTLObject<TLAbsChatInvite>() }
        chatInviteHash = readIfMask(16) { readString() }
        channelPost = readIfMask(4) { readInt() }
        startParam = readIfMask(1) { readString() }
        webpage = readIfMask(512) { readTLObject<TLSponsoredWebPage>(TLSponsoredWebPage::class, TLSponsoredWebPage.CONSTRUCTOR_ID) }
        app = readIfMask(1024) { readTLObject<TLAbsBotApp>() }
        message = readString()
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
        buttonText = readIfMask(2048) { readString() }
        sponsorInfo = readIfMask(128) { readString() }
        additionalInfo = readIfMask(256) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(randomId)
        size += getIntIfMask(fromId, 8) { it.computeSerializedSize() }
        size += getIntIfMask(chatInvite, 16) { it.computeSerializedSize() }
        size += getIntIfMask(chatInviteHash, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(channelPost, 4) { SIZE_INT32 }
        size += getIntIfMask(startParam, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(webpage, 512) { it.computeSerializedSize() }
        size += getIntIfMask(app, 1024) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        size += getIntIfMask(buttonText, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(sponsorInfo, 128) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(additionalInfo, 256) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSponsoredMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && recommended == other.recommended
                && showPeerPhoto == other.showPeerPhoto
                && randomId == other.randomId
                && fromId == other.fromId
                && chatInvite == other.chatInvite
                && chatInviteHash == other.chatInviteHash
                && channelPost == other.channelPost
                && startParam == other.startParam
                && webpage == other.webpage
                && app == other.app
                && message == other.message
                && entities == other.entities
                && buttonText == other.buttonText
                && sponsorInfo == other.sponsorInfo
                && additionalInfo == other.additionalInfo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xed5383f7.toInt()
    }
}
