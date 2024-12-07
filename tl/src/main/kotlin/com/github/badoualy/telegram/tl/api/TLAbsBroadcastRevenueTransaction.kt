package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Long

/**
 * Abstraction level for the following constructors:
 * * [broadcastRevenueTransactionProceeds#557e2cc4][TLBroadcastRevenueTransactionProceeds]
 * * [broadcastRevenueTransactionRefund#42d30d2e][TLBroadcastRevenueTransactionRefund]
 * * [broadcastRevenueTransactionWithdrawal#5a590978][TLBroadcastRevenueTransactionWithdrawal]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBroadcastRevenueTransaction : TLObject() {
    abstract var amount: Long
}
