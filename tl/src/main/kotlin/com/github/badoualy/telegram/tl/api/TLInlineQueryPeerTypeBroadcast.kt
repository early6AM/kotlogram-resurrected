package com.github.badoualy.telegram.tl.api

/**
 * inlineQueryPeerTypeBroadcast#6334ee9a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInlineQueryPeerTypeBroadcast : TLAbsInlineQueryPeerType() {
    private val _constructor: String = "inlineQueryPeerTypeBroadcast#6334ee9a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInlineQueryPeerTypeBroadcast) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6334ee9a
    }
}
