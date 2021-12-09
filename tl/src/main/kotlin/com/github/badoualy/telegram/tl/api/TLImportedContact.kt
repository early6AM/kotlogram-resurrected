package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * importedContact#c13e3c50
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLImportedContact() : TLObject() {
    var userId: Long = 0L

    var clientId: Long = 0L

    private val _constructor: String = "importedContact#c13e3c50"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Long, clientId: Long) : this() {
        this.userId = userId
        this.clientId = clientId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeLong(clientId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        clientId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLImportedContact) return false
        if (other === this) return true

        return userId == other.userId
                && clientId == other.clientId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc13e3c50.toInt()
    }
}
