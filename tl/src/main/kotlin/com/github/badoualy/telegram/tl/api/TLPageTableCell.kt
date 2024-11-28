package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * pageTableCell#34566b6a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageTableCell() : TLObject() {
    @Transient
    var header: Boolean = false

    @Transient
    var alignCenter: Boolean = false

    @Transient
    var alignRight: Boolean = false

    @Transient
    var valignMiddle: Boolean = false

    @Transient
    var valignBottom: Boolean = false

    var text: TLAbsRichText? = null

    var colspan: Int? = null

    var rowspan: Int? = null

    private val _constructor: String = "pageTableCell#34566b6a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            header: Boolean,
            alignCenter: Boolean,
            alignRight: Boolean,
            valignMiddle: Boolean,
            valignBottom: Boolean,
            text: TLAbsRichText?,
            colspan: Int?,
            rowspan: Int?
    ) : this() {
        this.header = header
        this.alignCenter = alignCenter
        this.alignRight = alignRight
        this.valignMiddle = valignMiddle
        this.valignBottom = valignBottom
        this.text = text
        this.colspan = colspan
        this.rowspan = rowspan
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(header, 1)
        updateFlags(alignCenter, 8)
        updateFlags(alignRight, 16)
        updateFlags(valignMiddle, 32)
        updateFlags(valignBottom, 64)
        updateFlags(text, 128)
        updateFlags(colspan, 2)
        updateFlags(rowspan, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(text, 128) { writeTLObject(it) }
        doIfMask(colspan, 2) { writeInt(it) }
        doIfMask(rowspan, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        header = isMask(1)
        alignCenter = isMask(8)
        alignRight = isMask(16)
        valignMiddle = isMask(32)
        valignBottom = isMask(64)
        text = readIfMask(128) { readTLObject<TLAbsRichText>() }
        colspan = readIfMask(2) { readInt() }
        rowspan = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(text, 128) { it.computeSerializedSize() }
        size += getIntIfMask(colspan, 2) { SIZE_INT32 }
        size += getIntIfMask(rowspan, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageTableCell) return false
        if (other === this) return true

        return _flags == other._flags
                && header == other.header
                && alignCenter == other.alignCenter
                && alignRight == other.alignRight
                && valignMiddle == other.valignMiddle
                && valignBottom == other.valignBottom
                && text == other.text
                && colspan == other.colspan
                && rowspan == other.rowspan
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x34566b6a.toInt()
    }
}
