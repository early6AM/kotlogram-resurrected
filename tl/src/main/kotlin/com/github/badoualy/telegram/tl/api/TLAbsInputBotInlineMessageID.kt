package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputBotInlineMessageID#890c3d89][TLInputBotInlineMessageID]
 * * [inputBotInlineMessageID64#b6d915d7][TLInputBotInlineMessageID64]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputBotInlineMessageID : TLObject() {
    abstract var dcId: Int

    abstract var accessHash: Long
}
