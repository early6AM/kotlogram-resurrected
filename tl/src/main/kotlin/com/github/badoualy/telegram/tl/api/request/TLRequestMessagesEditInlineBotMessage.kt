package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineMessageID
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup
import com.github.badoualy.telegram.tl.api.TLInputBotInlineMessageID
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesEditInlineBotMessage() : TLMethod<TLBool>() {
    @Transient
    var noWebpage: Boolean = false

    @Transient
    var invertMedia: Boolean = false

    var id: TLAbsInputBotInlineMessageID = TLInputBotInlineMessageID()

    var message: String? = null

    var media: TLAbsInputMedia? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "messages.editInlineBotMessage#83557dba"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            invertMedia: Boolean,
            id: TLAbsInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.noWebpage = noWebpage
        this.invertMedia = invertMedia
        this.id = id
        this.message = message
        this.media = media
        this.replyMarkup = replyMarkup
        this.entities = entities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(invertMedia, 65536)
        updateFlags(message, 2048)
        updateFlags(media, 16384)
        updateFlags(replyMarkup, 4)
        updateFlags(entities, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        doIfMask(message, 2048) { writeString(it) }
        doIfMask(media, 16384) { writeTLObject(it) }
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
        doIfMask(entities, 8) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        invertMedia = isMask(65536)
        id = readTLObject<TLAbsInputBotInlineMessageID>()
        message = readIfMask(2048) { readString() }
        media = readIfMask(16384) { readTLObject<TLAbsInputMedia>() }
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += getIntIfMask(message, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(media, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesEditInlineBotMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && invertMedia == other.invertMedia
                && id == other.id
                && message == other.message
                && media == other.media
                && replyMarkup == other.replyMarkup
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x83557dba.toInt()
    }
}
