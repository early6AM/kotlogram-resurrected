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
 * messageActionSetChatWallPaper#5060a3f4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionSetChatWallPaper() : TLAbsMessageAction() {
    @Transient
    var same: Boolean = false

    @Transient
    var forBoth: Boolean = false

    var wallpaper: TLAbsWallPaper = TLWallPaperNoFile()

    private val _constructor: String = "messageActionSetChatWallPaper#5060a3f4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            same: Boolean,
            forBoth: Boolean,
            wallpaper: TLAbsWallPaper
    ) : this() {
        this.same = same
        this.forBoth = forBoth
        this.wallpaper = wallpaper
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(same, 1)
        updateFlags(forBoth, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(wallpaper)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        same = isMask(1)
        forBoth = isMask(2)
        wallpaper = readTLObject<TLAbsWallPaper>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += wallpaper.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionSetChatWallPaper) return false
        if (other === this) return true

        return _flags == other._flags
                && same == other.same
                && forBoth == other.forBoth
                && wallpaper == other.wallpaper
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5060a3f4.toInt()
    }
}
