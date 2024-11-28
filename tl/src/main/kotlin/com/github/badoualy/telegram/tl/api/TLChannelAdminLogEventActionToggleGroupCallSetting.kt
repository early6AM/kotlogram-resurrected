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

/**
 * channelAdminLogEventActionToggleGroupCallSetting#56d6a247
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionToggleGroupCallSetting() : TLAbsChannelAdminLogEventAction() {
    var joinMuted: Boolean = false

    private val _constructor: String = "channelAdminLogEventActionToggleGroupCallSetting#56d6a247"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(joinMuted: Boolean) : this() {
        this.joinMuted = joinMuted
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeBoolean(joinMuted)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        joinMuted = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionToggleGroupCallSetting) return false
        if (other === this) return true

        return joinMuted == other.joinMuted
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x56d6a247.toInt()
    }
}
