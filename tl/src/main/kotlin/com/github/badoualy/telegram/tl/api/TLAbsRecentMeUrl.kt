package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [recentMeUrlChat#b2da71d2][TLRecentMeUrlChat]
 * * [recentMeUrlChatInvite#eb49081d][TLRecentMeUrlChatInvite]
 * * [recentMeUrlStickerSet#bc0a57dc][TLRecentMeUrlStickerSet]
 * * [recentMeUrlUnknown#46e1d13d][TLRecentMeUrlUnknown]
 * * [recentMeUrlUser#b92c09e2][TLRecentMeUrlUser]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsRecentMeUrl : TLObject() {
    abstract var url: String
}
