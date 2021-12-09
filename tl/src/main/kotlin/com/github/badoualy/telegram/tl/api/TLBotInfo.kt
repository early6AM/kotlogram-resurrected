package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * botInfo#1b74b335
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInfo() : TLObject() {
    var userId: Long = 0L

    var description: String = ""

    var commands: TLObjectVector<TLBotCommand> = TLObjectVector()

    private val _constructor: String = "botInfo#1b74b335"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long,
            description: String,
            commands: TLObjectVector<TLBotCommand>
    ) : this() {
        this.userId = userId
        this.description = description
        this.commands = commands
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(userId)
        writeString(description)
        writeTLVector(commands)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readLong()
        description = readString()
        commands = readTLVector<TLBotCommand>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLStringSerializedSize(description)
        size += commands.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInfo) return false
        if (other === this) return true

        return userId == other.userId
                && description == other.description
                && commands == other.commands
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1b74b335
    }
}
