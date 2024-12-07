package com.github.badoualy.telegram.tl.api

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
 * businessGreetingMessage#e519abab
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBusinessGreetingMessage() : TLObject() {
    var shortcutId: Int = 0

    var recipients: TLBusinessRecipients = TLBusinessRecipients()

    var noActivityDays: Int = 0

    private val _constructor: String = "businessGreetingMessage#e519abab"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            shortcutId: Int,
            recipients: TLBusinessRecipients,
            noActivityDays: Int
    ) : this() {
        this.shortcutId = shortcutId
        this.recipients = recipients
        this.noActivityDays = noActivityDays
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(shortcutId)
        writeTLObject(recipients)
        writeInt(noActivityDays)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        shortcutId = readInt()
        recipients = readTLObject<TLBusinessRecipients>(TLBusinessRecipients::class, TLBusinessRecipients.CONSTRUCTOR_ID)
        noActivityDays = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += recipients.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBusinessGreetingMessage) return false
        if (other === this) return true

        return shortcutId == other.shortcutId
                && recipients == other.recipients
                && noActivityDays == other.noActivityDays
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe519abab.toInt()
    }
}
