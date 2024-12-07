package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLMissingInvitee
import com.github.badoualy.telegram.tl.api.TLUpdatesTooLong
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
 * messages.invitedUsers#7f5defa6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInvitedUsers() : TLObject() {
    var updates: TLAbsUpdates = TLUpdatesTooLong()

    var missingInvitees: TLObjectVector<TLMissingInvitee> = TLObjectVector()

    private val _constructor: String = "messages.invitedUsers#7f5defa6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(updates: TLAbsUpdates, missingInvitees: TLObjectVector<TLMissingInvitee>) : this() {
        this.updates = updates
        this.missingInvitees = missingInvitees
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(updates)
        writeTLVector(missingInvitees)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        updates = readTLObject<TLAbsUpdates>()
        missingInvitees = readTLVector<TLMissingInvitee>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += updates.computeSerializedSize()
        size += missingInvitees.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInvitedUsers) return false
        if (other === this) return true

        return updates == other.updates
                && missingInvitees == other.missingInvitees
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7f5defa6.toInt()
    }
}
