package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLAbsJSONValue
import com.github.badoualy.telegram.tl.core.TLMethod

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetAppConfig : TLMethod<TLAbsJSONValue>() {
    private val _constructor: String = "help.getAppConfig#98914110"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetAppConfig) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98914110.toInt()
    }
}
