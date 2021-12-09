package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter
import com.github.badoualy.telegram.tl.api.TLInputMessagesFilterEmpty
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.searchCounter#e844ebff
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSearchCounter() : TLObject() {
    @Transient
    var inexact: Boolean = false

    var filter: TLAbsMessagesFilter = TLInputMessagesFilterEmpty()

    var count: Int = 0

    private val _constructor: String = "messages.searchCounter#e844ebff"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inexact: Boolean,
            filter: TLAbsMessagesFilter,
            count: Int
    ) : this() {
        this.inexact = inexact
        this.filter = filter
        this.count = count
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(inexact, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(filter)
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inexact = isMask(2)
        filter = readTLObject<TLAbsMessagesFilter>()
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSearchCounter) return false
        if (other === this) return true

        return _flags == other._flags
                && inexact == other.inexact
                && filter == other.filter
                && count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe844ebff.toInt()
    }
}
