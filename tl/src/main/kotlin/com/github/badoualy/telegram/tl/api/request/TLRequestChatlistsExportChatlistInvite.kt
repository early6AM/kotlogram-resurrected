package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputChatlistDialogFilter
import com.github.badoualy.telegram.tl.api.chatlists.TLExportedChatlistInvite
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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChatlistsExportChatlistInvite() : TLMethod<TLExportedChatlistInvite>() {
    var chatlist: TLInputChatlistDialogFilter = TLInputChatlistDialogFilter()

    var title: String = ""

    var peers: TLObjectVector<TLAbsInputPeer> = TLObjectVector()

    private val _constructor: String = "chatlists.exportChatlistInvite#8472478e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatlist: TLInputChatlistDialogFilter,
            title: String,
            peers: TLObjectVector<TLAbsInputPeer>
    ) : this() {
        this.chatlist = chatlist
        this.title = title
        this.peers = peers
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLExportedChatlistInvite = tlDeserializer.readTLObject(TLExportedChatlistInvite::class, TLExportedChatlistInvite.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(chatlist)
        writeString(title)
        writeTLVector(peers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatlist = readTLObject<TLInputChatlistDialogFilter>(TLInputChatlistDialogFilter::class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID)
        title = readString()
        peers = readTLVector<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += chatlist.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += peers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChatlistsExportChatlistInvite) return false
        if (other === this) return true

        return chatlist == other.chatlist
                && title == other.title
                && peers == other.peers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8472478e.toInt()
    }
}
