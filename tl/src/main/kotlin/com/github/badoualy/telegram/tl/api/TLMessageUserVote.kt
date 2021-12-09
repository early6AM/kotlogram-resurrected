package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageUserVote#34d247b4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageUserVote() : TLAbsMessageUserVote() {
    override var userId: Long = 0L

    var option: TLBytes = TLBytes.EMPTY

    override var date: Int = 0

    private val _constructor: String = "messageUserVote#34d247b4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            option: TLBytes,
            date: Int
    ) : this() {
        this.userId = userId
        this.option = option
        this.date = date
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeTLBytes(option)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        option = readTLBytes()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(option)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageUserVote) return false
        if (other === this) return true

        return userId == other.userId
                && option == other.option
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x34d247b4
    }
}
