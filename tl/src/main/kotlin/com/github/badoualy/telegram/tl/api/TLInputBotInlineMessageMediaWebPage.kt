package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * inputBotInlineMessageMediaWebPage#bddcc510
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineMessageMediaWebPage() : TLAbsInputBotInlineMessage() {
    @Transient
    var invertMedia: Boolean = false

    @Transient
    var forceLargeMedia: Boolean = false

    @Transient
    var forceSmallMedia: Boolean = false

    @Transient
    var optional: Boolean = false

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var url: String = ""

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "inputBotInlineMessageMediaWebPage#bddcc510"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            invertMedia: Boolean,
            forceLargeMedia: Boolean,
            forceSmallMedia: Boolean,
            optional: Boolean,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            url: String,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.invertMedia = invertMedia
        this.forceLargeMedia = forceLargeMedia
        this.forceSmallMedia = forceSmallMedia
        this.optional = optional
        this.message = message
        this.entities = entities
        this.url = url
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
        updateFlags(invertMedia, 8)
        updateFlags(forceLargeMedia, 16)
        updateFlags(forceSmallMedia, 32)
        updateFlags(optional, 64)
        updateFlags(entities, 2)
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(message)
        doIfMask(1, entities, 2) { writeTLVector(it) }
        writeString(url)
        doIfMask(1, replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        invertMedia = isMask(1, 8)
        forceLargeMedia = isMask(1, 16)
        forceSmallMedia = isMask(1, 32)
        optional = isMask(1, 64)
        message = readString()
        entities = readIfMask(1, 2) { readTLVector<TLAbsMessageEntity>() }
        url = readString()
        replyMarkup = readIfMask(1, 4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(1, entities, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(url)
        size += getIntIfMask(1, replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineMessageMediaWebPage) return false
        if (other === this) return true

        return _flags == other._flags
                && invertMedia == other.invertMedia
                && forceLargeMedia == other.forceLargeMedia
                && forceSmallMedia == other.forceSmallMedia
                && optional == other.optional
                && message == other.message
                && entities == other.entities
                && url == other.url
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbddcc510.toInt()
    }
}
