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
 * channelAdminLogEventActionChangeEmojiStatus#3ea9feb1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangeEmojiStatus() : TLAbsChannelAdminLogEventAction() {
    var prevValue: TLAbsEmojiStatus = TLEmojiStatusEmpty()

    var newValue: TLAbsEmojiStatus = TLEmojiStatusEmpty()

    private val _constructor: String = "channelAdminLogEventActionChangeEmojiStatus#3ea9feb1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevValue: TLAbsEmojiStatus, newValue: TLAbsEmojiStatus) : this() {
        this.prevValue = prevValue
        this.newValue = newValue
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevValue)
        writeTLObject(newValue)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevValue = readTLObject<TLAbsEmojiStatus>()
        newValue = readTLObject<TLAbsEmojiStatus>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevValue.computeSerializedSize()
        size += newValue.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangeEmojiStatus) return false
        if (other === this) return true

        return prevValue == other.prevValue
                && newValue == other.newValue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3ea9feb1.toInt()
    }
}
