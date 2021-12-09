package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChatInviteExported
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [messages.exportedChatInvite#1871be50][TLExportedChatInvite]
 * * [messages.exportedChatInviteReplaced#222600ef][TLExportedChatInviteReplaced]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsExportedChatInvite : TLObject() {
    abstract var invite: TLChatInviteExported

    abstract var users: TLObjectVector<TLAbsUser>
}
