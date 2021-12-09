package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelLocation#209b82db][TLChannelLocation]
 * * [channelLocationEmpty#bfb5ad8b][TLChannelLocationEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelLocation : TLObject() {
    fun isEmpty(): Boolean = this is TLChannelLocationEmpty

    fun isNotEmpty(): Boolean = this is TLChannelLocation

    fun asChannelLocation(): TLChannelLocation? = this as? TLChannelLocation
}
