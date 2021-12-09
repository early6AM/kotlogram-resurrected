package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionChangeHistoryTTL#6e941a38
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangeHistoryTTL() : TLAbsChannelAdminLogEventAction() {
    var prevValue: Int = 0

    var newValue: Int = 0

    private val _constructor: String = "channelAdminLogEventActionChangeHistoryTTL#6e941a38"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevValue: Int, newValue: Int) : this() {
        this.prevValue = prevValue
        this.newValue = newValue
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(prevValue)
        writeInt(newValue)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevValue = readInt()
        newValue = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangeHistoryTTL) return false
        if (other === this) return true

        return prevValue == other.prevValue
                && newValue == other.newValue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6e941a38
    }
}
