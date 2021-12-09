package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [secureFile#e0277a62][TLSecureFile]
 * * [secureFileEmpty#64199744][TLSecureFileEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSecureFile : TLObject() {
    fun isEmpty(): Boolean = this is TLSecureFileEmpty

    fun isNotEmpty(): Boolean = this is TLSecureFile

    fun asSecureFile(): TLSecureFile? = this as? TLSecureFile
}
