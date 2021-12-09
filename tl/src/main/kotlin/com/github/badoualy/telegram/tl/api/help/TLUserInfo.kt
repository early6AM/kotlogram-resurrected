package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * help.userInfo#1eb3758
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserInfo() : TLAbsUserInfo() {
    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    var author: String = ""

    var date: Int = 0

    private val _constructor: String = "help.userInfo#1eb3758"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>,
            author: String,
            date: Int
    ) : this() {
        this.message = message
        this.entities = entities
        this.author = author
        this.date = date
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(message)
        writeTLVector(entities)
        writeString(author)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        message = readString()
        entities = readTLVector<TLAbsMessageEntity>()
        author = readString()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(message)
        size += entities.computeSerializedSize()
        size += computeTLStringSerializedSize(author)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserInfo) return false
        if (other === this) return true

        return message == other.message
                && entities == other.entities
                && author == other.author
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1eb3758
    }
}
