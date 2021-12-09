package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channel#8261ac61][TLChannel]
 * * [channelForbidden#17d493d5][TLChannelForbidden]
 * * [chat#41cbf256][TLChat]
 * * [chatEmpty#29562865][TLChatEmpty]
 * * [chatForbidden#6592a1a7][TLChatForbidden]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChat : TLObject() {
    abstract var id: Long
}
