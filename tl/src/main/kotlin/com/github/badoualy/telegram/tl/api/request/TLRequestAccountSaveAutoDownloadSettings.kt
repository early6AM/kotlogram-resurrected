package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestAccountSaveAutoDownloadSettings() : TLMethod<TLBool>() {
    @Transient
    var low: Boolean = false

    @Transient
    var high: Boolean = false

    var settings: TLAutoDownloadSettings = TLAutoDownloadSettings()

    private val _constructor: String = "account.saveAutoDownloadSettings#76f36233"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            low: Boolean,
            high: Boolean,
            settings: TLAutoDownloadSettings
    ) : this() {
        this.low = low
        this.high = high
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(low, 1)
        updateFlags(high, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        low = isMask(1, 1)
        high = isMask(1, 2)
        settings = readTLObject<TLAutoDownloadSettings>(TLAutoDownloadSettings::class, TLAutoDownloadSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSaveAutoDownloadSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && low == other.low
                && high == other.high
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x76f36233.toInt()
    }
}
