package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * secureRequiredTypeOneOf#27477b4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureRequiredTypeOneOf() : TLAbsSecureRequiredType() {
    var types: TLObjectVector<TLAbsSecureRequiredType> = TLObjectVector()

    private val _constructor: String = "secureRequiredTypeOneOf#27477b4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(types: TLObjectVector<TLAbsSecureRequiredType>) : this() {
        this.types = types
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(types)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        types = readTLVector<TLAbsSecureRequiredType>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += types.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureRequiredTypeOneOf) return false
        if (other === this) return true

        return types == other.types
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x27477b4
    }
}
