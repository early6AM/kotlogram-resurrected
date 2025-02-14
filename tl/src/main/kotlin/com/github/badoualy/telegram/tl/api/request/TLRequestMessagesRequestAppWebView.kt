package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotApp
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAppWebViewResultUrl
import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.api.TLInputBotAppShortName
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
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
class TLRequestMessagesRequestAppWebView() : TLMethod<TLAppWebViewResultUrl>() {
    @Transient
    var writeAllowed: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var app: TLAbsInputBotApp = TLInputBotAppShortName()

    var startParam: String? = null

    var themeParams: TLDataJSON? = null

    var platform: String = ""

    private val _constructor: String = "messages.requestAppWebView#8c5a3b3c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer,
            app: TLAbsInputBotApp,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ) : this() {
        this.writeAllowed = writeAllowed
        this.peer = peer
        this.app = app
        this.startParam = startParam
        this.themeParams = themeParams
        this.platform = platform
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAppWebViewResultUrl = tlDeserializer.readTLObject(TLAppWebViewResultUrl::class, TLAppWebViewResultUrl.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(writeAllowed, 1)
        updateFlags(startParam, 2)
        updateFlags(themeParams, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeTLObject(app)
        doIfMask(startParam, 2) { writeString(it) }
        doIfMask(themeParams, 4) { writeTLObject(it) }
        writeString(platform)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        writeAllowed = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        app = readTLObject<TLAbsInputBotApp>()
        startParam = readIfMask(2) { readString() }
        themeParams = readIfMask(4) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        platform = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += app.computeSerializedSize()
        size += getIntIfMask(startParam, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(themeParams, 4) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(platform)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesRequestAppWebView) return false
        if (other === this) return true

        return _flags == other._flags
                && writeAllowed == other.writeAllowed
                && peer == other.peer
                && app == other.app
                && startParam == other.startParam
                && themeParams == other.themeParams
                && platform == other.platform
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c5a3b3c.toInt()
    }
}
