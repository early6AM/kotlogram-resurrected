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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * statsGroupTopAdmin#d7584c87
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStatsGroupTopAdmin() : TLObject() {
    var userId: Long = 0L

    var deleted: Int = 0

    var kicked: Int = 0

    var banned: Int = 0

    private val _constructor: String = "statsGroupTopAdmin#d7584c87"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            deleted: Int,
            kicked: Int,
            banned: Int
    ) : this() {
        this.userId = userId
        this.deleted = deleted
        this.kicked = kicked
        this.banned = banned
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeInt(deleted)
        writeInt(kicked)
        writeInt(banned)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        deleted = readInt()
        kicked = readInt()
        banned = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStatsGroupTopAdmin) return false
        if (other === this) return true

        return userId == other.userId
                && deleted == other.deleted
                && kicked == other.kicked
                && banned == other.banned
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd7584c87.toInt()
    }
}
