package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [help.termsOfServiceUpdate#28ecf961][TLTermsOfServiceUpdate]
 * * [help.termsOfServiceUpdateEmpty#e3309f7f][TLTermsOfServiceUpdateEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsTermsOfServiceUpdate : TLObject() {
    abstract var expires: Int

    fun isEmpty(): Boolean = this is TLTermsOfServiceUpdateEmpty

    fun isNotEmpty(): Boolean = this is TLTermsOfServiceUpdate

    fun asTermsOfServiceUpdate(): TLTermsOfServiceUpdate? = this as? TLTermsOfServiceUpdate
}
