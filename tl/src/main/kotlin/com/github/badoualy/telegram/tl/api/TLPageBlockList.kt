package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockList#e4e88011
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockList() : TLAbsPageBlock() {
    var items: TLObjectVector<TLAbsPageListItem> = TLObjectVector()

    private val _constructor: String = "pageBlockList#e4e88011"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(items: TLObjectVector<TLAbsPageListItem>) : this() {
        this.items = items
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(items)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        items = readTLVector<TLAbsPageListItem>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += items.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockList) return false
        if (other === this) return true

        return items == other.items
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe4e88011.toInt()
    }
}
