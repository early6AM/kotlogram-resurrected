package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMessageCallbackQuery#acfa1a7e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessageCallbackQuery() : TLAbsInputMessage() {
    var id: Int = 0

    var queryId: Long = 0L

    private val _constructor: String = "inputMessageCallbackQuery#acfa1a7e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: Int, queryId: Long) : this() {
        this.id = id
        this.queryId = queryId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeLong(queryId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        queryId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessageCallbackQuery) return false
        if (other === this) return true

        return id == other.id
                && queryId == other.queryId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xacfa1a7e.toInt()
    }
}
