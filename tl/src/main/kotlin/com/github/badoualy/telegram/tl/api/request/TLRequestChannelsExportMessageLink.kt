package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLExportedMessageLink
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
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
class TLRequestChannelsExportMessageLink() : TLMethod<TLExportedMessageLink>() {
    @Transient
    var grouped: Boolean = false

    @Transient
    var thread: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var id: Int = 0

    private val _constructor: String = "channels.exportMessageLink#e63fadeb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            grouped: Boolean,
            thread: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ) : this() {
        this.grouped = grouped
        this.thread = thread
        this.channel = channel
        this.id = id
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLExportedMessageLink = tlDeserializer.readTLObject(TLExportedMessageLink::class, TLExportedMessageLink.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(grouped, 1)
        updateFlags(thread, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeInt(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        grouped = isMask(1)
        thread = isMask(2)
        channel = readTLObject<TLAbsInputChannel>()
        id = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsExportMessageLink) return false
        if (other === this) return true

        return _flags == other._flags
                && grouped == other.grouped
                && thread == other.thread
                && channel == other.channel
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe63fadeb.toInt()
    }
}
