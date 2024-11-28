package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputStickerSetAnimatedEmoji#28703c8][TLInputStickerSetAnimatedEmoji]
 * * [inputStickerSetAnimatedEmojiAnimations#cde3739][TLInputStickerSetAnimatedEmojiAnimations]
 * * [inputStickerSetDice#e67f520e][TLInputStickerSetDice]
 * * [inputStickerSetEmojiChannelDefaultStatuses#49748553][TLInputStickerSetEmojiChannelDefaultStatuses]
 * * [inputStickerSetEmojiDefaultStatuses#29d0f5ee][TLInputStickerSetEmojiDefaultStatuses]
 * * [inputStickerSetEmojiDefaultTopicIcons#44c1f8e9][TLInputStickerSetEmojiDefaultTopicIcons]
 * * [inputStickerSetEmojiGenericAnimations#4c4d4ce][TLInputStickerSetEmojiGenericAnimations]
 * * [inputStickerSetEmpty#ffb62b95][TLInputStickerSetEmpty]
 * * [inputStickerSetID#9de7a269][TLInputStickerSetID]
 * * [inputStickerSetPremiumGifts#c88b3b02][TLInputStickerSetPremiumGifts]
 * * [inputStickerSetShortName#861cc8a0][TLInputStickerSetShortName]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputStickerSet : TLObject()
