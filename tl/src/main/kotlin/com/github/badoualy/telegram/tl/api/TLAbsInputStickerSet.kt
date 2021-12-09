package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputStickerSetAnimatedEmoji#28703c8][TLInputStickerSetAnimatedEmoji]
 * * [inputStickerSetAnimatedEmojiAnimations#cde3739][TLInputStickerSetAnimatedEmojiAnimations]
 * * [inputStickerSetDice#e67f520e][TLInputStickerSetDice]
 * * [inputStickerSetEmpty#ffb62b95][TLInputStickerSetEmpty]
 * * [inputStickerSetID#9de7a269][TLInputStickerSetID]
 * * [inputStickerSetShortName#861cc8a0][TLInputStickerSetShortName]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputStickerSet : TLObject()
