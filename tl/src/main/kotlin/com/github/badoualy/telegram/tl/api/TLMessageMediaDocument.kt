package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * messageMediaDocument#4cf4d72d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaDocument() : TLAbsMessageMedia() {
    @Transient
    var nopremium: Boolean = false

    @Transient
    var spoiler: Boolean = false

    @Transient
    var video: Boolean = false

    @Transient
    var round: Boolean = false

    @Transient
    var voice: Boolean = false

    var document: TLAbsDocument? = null

    var altDocument: TLAbsDocument? = null

    var ttlSeconds: Int? = null

    private val _constructor: String = "messageMediaDocument#4cf4d72d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            nopremium: Boolean,
            spoiler: Boolean,
            video: Boolean,
            round: Boolean,
            voice: Boolean,
            document: TLAbsDocument?,
            altDocument: TLAbsDocument?,
            ttlSeconds: Int?
    ) : this() {
        this.nopremium = nopremium
        this.spoiler = spoiler
        this.video = video
        this.round = round
        this.voice = voice
        this.document = document
        this.altDocument = altDocument
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(nopremium, 8)
        updateFlags(spoiler, 16)
        updateFlags(video, 64)
        updateFlags(round, 128)
        updateFlags(voice, 256)
        updateFlags(document, 1)
        updateFlags(altDocument, 32)
        updateFlags(ttlSeconds, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(document, 1) { writeTLObject(it) }
        doIfMask(altDocument, 32) { writeTLObject(it) }
        doIfMask(ttlSeconds, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        nopremium = isMask(8)
        spoiler = isMask(16)
        video = isMask(64)
        round = isMask(128)
        voice = isMask(256)
        document = readIfMask(1) { readTLObject<TLAbsDocument>() }
        altDocument = readIfMask(32) { readTLObject<TLAbsDocument>() }
        ttlSeconds = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(document, 1) { it.computeSerializedSize() }
        size += getIntIfMask(altDocument, 32) { it.computeSerializedSize() }
        size += getIntIfMask(ttlSeconds, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaDocument) return false
        if (other === this) return true

        return _flags == other._flags
                && nopremium == other.nopremium
                && spoiler == other.spoiler
                && video == other.video
                && round == other.round
                && voice == other.voice
                && document == other.document
                && altDocument == other.altDocument
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4cf4d72d.toInt()
    }
}
