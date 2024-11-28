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
 * * [inlineQueryPeerTypeBotPM#e3b2d0c][TLInlineQueryPeerTypeBotPM]
 * * [inlineQueryPeerTypeBroadcast#6334ee9a][TLInlineQueryPeerTypeBroadcast]
 * * [inlineQueryPeerTypeChat#d766c50a][TLInlineQueryPeerTypeChat]
 * * [inlineQueryPeerTypeMegagroup#5ec4be43][TLInlineQueryPeerTypeMegagroup]
 * * [inlineQueryPeerTypePM#833c0fac][TLInlineQueryPeerTypePM]
 * * [inlineQueryPeerTypeSameBotPM#3081ed9d][TLInlineQueryPeerTypeSameBotPM]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInlineQueryPeerType : TLObject()
