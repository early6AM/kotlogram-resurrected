package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyForwards#a4dd4c08
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyForwards : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyForwards#a4dd4c08"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyForwards) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa4dd4c08.toInt()
    }
}
