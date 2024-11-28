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
import kotlin.jvm.Transient

/**
 * page#98657f0d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPage() : TLObject() {
    @Transient
    var part: Boolean = false

    @Transient
    var rtl: Boolean = false

    @Transient
    var v2: Boolean = false

    var url: String = ""

    var blocks: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    var photos: TLObjectVector<TLAbsPhoto> = TLObjectVector()

    var documents: TLObjectVector<TLAbsDocument> = TLObjectVector()

    var views: Int? = null

    private val _constructor: String = "page#98657f0d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            part: Boolean,
            rtl: Boolean,
            v2: Boolean,
            url: String,
            blocks: TLObjectVector<TLAbsPageBlock>,
            photos: TLObjectVector<TLAbsPhoto>,
            documents: TLObjectVector<TLAbsDocument>,
            views: Int?
    ) : this() {
        this.part = part
        this.rtl = rtl
        this.v2 = v2
        this.url = url
        this.blocks = blocks
        this.photos = photos
        this.documents = documents
        this.views = views
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(part, 1)
        updateFlags(rtl, 2)
        updateFlags(v2, 4)
        updateFlags(views, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
        writeTLVector(blocks)
        writeTLVector(photos)
        writeTLVector(documents)
        doIfMask(views, 8) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        part = isMask(1)
        rtl = isMask(2)
        v2 = isMask(4)
        url = readString()
        blocks = readTLVector<TLAbsPageBlock>()
        photos = readTLVector<TLAbsPhoto>()
        documents = readTLVector<TLAbsDocument>()
        views = readIfMask(8) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += blocks.computeSerializedSize()
        size += photos.computeSerializedSize()
        size += documents.computeSerializedSize()
        size += getIntIfMask(views, 8) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPage) return false
        if (other === this) return true

        return _flags == other._flags
                && part == other.part
                && rtl == other.rtl
                && v2 == other.v2
                && url == other.url
                && blocks == other.blocks
                && photos == other.photos
                && documents == other.documents
                && views == other.views
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98657f0d.toInt()
    }
}
