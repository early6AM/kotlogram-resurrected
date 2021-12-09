package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateGroupCallConnection#b783982
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateGroupCallConnection() : TLAbsUpdate() {
    @Transient
    var presentation: Boolean = false

    var params: TLDataJSON = TLDataJSON()

    private val _constructor: String = "updateGroupCallConnection#b783982"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(presentation: Boolean, params: TLDataJSON) : this() {
        this.presentation = presentation
        this.params = params
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(presentation, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(params)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        presentation = isMask(1)
        params = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += params.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateGroupCallConnection) return false
        if (other === this) return true

        return _flags == other._flags
                && presentation == other.presentation
                && params == other.params
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb783982
    }
}
