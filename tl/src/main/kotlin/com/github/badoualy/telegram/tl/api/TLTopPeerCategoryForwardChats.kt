package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryForwardChats#fbeec0f0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryForwardChats : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryForwardChats#fbeec0f0"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryForwardChats) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfbeec0f0.toInt()
    }
}
