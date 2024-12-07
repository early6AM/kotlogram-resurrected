package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputBusinessChatLink#11679fa7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBusinessChatLink() : TLObject() {
    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var title: String? = null

    private val _constructor: String = "inputBusinessChatLink#11679fa7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            title: String?
    ) : this() {
        this.message = message
        this.entities = entities
        this.title = title
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(entities, 1)
        updateFlags(title, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(message)
        doIfMask(1, entities, 1) { writeTLVector(it) }
        doIfMask(1, title, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        message = readString()
        entities = readIfMask(1, 1) { readTLVector<TLAbsMessageEntity>() }
        title = readIfMask(1, 2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(1, entities, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, title, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBusinessChatLink) return false
        if (other === this) return true

        return _flags == other._flags
                && message == other.message
                && entities == other.entities
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x11679fa7.toInt()
    }
}
