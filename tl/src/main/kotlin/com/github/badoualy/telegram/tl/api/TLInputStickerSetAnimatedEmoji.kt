package com.github.badoualy.telegram.tl.api

/**
 * inputStickerSetAnimatedEmoji#28703c8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetAnimatedEmoji : TLAbsInputStickerSet() {
    private val _constructor: String = "inputStickerSetAnimatedEmoji#28703c8"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetAnimatedEmoji) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x28703c8
    }
}
