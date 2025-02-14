package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [inputMessageEntityMentionName#208e68c9][TLInputMessageEntityMentionName]
 * * [messageEntityBankCard#761e6af4][TLMessageEntityBankCard]
 * * [messageEntityBlockquote#20df5d0][TLMessageEntityBlockquote]
 * * [messageEntityBold#bd610bc9][TLMessageEntityBold]
 * * [messageEntityBotCommand#6cef8ac7][TLMessageEntityBotCommand]
 * * [messageEntityCashtag#4c4e743f][TLMessageEntityCashtag]
 * * [messageEntityCode#28a20571][TLMessageEntityCode]
 * * [messageEntityCustomEmoji#c8cf05f8][TLMessageEntityCustomEmoji]
 * * [messageEntityEmail#64e475c2][TLMessageEntityEmail]
 * * [messageEntityHashtag#6f635b0d][TLMessageEntityHashtag]
 * * [messageEntityItalic#826f8b60][TLMessageEntityItalic]
 * * [messageEntityMention#fa04579d][TLMessageEntityMention]
 * * [messageEntityMentionName#dc7b1140][TLMessageEntityMentionName]
 * * [messageEntityPhone#9b69e34b][TLMessageEntityPhone]
 * * [messageEntityPre#73924be0][TLMessageEntityPre]
 * * [messageEntitySpoiler#32ca960f][TLMessageEntitySpoiler]
 * * [messageEntityStrike#bf0693d4][TLMessageEntityStrike]
 * * [messageEntityTextUrl#76a6d327][TLMessageEntityTextUrl]
 * * [messageEntityUnderline#9c4e7e8b][TLMessageEntityUnderline]
 * * [messageEntityUnknown#bb92ba95][TLMessageEntityUnknown]
 * * [messageEntityUrl#6ed02538][TLMessageEntityUrl]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageEntity : TLObject() {
    abstract var offset: Int

    abstract var length: Int
}
