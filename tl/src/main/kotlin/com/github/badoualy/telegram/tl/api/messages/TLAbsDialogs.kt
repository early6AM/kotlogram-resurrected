package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.dialogs#15ba6c40][TLDialogs]
 * * [messages.dialogsNotModified#f0e3e596][TLDialogsNotModified]
 * * [messages.dialogsSlice#71e094f3][TLDialogsSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDialogs : TLObject()
