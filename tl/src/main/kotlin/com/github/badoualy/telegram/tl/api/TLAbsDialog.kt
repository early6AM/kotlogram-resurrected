package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [dialog#2c171f72][TLDialog]
 * * [dialogFolder#71bd134c][TLDialogFolder]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDialog : TLObject() {
    abstract var pinned: Boolean

    abstract var peer: TLAbsPeer

    abstract var topMessage: Int
}
