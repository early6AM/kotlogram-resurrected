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
 * reactionsNotifySettings#56e34970
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLReactionsNotifySettings() : TLObject() {
    var messagesNotifyFrom: TLAbsReactionNotificationsFrom? = null

    var storiesNotifyFrom: TLAbsReactionNotificationsFrom? = null

    var sound: TLAbsNotificationSound = TLNotificationSoundDefault()

    var showPreviews: Boolean = false

    private val _constructor: String = "reactionsNotifySettings#56e34970"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            messagesNotifyFrom: TLAbsReactionNotificationsFrom?,
            storiesNotifyFrom: TLAbsReactionNotificationsFrom?,
            sound: TLAbsNotificationSound,
            showPreviews: Boolean
    ) : this() {
        this.messagesNotifyFrom = messagesNotifyFrom
        this.storiesNotifyFrom = storiesNotifyFrom
        this.sound = sound
        this.showPreviews = showPreviews
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(messagesNotifyFrom, 1)
        updateFlags(storiesNotifyFrom, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, messagesNotifyFrom, 1) { writeTLObject(it) }
        doIfMask(1, storiesNotifyFrom, 2) { writeTLObject(it) }
        writeTLObject(sound)
        writeBoolean(showPreviews)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        messagesNotifyFrom = readIfMask(1, 1) { readTLObject<TLAbsReactionNotificationsFrom>() }
        storiesNotifyFrom = readIfMask(1, 2) { readTLObject<TLAbsReactionNotificationsFrom>() }
        sound = readTLObject<TLAbsNotificationSound>()
        showPreviews = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, messagesNotifyFrom, 1) { it.computeSerializedSize() }
        size += getIntIfMask(1, storiesNotifyFrom, 2) { it.computeSerializedSize() }
        size += sound.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLReactionsNotifySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && messagesNotifyFrom == other.messagesNotifyFrom
                && storiesNotifyFrom == other.storiesNotifyFrom
                && sound == other.sound
                && showPreviews == other.showPreviews
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x56e34970.toInt()
    }
}
