package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsBotApp
import com.github.badoualy.telegram.tl.api.TLBotAppNotModified
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
 * messages.botApp#eb50adf5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotApp() : TLObject() {
    @Transient
    var inactive: Boolean = false

    @Transient
    var requestWriteAccess: Boolean = false

    @Transient
    var hasSettings: Boolean = false

    var app: TLAbsBotApp = TLBotAppNotModified()

    private val _constructor: String = "messages.botApp#eb50adf5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inactive: Boolean,
            requestWriteAccess: Boolean,
            hasSettings: Boolean,
            app: TLAbsBotApp
    ) : this() {
        this.inactive = inactive
        this.requestWriteAccess = requestWriteAccess
        this.hasSettings = hasSettings
        this.app = app
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(inactive, 1)
        updateFlags(requestWriteAccess, 2)
        updateFlags(hasSettings, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(app)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inactive = isMask(1, 1)
        requestWriteAccess = isMask(1, 2)
        hasSettings = isMask(1, 4)
        app = readTLObject<TLAbsBotApp>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += app.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotApp) return false
        if (other === this) return true

        return _flags == other._flags
                && inactive == other.inactive
                && requestWriteAccess == other.requestWriteAccess
                && hasSettings == other.hasSettings
                && app == other.app
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeb50adf5.toInt()
    }
}
