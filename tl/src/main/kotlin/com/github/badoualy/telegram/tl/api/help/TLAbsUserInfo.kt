package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [help.userInfo#1eb3758][TLUserInfo]
 * * [help.userInfoEmpty#f3ae2eed][TLUserInfoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUserInfo : TLObject() {
    fun isEmpty(): Boolean = this is TLUserInfoEmpty

    fun isNotEmpty(): Boolean = this is TLUserInfo

    fun asUserInfo(): TLUserInfo? = this as? TLUserInfo
}
