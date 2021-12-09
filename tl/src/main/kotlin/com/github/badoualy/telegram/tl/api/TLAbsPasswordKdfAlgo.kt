package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow#3a912d4a][TLPasswordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow]
 * * [passwordKdfAlgoUnknown#d45ab096][TLPasswordKdfAlgoUnknown]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPasswordKdfAlgo : TLObject()
