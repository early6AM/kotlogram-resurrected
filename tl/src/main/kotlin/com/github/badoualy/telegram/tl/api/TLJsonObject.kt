package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * jsonObject#99c1d49d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLJsonObject() : TLAbsJSONValue() {
    var value: TLObjectVector<TLJsonObjectValue> = TLObjectVector()

    private val _constructor: String = "jsonObject#99c1d49d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(value: TLObjectVector<TLJsonObjectValue>) : this() {
        this.value = value
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(value)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        value = readTLVector<TLJsonObjectValue>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += value.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLJsonObject) return false
        if (other === this) return true

        return value == other.value
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x99c1d49d.toInt()
    }
}
