package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsDialog
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLDialogFolder
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updates.channelDifferenceTooLong#a4bcc6fe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelDifferenceTooLong() : TLAbsChannelDifference() {
    @Transient
    override var _final: Boolean = false

    override var timeout: Int? = null

    var dialog: TLAbsDialog = TLDialogFolder()

    var messages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "updates.channelDifferenceTooLong#a4bcc6fe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            _final: Boolean,
            timeout: Int?,
            dialog: TLAbsDialog,
            messages: TLObjectVector<TLAbsMessage>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this._final = _final
        this.timeout = timeout
        this.dialog = dialog
        this.messages = messages
        this.chats = chats
        this.users = users
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(_final, 1)
        updateFlags(timeout, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(timeout, 2) { writeInt(it) }
        writeTLObject(dialog)
        writeTLVector(messages)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        _final = isMask(1)
        timeout = readIfMask(2) { readInt() }
        dialog = readTLObject<TLAbsDialog>()
        messages = readTLVector<TLAbsMessage>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(timeout, 2) { SIZE_INT32 }
        size += dialog.computeSerializedSize()
        size += messages.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelDifferenceTooLong) return false
        if (other === this) return true

        return _flags == other._flags
                && _final == other._final
                && timeout == other.timeout
                && dialog == other.dialog
                && messages == other.messages
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa4bcc6fe.toInt()
    }
}
