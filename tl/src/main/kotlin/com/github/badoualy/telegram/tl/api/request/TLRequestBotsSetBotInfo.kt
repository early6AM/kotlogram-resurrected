package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestBotsSetBotInfo() : TLMethod<TLBool>() {
    var bot: TLAbsInputUser? = null

    var langCode: String = ""

    var name: String? = null

    var about: String? = null

    var description: String? = null

    private val _constructor: String = "bots.setBotInfo#10cf3123"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            bot: TLAbsInputUser?,
            langCode: String,
            name: String?,
            about: String?,
            description: String?
    ) : this() {
        this.bot = bot
        this.langCode = langCode
        this.name = name
        this.about = about
        this.description = description
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(bot, 4)
        updateFlags(name, 8)
        updateFlags(about, 1)
        updateFlags(description, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(bot, 4) { writeTLObject(it) }
        writeString(langCode)
        doIfMask(name, 8) { writeString(it) }
        doIfMask(about, 1) { writeString(it) }
        doIfMask(description, 2) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        bot = readIfMask(4) { readTLObject<TLAbsInputUser>() }
        langCode = readString()
        name = readIfMask(8) { readString() }
        about = readIfMask(1) { readString() }
        description = readIfMask(2) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(bot, 4) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(langCode)
        size += getIntIfMask(name, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(about, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(description, 2) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestBotsSetBotInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && bot == other.bot
                && langCode == other.langCode
                && name == other.name
                && about == other.about
                && description == other.description
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x10cf3123.toInt()
    }
}
