package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputSecureFile#5367e5be][TLInputSecureFile]
 * * [inputSecureFileUploaded#3334b0f0][TLInputSecureFileUploaded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputSecureFile : TLObject() {
    abstract var id: Long
}
