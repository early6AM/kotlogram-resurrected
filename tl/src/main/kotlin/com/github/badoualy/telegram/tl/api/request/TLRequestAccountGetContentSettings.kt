package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.account.TLContentSettings
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetContentSettings : TLMethod<TLContentSettings>() {
    private val _constructor: String = "account.getContentSettings#8b9b4dae"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLContentSettings = tlDeserializer.readTLObject(TLContentSettings::class, TLContentSettings.CONSTRUCTOR_ID)

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetContentSettings) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8b9b4dae.toInt()
    }
}
