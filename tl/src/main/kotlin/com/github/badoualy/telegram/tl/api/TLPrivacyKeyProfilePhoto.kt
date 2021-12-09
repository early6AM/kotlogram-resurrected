package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyProfilePhoto#96151fed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyProfilePhoto : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyProfilePhoto#96151fed"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyProfilePhoto) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x96151fed.toInt()
    }
}
