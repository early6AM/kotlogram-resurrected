package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [wallPaper#a437c3ed][TLWallPaper]
 * * [wallPaperNoFile#e0804116][TLWallPaperNoFile]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsWallPaper : TLObject() {
    abstract var id: Long

    abstract var default: Boolean

    abstract var dark: Boolean

    abstract var settings: TLWallPaperSettings?
}
