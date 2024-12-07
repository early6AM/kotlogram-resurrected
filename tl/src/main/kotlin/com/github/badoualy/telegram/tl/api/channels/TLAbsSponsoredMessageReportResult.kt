package com.github.badoualy.telegram.tl.api.channels

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channels.sponsoredMessageReportResultAdsHidden#3e3bcf2f][TLSponsoredMessageReportResultAdsHidden]
 * * [channels.sponsoredMessageReportResultChooseOption#846f9e42][TLSponsoredMessageReportResultChooseOption]
 * * [channels.sponsoredMessageReportResultReported#ad798849][TLSponsoredMessageReportResultReported]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSponsoredMessageReportResult : TLObject()
