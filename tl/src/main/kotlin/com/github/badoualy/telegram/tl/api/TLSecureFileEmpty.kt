package com.github.badoualy.telegram.tl.api

/**
 * secureFileEmpty#64199744
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureFileEmpty : TLAbsSecureFile() {
    private val _constructor: String = "secureFileEmpty#64199744"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureFileEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x64199744
    }
}
