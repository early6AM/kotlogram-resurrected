package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLAbsWebDocument
import com.github.badoualy.telegram.tl.api.TLInvoice
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [payments.paymentReceipt#70c4fe03][TLPaymentReceipt]
 * * [payments.paymentReceiptStars#dabbf83a][TLPaymentReceiptStars]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPaymentReceipt : TLObject() {
    abstract var date: Int

    abstract var botId: Long

    abstract var title: String

    abstract var description: String

    abstract var photo: TLAbsWebDocument?

    abstract var invoice: TLInvoice

    abstract var currency: String

    abstract var totalAmount: Long

    abstract var users: TLObjectVector<TLAbsUser>
}
