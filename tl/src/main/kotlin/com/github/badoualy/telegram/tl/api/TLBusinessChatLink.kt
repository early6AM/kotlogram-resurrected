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
 * businessChatLink#b4ae666f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBusinessChatLink() : TLObject() {
    var link: String = ""

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var title: String? = null

    var views: Int = 0

    private val _constructor: String = "businessChatLink#b4ae666f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            link: String,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            title: String?,
            views: Int
    ) : this() {
        this.link = link
        this.message = message
        this.entities = entities
        this.title = title
        this.views = views
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(entities, 1)
        updateFlags(title, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(link)
        writeString(message)
        doIfMask(entities, 1) { writeTLVector(it) }
        doIfMask(title, 2) { writeString(it) }
        writeInt(views)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        link = readString()
        message = readString()
        entities = readIfMask(1) { readTLVector<TLAbsMessageEntity>() }
        title = readIfMask(2) { readString() }
        views = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(link)
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 1) { it.computeSerializedSize() }
        size += getIntIfMask(title, 2) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBusinessChatLink) return false
        if (other === this) return true

        return _flags == other._flags
                && link == other.link
                && message == other.message
                && entities == other.entities
                && title == other.title
                && views == other.views
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb4ae666f.toInt()
    }
}
