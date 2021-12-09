package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * jsonObjectValue#c0de1bd9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLJsonObjectValue() : TLObject() {
    var key: String = ""

    var value: TLAbsJSONValue = TLJsonNull()

    private val _constructor: String = "jsonObjectValue#c0de1bd9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(key: String, value: TLAbsJSONValue) : this() {
        this.key = key
        this.value = value
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(key)
        writeTLObject(value)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        key = readString()
        value = readTLObject<TLAbsJSONValue>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(key)
        size += value.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLJsonObjectValue) return false
        if (other === this) return true

        return key == other.key
                && value == other.value
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc0de1bd9.toInt()
    }
}
