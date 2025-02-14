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
import kotlin.jvm.Transient

/**
 * wallPaper#a437c3ed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPaper() : TLAbsWallPaper() {
    override var id: Long = 0L

    @Transient
    var creator: Boolean = false

    @Transient
    override var default: Boolean = false

    @Transient
    var pattern: Boolean = false

    @Transient
    override var dark: Boolean = false

    var accessHash: Long = 0L

    var slug: String = ""

    var document: TLAbsDocument = TLDocumentEmpty()

    override var settings: TLWallPaperSettings? = null

    private val _constructor: String = "wallPaper#a437c3ed"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            creator: Boolean,
            default: Boolean,
            pattern: Boolean,
            dark: Boolean,
            accessHash: Long,
            slug: String,
            document: TLAbsDocument,
            settings: TLWallPaperSettings?
    ) : this() {
        this.id = id
        this.creator = creator
        this.default = default
        this.pattern = pattern
        this.dark = dark
        this.accessHash = accessHash
        this.slug = slug
        this.document = document
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(default, 2)
        updateFlags(pattern, 8)
        updateFlags(dark, 16)
        updateFlags(settings, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeLong(id)
        writeInt(_flags)
        writeLong(accessHash)
        writeString(slug)
        writeTLObject(document)
        doIfMask(settings, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        _flags = readInt()
        creator = isMask(1)
        default = isMask(2)
        pattern = isMask(8)
        dark = isMask(16)
        accessHash = readLong()
        slug = readString()
        document = readTLObject<TLAbsDocument>()
        settings = readIfMask(4) { readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(slug)
        size += document.computeSerializedSize()
        size += getIntIfMask(settings, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPaper) return false
        if (other === this) return true

        return id == other.id
                && _flags == other._flags
                && creator == other.creator
                && default == other.default
                && pattern == other.pattern
                && dark == other.dark
                && accessHash == other.accessHash
                && slug == other.slug
                && document == other.document
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa437c3ed.toInt()
    }
}
