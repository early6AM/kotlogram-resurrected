package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [replyInlineMarkup#48a30254][TLReplyInlineMarkup]
 * * [replyKeyboardForceReply#86b40b08][TLReplyKeyboardForceReply]
 * * [replyKeyboardHide#a03e5b85][TLReplyKeyboardHide]
 * * [replyKeyboardMarkup#85dd99d1][TLReplyKeyboardMarkup]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsReplyMarkup : TLObject()
