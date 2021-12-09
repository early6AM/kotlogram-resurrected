package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.channelMessages#64479808][TLChannelMessages]
 * * [messages.messages#8c718e87][TLMessages]
 * * [messages.messagesNotModified#74535f21][TLMessagesNotModified]
 * * [messages.messagesSlice#3a54685e][TLMessagesSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessages : TLObject()
