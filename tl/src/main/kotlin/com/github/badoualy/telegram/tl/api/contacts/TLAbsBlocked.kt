package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLPeerBlocked
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [contacts.blocked#ade1591][TLBlocked]
 * * [contacts.blockedSlice#e1664194][TLBlockedSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBlocked : TLObject() {
    abstract var blocked: TLObjectVector<TLPeerBlocked>

    abstract var chats: TLObjectVector<TLAbsChat>

    abstract var users: TLObjectVector<TLAbsUser>
}
