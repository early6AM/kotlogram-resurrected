package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * inputStickerSetEmojiChannelDefaultStatuses#49748553
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetEmojiChannelDefaultStatuses : TLAbsInputStickerSet() {
    private val _constructor: String = "inputStickerSetEmojiChannelDefaultStatuses#49748553"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetEmojiChannelDefaultStatuses) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x49748553.toInt()
    }
}
