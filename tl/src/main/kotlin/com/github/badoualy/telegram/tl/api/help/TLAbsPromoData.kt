package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Boolean
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [help.promoData#8c39793f][TLPromoData]
 * * [help.promoDataEmpty#98f6ac75][TLPromoDataEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPromoData : TLObject() {
    abstract var expires: Int

    fun isEmpty(): Boolean = this is TLPromoDataEmpty

    fun isNotEmpty(): Boolean = this is TLPromoData

    fun asPromoData(): TLPromoData? = this as? TLPromoData
}
