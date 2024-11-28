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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateBotStopped#c4870a49
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotStopped() : TLAbsUpdate() {
    var userId: Long = 0L

    var date: Int = 0

    var stopped: Boolean = false

    var qts: Int = 0

    private val _constructor: String = "updateBotStopped#c4870a49"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            date: Int,
            stopped: Boolean,
            qts: Int
    ) : this() {
        this.userId = userId
        this.date = date
        this.stopped = stopped
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeInt(date)
        writeBoolean(stopped)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        date = readInt()
        stopped = readBoolean()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotStopped) return false
        if (other === this) return true

        return userId == other.userId
                && date == other.date
                && stopped == other.stopped
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc4870a49.toInt()
    }
}
