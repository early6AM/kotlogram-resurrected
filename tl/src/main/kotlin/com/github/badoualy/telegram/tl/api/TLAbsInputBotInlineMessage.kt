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
 * * [inputBotInlineMessageGame#4b425864][TLInputBotInlineMessageGame]
 * * [inputBotInlineMessageMediaAuto#3380c786][TLInputBotInlineMessageMediaAuto]
 * * [inputBotInlineMessageMediaContact#a6edbffd][TLInputBotInlineMessageMediaContact]
 * * [inputBotInlineMessageMediaGeo#96929a85][TLInputBotInlineMessageMediaGeo]
 * * [inputBotInlineMessageMediaInvoice#d7e78225][TLInputBotInlineMessageMediaInvoice]
 * * [inputBotInlineMessageMediaVenue#417bbf11][TLInputBotInlineMessageMediaVenue]
 * * [inputBotInlineMessageMediaWebPage#bddcc510][TLInputBotInlineMessageMediaWebPage]
 * * [inputBotInlineMessageText#3dcd7a87][TLInputBotInlineMessageText]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputBotInlineMessage : TLObject() {
    abstract var replyMarkup: TLAbsReplyMarkup?
}
