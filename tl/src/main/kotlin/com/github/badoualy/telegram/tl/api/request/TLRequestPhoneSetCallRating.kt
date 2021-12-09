package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPhoneCall
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneSetCallRating() : TLMethod<TLAbsUpdates>() {
    @Transient
    var userInitiative: Boolean = false

    var peer: TLInputPhoneCall = TLInputPhoneCall()

    var rating: Int = 0

    var comment: String = ""

    private val _constructor: String = "phone.setCallRating#59ead627"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userInitiative: Boolean,
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ) : this() {
        this.userInitiative = userInitiative
        this.peer = peer
        this.rating = rating
        this.comment = comment
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(userInitiative, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(rating)
        writeString(comment)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userInitiative = isMask(1)
        peer = readTLObject<TLInputPhoneCall>(TLInputPhoneCall::class, TLInputPhoneCall.CONSTRUCTOR_ID)
        rating = readInt()
        comment = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += computeTLStringSerializedSize(comment)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneSetCallRating) return false
        if (other === this) return true

        return _flags == other._flags
                && userInitiative == other.userInitiative
                && peer == other.peer
                && rating == other.rating
                && comment == other.comment
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x59ead627
    }
}
