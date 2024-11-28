package com.github.badoualy.telegram.tl.api.users

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsUser
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
 * users.userFull#3b6d152e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserFull() : TLObject() {
    var fullUser: com.github.badoualy.telegram.tl.api.TLUserFull = com.github.badoualy.telegram.tl.api.TLUserFull()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "users.userFull#3b6d152e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fullUser: com.github.badoualy.telegram.tl.api.TLUserFull,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.fullUser = fullUser
        this.chats = chats
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(fullUser)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        fullUser = readTLObject<com.github.badoualy.telegram.tl.api.TLUserFull>(com.github.badoualy.telegram.tl.api.TLUserFull::class, com.github.badoualy.telegram.tl.api.TLUserFull.CONSTRUCTOR_ID)
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += fullUser.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserFull) return false
        if (other === this) return true

        return fullUser == other.fullUser
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3b6d152e.toInt()
    }
}
