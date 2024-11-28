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
 * wallPaperNoFile#e0804116
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPaperNoFile() : TLAbsWallPaper() {
    override var id: Long = 0L

    @Transient
    override var default: Boolean = false

    @Transient
    override var dark: Boolean = false

    override var settings: TLWallPaperSettings? = null

    private val _constructor: String = "wallPaperNoFile#e0804116"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            default: Boolean,
            dark: Boolean,
            settings: TLWallPaperSettings?
    ) : this() {
        this.id = id
        this.default = default
        this.dark = dark
        this.settings = settings
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(default, 2)
        updateFlags(dark, 16)
        updateFlags(settings, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeLong(id)
        writeInt(_flags)
        doIfMask(settings, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        _flags = readInt()
        default = isMask(2)
        dark = isMask(16)
        settings = readIfMask(4) { readTLObject<TLWallPaperSettings>(TLWallPaperSettings::class, TLWallPaperSettings.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += getIntIfMask(settings, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPaperNoFile) return false
        if (other === this) return true

        return id == other.id
                && _flags == other._flags
                && default == other.default
                && dark == other.dark
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe0804116.toInt()
    }
}
