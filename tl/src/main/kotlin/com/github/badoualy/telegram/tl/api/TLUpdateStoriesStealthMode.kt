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

/**
 * updateStoriesStealthMode#2c084dc1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateStoriesStealthMode() : TLAbsUpdate() {
    var stealthMode: TLStoriesStealthMode = TLStoriesStealthMode()

    private val _constructor: String = "updateStoriesStealthMode#2c084dc1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stealthMode: TLStoriesStealthMode) : this() {
        this.stealthMode = stealthMode
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stealthMode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stealthMode = readTLObject<TLStoriesStealthMode>(TLStoriesStealthMode::class, TLStoriesStealthMode.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stealthMode.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateStoriesStealthMode) return false
        if (other === this) return true

        return stealthMode == other.stealthMode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2c084dc1.toInt()
    }
}
