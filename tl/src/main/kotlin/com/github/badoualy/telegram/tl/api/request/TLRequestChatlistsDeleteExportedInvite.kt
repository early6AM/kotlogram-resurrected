package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputChatlistDialogFilter
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChatlistsDeleteExportedInvite() : TLMethod<TLBool>() {
    var chatlist: TLInputChatlistDialogFilter = TLInputChatlistDialogFilter()

    var slug: String = ""

    private val _constructor: String = "chatlists.deleteExportedInvite#719c5c5e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(chatlist: TLInputChatlistDialogFilter, slug: String) : this() {
        this.chatlist = chatlist
        this.slug = slug
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(chatlist)
        writeString(slug)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatlist = readTLObject<TLInputChatlistDialogFilter>(TLInputChatlistDialogFilter::class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID)
        slug = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += chatlist.computeSerializedSize()
        size += computeTLStringSerializedSize(slug)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChatlistsDeleteExportedInvite) return false
        if (other === this) return true

        return chatlist == other.chatlist
                && slug == other.slug
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x719c5c5e.toInt()
    }
}
