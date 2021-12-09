package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * folder#ff544e65
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFolder() : TLObject() {
    @Transient
    var autofillNewBroadcasts: Boolean = false

    @Transient
    var autofillPublicGroups: Boolean = false

    @Transient
    var autofillNewCorrespondents: Boolean = false

    var id: Int = 0

    var title: String = ""

    var photo: TLAbsChatPhoto? = null

    private val _constructor: String = "folder#ff544e65"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            autofillNewBroadcasts: Boolean,
            autofillPublicGroups: Boolean,
            autofillNewCorrespondents: Boolean,
            id: Int,
            title: String,
            photo: TLAbsChatPhoto?
    ) : this() {
        this.autofillNewBroadcasts = autofillNewBroadcasts
        this.autofillPublicGroups = autofillPublicGroups
        this.autofillNewCorrespondents = autofillNewCorrespondents
        this.id = id
        this.title = title
        this.photo = photo
    }

    override fun computeFlags() {
        _flags = 0
        updateFlags(autofillNewBroadcasts, 1)
        updateFlags(autofillPublicGroups, 2)
        updateFlags(autofillNewCorrespondents, 4)
        updateFlags(photo, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(title)
        doIfMask(photo, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        autofillNewBroadcasts = isMask(1)
        autofillPublicGroups = isMask(2)
        autofillNewCorrespondents = isMask(4)
        id = readInt()
        title = readString()
        photo = readIfMask(8) { readTLObject<TLAbsChatPhoto>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(photo, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFolder) return false
        if (other === this) return true

        return _flags == other._flags
                && autofillNewBroadcasts == other.autofillNewBroadcasts
                && autofillPublicGroups == other.autofillPublicGroups
                && autofillNewCorrespondents == other.autofillNewCorrespondents
                && id == other.id
                && title == other.title
                && photo == other.photo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xff544e65.toInt()
    }
}
