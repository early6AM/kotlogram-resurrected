package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLBotPreviewMedia
import com.github.badoualy.telegram.tl.api.TLInputMediaEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestBotsEditPreviewMedia() : TLMethod<TLBotPreviewMedia>() {
    var bot: TLAbsInputUser = TLInputUserEmpty()

    var langCode: String = ""

    var media: TLAbsInputMedia = TLInputMediaEmpty()

    var newMedia: TLAbsInputMedia = TLInputMediaEmpty()

    private val _constructor: String = "bots.editPreviewMedia#8525606f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            bot: TLAbsInputUser,
            langCode: String,
            media: TLAbsInputMedia,
            newMedia: TLAbsInputMedia
    ) : this() {
        this.bot = bot
        this.langCode = langCode
        this.media = media
        this.newMedia = newMedia
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLBotPreviewMedia = tlDeserializer.readTLObject(TLBotPreviewMedia::class, TLBotPreviewMedia.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(bot)
        writeString(langCode)
        writeTLObject(media)
        writeTLObject(newMedia)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        bot = readTLObject<TLAbsInputUser>()
        langCode = readString()
        media = readTLObject<TLAbsInputMedia>()
        newMedia = readTLObject<TLAbsInputMedia>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += bot.computeSerializedSize()
        size += computeTLStringSerializedSize(langCode)
        size += media.computeSerializedSize()
        size += newMedia.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestBotsEditPreviewMedia) return false
        if (other === this) return true

        return bot == other.bot
                && langCode == other.langCode
                && media == other.media
                && newMedia == other.newMedia
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8525606f.toInt()
    }
}
