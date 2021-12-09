package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLStringVector

/**
 * Abstraction level for the following constructors:
 * * [emojiKeyword#d5b3b9f9][TLEmojiKeyword]
 * * [emojiKeywordDeleted#236df622][TLEmojiKeywordDeleted]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsEmojiKeyword : TLObject() {
    abstract var keyword: String

    abstract var emoticons: TLStringVector
}
