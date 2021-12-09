package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto
import com.github.badoualy.telegram.tl.api.TLAbsReportReason
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputPhotoEmpty
import com.github.badoualy.telegram.tl.api.TLInputReportReasonFake
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountReportProfilePhoto() : TLMethod<TLBool>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var photoId: TLAbsInputPhoto = TLInputPhotoEmpty()

    var reason: TLAbsReportReason = TLInputReportReasonFake()

    var message: String = ""

    private val _constructor: String = "account.reportProfilePhoto#fa8cc6f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            photoId: TLAbsInputPhoto,
            reason: TLAbsReportReason,
            message: String
    ) : this() {
        this.peer = peer
        this.photoId = photoId
        this.reason = reason
        this.message = message
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(photoId)
        writeTLObject(reason)
        writeString(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        photoId = readTLObject<TLAbsInputPhoto>()
        reason = readTLObject<TLAbsReportReason>()
        message = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += photoId.computeSerializedSize()
        size += reason.computeSerializedSize()
        size += computeTLStringSerializedSize(message)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountReportProfilePhoto) return false
        if (other === this) return true

        return peer == other.peer
                && photoId == other.photoId
                && reason == other.reason
                && message == other.message
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa8cc6f5.toInt()
    }
}
