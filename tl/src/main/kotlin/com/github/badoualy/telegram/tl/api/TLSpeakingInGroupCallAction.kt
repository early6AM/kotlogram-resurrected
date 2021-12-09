package com.github.badoualy.telegram.tl.api

/**
 * speakingInGroupCallAction#d92c2285
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSpeakingInGroupCallAction : TLAbsSendMessageAction() {
    private val _constructor: String = "speakingInGroupCallAction#d92c2285"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSpeakingInGroupCallAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd92c2285.toInt()
    }
}
