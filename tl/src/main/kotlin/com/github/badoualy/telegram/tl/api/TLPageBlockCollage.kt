package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * pageBlockCollage#65a0fa4d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockCollage() : TLAbsPageBlock() {
    var items: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    var caption: TLPageCaption = TLPageCaption()

    private val _constructor: String = "pageBlockCollage#65a0fa4d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(items: TLObjectVector<TLAbsPageBlock>, caption: TLPageCaption) : this() {
        this.items = items
        this.caption = caption
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(items)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        items = readTLVector<TLAbsPageBlock>()
        caption = readTLObject<TLPageCaption>(TLPageCaption::class, TLPageCaption.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += items.computeSerializedSize()
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockCollage) return false
        if (other === this) return true

        return items == other.items
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x65a0fa4d.toInt()
    }
}
