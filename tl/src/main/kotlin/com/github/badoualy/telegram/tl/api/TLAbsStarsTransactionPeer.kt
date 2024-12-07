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
 * * [starsTransactionPeer#d80da15d][TLStarsTransactionPeer]
 * * [starsTransactionPeerAds#60682812][TLStarsTransactionPeerAds]
 * * [starsTransactionPeerAppStore#b457b375][TLStarsTransactionPeerAppStore]
 * * [starsTransactionPeerFragment#e92fd902][TLStarsTransactionPeerFragment]
 * * [starsTransactionPeerPlayMarket#7b560a0b][TLStarsTransactionPeerPlayMarket]
 * * [starsTransactionPeerPremiumBot#250dbaf8][TLStarsTransactionPeerPremiumBot]
 * * [starsTransactionPeerUnsupported#95f2bfe4][TLStarsTransactionPeerUnsupported]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsStarsTransactionPeer : TLObject()
