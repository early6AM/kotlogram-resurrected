package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockTable#bf4dea82
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockTable() : TLAbsPageBlock() {
    @Transient
    var bordered: Boolean = false

    @Transient
    var striped: Boolean = false

    var title: TLAbsRichText = TLTextEmpty()

    var rows: TLObjectVector<TLPageTableRow> = TLObjectVector()

    private val _constructor: String = "pageBlockTable#bf4dea82"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            bordered: Boolean,
            striped: Boolean,
            title: TLAbsRichText,
            rows: TLObjectVector<TLPageTableRow>
    ) : this() {
        this.bordered = bordered
        this.striped = striped
        this.title = title
        this.rows = rows
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(bordered, 1)
        updateFlags(striped, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(title)
        writeTLVector(rows)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        bordered = isMask(1)
        striped = isMask(2)
        title = readTLObject<TLAbsRichText>()
        rows = readTLVector<TLPageTableRow>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += title.computeSerializedSize()
        size += rows.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockTable) return false
        if (other === this) return true

        return _flags == other._flags
                && bordered == other.bordered
                && striped == other.striped
                && title == other.title
                && rows == other.rows
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbf4dea82.toInt()
    }
}
