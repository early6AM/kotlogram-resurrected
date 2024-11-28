package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotApp
import com.github.badoualy.telegram.tl.api.TLInputBotAppShortName
import com.github.badoualy.telegram.tl.api.messages.TLBotApp
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetBotApp() : TLMethod<TLBotApp>() {
    var app: TLAbsInputBotApp = TLInputBotAppShortName()

    var hash: Long = 0L

    private val _constructor: String = "messages.getBotApp#34fdc5c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(app: TLAbsInputBotApp, hash: Long) : this() {
        this.app = app
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLBotApp = tlDeserializer.readTLObject(TLBotApp::class, TLBotApp.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(app)
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        app = readTLObject<TLAbsInputBotApp>()
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += app.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetBotApp) return false
        if (other === this) return true

        return app == other.app
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x34fdc5c3.toInt()
    }
}
