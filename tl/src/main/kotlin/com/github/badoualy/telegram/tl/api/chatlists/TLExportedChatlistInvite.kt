package com.github.badoualy.telegram.tl.api.chatlists

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDialogFilter
import com.github.badoualy.telegram.tl.api.TLDialogFilterDefault
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
 * chatlists.exportedChatlistInvite#10e6e3a6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLExportedChatlistInvite() : TLObject() {
    var filter: TLAbsDialogFilter = TLDialogFilterDefault()

    var invite: com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite = com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite()

    private val _constructor: String = "chatlists.exportedChatlistInvite#10e6e3a6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(filter: TLAbsDialogFilter, invite: com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite) : this() {
        this.filter = filter
        this.invite = invite
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(filter)
        writeTLObject(invite)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        filter = readTLObject<TLAbsDialogFilter>()
        invite = readTLObject<com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite>(com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite::class, com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += filter.computeSerializedSize()
        size += invite.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLExportedChatlistInvite) return false
        if (other === this) return true

        return filter == other.filter
                && invite == other.invite
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x10e6e3a6.toInt()
    }
}
