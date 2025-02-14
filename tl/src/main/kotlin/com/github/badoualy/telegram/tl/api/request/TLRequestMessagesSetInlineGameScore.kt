package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineMessageID
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputBotInlineMessageID
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestMessagesSetInlineGameScore() : TLMethod<TLBool>() {
    @Transient
    var editMessage: Boolean = false

    @Transient
    var force: Boolean = false

    var id: TLAbsInputBotInlineMessageID = TLInputBotInlineMessageID()

    var userId: TLAbsInputUser = TLInputUserEmpty()

    var score: Int = 0

    private val _constructor: String = "messages.setInlineGameScore#15ad9f64"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            editMessage: Boolean,
            force: Boolean,
            id: TLAbsInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ) : this() {
        this.editMessage = editMessage
        this.force = force
        this.id = id
        this.userId = userId
        this.score = score
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(editMessage, 1)
        updateFlags(force, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        writeTLObject(userId)
        writeInt(score)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        editMessage = isMask(1)
        force = isMask(2)
        id = readTLObject<TLAbsInputBotInlineMessageID>()
        userId = readTLObject<TLAbsInputUser>()
        score = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += userId.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetInlineGameScore) return false
        if (other === this) return true

        return _flags == other._flags
                && editMessage == other.editMessage
                && force == other.force
                && id == other.id
                && userId == other.userId
                && score == other.score
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x15ad9f64.toInt()
    }
}
