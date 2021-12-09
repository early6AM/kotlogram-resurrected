package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionInviteToGroupCall#502f92f7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionInviteToGroupCall() : TLAbsMessageAction() {
    var call: TLInputGroupCall = TLInputGroupCall()

    var users: TLLongVector = TLLongVector()

    private val _constructor: String = "messageActionInviteToGroupCall#502f92f7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(call: TLInputGroupCall, users: TLLongVector) : this() {
        this.call = call
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(call)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        call = readTLObject<TLInputGroupCall>(TLInputGroupCall::class, TLInputGroupCall.CONSTRUCTOR_ID)
        users = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += call.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionInviteToGroupCall) return false
        if (other === this) return true

        return call == other.call
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x502f92f7
    }
}
