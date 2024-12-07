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
import kotlin.jvm.Transient

/**
 * inputBusinessAwayMessage#832175e0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBusinessAwayMessage() : TLObject() {
    @Transient
    var offlineOnly: Boolean = false

    var shortcutId: Int = 0

    var schedule: TLAbsBusinessAwayMessageSchedule = TLBusinessAwayMessageScheduleAlways()

    var recipients: TLInputBusinessRecipients = TLInputBusinessRecipients()

    private val _constructor: String = "inputBusinessAwayMessage#832175e0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            offlineOnly: Boolean,
            shortcutId: Int,
            schedule: TLAbsBusinessAwayMessageSchedule,
            recipients: TLInputBusinessRecipients
    ) : this() {
        this.offlineOnly = offlineOnly
        this.shortcutId = shortcutId
        this.schedule = schedule
        this.recipients = recipients
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(offlineOnly, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(shortcutId)
        writeTLObject(schedule)
        writeTLObject(recipients)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        offlineOnly = isMask(1)
        shortcutId = readInt()
        schedule = readTLObject<TLAbsBusinessAwayMessageSchedule>()
        recipients = readTLObject<TLInputBusinessRecipients>(TLInputBusinessRecipients::class, TLInputBusinessRecipients.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += schedule.computeSerializedSize()
        size += recipients.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBusinessAwayMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && offlineOnly == other.offlineOnly
                && shortcutId == other.shortcutId
                && schedule == other.schedule
                && recipients == other.recipients
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x832175e0.toInt()
    }
}
