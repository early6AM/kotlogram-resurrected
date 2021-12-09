package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageFwdHeader#5f777dce
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageFwdHeader() : TLObject() {
    @Transient
    var imported: Boolean = false

    var fromId: TLAbsPeer? = null

    var fromName: String? = null

    var date: Int = 0

    var channelPost: Int? = null

    var postAuthor: String? = null

    var savedFromPeer: TLAbsPeer? = null

    var savedFromMsgId: Int? = null

    var psaType: String? = null

    private val _constructor: String = "messageFwdHeader#5f777dce"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            imported: Boolean,
            fromId: TLAbsPeer?,
            fromName: String?,
            date: Int,
            channelPost: Int?,
            postAuthor: String?,
            savedFromPeer: TLAbsPeer?,
            savedFromMsgId: Int?,
            psaType: String?
    ) : this() {
        this.imported = imported
        this.fromId = fromId
        this.fromName = fromName
        this.date = date
        this.channelPost = channelPost
        this.postAuthor = postAuthor
        this.savedFromPeer = savedFromPeer
        this.savedFromMsgId = savedFromMsgId
        this.psaType = psaType
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(imported, 128)
        updateFlags(fromId, 1)
        updateFlags(fromName, 32)
        updateFlags(channelPost, 4)
        updateFlags(postAuthor, 8)
        updateFlags(savedFromPeer, 16)
        updateFlags(savedFromMsgId, 16)
        updateFlags(psaType, 64)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(fromId, 1) { writeTLObject(it) }
        doIfMask(fromName, 32) { writeString(it) }
        writeInt(date)
        doIfMask(channelPost, 4) { writeInt(it) }
        doIfMask(postAuthor, 8) { writeString(it) }
        doIfMask(savedFromPeer, 16) { writeTLObject(it) }
        doIfMask(savedFromMsgId, 16) { writeInt(it) }
        doIfMask(psaType, 64) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        imported = isMask(128)
        fromId = readIfMask(1) { readTLObject<TLAbsPeer>() }
        fromName = readIfMask(32) { readString() }
        date = readInt()
        channelPost = readIfMask(4) { readInt() }
        postAuthor = readIfMask(8) { readString() }
        savedFromPeer = readIfMask(16) { readTLObject<TLAbsPeer>() }
        savedFromMsgId = readIfMask(16) { readInt() }
        psaType = readIfMask(64) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(fromId, 1) { it.computeSerializedSize() }
        size += getIntIfMask(fromName, 32) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        size += getIntIfMask(channelPost, 4) { SIZE_INT32 }
        size += getIntIfMask(postAuthor, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(savedFromPeer, 16) { it.computeSerializedSize() }
        size += getIntIfMask(savedFromMsgId, 16) { SIZE_INT32 }
        size += getIntIfMask(psaType, 64) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageFwdHeader) return false
        if (other === this) return true

        return _flags == other._flags
                && imported == other.imported
                && fromId == other.fromId
                && fromName == other.fromName
                && date == other.date
                && channelPost == other.channelPost
                && postAuthor == other.postAuthor
                && savedFromPeer == other.savedFromPeer
                && savedFromMsgId == other.savedFromMsgId
                && psaType == other.psaType
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5f777dce
    }
}
