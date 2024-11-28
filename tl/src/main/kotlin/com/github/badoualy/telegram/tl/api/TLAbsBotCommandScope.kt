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
 * * [botCommandScopeChatAdmins#b9aa606a][TLBotCommandScopeChatAdmins]
 * * [botCommandScopeChats#6fe1a881][TLBotCommandScopeChats]
 * * [botCommandScopeDefault#2f6cb2ab][TLBotCommandScopeDefault]
 * * [botCommandScopePeer#db9d897d][TLBotCommandScopePeer]
 * * [botCommandScopePeerAdmins#3fd863d1][TLBotCommandScopePeerAdmins]
 * * [botCommandScopePeerUser#a1321f3][TLBotCommandScopePeerUser]
 * * [botCommandScopeUsers#3c4f04d8][TLBotCommandScopeUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBotCommandScope : TLObject()
