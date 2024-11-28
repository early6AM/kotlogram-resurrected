package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite
import com.github.badoualy.telegram.tl.api.TLInputChatlistDialogFilter
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
class TLRequestChatlistsEditExportedInvite() : TLMethod<TLExportedChatlistInvite>() {
    var chatlist: TLInputChatlistDialogFilter = TLInputChatlistDialogFilter()

    var slug: String = ""

    var title: String? = null

    var peers: TLObjectVector<TLAbsInputPeer>? = TLObjectVector()

    private val _constructor: String = "chatlists.editExportedInvite#653db63d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatlist: TLInputChatlistDialogFilter,
            slug: String,
            title: String?,
            peers: TLObjectVector<TLAbsInputPeer>?
    ) : this() {
        this.chatlist = chatlist
        this.slug = slug
        this.title = title
        this.peers = peers
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLExportedChatlistInvite = tlDeserializer.readTLObject(TLExportedChatlistInvite::class, TLExportedChatlistInvite.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 2)
        updateFlags(peers, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(chatlist)
        writeString(slug)
        doIfMask(title, 2) { writeString(it) }
        doIfMask(peers, 4) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chatlist = readTLObject<TLInputChatlistDialogFilter>(TLInputChatlistDialogFilter::class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID)
        slug = readString()
        title = readIfMask(2) { readString() }
        peers = readIfMask(4) { readTLVector<TLAbsInputPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += chatlist.computeSerializedSize()
        size += computeTLStringSerializedSize(slug)
        size += getIntIfMask(title, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(peers, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChatlistsEditExportedInvite) return false
        if (other === this) return true

        return _flags == other._flags
                && chatlist == other.chatlist
                && slug == other.slug
                && title == other.title
                && peers == other.peers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x653db63d.toInt()
    }
}
