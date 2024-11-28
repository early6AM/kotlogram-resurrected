package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [inputKeyboardButtonUrlAuth#d02e7fd4][TLInputKeyboardButtonUrlAuth]
 * * [inputKeyboardButtonUserProfile#e988037b][TLInputKeyboardButtonUserProfile]
 * * [keyboardButton#a2fa4880][TLKeyboardButton]
 * * [keyboardButtonBuy#afd93fbb][TLKeyboardButtonBuy]
 * * [keyboardButtonCallback#35bbdb6b][TLKeyboardButtonCallback]
 * * [keyboardButtonGame#50f41ccf][TLKeyboardButtonGame]
 * * [keyboardButtonRequestGeoLocation#fc796b3f][TLKeyboardButtonRequestGeoLocation]
 * * [keyboardButtonRequestPeer#53d7bfd8][TLKeyboardButtonRequestPeer]
 * * [keyboardButtonRequestPhone#b16a6c29][TLKeyboardButtonRequestPhone]
 * * [keyboardButtonRequestPoll#bbc7515d][TLKeyboardButtonRequestPoll]
 * * [keyboardButtonSimpleWebView#a0c0505c][TLKeyboardButtonSimpleWebView]
 * * [keyboardButtonSwitchInline#93b9fbb5][TLKeyboardButtonSwitchInline]
 * * [keyboardButtonUrl#258aff05][TLKeyboardButtonUrl]
 * * [keyboardButtonUrlAuth#10b78d29][TLKeyboardButtonUrlAuth]
 * * [keyboardButtonUserProfile#308660c1][TLKeyboardButtonUserProfile]
 * * [keyboardButtonWebView#13767230][TLKeyboardButtonWebView]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsKeyboardButton : TLObject() {
    abstract var text: String
}
