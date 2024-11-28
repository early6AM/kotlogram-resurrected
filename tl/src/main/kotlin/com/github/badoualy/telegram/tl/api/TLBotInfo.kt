package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * botInfo#8f300b57
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInfo() : TLObject() {
    var userId: Long? = null

    var description: String? = null

    var descriptionPhoto: TLAbsPhoto? = null

    var descriptionDocument: TLAbsDocument? = null

    var commands: TLObjectVector<TLBotCommand>? = TLObjectVector()

    var menuButton: TLAbsBotMenuButton? = null

    private val _constructor: String = "botInfo#8f300b57"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Long?,
            description: String?,
            descriptionPhoto: TLAbsPhoto?,
            descriptionDocument: TLAbsDocument?,
            commands: TLObjectVector<TLBotCommand>?,
            menuButton: TLAbsBotMenuButton?
    ) : this() {
        this.userId = userId
        this.description = description
        this.descriptionPhoto = descriptionPhoto
        this.descriptionDocument = descriptionDocument
        this.commands = commands
        this.menuButton = menuButton
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(userId, 1)
        updateFlags(description, 2)
        updateFlags(descriptionPhoto, 16)
        updateFlags(descriptionDocument, 32)
        updateFlags(commands, 4)
        updateFlags(menuButton, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(userId, 1) { writeLong(it) }
        doIfMask(description, 2) { writeString(it) }
        doIfMask(descriptionPhoto, 16) { writeTLObject(it) }
        doIfMask(descriptionDocument, 32) { writeTLObject(it) }
        doIfMask(commands, 4) { writeTLVector(it) }
        doIfMask(menuButton, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userId = readIfMask(1) { readLong() }
        description = readIfMask(2) { readString() }
        descriptionPhoto = readIfMask(16) { readTLObject<TLAbsPhoto>() }
        descriptionDocument = readIfMask(32) { readTLObject<TLAbsDocument>() }
        commands = readIfMask(4) { readTLVector<TLBotCommand>() }
        menuButton = readIfMask(8) { readTLObject<TLAbsBotMenuButton>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(userId, 1) { SIZE_INT64 }
        size += getIntIfMask(description, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(descriptionPhoto, 16) { it.computeSerializedSize() }
        size += getIntIfMask(descriptionDocument, 32) { it.computeSerializedSize() }
        size += getIntIfMask(commands, 4) { it.computeSerializedSize() }
        size += getIntIfMask(menuButton, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && userId == other.userId
                && description == other.description
                && descriptionPhoto == other.descriptionPhoto
                && descriptionDocument == other.descriptionDocument
                && commands == other.commands
                && menuButton == other.menuButton
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8f300b57.toInt()
    }
}
