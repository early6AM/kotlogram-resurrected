package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [encryptedChat#61f0d4c7][TLEncryptedChat]
 * * [encryptedChatDiscarded#1e1c7c45][TLEncryptedChatDiscarded]
 * * [encryptedChatEmpty#ab7ec0a0][TLEncryptedChatEmpty]
 * * [encryptedChatRequested#48f1d94c][TLEncryptedChatRequested]
 * * [encryptedChatWaiting#66b25953][TLEncryptedChatWaiting]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsEncryptedChat : TLObject() {
    abstract var id: Int
}
