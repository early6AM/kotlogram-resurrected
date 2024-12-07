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
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * mediaAreaWeather#49a6549c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMediaAreaWeather() : TLAbsMediaArea() {
    override var coordinates: TLMediaAreaCoordinates = TLMediaAreaCoordinates()

    var emoji: String = ""

    var temperatureC: Double = 0.0

    var color: Int = 0

    private val _constructor: String = "mediaAreaWeather#49a6549c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            coordinates: TLMediaAreaCoordinates,
            emoji: String,
            temperatureC: Double,
            color: Int
    ) : this() {
        this.coordinates = coordinates
        this.emoji = emoji
        this.temperatureC = temperatureC
        this.color = color
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(coordinates)
        writeString(emoji)
        writeDouble(temperatureC)
        writeInt(color)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        coordinates = readTLObject<TLMediaAreaCoordinates>(TLMediaAreaCoordinates::class, TLMediaAreaCoordinates.CONSTRUCTOR_ID)
        emoji = readString()
        temperatureC = readDouble()
        color = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += coordinates.computeSerializedSize()
        size += computeTLStringSerializedSize(emoji)
        size += SIZE_DOUBLE
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMediaAreaWeather) return false
        if (other === this) return true

        return coordinates == other.coordinates
                && emoji == other.emoji
                && temperatureC == other.temperatureC
                && color == other.color
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x49a6549c.toInt()
    }
}
