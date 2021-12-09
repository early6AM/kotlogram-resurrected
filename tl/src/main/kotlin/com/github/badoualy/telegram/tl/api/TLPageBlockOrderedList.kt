package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockOrderedList#9a8ae1e1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockOrderedList() : TLAbsPageBlock() {
    var items: TLObjectVector<TLAbsPageListOrderedItem> = TLObjectVector()

    private val _constructor: String = "pageBlockOrderedList#9a8ae1e1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(items: TLObjectVector<TLAbsPageListOrderedItem>) : this() {
        this.items = items
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(items)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        items = readTLVector<TLAbsPageListOrderedItem>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += items.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockOrderedList) return false
        if (other === this) return true

        return items == other.items
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a8ae1e1.toInt()
    }
}
