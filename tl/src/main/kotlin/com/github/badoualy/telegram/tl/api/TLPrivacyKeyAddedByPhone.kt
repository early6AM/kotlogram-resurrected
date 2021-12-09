package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyAddedByPhone#42ffd42b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyAddedByPhone : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyAddedByPhone#42ffd42b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyAddedByPhone) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x42ffd42b
    }
}
