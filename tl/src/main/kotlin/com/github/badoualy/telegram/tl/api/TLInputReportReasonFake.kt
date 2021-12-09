package com.github.badoualy.telegram.tl.api

/**
 * inputReportReasonFake#f5ddd6e7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReportReasonFake : TLAbsReportReason() {
    private val _constructor: String = "inputReportReasonFake#f5ddd6e7"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReportReasonFake) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf5ddd6e7.toInt()
    }
}
