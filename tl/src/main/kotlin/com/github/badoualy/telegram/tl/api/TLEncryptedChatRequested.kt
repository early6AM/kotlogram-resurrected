package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * encryptedChatRequested#48f1d94c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedChatRequested() : TLAbsEncryptedChat() {
    var folderId: Int? = null

    override var id: Int = 0

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Long = 0L

    var participantId: Long = 0L

    var gA: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "encryptedChatRequested#48f1d94c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            folderId: Int?,
            id: Int,
            accessHash: Long,
            date: Int,
            adminId: Long,
            participantId: Long,
            gA: TLBytes
    ) : this() {
        this.folderId = folderId
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.gA = gA
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(folderId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(folderId, 1) { writeInt(it) }
        writeInt(id)
        writeLong(accessHash)
        writeInt(date)
        writeLong(adminId)
        writeLong(participantId)
        writeTLBytes(gA)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        folderId = readIfMask(1) { readInt() }
        id = readInt()
        accessHash = readLong()
        date = readInt()
        adminId = readLong()
        participantId = readLong()
        gA = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(folderId, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(gA)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedChatRequested) return false
        if (other === this) return true

        return _flags == other._flags
                && folderId == other.folderId
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && gA == other.gA
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x48f1d94c
    }
}
