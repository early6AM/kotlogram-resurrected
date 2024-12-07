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
import kotlin.jvm.Transient

/**
 * chatInviteImporter#8c5adfd9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInviteImporter() : TLObject() {
    @Transient
    var requested: Boolean = false

    @Transient
    var viaChatlist: Boolean = false

    var userId: Long = 0L

    var date: Int = 0

    var about: String? = null

    var approvedBy: Long? = null

    private val _constructor: String = "chatInviteImporter#8c5adfd9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            requested: Boolean,
            viaChatlist: Boolean,
            userId: Long,
            date: Int,
            about: String?,
            approvedBy: Long?
    ) : this() {
        this.requested = requested
        this.viaChatlist = viaChatlist
        this.userId = userId
        this.date = date
        this.about = about
        this.approvedBy = approvedBy
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(requested, 1)
        updateFlags(viaChatlist, 8)
        updateFlags(about, 4)
        updateFlags(approvedBy, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(userId)
        writeInt(date)
        doIfMask(1, about, 4) { writeString(it) }
        doIfMask(1, approvedBy, 2) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        requested = isMask(1, 1)
        viaChatlist = isMask(1, 8)
        userId = readLong()
        date = readInt()
        about = readIfMask(1, 4) { readString() }
        approvedBy = readIfMask(1, 2) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(1, about, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, approvedBy, 2) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInviteImporter) return false
        if (other === this) return true

        return _flags == other._flags
                && requested == other.requested
                && viaChatlist == other.viaChatlist
                && userId == other.userId
                && date == other.date
                && about == other.about
                && approvedBy == other.approvedBy
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c5adfd9.toInt()
    }
}
