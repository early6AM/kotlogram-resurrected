package com.github.badoualy.telegram.tl.api

/**
 * inlineQueryPeerTypePM#833c0fac
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInlineQueryPeerTypePM : TLAbsInlineQueryPeerType() {
    private val _constructor: String = "inlineQueryPeerTypePM#833c0fac"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInlineQueryPeerTypePM) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x833c0fac.toInt()
    }
}
