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
 * updateBotMenuButton#14b85813
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotMenuButton() : TLAbsUpdate() {
    var botId: Long = 0L

    var button: TLAbsBotMenuButton = TLBotMenuButtonDefault()

    private val _constructor: String = "updateBotMenuButton#14b85813"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(botId: Long, button: TLAbsBotMenuButton) : this() {
        this.botId = botId
        this.button = button
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(botId)
        writeTLObject(button)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        botId = readLong()
        button = readTLObject<TLAbsBotMenuButton>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += button.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotMenuButton) return false
        if (other === this) return true

        return botId == other.botId
                && button == other.button
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x14b85813.toInt()
    }
}
