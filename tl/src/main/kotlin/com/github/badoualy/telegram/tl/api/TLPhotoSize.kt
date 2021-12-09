package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photoSize#75c78e60
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhotoSize() : TLAbsPhotoSize() {
    override var type: String = ""

    var w: Int = 0

    var h: Int = 0

    var size: Int = 0

    private val _constructor: String = "photoSize#75c78e60"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: String,
            w: Int,
            h: Int,
            size: Int
    ) : this() {
        this.type = type
        this.w = w
        this.h = h
        this.size = size
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(type)
        writeInt(w)
        writeInt(h)
        writeInt(size)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        type = readString()
        w = readInt()
        h = readInt()
        size = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(type)
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhotoSize) return false
        if (other === this) return true

        return type == other.type
                && w == other.w
                && h == other.h
                && size == other.size
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x75c78e60
    }
}
