package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStickerSetCovered
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messages.featuredStickers#be382906
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFeaturedStickers() : TLAbsFeaturedStickers() {
    @Transient
    var premium: Boolean = false

    var hash: Long = 0L

    override var count: Int = 0

    var sets: TLObjectVector<TLAbsStickerSetCovered> = TLObjectVector()

    var unread: TLLongVector = TLLongVector()

    private val _constructor: String = "messages.featuredStickers#be382906"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            premium: Boolean,
            hash: Long,
            count: Int,
            sets: TLObjectVector<TLAbsStickerSetCovered>,
            unread: TLLongVector
    ) : this() {
        this.premium = premium
        this.hash = hash
        this.count = count
        this.sets = sets
        this.unread = unread
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(premium, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(hash)
        writeInt(count)
        writeTLVector(sets)
        writeTLVector(unread)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        premium = isMask(1)
        hash = readLong()
        count = readInt()
        sets = readTLVector<TLAbsStickerSetCovered>()
        unread = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += sets.computeSerializedSize()
        size += unread.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFeaturedStickers) return false
        if (other === this) return true

        return _flags == other._flags
                && premium == other.premium
                && hash == other.hash
                && count == other.count
                && sets == other.sets
                && unread == other.unread
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbe382906.toInt()
    }
}
