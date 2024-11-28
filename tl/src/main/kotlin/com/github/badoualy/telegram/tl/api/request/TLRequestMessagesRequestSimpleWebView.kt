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
import com.github.badoualy.telegram.tl.api.TLSimpleWebViewResultUrl
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
class TLRequestMessagesRequestSimpleWebView() : TLMethod<TLSimpleWebViewResultUrl>() {
    @Transient
    var fromSwitchWebview: Boolean = false

    @Transient
    var fromSideMenu: Boolean = false

    var bot: TLAbsInputUser = TLInputUserEmpty()

    var url: String? = null

    var startParam: String? = null

    var themeParams: TLDataJSON? = null

    var platform: String = ""

    private val _constructor: String = "messages.requestSimpleWebView#1a46500a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromSwitchWebview: Boolean,
            fromSideMenu: Boolean,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ) : this() {
        this.fromSwitchWebview = fromSwitchWebview
        this.fromSideMenu = fromSideMenu
        this.bot = bot
        this.url = url
        this.startParam = startParam
        this.themeParams = themeParams
        this.platform = platform
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSimpleWebViewResultUrl = tlDeserializer.readTLObject(TLSimpleWebViewResultUrl::class, TLSimpleWebViewResultUrl.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromSwitchWebview, 2)
        updateFlags(fromSideMenu, 4)
        updateFlags(url, 8)
        updateFlags(startParam, 16)
        updateFlags(themeParams, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(bot)
        doIfMask(url, 8) { writeString(it) }
        doIfMask(startParam, 16) { writeString(it) }
        doIfMask(themeParams, 1) { writeTLObject(it) }
        writeString(platform)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fromSwitchWebview = isMask(2)
        fromSideMenu = isMask(4)
        bot = readTLObject<TLAbsInputUser>()
        url = readIfMask(8) { readString() }
        startParam = readIfMask(16) { readString() }
        themeParams = readIfMask(1) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        platform = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += bot.computeSerializedSize()
        size += getIntIfMask(url, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(startParam, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(themeParams, 1) { it.computeSerializedSize() }
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
                && bot == other.bot
                && url == other.url
                && startParam == other.startParam
                && themeParams == other.themeParams
                && platform == other.platform
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1a46500a.toInt()
    }
}
