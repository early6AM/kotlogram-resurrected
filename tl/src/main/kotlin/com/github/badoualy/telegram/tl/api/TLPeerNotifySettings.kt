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
 * peerNotifySettings#99622c0c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerNotifySettings() : TLObject() {
    var showPreviews: Boolean? = null

    var silent: Boolean? = null

    var muteUntil: Int? = null

    var iosSound: TLAbsNotificationSound? = null

    var androidSound: TLAbsNotificationSound? = null

    var otherSound: TLAbsNotificationSound? = null

    var storiesMuted: Boolean? = null

    var storiesHideSender: Boolean? = null

    var storiesIosSound: TLAbsNotificationSound? = null

    var storiesAndroidSound: TLAbsNotificationSound? = null

    var storiesOtherSound: TLAbsNotificationSound? = null

    private val _constructor: String = "peerNotifySettings#99622c0c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            showPreviews: Boolean?,
            silent: Boolean?,
            muteUntil: Int?,
            iosSound: TLAbsNotificationSound?,
            androidSound: TLAbsNotificationSound?,
            otherSound: TLAbsNotificationSound?,
            storiesMuted: Boolean?,
            storiesHideSender: Boolean?,
            storiesIosSound: TLAbsNotificationSound?,
            storiesAndroidSound: TLAbsNotificationSound?,
            storiesOtherSound: TLAbsNotificationSound?
    ) : this() {
        this.showPreviews = showPreviews
        this.silent = silent
        this.muteUntil = muteUntil
        this.iosSound = iosSound
        this.androidSound = androidSound
        this.otherSound = otherSound
        this.storiesMuted = storiesMuted
        this.storiesHideSender = storiesHideSender
        this.storiesIosSound = storiesIosSound
        this.storiesAndroidSound = storiesAndroidSound
        this.storiesOtherSound = storiesOtherSound
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(showPreviews, 1)
        updateFlags(silent, 2)
        updateFlags(muteUntil, 4)
        updateFlags(iosSound, 8)
        updateFlags(androidSound, 16)
        updateFlags(otherSound, 32)
        updateFlags(storiesMuted, 64)
        updateFlags(storiesHideSender, 128)
        updateFlags(storiesIosSound, 256)
        updateFlags(storiesAndroidSound, 512)
        updateFlags(storiesOtherSound, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, showPreviews, 1) { writeBoolean(it) }
        doIfMask(1, silent, 2) { writeBoolean(it) }
        doIfMask(1, muteUntil, 4) { writeInt(it) }
        doIfMask(1, iosSound, 8) { writeTLObject(it) }
        doIfMask(1, androidSound, 16) { writeTLObject(it) }
        doIfMask(1, otherSound, 32) { writeTLObject(it) }
        doIfMask(1, storiesMuted, 64) { writeBoolean(it) }
        doIfMask(1, storiesHideSender, 128) { writeBoolean(it) }
        doIfMask(1, storiesIosSound, 256) { writeTLObject(it) }
        doIfMask(1, storiesAndroidSound, 512) { writeTLObject(it) }
        doIfMask(1, storiesOtherSound, 1024) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        showPreviews = readIfMask(1, 1) { readBoolean() }
        silent = readIfMask(1, 2) { readBoolean() }
        muteUntil = readIfMask(1, 4) { readInt() }
        iosSound = readIfMask(1, 8) { readTLObject<TLAbsNotificationSound>() }
        androidSound = readIfMask(1, 16) { readTLObject<TLAbsNotificationSound>() }
        otherSound = readIfMask(1, 32) { readTLObject<TLAbsNotificationSound>() }
        storiesMuted = readIfMask(1, 64) { readBoolean() }
        storiesHideSender = readIfMask(1, 128) { readBoolean() }
        storiesIosSound = readIfMask(1, 256) { readTLObject<TLAbsNotificationSound>() }
        storiesAndroidSound = readIfMask(1, 512) { readTLObject<TLAbsNotificationSound>() }
        storiesOtherSound = readIfMask(1, 1024) { readTLObject<TLAbsNotificationSound>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, showPreviews, 1) { SIZE_BOOLEAN }
        size += getIntIfMask(1, silent, 2) { SIZE_BOOLEAN }
        size += getIntIfMask(1, muteUntil, 4) { SIZE_INT32 }
        size += getIntIfMask(1, iosSound, 8) { it.computeSerializedSize() }
        size += getIntIfMask(1, androidSound, 16) { it.computeSerializedSize() }
        size += getIntIfMask(1, otherSound, 32) { it.computeSerializedSize() }
        size += getIntIfMask(1, storiesMuted, 64) { SIZE_BOOLEAN }
        size += getIntIfMask(1, storiesHideSender, 128) { SIZE_BOOLEAN }
        size += getIntIfMask(1, storiesIosSound, 256) { it.computeSerializedSize() }
        size += getIntIfMask(1, storiesAndroidSound, 512) { it.computeSerializedSize() }
        size += getIntIfMask(1, storiesOtherSound, 1024) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerNotifySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && showPreviews == other.showPreviews
                && silent == other.silent
                && muteUntil == other.muteUntil
                && iosSound == other.iosSound
                && androidSound == other.androidSound
                && otherSound == other.otherSound
                && storiesMuted == other.storiesMuted
                && storiesHideSender == other.storiesHideSender
                && storiesIosSound == other.storiesIosSound
                && storiesAndroidSound == other.storiesAndroidSound
                && storiesOtherSound == other.storiesOtherSound
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x99622c0c.toInt()
    }
}
