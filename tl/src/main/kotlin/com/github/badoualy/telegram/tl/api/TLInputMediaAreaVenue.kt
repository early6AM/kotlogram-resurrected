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

/**
 * inputMediaAreaVenue#b282217f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaAreaVenue() : TLAbsMediaArea() {
    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var queryId: Long = 0L

    var resultId: String = ""

    private val _constructor: String = "inputMediaAreaVenue#b282217f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            coordinates: TLMediaAreaCoordinates,
            queryId: Long,
            resultId: String
    ) : this() {
        this.coordinates = coordinates
        this.queryId = queryId
        this.resultId = resultId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(coordinates)
        writeLong(queryId)
        writeString(resultId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        queryId = readLong()
        resultId = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += coordinates.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLStringSerializedSize(resultId)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaAreaVenue) return false
        if (other === this) return true

        return coordinates == other.coordinates
                && queryId == other.queryId
                && resultId == other.resultId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb282217f.toInt()
    }
}
