package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.historyImportParsed#5e0fb7b9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLHistoryImportParsed() : TLObject() {
    @Transient
    var pm: Boolean = false

    @Transient
    var group: Boolean = false

    var title: String? = null

    private val _constructor: String = "messages.historyImportParsed#5e0fb7b9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pm: Boolean,
            group: Boolean,
            title: String?
    ) : this() {
        this.pm = pm
        this.group = group
        this.title = title
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(pm, 1)
        updateFlags(group, 2)
        updateFlags(title, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(title, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pm = isMask(1)
        group = isMask(2)
        title = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(title, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLHistoryImportParsed) return false
        if (other === this) return true

        return _flags == other._flags
                && pm == other.pm
                && group == other.group
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5e0fb7b9
    }
}
