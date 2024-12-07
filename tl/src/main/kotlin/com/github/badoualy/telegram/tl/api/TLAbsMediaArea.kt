package com.github.badoualy.telegram.tl.api

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
 * * [inputMediaAreaChannelPost#2271f2bf][TLInputMediaAreaChannelPost]
 * * [inputMediaAreaVenue#b282217f][TLInputMediaAreaVenue]
 * * [mediaAreaChannelPost#770416af][TLMediaAreaChannelPost]
 * * [mediaAreaGeoPoint#cad5452d][TLMediaAreaGeoPoint]
 * * [mediaAreaSuggestedReaction#14455871][TLMediaAreaSuggestedReaction]
 * * [mediaAreaUrl#37381085][TLMediaAreaUrl]
 * * [mediaAreaVenue#be82db9c][TLMediaAreaVenue]
 * * [mediaAreaWeather#49a6549c][TLMediaAreaWeather]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMediaArea : TLObject() {
    abstract var coordinates: TLMediaAreaCoordinates
}
