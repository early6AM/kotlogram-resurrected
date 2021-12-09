package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputCheckPasswordEmpty#9880f658][TLInputCheckPasswordEmpty]
 * * [inputCheckPasswordSRP#d27ff082][TLInputCheckPasswordSRP]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputCheckPasswordSRP : TLObject() {
    fun isEmpty(): Boolean = this is TLInputCheckPasswordEmpty

    fun isNotEmpty(): Boolean = this is TLInputCheckPasswordSRP

    fun asInputCheckPasswordSRP(): TLInputCheckPasswordSRP? = this as? TLInputCheckPasswordSRP
}
