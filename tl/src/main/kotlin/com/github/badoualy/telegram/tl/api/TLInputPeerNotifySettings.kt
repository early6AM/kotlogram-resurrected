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
 * inputPeerNotifySettings#cacb6ae2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPeerNotifySettings() : TLObject() {
    var showPreviews: Boolean? = null

    var silent: Boolean? = null

    var muteUntil: Int? = null

    var sound: TLAbsNotificationSound? = null

    var storiesMuted: Boolean? = null

    var storiesHideSender: Boolean? = null

    var storiesSound: TLAbsNotificationSound? = null

    private val _constructor: String = "inputPeerNotifySettings#cacb6ae2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            showPreviews: Boolean?,
            silent: Boolean?,
            muteUntil: Int?,
            sound: TLAbsNotificationSound?,
            storiesMuted: Boolean?,
            storiesHideSender: Boolean?,
            storiesSound: TLAbsNotificationSound?
    ) : this() {
        this.showPreviews = showPreviews
        this.silent = silent
        this.muteUntil = muteUntil
        this.sound = sound
        this.storiesMuted = storiesMuted
        this.storiesHideSender = storiesHideSender
        this.storiesSound = storiesSound
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(showPreviews, 1)
        updateFlags(silent, 2)
        updateFlags(muteUntil, 4)
        updateFlags(sound, 8)
        updateFlags(storiesMuted, 64)
        updateFlags(storiesHideSender, 128)
        updateFlags(storiesSound, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(showPreviews, 1) { writeBoolean(it) }
        doIfMask(silent, 2) { writeBoolean(it) }
        doIfMask(muteUntil, 4) { writeInt(it) }
        doIfMask(sound, 8) { writeTLObject(it) }
        doIfMask(storiesMuted, 64) { writeBoolean(it) }
        doIfMask(storiesHideSender, 128) { writeBoolean(it) }
        doIfMask(storiesSound, 256) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        showPreviews = readIfMask(1) { readBoolean() }
        silent = readIfMask(2) { readBoolean() }
        muteUntil = readIfMask(4) { readInt() }
        sound = readIfMask(8) { readTLObject<TLAbsNotificationSound>() }
        storiesMuted = readIfMask(64) { readBoolean() }
        storiesHideSender = readIfMask(128) { readBoolean() }
        storiesSound = readIfMask(256) { readTLObject<TLAbsNotificationSound>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(showPreviews, 1) { SIZE_BOOLEAN }
        size += getIntIfMask(silent, 2) { SIZE_BOOLEAN }
        size += getIntIfMask(muteUntil, 4) { SIZE_INT32 }
        size += getIntIfMask(sound, 8) { it.computeSerializedSize() }
        size += getIntIfMask(storiesMuted, 64) { SIZE_BOOLEAN }
        size += getIntIfMask(storiesHideSender, 128) { SIZE_BOOLEAN }
        size += getIntIfMask(storiesSound, 256) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPeerNotifySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && showPreviews == other.showPreviews
                && silent == other.silent
                && muteUntil == other.muteUntil
                && sound == other.sound
                && storiesMuted == other.storiesMuted
                && storiesHideSender == other.storiesHideSender
                && storiesSound == other.storiesSound
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcacb6ae2.toInt()
    }
}
