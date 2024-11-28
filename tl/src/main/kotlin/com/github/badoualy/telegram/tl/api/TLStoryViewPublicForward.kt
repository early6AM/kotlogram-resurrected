package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * storyViewPublicForward#9083670b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryViewPublicForward() : TLAbsStoryView() {
    @Transient
    override var blocked: Boolean = false

    @Transient
    override var blockedMyStoriesFrom: Boolean = false

    var message: TLAbsMessage = TLMessageEmpty()

    private val _constructor: String = "storyViewPublicForward#9083670b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocked: Boolean,
            blockedMyStoriesFrom: Boolean,
            message: TLAbsMessage
    ) : this() {
        this.blocked = blocked
        this.blockedMyStoriesFrom = blockedMyStoriesFrom
        this.message = message
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(blocked, 1)
        updateFlags(blockedMyStoriesFrom, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blocked = isMask(1)
        blockedMyStoriesFrom = isMask(2)
        message = readTLObject<TLAbsMessage>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += message.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryViewPublicForward) return false
        if (other === this) return true

        return _flags == other._flags
                && blocked == other.blocked
                && blockedMyStoriesFrom == other.blockedMyStoriesFrom
                && message == other.message
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9083670b.toInt()
    }
}
