package com.github.badoualy.telegram.tl.api

/**
 * inlineQueryPeerTypeMegagroup#5ec4be43
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInlineQueryPeerTypeMegagroup : TLAbsInlineQueryPeerType() {
    private val _constructor: String = "inlineQueryPeerTypeMegagroup#5ec4be43"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInlineQueryPeerTypeMegagroup) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5ec4be43
    }
}
