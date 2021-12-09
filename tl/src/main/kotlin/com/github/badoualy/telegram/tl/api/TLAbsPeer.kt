package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [peerChannel#a2a5371e][TLPeerChannel]
 * * [peerChat#36c6019a][TLPeerChat]
 * * [peerUser#59511722][TLPeerUser]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPeer : TLObject()
