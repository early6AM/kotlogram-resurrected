package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLSearchResultsCalendarPeriod
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
import kotlin.jvm.Transient

/**
 * messages.searchResultsCalendar#147ee23c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSearchResultsCalendar() : TLObject() {
    @Transient
    var inexact: Boolean = false

    var count: Int = 0

    var minDate: Int = 0

    var minMsgId: Int = 0

    var offsetIdOffset: Int? = null

    var periods: TLObjectVector<TLSearchResultsCalendarPeriod> = TLObjectVector()

    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "messages.searchResultsCalendar#147ee23c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inexact: Boolean,
            count: Int,
            minDate: Int,
            minMsgId: Int,
            offsetIdOffset: Int?,
            periods: TLObjectVector<TLSearchResultsCalendarPeriod>,
            messages: TLObjectVector<TLAbsMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.inexact = inexact
        this.count = count
        this.minDate = minDate
        this.minMsgId = minMsgId
        this.offsetIdOffset = offsetIdOffset
        this.periods = periods
        this.messages = messages
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(inexact, 1)
        updateFlags(offsetIdOffset, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeInt(minDate)
        writeInt(minMsgId)
        doIfMask(1, offsetIdOffset, 2) { writeInt(it) }
        writeTLVector(periods)
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inexact = isMask(1, 1)
        count = readInt()
        minDate = readInt()
        minMsgId = readInt()
        offsetIdOffset = readIfMask(1, 2) { readInt() }
        periods = readTLVector<TLSearchResultsCalendarPeriod>()
        messages = readTLVector<TLAbsMessage>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(1, offsetIdOffset, 2) { SIZE_INT32 }
        size += periods.computeSerializedSize()
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSearchResultsCalendar) return false
        if (other === this) return true

        return _flags == other._flags
                && inexact == other.inexact
                && count == other.count
                && minDate == other.minDate
                && minMsgId == other.minMsgId
                && offsetIdOffset == other.offsetIdOffset
                && periods == other.periods
                && messages == other.messages
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x147ee23c.toInt()
    }
}
