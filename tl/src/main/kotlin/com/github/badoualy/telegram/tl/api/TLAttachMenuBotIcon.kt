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
 * attachMenuBotIcon#b2a7386b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAttachMenuBotIcon() : TLObject() {
    var name: String = ""

    var icon: TLAbsDocument = TLDocumentEmpty()

    var colors: TLObjectVector<TLAttachMenuBotIconColor>? = TLObjectVector()

    private val _constructor: String = "attachMenuBotIcon#b2a7386b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            name: String,
            icon: TLAbsDocument,
            colors: TLObjectVector<TLAttachMenuBotIconColor>?
    ) : this() {
        this.name = name
        this.icon = icon
        this.colors = colors
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(colors, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(name)
        writeTLObject(icon)
        doIfMask(colors, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        name = readString()
        icon = readTLObject<TLAbsDocument>()
        colors = readIfMask(1) { readTLVector<TLAttachMenuBotIconColor>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(name)
        size += icon.computeSerializedSize()
        size += getIntIfMask(colors, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAttachMenuBotIcon) return false
        if (other === this) return true

        return _flags == other._flags
                && name == other.name
                && icon == other.icon
                && colors == other.colors
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb2a7386b.toInt()
    }
}
