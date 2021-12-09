package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageUserVoteMultiple#8a65e557
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageUserVoteMultiple() : TLAbsMessageUserVote() {
    override var userId: Long = 0L

    var options: TLBytesVector = TLBytesVector()

    override var date: Int = 0

    private val _constructor: String = "messageUserVoteMultiple#8a65e557"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            options: TLBytesVector,
            date: Int
    ) : this() {
        this.userId = userId
        this.options = options
        this.date = date
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeTLVector(options)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        options = readTLBytesVector()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += options.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageUserVoteMultiple) return false
        if (other === this) return true

        return userId == other.userId
                && options == other.options
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8a65e557.toInt()
    }
}
