package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [chatParticipants#3cbc93f8][TLChatParticipants]
 * * [chatParticipantsForbidden#8763d3e1][TLChatParticipantsForbidden]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatParticipants : TLObject() {
    abstract var chatId: Long
}
