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
 * quickReply#697102b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLQuickReply() : TLObject() {
    var shortcutId: Int = 0

    var shortcut: String = ""

    var topMessage: Int = 0

    var count: Int = 0

    private val _constructor: String = "quickReply#697102b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            shortcutId: Int,
            shortcut: String,
            topMessage: Int,
            count: Int
    ) : this() {
        this.shortcutId = shortcutId
        this.shortcut = shortcut
        this.topMessage = topMessage
        this.count = count
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(shortcutId)
        writeString(shortcut)
        writeInt(topMessage)
        writeInt(count)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        shortcutId = readInt()
        shortcut = readString()
        topMessage = readInt()
        count = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(shortcut)
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLQuickReply) return false
        if (other === this) return true

        return shortcutId == other.shortcutId
                && shortcut == other.shortcut
                && topMessage == other.topMessage
                && count == other.count
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x697102b.toInt()
    }
}
