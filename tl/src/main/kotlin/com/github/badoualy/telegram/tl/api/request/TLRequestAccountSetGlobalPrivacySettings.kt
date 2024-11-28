package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLGlobalPrivacySettings
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountSetGlobalPrivacySettings() : TLMethod<TLGlobalPrivacySettings>() {
    var settings: TLGlobalPrivacySettings = TLGlobalPrivacySettings()

    private val _constructor: String = "account.setGlobalPrivacySettings#1edaaac2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(settings: TLGlobalPrivacySettings) : this() {
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLGlobalPrivacySettings = tlDeserializer.readTLObject(TLGlobalPrivacySettings::class, TLGlobalPrivacySettings.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        settings = readTLObject<TLGlobalPrivacySettings>(TLGlobalPrivacySettings::class, TLGlobalPrivacySettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSetGlobalPrivacySettings) return false
        if (other === this) return true

        return settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1edaaac2.toInt()
    }
}
