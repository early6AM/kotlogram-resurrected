package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLPremiumSubscriptionOption
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * help.premiumPromo#5334759c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPremiumPromo() : TLObject() {
    var statusText: String = ""

    var statusEntities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    var videoSections: TLStringVector = TLStringVector()

    var videos: TLObjectVector<TLAbsDocument> = TLObjectVector()

    var periodOptions: TLObjectVector<TLPremiumSubscriptionOption> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "help.premiumPromo#5334759c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            statusText: String,
            statusEntities: TLObjectVector<TLAbsMessageEntity>,
            videoSections: TLStringVector,
            videos: TLObjectVector<TLAbsDocument>,
            periodOptions: TLObjectVector<TLPremiumSubscriptionOption>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.statusText = statusText
        this.statusEntities = statusEntities
        this.videoSections = videoSections
        this.videos = videos
        this.periodOptions = periodOptions
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(statusText)
        writeTLVector(statusEntities)
        writeTLVector(videoSections)
        writeTLVector(videos)
        writeTLVector(periodOptions)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        statusText = readString()
        statusEntities = readTLVector<TLAbsMessageEntity>()
        videoSections = readTLStringVector()
        videos = readTLVector<TLAbsDocument>()
        periodOptions = readTLVector<TLPremiumSubscriptionOption>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(statusText)
        size += statusEntities.computeSerializedSize()
        size += videoSections.computeSerializedSize()
        size += videos.computeSerializedSize()
        size += periodOptions.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPremiumPromo) return false
        if (other === this) return true

        return statusText == other.statusText
                && statusEntities == other.statusEntities
                && videoSections == other.videoSections
                && videos == other.videos
                && periodOptions == other.periodOptions
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5334759c.toInt()
    }
}
