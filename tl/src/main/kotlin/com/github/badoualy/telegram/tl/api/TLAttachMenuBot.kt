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
import kotlin.jvm.Transient

/**
 * attachMenuBot#d90d8dfe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAttachMenuBot() : TLObject() {
    @Transient
    var inactive: Boolean = false

    @Transient
    var hasSettings: Boolean = false

    @Transient
    var requestWriteAccess: Boolean = false

    @Transient
    var showInAttachMenu: Boolean = false

    @Transient
    var showInSideMenu: Boolean = false

    @Transient
    var sideMenuDisclaimerNeeded: Boolean = false

    var botId: Long = 0L

    var shortName: String = ""

    var peerTypes: TLObjectVector<TLAbsAttachMenuPeerType>? = TLObjectVector()

    var icons: TLObjectVector<TLAttachMenuBotIcon> = TLObjectVector()

    private val _constructor: String = "attachMenuBot#d90d8dfe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inactive: Boolean,
            hasSettings: Boolean,
            requestWriteAccess: Boolean,
            showInAttachMenu: Boolean,
            showInSideMenu: Boolean,
            sideMenuDisclaimerNeeded: Boolean,
            botId: Long,
            shortName: String,
            peerTypes: TLObjectVector<TLAbsAttachMenuPeerType>?,
            icons: TLObjectVector<TLAttachMenuBotIcon>
    ) : this() {
        this.inactive = inactive
        this.hasSettings = hasSettings
        this.requestWriteAccess = requestWriteAccess
        this.showInAttachMenu = showInAttachMenu
        this.showInSideMenu = showInSideMenu
        this.sideMenuDisclaimerNeeded = sideMenuDisclaimerNeeded
        this.botId = botId
        this.shortName = shortName
        this.peerTypes = peerTypes
        this.icons = icons
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(inactive, 1)
        updateFlags(hasSettings, 2)
        updateFlags(requestWriteAccess, 4)
        updateFlags(showInAttachMenu, 8)
        updateFlags(showInSideMenu, 16)
        updateFlags(sideMenuDisclaimerNeeded, 32)
        updateFlags(peerTypes, 8)

        // Following parameters might be forced to true by another field that updated the flags
        showInAttachMenu = isMask(8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(botId)
        writeString(shortName)
        doIfMask(peerTypes, 8) { writeTLVector(it) }
        writeTLVector(icons)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inactive = isMask(1)
        hasSettings = isMask(2)
        requestWriteAccess = isMask(4)
        showInAttachMenu = isMask(8)
        showInSideMenu = isMask(16)
        sideMenuDisclaimerNeeded = isMask(32)
        botId = readLong()
        shortName = readString()
        peerTypes = readIfMask(8) { readTLVector<TLAbsAttachMenuPeerType>() }
        icons = readTLVector<TLAttachMenuBotIcon>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(shortName)
        size += getIntIfMask(peerTypes, 8) { it.computeSerializedSize() }
        size += icons.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAttachMenuBot) return false
        if (other === this) return true

        return _flags == other._flags
                && inactive == other.inactive
                && hasSettings == other.hasSettings
                && requestWriteAccess == other.requestWriteAccess
                && showInAttachMenu == other.showInAttachMenu
                && showInSideMenu == other.showInSideMenu
                && sideMenuDisclaimerNeeded == other.sideMenuDisclaimerNeeded
                && botId == other.botId
                && shortName == other.shortName
                && peerTypes == other.peerTypes
                && icons == other.icons
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd90d8dfe.toInt()
    }
}
