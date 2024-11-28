package com.github.badoualy.telegram.tl.api.stories

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [stories.allStories#6efc5e81][TLAllStories]
 * * [stories.allStoriesNotModified#1158fe3e][TLAllStoriesNotModified]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsAllStories : TLObject() {
    abstract var state: String

    abstract var stealthMode: TLStoriesStealthMode
}
