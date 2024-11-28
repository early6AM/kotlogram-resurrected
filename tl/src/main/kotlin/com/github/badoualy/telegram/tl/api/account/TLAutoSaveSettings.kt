package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLAutoSaveException
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * account.autoSaveSettings#4c3e069d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAutoSaveSettings() : TLObject() {
    var usersSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings = com.github.badoualy.telegram.tl.api.TLAutoSaveSettings()

    var chatsSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings = com.github.badoualy.telegram.tl.api.TLAutoSaveSettings()

    var broadcastsSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings = com.github.badoualy.telegram.tl.api.TLAutoSaveSettings()

    var exceptions: TLObjectVector<TLAutoSaveException> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "account.autoSaveSettings#4c3e069d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            usersSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings,
            chatsSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings,
            broadcastsSettings: com.github.badoualy.telegram.tl.api.TLAutoSaveSettings,
            exceptions: TLObjectVector<TLAutoSaveException>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.usersSettings = usersSettings
        this.chatsSettings = chatsSettings
        this.broadcastsSettings = broadcastsSettings
        this.exceptions = exceptions
        this.chats = chats
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(usersSettings)
        writeTLObject(chatsSettings)
        writeTLObject(broadcastsSettings)
        writeTLVector(exceptions)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        usersSettings = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoSaveSettings>(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings::class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID)
        chatsSettings = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoSaveSettings>(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings::class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID)
        broadcastsSettings = readTLObject<com.github.badoualy.telegram.tl.api.TLAutoSaveSettings>(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings::class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID)
        exceptions = readTLVector<TLAutoSaveException>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += usersSettings.computeSerializedSize()
        size += chatsSettings.computeSerializedSize()
        size += broadcastsSettings.computeSerializedSize()
        size += exceptions.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAutoSaveSettings) return false
        if (other === this) return true

        return usersSettings == other.usersSettings
                && chatsSettings == other.chatsSettings
                && broadcastsSettings == other.broadcastsSettings
                && exceptions == other.exceptions
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4c3e069d.toInt()
    }
}
