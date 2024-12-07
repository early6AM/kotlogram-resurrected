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
 * messageMediaWebPage#ddf10c3b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaWebPage() : TLAbsMessageMedia() {
    @Transient
    var forceLargeMedia: Boolean = false

    @Transient
    var forceSmallMedia: Boolean = false

    @Transient
    var manual: Boolean = false

    @Transient
    var safe: Boolean = false

    var webpage: TLAbsWebPage = TLWebPageEmpty()

    private val _constructor: String = "messageMediaWebPage#ddf10c3b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            forceLargeMedia: Boolean,
            forceSmallMedia: Boolean,
            manual: Boolean,
            safe: Boolean,
            webpage: TLAbsWebPage
    ) : this() {
        this.forceLargeMedia = forceLargeMedia
        this.forceSmallMedia = forceSmallMedia
        this.manual = manual
        this.safe = safe
        this.webpage = webpage
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(forceLargeMedia, 1)
        updateFlags(forceSmallMedia, 2)
        updateFlags(manual, 8)
        updateFlags(safe, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(webpage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        forceLargeMedia = isMask(1, 1)
        forceSmallMedia = isMask(1, 2)
        manual = isMask(1, 8)
        safe = isMask(1, 16)
        webpage = readTLObject<TLAbsWebPage>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += webpage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaWebPage) return false
        if (other === this) return true

        return _flags == other._flags
                && forceLargeMedia == other.forceLargeMedia
                && forceSmallMedia == other.forceSmallMedia
                && manual == other.manual
                && safe == other.safe
                && webpage == other.webpage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xddf10c3b.toInt()
    }
}
