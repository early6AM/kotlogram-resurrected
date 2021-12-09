package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageListOrderedItemBlocks#98dd8936
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageListOrderedItemBlocks() : TLAbsPageListOrderedItem() {
    override var num: String = ""

    var blocks: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    private val _constructor: String = "pageListOrderedItemBlocks#98dd8936"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(num: String, blocks: TLObjectVector<TLAbsPageBlock>) : this() {
        this.num = num
        this.blocks = blocks
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(num)
        writeTLVector(blocks)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        num = readString()
        blocks = readTLVector<TLAbsPageBlock>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(num)
        size += blocks.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageListOrderedItemBlocks) return false
        if (other === this) return true

        return num == other.num
                && blocks == other.blocks
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98dd8936.toInt()
    }
}
