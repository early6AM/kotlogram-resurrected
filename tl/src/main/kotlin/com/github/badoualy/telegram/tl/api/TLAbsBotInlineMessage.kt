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
 * * [botInlineMessageMediaAuto#764cf810][TLBotInlineMessageMediaAuto]
 * * [botInlineMessageMediaContact#18d1cdc2][TLBotInlineMessageMediaContact]
 * * [botInlineMessageMediaGeo#51846fd][TLBotInlineMessageMediaGeo]
 * * [botInlineMessageMediaInvoice#354a9b09][TLBotInlineMessageMediaInvoice]
 * * [botInlineMessageMediaVenue#8a86659c][TLBotInlineMessageMediaVenue]
 * * [botInlineMessageMediaWebPage#809ad9a6][TLBotInlineMessageMediaWebPage]
 * * [botInlineMessageText#8c7f65e2][TLBotInlineMessageText]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBotInlineMessage : TLObject() {
    abstract var replyMarkup: TLAbsReplyMarkup?
}
