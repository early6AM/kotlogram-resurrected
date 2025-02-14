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
 * * [inputStorePaymentGiftPremium#616f7fe8][TLInputStorePaymentGiftPremium]
 * * [inputStorePaymentPremiumGiftCode#a3805f3f][TLInputStorePaymentPremiumGiftCode]
 * * [inputStorePaymentPremiumGiveaway#160544ca][TLInputStorePaymentPremiumGiveaway]
 * * [inputStorePaymentPremiumSubscription#a6751e66][TLInputStorePaymentPremiumSubscription]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputStorePaymentPurpose : TLObject()
