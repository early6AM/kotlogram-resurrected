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
import kotlin.jvm.Transient

/**
 * pageBlockDetails#76768bed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockDetails() : TLAbsPageBlock() {
    @Transient
    var open: Boolean = false

    var blocks: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    var title: TLAbsRichText = TLTextEmpty()

    private val _constructor: String = "pageBlockDetails#76768bed"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            open: Boolean,
            blocks: TLObjectVector<TLAbsPageBlock>,
            title: TLAbsRichText
    ) : this() {
        this.open = open
        this.blocks = blocks
        this.title = title
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(open, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(blocks)
        writeTLObject(title)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        open = isMask(1)
        blocks = readTLVector<TLAbsPageBlock>()
        title = readTLObject<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += blocks.computeSerializedSize()
        size += title.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockDetails) return false
        if (other === this) return true

        return _flags == other._flags
                && open == other.open
                && blocks == other.blocks
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x76768bed.toInt()
    }
}
