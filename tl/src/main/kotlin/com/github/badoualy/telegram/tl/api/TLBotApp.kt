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
 * botApp#95fcd1d6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotApp() : TLAbsBotApp() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var shortName: String = ""

    var title: String = ""

    var description: String = ""

    var photo: TLAbsPhoto = TLPhotoEmpty()

    var document: TLAbsDocument? = null

    var hash: Long = 0L

    private val _constructor: String = "botApp#95fcd1d6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            shortName: String,
            title: String,
            description: String,
            photo: TLAbsPhoto,
            document: TLAbsDocument?,
            hash: Long
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.shortName = shortName
        this.title = title
        this.description = description
        this.photo = photo
        this.document = document
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(document, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeString(shortName)
        writeString(title)
        writeString(description)
        writeTLObject(photo)
        doIfMask(document, 1) { writeTLObject(it) }
        writeLong(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readLong()
        accessHash = readLong()
        shortName = readString()
        title = readString()
        description = readString()
        photo = readTLObject<TLAbsPhoto>()
        document = readIfMask(1) { readTLObject<TLAbsDocument>() }
        hash = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(shortName)
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += photo.computeSerializedSize()
        size += getIntIfMask(document, 1) { it.computeSerializedSize() }
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotApp) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && accessHash == other.accessHash
                && shortName == other.shortName
                && title == other.title
                && description == other.description
                && photo == other.photo
                && document == other.document
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x95fcd1d6.toInt()
    }
}
