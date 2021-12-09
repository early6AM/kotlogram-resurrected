package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [securePasswordKdfAlgoPBKDF2HMACSHA512iter100000#bbf2dda0][TLSecurePasswordKdfAlgoPBKDF2HMACSHA512iter100000]
 * * [securePasswordKdfAlgoSHA512#86471d92][TLSecurePasswordKdfAlgoSHA512]
 * * [securePasswordKdfAlgoUnknown#4a8537][TLSecurePasswordKdfAlgoUnknown]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSecurePasswordKdfAlgo : TLObject()
