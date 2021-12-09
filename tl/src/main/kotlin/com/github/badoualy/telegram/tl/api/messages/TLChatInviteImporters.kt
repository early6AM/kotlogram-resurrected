package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChatInviteImporter
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.chatInviteImporters#81b6b00a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInviteImporters() : TLObject() {
    var count: Int = 0

    var importers: TLObjectVector<TLChatInviteImporter> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.chatInviteImporters#81b6b00a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            importers: TLObjectVector<TLChatInviteImporter>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.count = count
        this.importers = importers
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(count)
        writeTLVector(importers)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        count = readInt()
        importers = readTLVector<TLChatInviteImporter>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += importers.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInviteImporters) return false
        if (other === this) return true

        return count == other.count
                && importers == other.importers
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x81b6b00a.toInt()
    }
}
