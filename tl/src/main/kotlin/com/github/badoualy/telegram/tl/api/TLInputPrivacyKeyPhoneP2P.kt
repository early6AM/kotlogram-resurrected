package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyPhoneP2P#db9e70d2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyPhoneP2P : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyPhoneP2P#db9e70d2"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyPhoneP2P) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdb9e70d2.toInt()
    }
}
