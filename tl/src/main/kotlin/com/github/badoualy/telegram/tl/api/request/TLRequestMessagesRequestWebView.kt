package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.TLWebViewResultUrl
import com.github.badoualy.telegram.tl.core.TLMethod
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
class TLRequestMessagesRequestWebView() : TLMethod<TLWebViewResultUrl>() {
    @Transient
    var fromBotMenu: Boolean = false

    @Transient
    var silent: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var url: String? = null

    var startParam: String? = null

    var themeParams: TLDataJSON? = null

    var platform: String = ""

    var replyTo: TLAbsInputReplyTo? = null

    var sendAs: TLAbsInputPeer? = null

    private val _constructor: String = "messages.requestWebView#269dc2c1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromBotMenu: Boolean,
            silent: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ) : this() {
        this.fromBotMenu = fromBotMenu
        this.silent = silent
        this.peer = peer
        this.bot = bot
        this.url = url
        this.startParam = startParam
        this.themeParams = themeParams
        this.platform = platform
        this.replyTo = replyTo
        this.sendAs = sendAs
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLWebViewResultUrl = tlDeserializer.readTLObject(TLWebViewResultUrl::class, TLWebViewResultUrl.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromBotMenu, 16)
        updateFlags(silent, 32)
        updateFlags(url, 2)
        updateFlags(startParam, 8)
        updateFlags(themeParams, 4)
        updateFlags(replyTo, 1)
        updateFlags(sendAs, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(bot)
        doIfMask(url, 2) { writeString(it) }
        doIfMask(startParam, 8) { writeString(it) }
        doIfMask(themeParams, 4) { writeTLObject(it) }
        writeString(platform)
        doIfMask(replyTo, 1) { writeTLObject(it) }
        doIfMask(sendAs, 8192) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fromBotMenu = isMask(16)
        silent = isMask(32)
        peer = readTLObject<TLAbsInputPeer>()
        bot = readTLObject<TLAbsInputUser>()
        url = readIfMask(2) { readString() }
        startParam = readIfMask(8) { readString() }
        themeParams = readIfMask(4) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        platform = readString()
        replyTo = readIfMask(1) { readTLObject<TLAbsInputReplyTo>() }
        sendAs = readIfMask(8192) { readTLObject<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += bot.computeSerializedSize()
        size += getIntIfMask(url, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(startParam, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(themeParams, 4) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(platform)
        size += getIntIfMask(replyTo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(sendAs, 8192) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesRequestWebView) return false
        if (other === this) return true

        return _flags == other._flags
                && fromBotMenu == other.fromBotMenu
                && silent == other.silent
                && peer == other.peer
                && bot == other.bot
                && url == other.url
                && startParam == other.startParam
                && themeParams == other.themeParams
                && platform == other.platform
                && replyTo == other.replyTo
                && sendAs == other.sendAs
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x269dc2c1.toInt()
    }
}
