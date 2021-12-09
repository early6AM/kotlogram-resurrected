package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [chatParticipant#c02d4007][TLChatParticipant]
 * * [chatParticipantAdmin#a0933f5b][TLChatParticipantAdmin]
 * * [chatParticipantCreator#e46bcee4][TLChatParticipantCreator]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatParticipant : TLObject() {
    abstract var userId: Long
}
