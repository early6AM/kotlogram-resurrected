package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * highScore#73a379eb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLHighScore() : TLObject() {
    var pos: Int = 0

    var userId: Long = 0L

    var score: Int = 0

    private val _constructor: String = "highScore#73a379eb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pos: Int,
            userId: Long,
            score: Int
    ) : this() {
        this.pos = pos
        this.userId = userId
        this.score = score
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(pos)
        writeLong(userId)
        writeInt(score)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pos = readInt()
        userId = readLong()
        score = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLHighScore) return false
        if (other === this) return true

        return pos == other.pos
                && userId == other.userId
                && score == other.score
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x73a379eb
    }
}
