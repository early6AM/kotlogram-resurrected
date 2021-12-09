package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * theme#e802b8dc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTheme() : TLObject() {
    @Transient
    var creator: Boolean = false

    @Transient
    var default: Boolean = false

    @Transient
    var forChat: Boolean = false

    var id: Long = 0L

    var accessHash: Long = 0L

    var slug: String = ""

    var title: String = ""

    var document: TLAbsDocument? = null

    var settings: TLThemeSettings? = null

    var installsCount: Int? = null

    private val _constructor: String = "theme#e802b8dc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            default: Boolean,
            forChat: Boolean,
            id: Long,
            accessHash: Long,
            slug: String,
            title: String,
            document: TLAbsDocument?,
            settings: TLThemeSettings?,
            installsCount: Int?
    ) : this() {
        this.creator = creator
        this.default = default
        this.forChat = forChat
        this.id = id
        this.accessHash = accessHash
        this.slug = slug
        this.title = title
        this.document = document
        this.settings = settings
        this.installsCount = installsCount
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(default, 2)
        updateFlags(forChat, 32)
        updateFlags(document, 4)
        updateFlags(settings, 8)
        updateFlags(installsCount, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeString(slug)
        writeString(title)
        doIfMask(document, 4) { writeTLObject(it) }
        doIfMask(settings, 8) { writeTLObject(it) }
        doIfMask(installsCount, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        default = isMask(2)
        forChat = isMask(32)
        id = readLong()
        accessHash = readLong()
        slug = readString()
        title = readString()
        document = readIfMask(4) { readTLObject<TLAbsDocument>() }
        settings = readIfMask(8) { readTLObject<TLThemeSettings>(TLThemeSettings::class, TLThemeSettings.CONSTRUCTOR_ID) }
        installsCount = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(slug)
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(document, 4) { it.computeSerializedSize() }
        size += getIntIfMask(settings, 8) { it.computeSerializedSize() }
        size += getIntIfMask(installsCount, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTheme) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && default == other.default
                && forChat == other.forChat
                && id == other.id
                && accessHash == other.accessHash
                && slug == other.slug
                && title == other.title
                && document == other.document
                && settings == other.settings
                && installsCount == other.installsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe802b8dc.toInt()
    }
}
