package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

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

    @Transient
    var manageTopics: Boolean = false

    @Transient
    var postStories: Boolean = false

    @Transient
    var editStories: Boolean = false

    @Transient
    var deleteStories: Boolean = false

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
            other: Boolean,
            manageTopics: Boolean,
            postStories: Boolean,
            editStories: Boolean,
            deleteStories: Boolean
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
        this.manageTopics = manageTopics
        this.postStories = postStories
        this.editStories = editStories
        this.deleteStories = deleteStories
    }

    protected override fun computeFlags() {
        _flags = 0
        _flags2 = 0
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
        updateFlags(manageTopics, 8192)
        updateFlags(postStories, 16384)
        updateFlags(editStories, 32768)
        updateFlags(deleteStories, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        changeInfo = isMask(1, 1)
        postMessages = isMask(1, 2)
        editMessages = isMask(1, 4)
        deleteMessages = isMask(1, 8)
        banUsers = isMask(1, 16)
        inviteUsers = isMask(1, 32)
        pinMessages = isMask(1, 128)
        addAdmins = isMask(1, 512)
        anonymous = isMask(1, 1024)
        manageCall = isMask(1, 2048)
        other = isMask(1, 4096)
        manageTopics = isMask(1, 8192)
        postStories = isMask(1, 16384)
        editStories = isMask(1, 32768)
        deleteStories = isMask(1, 65536)
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
                && manageTopics == other.manageTopics
                && postStories == other.postStories
                && editStories == other.editStories
                && deleteStories == other.deleteStories
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5fb224d5.toInt()
    }
}
