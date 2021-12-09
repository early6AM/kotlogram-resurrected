package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [groupCall#d597650c][TLGroupCall]
 * * [groupCallDiscarded#7780bcb4][TLGroupCallDiscarded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsGroupCall : TLObject() {
    abstract var id: Long

    abstract var accessHash: Long
}
