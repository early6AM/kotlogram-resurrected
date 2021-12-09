package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult
import com.github.badoualy.telegram.tl.core.TLMethod

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountResetPassword : TLMethod<TLAbsResetPasswordResult>() {
    private val _constructor: String = "account.resetPassword#9308ce1b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountResetPassword) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9308ce1b.toInt()
    }
}
