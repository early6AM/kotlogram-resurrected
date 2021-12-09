package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [auth.loginToken#629f1980][TLLoginToken]
 * * [auth.loginTokenMigrateTo#68e9916][TLLoginTokenMigrateTo]
 * * [auth.loginTokenSuccess#390d5c5e][TLLoginTokenSuccess]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsLoginToken : TLObject()
