package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsBlockFromReplies() : TLMethod<TLAbsUpdates>() {
    @Transient
    var deleteMessage: Boolean = false

    @Transient
    var deleteHistory: Boolean = false

    @Transient
    var reportSpam: Boolean = false

    var msgId: Int = 0

    private val _constructor: String = "contacts.blockFromReplies#29a8962c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            deleteMessage: Boolean,
            deleteHistory: Boolean,
            reportSpam: Boolean,
            msgId: Int
    ) : this() {
        this.deleteMessage = deleteMessage
        this.deleteHistory = deleteHistory
        this.reportSpam = reportSpam
        this.msgId = msgId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(deleteMessage, 1)
        updateFlags(deleteHistory, 2)
        updateFlags(reportSpam, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(msgId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        deleteMessage = isMask(1)
        deleteHistory = isMask(2)
        reportSpam = isMask(4)
        msgId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsBlockFromReplies) return false
        if (other === this) return true

        return _flags == other._flags
                && deleteMessage == other.deleteMessage
                && deleteHistory == other.deleteHistory
                && reportSpam == other.reportSpam
                && msgId == other.msgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x29a8962c.toInt()
    }
}
