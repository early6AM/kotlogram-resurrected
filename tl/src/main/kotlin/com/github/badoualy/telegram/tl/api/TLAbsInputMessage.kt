package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputMessageCallbackQuery#acfa1a7e][TLInputMessageCallbackQuery]
 * * [inputMessageID#a676a322][TLInputMessageID]
 * * [inputMessagePinned#86872538][TLInputMessagePinned]
 * * [inputMessageReplyTo#bad88395][TLInputMessageReplyTo]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputMessage : TLObject()
