package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputPeerChannel#27bcbbfc][TLInputPeerChannel]
 * * [inputPeerChannelFromMessage#bd2a0840][TLInputPeerChannelFromMessage]
 * * [inputPeerChat#35a95cb9][TLInputPeerChat]
 * * [inputPeerEmpty#7f3b18ea][TLInputPeerEmpty]
 * * [inputPeerSelf#7da07ec9][TLInputPeerSelf]
 * * [inputPeerUser#dde8a54c][TLInputPeerUser]
 * * [inputPeerUserFromMessage#a87b0a1c][TLInputPeerUserFromMessage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPeer : TLObject()
