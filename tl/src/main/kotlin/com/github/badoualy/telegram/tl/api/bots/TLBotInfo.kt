package com.github.badoualy.telegram.tl.api.bots

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
 * bots.botInfo#e8a775b0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInfo() : TLObject() {
    var name: String = ""

    var about: String = ""

    var description: String = ""

    private val _constructor: String = "bots.botInfo#e8a775b0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            name: String,
            about: String,
            description: String
    ) : this() {
        this.name = name
        this.about = about
        this.description = description
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(name)
        writeString(about)
        writeString(description)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        name = readString()
        about = readString()
        description = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(name)
        size += computeTLStringSerializedSize(about)
        size += computeTLStringSerializedSize(description)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInfo) return false
        if (other === this) return true

        return name == other.name
                && about == other.about
                && description == other.description
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe8a775b0.toInt()
    }
}
