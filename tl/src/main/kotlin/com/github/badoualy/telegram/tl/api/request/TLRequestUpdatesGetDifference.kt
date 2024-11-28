package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUpdatesGetDifference() : TLMethod<TLAbsDifference>() {
    var pts: Int = 0

    var ptsLimit: Int? = null

    var ptsTotalLimit: Int? = null

    var date: Int = 0

    var qts: Int = 0

    var qtsLimit: Int? = null

    private val _constructor: String = "updates.getDifference#19c2f763"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pts: Int,
            ptsLimit: Int?,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int,
            qtsLimit: Int?
    ) : this() {
        this.pts = pts
        this.ptsLimit = ptsLimit
        this.ptsTotalLimit = ptsTotalLimit
        this.date = date
        this.qts = qts
        this.qtsLimit = qtsLimit
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ptsLimit, 2)
        updateFlags(ptsTotalLimit, 1)
        updateFlags(qtsLimit, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(pts)
        doIfMask(ptsLimit, 2) { writeInt(it) }
        doIfMask(ptsTotalLimit, 1) { writeInt(it) }
        writeInt(date)
        writeInt(qts)
        doIfMask(qtsLimit, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pts = readInt()
        ptsLimit = readIfMask(2) { readInt() }
        ptsTotalLimit = readIfMask(1) { readInt() }
        date = readInt()
        qts = readInt()
        qtsLimit = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(ptsLimit, 2) { SIZE_INT32 }
        size += getIntIfMask(ptsTotalLimit, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(qtsLimit, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUpdatesGetDifference) return false
        if (other === this) return true

        return _flags == other._flags
                && pts == other.pts
                && ptsLimit == other.ptsLimit
                && ptsTotalLimit == other.ptsTotalLimit
                && date == other.date
                && qts == other.qts
                && qtsLimit == other.qtsLimit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x19c2f763.toInt()
    }
}
