package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photoPathSize#d8214d41
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhotoPathSize() : TLAbsPhotoSize() {
    override var type: String = ""

    var bytes: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "photoPathSize#d8214d41"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(type: String, bytes: TLBytes) : this() {
        this.type = type
        this.bytes = bytes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(type)
        writeTLBytes(bytes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        type = readString()
        bytes = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(type)
        size += computeTLBytesSerializedSize(bytes)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhotoPathSize) return false
        if (other === this) return true

        return type == other.type
                && bytes == other.bytes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd8214d41.toInt()
    }
}
