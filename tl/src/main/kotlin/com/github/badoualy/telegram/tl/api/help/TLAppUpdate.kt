package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * help.appUpdate#ccbbce30
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAppUpdate() : TLAbsAppUpdate() {
    @Transient
    var canNotSkip: Boolean = false

    var id: Int = 0

    var version: String = ""

    var text: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    var document: TLAbsDocument? = null

    var url: String? = null

    var sticker: TLAbsDocument? = null

    private val _constructor: String = "help.appUpdate#ccbbce30"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canNotSkip: Boolean,
            id: Int,
            version: String,
            text: String,
            entities: TLObjectVector<TLAbsMessageEntity>,
            document: TLAbsDocument?,
            url: String?,
            sticker: TLAbsDocument?
    ) : this() {
        this.canNotSkip = canNotSkip
        this.id = id
        this.version = version
        this.text = text
        this.entities = entities
        this.document = document
        this.url = url
        this.sticker = sticker
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(canNotSkip, 1)
        updateFlags(document, 2)
        updateFlags(url, 4)
        updateFlags(sticker, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(version)
        writeString(text)
        writeTLVector(entities)
        doIfMask(1, document, 2) { writeTLObject(it) }
        doIfMask(1, url, 4) { writeString(it) }
        doIfMask(1, sticker, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canNotSkip = isMask(1, 1)
        id = readInt()
        version = readString()
        text = readString()
        entities = readTLVector<TLAbsMessageEntity>()
        document = readIfMask(1, 2) { readTLObject<TLAbsDocument>() }
        url = readIfMask(1, 4) { readString() }
        sticker = readIfMask(1, 8) { readTLObject<TLAbsDocument>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(version)
        size += computeTLStringSerializedSize(text)
        size += entities.computeSerializedSize()
        size += getIntIfMask(1, document, 2) { it.computeSerializedSize() }
        size += getIntIfMask(1, url, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, sticker, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAppUpdate) return false
        if (other === this) return true

        return _flags == other._flags
                && canNotSkip == other.canNotSkip
                && id == other.id
                && version == other.version
                && text == other.text
                && entities == other.entities
                && document == other.document
                && url == other.url
                && sticker == other.sticker
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xccbbce30.toInt()
    }
}
