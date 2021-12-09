package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateDialogFilterOrder#a5d72105
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDialogFilterOrder() : TLAbsUpdate() {
    var order: TLIntVector = TLIntVector()

    private val _constructor: String = "updateDialogFilterOrder#a5d72105"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(order: TLIntVector) : this() {
        this.order = order
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(order)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        order = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += order.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateDialogFilterOrder) return false
        if (other === this) return true

        return order == other.order
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa5d72105.toInt()
    }
}
