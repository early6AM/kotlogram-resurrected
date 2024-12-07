package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
import kotlin.jvm.Transient

/**
 * sponsoredMessage#bdedf566
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSponsoredMessage() : TLObject() {
    @Transient
    var recommended: Boolean = false

    @Transient
    var canReport: Boolean = false

    var randomId: TLBytes = TLBytes.EMPTY

    var url: String = ""

    var title: String = ""

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var photo: TLAbsPhoto? = null

    var color: TLPeerColor? = null

    var buttonText: String = ""

    var sponsorInfo: String? = null

    var additionalInfo: String? = null

    private val _constructor: String = "sponsoredMessage#bdedf566"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            recommended: Boolean,
            canReport: Boolean,
            randomId: TLBytes,
            url: String,
            title: String,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            photo: TLAbsPhoto?,
            color: TLPeerColor?,
            buttonText: String,
            sponsorInfo: String?,
            additionalInfo: String?
    ) : this() {
        this.recommended = recommended
        this.canReport = canReport
        this.randomId = randomId
        this.url = url
        this.title = title
        this.message = message
        this.entities = entities
        this.photo = photo
        this.color = color
        this.buttonText = buttonText
        this.sponsorInfo = sponsorInfo
        this.additionalInfo = additionalInfo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(recommended, 32)
        updateFlags(canReport, 4096)
        updateFlags(entities, 2)
        updateFlags(photo, 64)
        updateFlags(color, 8192)
        updateFlags(sponsorInfo, 128)
        updateFlags(additionalInfo, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLBytes(randomId)
        writeString(url)
        writeString(title)
        writeString(message)
        doIfMask(entities, 2) { writeTLVector(it) }
        doIfMask(photo, 64) { writeTLObject(it) }
        doIfMask(color, 8192) { writeTLObject(it) }
        writeString(buttonText)
        doIfMask(sponsorInfo, 128) { writeString(it) }
        doIfMask(additionalInfo, 256) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        recommended = isMask(32)
        canReport = isMask(4096)
        randomId = readTLBytes()
        url = readString()
        title = readString()
        message = readString()
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
        photo = readIfMask(64) { readTLObject<TLAbsPhoto>() }
        color = readIfMask(8192) { readTLObject<TLPeerColor>(TLPeerColor::class, TLPeerColor.CONSTRUCTOR_ID) }
        buttonText = readString()
        sponsorInfo = readIfMask(128) { readString() }
        additionalInfo = readIfMask(256) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(randomId)
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        size += getIntIfMask(photo, 64) { it.computeSerializedSize() }
        size += getIntIfMask(color, 8192) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(buttonText)
        size += getIntIfMask(sponsorInfo, 128) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(additionalInfo, 256) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSponsoredMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && recommended == other.recommended
                && canReport == other.canReport
                && randomId == other.randomId
                && url == other.url
                && title == other.title
                && message == other.message
                && entities == other.entities
                && photo == other.photo
                && color == other.color
                && buttonText == other.buttonText
                && sponsorInfo == other.sponsorInfo
                && additionalInfo == other.additionalInfo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbdedf566.toInt()
    }
}
