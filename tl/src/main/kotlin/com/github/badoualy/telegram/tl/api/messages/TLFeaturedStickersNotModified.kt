package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.featuredStickersNotModified#c6dc0c66
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFeaturedStickersNotModified() : TLAbsFeaturedStickers() {
    override var count: Int = 0

    private val _constructor: String = "messages.featuredStickersNotModified#c6dc0c66"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(count: Int) : this() {
        this.count = count
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFeaturedStickersNotModified) return false
        if (other === this) return true

        return count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc6dc0c66.toInt()
    }
}
