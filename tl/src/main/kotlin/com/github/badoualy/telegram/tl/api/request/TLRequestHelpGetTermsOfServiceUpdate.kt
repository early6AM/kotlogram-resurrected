package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.core.TLMethod

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetTermsOfServiceUpdate : TLMethod<TLAbsTermsOfServiceUpdate>() {
    private val _constructor: String = "help.getTermsOfServiceUpdate#2ca51fd1"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetTermsOfServiceUpdate) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2ca51fd1
    }
}
