package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputNotifyBroadcasts#b1db7c7e][TLInputNotifyBroadcasts]
 * * [inputNotifyChats#4a95e84e][TLInputNotifyChats]
 * * [inputNotifyPeer#b8bc5b0c][TLInputNotifyPeer]
 * * [inputNotifyUsers#193b4417][TLInputNotifyUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputNotifyPeer : TLObject()
