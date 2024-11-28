package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * storyItemSkipped#ffadc913
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryItemSkipped() : TLAbsStoryItem() {
    @Transient
    var closeFriends: Boolean = false

    override var id: Int = 0

    var date: Int = 0

    var expireDate: Int = 0

    private val _constructor: String = "storyItemSkipped#ffadc913"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            closeFriends: Boolean,
            id: Int,
            date: Int,
            expireDate: Int
    ) : this() {
        this.closeFriends = closeFriends
        this.id = id
        this.date = date
        this.expireDate = expireDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(closeFriends, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeInt(date)
        writeInt(expireDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        closeFriends = isMask(256)
        id = readInt()
        date = readInt()
        expireDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryItemSkipped) return false
        if (other === this) return true

        return _flags == other._flags
                && closeFriends == other.closeFriends
                && id == other.id
                && date == other.date
                && expireDate == other.expireDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xffadc913.toInt()
    }
}
