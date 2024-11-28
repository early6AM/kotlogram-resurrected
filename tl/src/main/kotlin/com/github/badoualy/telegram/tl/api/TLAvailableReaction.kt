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
 * availableReaction#c077ec01
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAvailableReaction() : TLObject() {
    @Transient
    var inactive: Boolean = false

    @Transient
    var premium: Boolean = false

    var reaction: String = ""

    var title: String = ""

    var staticIcon: TLAbsDocument = TLDocumentEmpty()

    var appearAnimation: TLAbsDocument = TLDocumentEmpty()

    var selectAnimation: TLAbsDocument = TLDocumentEmpty()

    var activateAnimation: TLAbsDocument = TLDocumentEmpty()

    var effectAnimation: TLAbsDocument = TLDocumentEmpty()

    var aroundAnimation: TLAbsDocument? = null

    var centerIcon: TLAbsDocument? = null

    private val _constructor: String = "availableReaction#c077ec01"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            inactive: Boolean,
            premium: Boolean,
            reaction: String,
            title: String,
            staticIcon: TLAbsDocument,
            appearAnimation: TLAbsDocument,
            selectAnimation: TLAbsDocument,
            activateAnimation: TLAbsDocument,
            effectAnimation: TLAbsDocument,
            aroundAnimation: TLAbsDocument?,
            centerIcon: TLAbsDocument?
    ) : this() {
        this.inactive = inactive
        this.premium = premium
        this.reaction = reaction
        this.title = title
        this.staticIcon = staticIcon
        this.appearAnimation = appearAnimation
        this.selectAnimation = selectAnimation
        this.activateAnimation = activateAnimation
        this.effectAnimation = effectAnimation
        this.aroundAnimation = aroundAnimation
        this.centerIcon = centerIcon
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(inactive, 1)
        updateFlags(premium, 4)
        updateFlags(aroundAnimation, 2)
        updateFlags(centerIcon, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(reaction)
        writeString(title)
        writeTLObject(staticIcon)
        writeTLObject(appearAnimation)
        writeTLObject(selectAnimation)
        writeTLObject(activateAnimation)
        writeTLObject(effectAnimation)
        doIfMask(aroundAnimation, 2) { writeTLObject(it) }
        doIfMask(centerIcon, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        inactive = isMask(1)
        premium = isMask(4)
        reaction = readString()
        title = readString()
        staticIcon = readTLObject<TLAbsDocument>()
        appearAnimation = readTLObject<TLAbsDocument>()
        selectAnimation = readTLObject<TLAbsDocument>()
        activateAnimation = readTLObject<TLAbsDocument>()
        effectAnimation = readTLObject<TLAbsDocument>()
        aroundAnimation = readIfMask(2) { readTLObject<TLAbsDocument>() }
        centerIcon = readIfMask(2) { readTLObject<TLAbsDocument>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(reaction)
        size += computeTLStringSerializedSize(title)
        size += staticIcon.computeSerializedSize()
        size += appearAnimation.computeSerializedSize()
        size += selectAnimation.computeSerializedSize()
        size += activateAnimation.computeSerializedSize()
        size += effectAnimation.computeSerializedSize()
        size += getIntIfMask(aroundAnimation, 2) { it.computeSerializedSize() }
        size += getIntIfMask(centerIcon, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAvailableReaction) return false
        if (other === this) return true

        return _flags == other._flags
                && inactive == other.inactive
                && premium == other.premium
                && reaction == other.reaction
                && title == other.title
                && staticIcon == other.staticIcon
                && appearAnimation == other.appearAnimation
                && selectAnimation == other.selectAnimation
                && activateAnimation == other.activateAnimation
                && effectAnimation == other.effectAnimation
                && aroundAnimation == other.aroundAnimation
                && centerIcon == other.centerIcon
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc077ec01.toInt()
    }
}
