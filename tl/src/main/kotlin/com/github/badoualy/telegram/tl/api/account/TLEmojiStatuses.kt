package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEmojiStatus
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

/**
 * account.emojiStatuses#90c467d1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEmojiStatuses() : TLAbsEmojiStatuses() {
    var hash: Long = 0L

    var statuses: TLObjectVector<TLAbsEmojiStatus> = TLObjectVector()

    private val _constructor: String = "account.emojiStatuses#90c467d1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Long, statuses: TLObjectVector<TLAbsEmojiStatus>) : this() {
        this.hash = hash
        this.statuses = statuses
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeTLVector(statuses)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        statuses = readTLVector<TLAbsEmojiStatus>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += statuses.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEmojiStatuses) return false
        if (other === this) return true

        return hash == other.hash
                && statuses == other.statuses
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x90c467d1.toInt()
    }
}
