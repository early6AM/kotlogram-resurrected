package com.github.badoualy.telegram.tl.api.account

/**
 * account.resetPasswordOk#e926d63e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLResetPasswordOk : TLAbsResetPasswordResult() {
    private val _constructor: String = "account.resetPasswordOk#e926d63e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLResetPasswordOk) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe926d63e.toInt()
    }
}
