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
 * updateUserEmojiStatus#28373599
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateUserEmojiStatus() : TLAbsUpdate() {
    var userId: Long = 0L

    var emojiStatus: TLAbsEmojiStatus = TLEmojiStatusEmpty()

    private val _constructor: String = "updateUserEmojiStatus#28373599"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Long, emojiStatus: TLAbsEmojiStatus) : this() {
        this.userId = userId
        this.emojiStatus = emojiStatus
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeTLObject(emojiStatus)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        emojiStatus = readTLObject<TLAbsEmojiStatus>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += emojiStatus.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateUserEmojiStatus) return false
        if (other === this) return true

        return userId == other.userId
                && emojiStatus == other.emojiStatus
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x28373599.toInt()
    }
}
