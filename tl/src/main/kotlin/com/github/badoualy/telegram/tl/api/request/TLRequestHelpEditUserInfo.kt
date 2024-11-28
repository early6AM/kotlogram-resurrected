package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
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
class TLRequestHelpEditUserInfo() : TLMethod<TLAbsUserInfo>() {
    var userId: TLAbsInputUser = TLInputUserEmpty()

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    private val _constructor: String = "help.editUserInfo#66b91b70"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: TLAbsInputUser,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>
    ) : this() {
        this.userId = userId
        this.message = message
        this.entities = entities
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(userId)
        writeString(message)
        writeTLVector(entities)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readTLObject<TLAbsInputUser>()
        message = readString()
        entities = readTLVector<TLAbsMessageEntity>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += userId.computeSerializedSize()
        size += computeTLStringSerializedSize(message)
        size += entities.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpEditUserInfo) return false
        if (other === this) return true

        return userId == other.userId
                && message == other.message
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x66b91b70.toInt()
    }
}
