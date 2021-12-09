package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetUserInfo() : TLMethod<TLAbsUserInfo>() {
    var userId: TLAbsInputUser = TLInputUserEmpty()

    private val _constructor: String = "help.getUserInfo#38a08d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: TLAbsInputUser) : this() {
        this.userId = userId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readTLObject<TLAbsInputUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += userId.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetUserInfo) return false
        if (other === this) return true

        return userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x38a08d3
    }
}
