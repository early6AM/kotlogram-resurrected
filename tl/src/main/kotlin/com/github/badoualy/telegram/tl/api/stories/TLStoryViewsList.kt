package com.github.badoualy.telegram.tl.api.stories

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsStoryView
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
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
 * stories.storyViewsList#59d78fc5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStoryViewsList() : TLObject() {
    var count: Int = 0

    var viewsCount: Int = 0

    var forwardsCount: Int = 0

    var reactionsCount: Int = 0

    var views: TLObjectVector<TLAbsStoryView> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var nextOffset: String? = null

    private val _constructor: String = "stories.storyViewsList#59d78fc5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            count: Int,
            viewsCount: Int,
            forwardsCount: Int,
            reactionsCount: Int,
            views: TLObjectVector<TLAbsStoryView>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            nextOffset: String?
    ) : this() {
        this.count = count
        this.viewsCount = viewsCount
        this.forwardsCount = forwardsCount
        this.reactionsCount = reactionsCount
        this.views = views
        this.chats = chats
        this.users = users
        this.nextOffset = nextOffset
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nextOffset, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(count)
        writeInt(viewsCount)
        writeInt(forwardsCount)
        writeInt(reactionsCount)
        writeTLVector(views)
        writeTLVector(chats)
        writeTLVector(users)
        doIfMask(nextOffset, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        count = readInt()
        viewsCount = readInt()
        forwardsCount = readInt()
        reactionsCount = readInt()
        views = readTLVector<TLAbsStoryView>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        nextOffset = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += views.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += getIntIfMask(nextOffset, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStoryViewsList) return false
        if (other === this) return true

        return _flags == other._flags
                && count == other.count
                && viewsCount == other.viewsCount
                && forwardsCount == other.forwardsCount
                && reactionsCount == other.reactionsCount
                && views == other.views
                && chats == other.chats
                && users == other.users
                && nextOffset == other.nextOffset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x59d78fc5.toInt()
    }
}
