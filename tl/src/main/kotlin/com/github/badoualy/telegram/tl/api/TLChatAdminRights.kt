package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * chatAdminRights#5fb224d5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatAdminRights() : TLObject() {
    @Transient
    var changeInfo: Boolean = false

    @Transient
    var postMessages: Boolean = false

    @Transient
    var editMessages: Boolean = false

    @Transient
    var deleteMessages: Boolean = false

    @Transient
    var banUsers: Boolean = false

    @Transient
    var inviteUsers: Boolean = false

    @Transient
    var pinMessages: Boolean = false

    @Transient
    var addAdmins: Boolean = false

    @Transient
    var anonymous: Boolean = false

    @Transient
    var manageCall: Boolean = false

    @Transient
    var other: Boolean = false

    private val _constructor: String = "chatAdminRights#5fb224d5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            changeInfo: Boolean,
            postMessages: Boolean,
            editMessages: Boolean,
            deleteMessages: Boolean,
            banUsers: Boolean,
            inviteUsers: Boolean,
            pinMessages: Boolean,
            addAdmins: Boolean,
            anonymous: Boolean,
            manageCall: Boolean,
            other: Boolean
    ) : this() {
        this.changeInfo = changeInfo
        this.postMessages = postMessages
        this.editMessages = editMessages
        this.deleteMessages = deleteMessages
        this.banUsers = banUsers
        this.inviteUsers = inviteUsers
        this.pinMessages = pinMessages
        this.addAdmins = addAdmins
        this.anonymous = anonymous
        this.manageCall = manageCall
        this.other = other
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(changeInfo, 1)
        updateFlags(postMessages, 2)
        updateFlags(editMessages, 4)
        updateFlags(deleteMessages, 8)
        updateFlags(banUsers, 16)
        updateFlags(inviteUsers, 32)
        updateFlags(pinMessages, 128)
        updateFlags(addAdmins, 512)
        updateFlags(anonymous, 1024)
        updateFlags(manageCall, 2048)
        updateFlags(other, 4096)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        changeInfo = isMask(1)
        postMessages = isMask(2)
        editMessages = isMask(4)
        deleteMessages = isMask(8)
        banUsers = isMask(16)
        inviteUsers = isMask(32)
        pinMessages = isMask(128)
        addAdmins = isMask(512)
        anonymous = isMask(1024)
        manageCall = isMask(2048)
        other = isMask(4096)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatAdminRights) return false
        if (other === this) return true

        return _flags == other._flags
                && changeInfo == other.changeInfo
                && postMessages == other.postMessages
                && editMessages == other.editMessages
                && deleteMessages == other.deleteMessages
                && banUsers == other.banUsers
                && inviteUsers == other.inviteUsers
                && pinMessages == other.pinMessages
                && addAdmins == other.addAdmins
                && anonymous == other.anonymous
                && manageCall == other.manageCall
                && other == other.other
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5fb224d5
    }
}
