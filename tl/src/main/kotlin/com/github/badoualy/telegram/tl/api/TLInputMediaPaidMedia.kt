package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputMediaPaidMedia#aa661fc3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaPaidMedia() : TLAbsInputMedia() {
    var starsAmount: Long = 0L

    var extendedMedia: TLObjectVector<TLAbsInputMedia> = TLObjectVector()

    private val _constructor: String = "inputMediaPaidMedia#aa661fc3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(starsAmount: Long, extendedMedia: TLObjectVector<TLAbsInputMedia>) : this() {
        this.starsAmount = starsAmount
        this.extendedMedia = extendedMedia
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(starsAmount)
        writeTLVector(extendedMedia)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        starsAmount = readLong()
        extendedMedia = readTLVector<TLAbsInputMedia>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += extendedMedia.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaPaidMedia) return false
        if (other === this) return true

        return starsAmount == other.starsAmount
                && extendedMedia == other.extendedMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaa661fc3.toInt()
    }
}
