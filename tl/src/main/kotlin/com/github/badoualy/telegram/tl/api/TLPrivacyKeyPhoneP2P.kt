package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyPhoneP2P#39491cc8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyPhoneP2P : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyPhoneP2P#39491cc8"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyPhoneP2P) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x39491cc8
    }
}
