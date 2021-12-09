package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.featuredStickers#84c02310][TLFeaturedStickers]
 * * [messages.featuredStickersNotModified#c6dc0c66][TLFeaturedStickersNotModified]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsFeaturedStickers : TLObject() {
    abstract var count: Int
}
