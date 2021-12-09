package com.github.badoualy.telegram.tl.api

/**
 * inputReportReasonGeoIrrelevant#dbd4feed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputReportReasonGeoIrrelevant : TLAbsReportReason() {
    private val _constructor: String = "inputReportReasonGeoIrrelevant#dbd4feed"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputReportReasonGeoIrrelevant) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdbd4feed.toInt()
    }
}
