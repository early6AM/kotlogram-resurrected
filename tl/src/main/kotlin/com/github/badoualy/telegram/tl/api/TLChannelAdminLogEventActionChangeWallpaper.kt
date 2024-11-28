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
 * channelAdminLogEventActionChangeWallpaper#31bb5d52
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangeWallpaper() : TLAbsChannelAdminLogEventAction() {
    var prevValue: TLAbsWallPaper = TLWallPaperNoFile()

    var newValue: TLAbsWallPaper = TLWallPaperNoFile()

    private val _constructor: String = "channelAdminLogEventActionChangeWallpaper#31bb5d52"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevValue: TLAbsWallPaper, newValue: TLAbsWallPaper) : this() {
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
        prevValue = readTLObject<TLAbsWallPaper>()
        newValue = readTLObject<TLAbsWallPaper>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevValue.computeSerializedSize()
        size += newValue.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangeWallpaper) return false
        if (other === this) return true

        return prevValue == other.prevValue
                && newValue == other.newValue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x31bb5d52.toInt()
    }
}
