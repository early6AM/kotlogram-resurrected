package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [auth.authorization#cd050916][TLAuthorization]
 * * [auth.authorizationSignUpRequired#44747e9a][TLAuthorizationSignUpRequired]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsAuthorization : TLObject()
