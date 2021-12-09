package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [account.resetPasswordFailedWait#e3779861][TLResetPasswordFailedWait]
 * * [account.resetPasswordOk#e926d63e][TLResetPasswordOk]
 * * [account.resetPasswordRequestedWait#e9effc7d][TLResetPasswordRequestedWait]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsResetPasswordResult : TLObject()
