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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * theme#a00e67d6
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

    var settings: TLObjectVector<TLThemeSettings>? = TLObjectVector()

    var emoticon: String? = null

    var installsCount: Int? = null

    private val _constructor: String = "theme#a00e67d6"

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
            settings: TLObjectVector<TLThemeSettings>?,
            emoticon: String?,
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
        this.emoticon = emoticon
        this.installsCount = installsCount
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(creator, 1)
        updateFlags(default, 2)
        updateFlags(forChat, 32)
        updateFlags(document, 4)
        updateFlags(settings, 8)
        updateFlags(emoticon, 64)
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
        doIfMask(1, document, 4) { writeTLObject(it) }
        doIfMask(1, settings, 8) { writeTLVector(it) }
        doIfMask(1, emoticon, 64) { writeString(it) }
        doIfMask(1, installsCount, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1, 1)
        default = isMask(1, 2)
        forChat = isMask(1, 32)
        id = readLong()
        accessHash = readLong()
        slug = readString()
        title = readString()
        document = readIfMask(1, 4) { readTLObject<TLAbsDocument>() }
        settings = readIfMask(1, 8) { readTLVector<TLThemeSettings>() }
        emoticon = readIfMask(1, 64) { readString() }
        installsCount = readIfMask(1, 16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(slug)
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(1, document, 4) { it.computeSerializedSize() }
        size += getIntIfMask(1, settings, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, emoticon, 64) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, installsCount, 16) { SIZE_INT32 }
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
                && emoticon == other.emoticon
                && installsCount == other.installsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa00e67d6.toInt()
    }
}
