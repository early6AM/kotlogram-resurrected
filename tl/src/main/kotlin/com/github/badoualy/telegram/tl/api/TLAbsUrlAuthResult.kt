package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [urlAuthResultAccepted#8f8c0e4e][TLUrlAuthResultAccepted]
 * * [urlAuthResultDefault#a9d6db1f][TLUrlAuthResultDefault]
 * * [urlAuthResultRequest#92d33a0e][TLUrlAuthResultRequest]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUrlAuthResult : TLObject()
