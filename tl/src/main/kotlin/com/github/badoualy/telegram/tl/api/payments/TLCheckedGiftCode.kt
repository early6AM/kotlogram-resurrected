package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsPeer
import com.github.badoualy.telegram.tl.api.TLAbsUser
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
 * payments.checkedGiftCode#284a1096
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCheckedGiftCode() : TLObject() {
    @Transient
    var viaGiveaway: Boolean = false

    var fromId: TLAbsPeer? = null

    var giveawayMsgId: Int? = null

    var toId: Long? = null

    var date: Int = 0

    var months: Int = 0

    var usedDate: Int? = null

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.checkedGiftCode#284a1096"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viaGiveaway: Boolean,
            fromId: TLAbsPeer?,
            giveawayMsgId: Int?,
            toId: Long?,
            date: Int,
            months: Int,
            usedDate: Int?,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.viaGiveaway = viaGiveaway
        this.fromId = fromId
        this.giveawayMsgId = giveawayMsgId
        this.toId = toId
        this.date = date
        this.months = months
        this.usedDate = usedDate
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(viaGiveaway, 4)
        updateFlags(fromId, 16)
        updateFlags(giveawayMsgId, 8)
        updateFlags(toId, 1)
        updateFlags(usedDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(1, fromId, 16) { writeTLObject(it) }
        doIfMask(1, giveawayMsgId, 8) { writeInt(it) }
        doIfMask(1, toId, 1) { writeLong(it) }
        writeInt(date)
        writeInt(months)
        doIfMask(1, usedDate, 2) { writeInt(it) }
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viaGiveaway = isMask(1, 4)
        fromId = readIfMask(1, 16) { readTLObject<TLAbsPeer>() }
        giveawayMsgId = readIfMask(1, 8) { readInt() }
        toId = readIfMask(1, 1) { readLong() }
        date = readInt()
        months = readInt()
        usedDate = readIfMask(1, 2) { readInt() }
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(1, fromId, 16) { it.computeSerializedSize() }
        size += getIntIfMask(1, giveawayMsgId, 8) { SIZE_INT32 }
        size += getIntIfMask(1, toId, 1) { SIZE_INT64 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, usedDate, 2) { SIZE_INT32 }
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCheckedGiftCode) return false
        if (other === this) return true

        return _flags == other._flags
                && viaGiveaway == other.viaGiveaway
                && fromId == other.fromId
                && giveawayMsgId == other.giveawayMsgId
                && toId == other.toId
                && date == other.date
                && months == other.months
                && usedDate == other.usedDate
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x284a1096.toInt()
    }
}
