package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelFull#e9b27a17][TLChannelFull]
 * * [chatFull#4dbdc099][TLChatFull]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatFull : TLObject() {
    abstract var id: Long

    abstract var about: String

    abstract var notifySettings: TLPeerNotifySettings

    abstract var folderId: Int?
}
