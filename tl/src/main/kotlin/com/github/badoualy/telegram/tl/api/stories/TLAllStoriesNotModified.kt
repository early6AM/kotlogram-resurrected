package com.github.badoualy.telegram.tl.api.stories

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLStoriesStealthMode
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * stories.allStoriesNotModified#1158fe3e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAllStoriesNotModified() : TLAbsAllStories() {
    override var state: String = ""

    override var stealthMode: TLStoriesStealthMode = TLStoriesStealthMode()

    private val _constructor: String = "stories.allStoriesNotModified#1158fe3e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(state: String, stealthMode: TLStoriesStealthMode) : this() {
        this.state = state
        this.stealthMode = stealthMode
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(_flags)
        writeString(state)
        writeTLObject(stealthMode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        state = readString()
        stealthMode = readTLObject<TLStoriesStealthMode>(TLStoriesStealthMode::class, TLStoriesStealthMode.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(state)
        size += stealthMode.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAllStoriesNotModified) return false
        if (other === this) return true

        return _flags == other._flags
                && state == other.state
                && stealthMode == other.stealthMode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1158fe3e.toInt()
    }
}
