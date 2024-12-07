package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLDataJSON
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
class TLRequestMessagesRequestSimpleWebView() : TLMethod<TLWebViewResultUrl>() {
    @Transient
    var fromSwitchWebview: Boolean = false

    @Transient
    var fromSideMenu: Boolean = false

    @Transient
    var compact: Boolean = false

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var url: String? = null

    var startParam: String? = null

    var themeParams: TLDataJSON? = null

    var platform: String = ""

    private val _constructor: String = "messages.requestSimpleWebView#413a3e73"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromSwitchWebview: Boolean,
            fromSideMenu: Boolean,
            compact: Boolean,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ) : this() {
        this.fromSwitchWebview = fromSwitchWebview
        this.fromSideMenu = fromSideMenu
        this.compact = compact
        this.bot = bot
        this.url = url
        this.startParam = startParam
        this.themeParams = themeParams
        this.platform = platform
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLWebViewResultUrl = tlDeserializer.readTLObject(TLWebViewResultUrl::class, TLWebViewResultUrl.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(fromSwitchWebview, 2)
        updateFlags(fromSideMenu, 4)
        updateFlags(compact, 128)
        updateFlags(url, 8)
        updateFlags(startParam, 16)
        updateFlags(themeParams, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(bot)
        doIfMask(1, url, 8) { writeString(it) }
        doIfMask(1, startParam, 16) { writeString(it) }
        doIfMask(1, themeParams, 1) { writeTLObject(it) }
        writeString(platform)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fromSwitchWebview = isMask(1, 2)
        fromSideMenu = isMask(1, 4)
        compact = isMask(1, 128)
        bot = readTLObject<TLAbsInputUser>()
        url = readIfMask(1, 8) { readString() }
        startParam = readIfMask(1, 16) { readString() }
        themeParams = readIfMask(1, 1) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        platform = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += bot.computeSerializedSize()
        size += getIntIfMask(1, url, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, startParam, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, themeParams, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(platform)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesRequestSimpleWebView) return false
        if (other === this) return true

        return _flags == other._flags
                && fromSwitchWebview == other.fromSwitchWebview
                && fromSideMenu == other.fromSideMenu
                && compact == other.compact
                && bot == other.bot
                && url == other.url
                && startParam == other.startParam
                && themeParams == other.themeParams
                && platform == other.platform
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x413a3e73.toInt()
    }
}
