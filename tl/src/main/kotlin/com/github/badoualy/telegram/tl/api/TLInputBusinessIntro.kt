package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputBusinessIntro#9c469cd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBusinessIntro() : TLObject() {
    var title: String = ""

    var description: String = ""

    var sticker: TLAbsInputDocument? = null

    private val _constructor: String = "inputBusinessIntro#9c469cd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            description: String,
            sticker: TLAbsInputDocument?
    ) : this() {
        this.title = title
        this.description = description
        this.sticker = sticker
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(sticker, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(1, sticker, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        description = readString()
        sticker = readIfMask(1, 1) { readTLObject<TLAbsInputDocument>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(1, sticker, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBusinessIntro) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && description == other.description
                && sticker == other.sticker
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9c469cd.toInt()
    }
}
