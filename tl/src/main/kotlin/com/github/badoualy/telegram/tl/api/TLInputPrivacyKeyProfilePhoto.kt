package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyProfilePhoto#5719bacc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyProfilePhoto : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyProfilePhoto#5719bacc"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyProfilePhoto) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5719bacc
    }
}
