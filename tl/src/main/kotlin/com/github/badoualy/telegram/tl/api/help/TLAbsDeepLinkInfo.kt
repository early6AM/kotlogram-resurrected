package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [help.deepLinkInfo#6a4ee832][TLDeepLinkInfo]
 * * [help.deepLinkInfoEmpty#66afa166][TLDeepLinkInfoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDeepLinkInfo : TLObject() {
    fun isEmpty(): Boolean = this is TLDeepLinkInfoEmpty

    fun isNotEmpty(): Boolean = this is TLDeepLinkInfo

    fun asDeepLinkInfo(): TLDeepLinkInfo? = this as? TLDeepLinkInfo
}
