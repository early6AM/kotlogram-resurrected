package com.github.badoualy.telegram.tl.api

/**
 * sendMessageChooseStickerAction#b05ac6b1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageChooseStickerAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageChooseStickerAction#b05ac6b1"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageChooseStickerAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb05ac6b1.toInt()
    }
}
