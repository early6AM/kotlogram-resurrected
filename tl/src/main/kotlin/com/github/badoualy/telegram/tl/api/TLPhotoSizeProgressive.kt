package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photoSizeProgressive#fa3efb95
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhotoSizeProgressive() : TLAbsPhotoSize() {
    override var type: String = ""

    var w: Int = 0

    var h: Int = 0

    var sizes: TLIntVector = TLIntVector()

    private val _constructor: String = "photoSizeProgressive#fa3efb95"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: String,
            w: Int,
            h: Int,
            sizes: TLIntVector
    ) : this() {
        this.type = type
        this.w = w
        this.h = h
        this.sizes = sizes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(type)
        writeInt(w)
        writeInt(h)
        writeTLVector(sizes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        type = readString()
        w = readInt()
        h = readInt()
        sizes = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(type)
        size += SIZE_INT32
        size += SIZE_INT32
        size += sizes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhotoSizeProgressive) return false
        if (other === this) return true

        return type == other.type
                && w == other.w
                && h == other.h
                && sizes == other.sizes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa3efb95.toInt()
    }
}
