package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputBotInlineMessageID64#b6d915d7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineMessageID64() : TLAbsInputBotInlineMessageID() {
    override var dcId: Int = 0

    var ownerId: Long = 0L

    var id: Int = 0

    override var accessHash: Long = 0L

    private val _constructor: String = "inputBotInlineMessageID64#b6d915d7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dcId: Int,
            ownerId: Long,
            id: Int,
            accessHash: Long
    ) : this() {
        this.dcId = dcId
        this.ownerId = ownerId
        this.id = id
        this.accessHash = accessHash
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(dcId)
        writeLong(ownerId)
        writeInt(id)
        writeLong(accessHash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        dcId = readInt()
        ownerId = readLong()
        id = readInt()
        accessHash = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineMessageID64) return false
        if (other === this) return true

        return dcId == other.dcId
                && ownerId == other.ownerId
                && id == other.id
                && accessHash == other.accessHash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb6d915d7.toInt()
    }
}
