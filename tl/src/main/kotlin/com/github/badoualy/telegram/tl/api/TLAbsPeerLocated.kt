package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [peerLocated#ca461b5d][TLPeerLocated]
 * * [peerSelfLocated#f8ec284b][TLPeerSelfLocated]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPeerLocated : TLObject() {
    abstract var expires: Int
}
