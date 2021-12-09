package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyAddedByPhone#d1219bdd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyAddedByPhone : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyAddedByPhone#d1219bdd"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyAddedByPhone) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd1219bdd.toInt()
    }
}
