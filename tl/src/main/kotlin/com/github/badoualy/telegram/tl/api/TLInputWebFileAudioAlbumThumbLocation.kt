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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * inputWebFileAudioAlbumThumbLocation#f46fe924
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputWebFileAudioAlbumThumbLocation() : TLAbsInputWebFileLocation() {
    @Transient
    var small: Boolean = false

    var document: TLAbsInputDocument? = null

    var title: String? = null

    var performer: String? = null

    private val _constructor: String = "inputWebFileAudioAlbumThumbLocation#f46fe924"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            small: Boolean,
            document: TLAbsInputDocument?,
            title: String?,
            performer: String?
    ) : this() {
        this.small = small
        this.document = document
        this.title = title
        this.performer = performer
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(small, 4)
        updateFlags(document, 1)
        updateFlags(title, 2)
        updateFlags(performer, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, document, 1) { writeTLObject(it) }
        doIfMask(1, title, 2) { writeString(it) }
        doIfMask(1, performer, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        small = isMask(1, 4)
        document = readIfMask(1, 1) { readTLObject<TLAbsInputDocument>() }
        title = readIfMask(1, 2) { readString() }
        performer = readIfMask(1, 2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, document, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, title, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(1, performer, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputWebFileAudioAlbumThumbLocation) return false
        if (other === this) return true

        return _flags == other._flags
                && small == other.small
                && document == other.document
                && title == other.title
                && performer == other.performer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf46fe924.toInt()
    }
}
