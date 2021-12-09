package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryForwardUsers#a8406ca9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryForwardUsers : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryForwardUsers#a8406ca9"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryForwardUsers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa8406ca9.toInt()
    }
}
