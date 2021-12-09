package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [payments.paymentResult#4e5f810d][TLPaymentResult]
 * * [payments.paymentVerificationNeeded#d8411139][TLPaymentVerificationNeeded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPaymentResult : TLObject()
