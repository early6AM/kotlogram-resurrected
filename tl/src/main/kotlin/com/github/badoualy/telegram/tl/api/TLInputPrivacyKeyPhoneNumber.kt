package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyPhoneNumber#352dafa
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyPhoneNumber : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyPhoneNumber#352dafa"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyPhoneNumber) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x352dafa
    }
}
