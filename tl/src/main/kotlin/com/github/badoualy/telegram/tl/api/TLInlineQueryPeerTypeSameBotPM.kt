package com.github.badoualy.telegram.tl.api

/**
 * inlineQueryPeerTypeSameBotPM#3081ed9d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInlineQueryPeerTypeSameBotPM : TLAbsInlineQueryPeerType() {
    private val _constructor: String = "inlineQueryPeerTypeSameBotPM#3081ed9d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInlineQueryPeerTypeSameBotPM) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3081ed9d
    }
}
