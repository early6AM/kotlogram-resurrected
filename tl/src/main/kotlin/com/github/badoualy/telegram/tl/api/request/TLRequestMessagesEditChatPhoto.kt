package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputChatPhotoEmpty
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesEditChatPhoto() : TLMethod<TLAbsUpdates>() {
    var chatId: Long = 0L

    var photo: TLAbsInputChatPhoto = TLInputChatPhotoEmpty()

    private val _constructor: String = "messages.editChatPhoto#35ddd674"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(chatId: Long, photo: TLAbsInputChatPhoto) : this() {
        this.chatId = chatId
        this.photo = photo
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(chatId)
        writeTLObject(photo)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readLong()
        photo = readTLObject<TLAbsInputChatPhoto>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += photo.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesEditChatPhoto) return false
        if (other === this) return true

        return chatId == other.chatId
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x35ddd674
    }
}
