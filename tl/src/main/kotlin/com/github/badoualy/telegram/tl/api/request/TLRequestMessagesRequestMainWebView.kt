package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
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
class TLRequestMessagesRequestMainWebView() : TLMethod<TLWebViewResultUrl>() {
    @Transient
    var compact: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var startParam: String? = null

    var themeParams: TLDataJSON? = null

    var platform: String = ""

    private val _constructor: String = "messages.requestMainWebView#c9e01e7b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            compact: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ) : this() {
        this.compact = compact
        this.peer = peer
        this.bot = bot
        this.startParam = startParam
        this.themeParams = themeParams
        this.platform = platform
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLWebViewResultUrl = tlDeserializer.readTLObject(TLWebViewResultUrl::class, TLWebViewResultUrl.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(compact, 128)
        updateFlags(startParam, 2)
        updateFlags(themeParams, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(bot)
        doIfMask(1, startParam, 2) { writeString(it) }
        doIfMask(1, themeParams, 1) { writeTLObject(it) }
        writeString(platform)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        compact = isMask(1, 128)
        peer = readTLObject<TLAbsInputPeer>()
        bot = readTLObject<TLAbsInputUser>()
        startParam = readIfMask(1, 2) { readString() }
        themeParams = readIfMask(1, 1) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        platform = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += bot.computeSerializedSize()
        size += getIntIfMask(1, startParam, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, themeParams, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(platform)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesRequestMainWebView) return false
        if (other === this) return true

        return _flags == other._flags
                && compact == other.compact
                && peer == other.peer
                && bot == other.bot
                && startParam == other.startParam
                && themeParams == other.themeParams
                && platform == other.platform
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9e01e7b.toInt()
    }
}
