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
 * * [attachMenuPeerTypeBotPM#c32bfa1a][TLAttachMenuPeerTypeBotPM]
 * * [attachMenuPeerTypeBroadcast#7bfbdefc][TLAttachMenuPeerTypeBroadcast]
 * * [attachMenuPeerTypeChat#509113f][TLAttachMenuPeerTypeChat]
 * * [attachMenuPeerTypePM#f146d31f][TLAttachMenuPeerTypePM]
 * * [attachMenuPeerTypeSameBotPM#7d6be90e][TLAttachMenuPeerTypeSameBotPM]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsAttachMenuPeerType : TLObject()
