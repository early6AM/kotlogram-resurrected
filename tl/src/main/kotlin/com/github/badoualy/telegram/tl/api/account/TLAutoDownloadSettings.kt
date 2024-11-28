package com.github.badoualy.telegram.tl.api.account

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

/**
 * account.autoDownloadSettings#63cacf26
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAutoDownloadSettings() : TLObject() {
    var low: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings = com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings()

    var medium: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings = com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings()

    var high: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings = com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings()

    private val _constructor: String = "account.autoDownloadSettings#63cacf26"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            low: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings,
            medium: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings,
            high: com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings
    ) : this() {
        this.low = low
        this.medium = medium
        this.high = high
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(low)
        writeTLObject(medium)
        writeTLObject(high)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        low = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings>(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings::class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID)
        medium = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings>(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings::class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID)
        high = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings>(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings::class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += low.computeSerializedSize()
        size += medium.computeSerializedSize()
        size += high.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAutoDownloadSettings) return false
        if (other === this) return true

        return low == other.low
                && medium == other.medium
                && high == other.high
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x63cacf26.toInt()
    }
}
