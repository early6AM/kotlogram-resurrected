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
 * * [inputPrivacyKeyAbout#3823cc40][TLInputPrivacyKeyAbout]
 * * [inputPrivacyKeyAddedByPhone#d1219bdd][TLInputPrivacyKeyAddedByPhone]
 * * [inputPrivacyKeyChatInvite#bdfb0426][TLInputPrivacyKeyChatInvite]
 * * [inputPrivacyKeyForwards#a4dd4c08][TLInputPrivacyKeyForwards]
 * * [inputPrivacyKeyPhoneCall#fabadc5f][TLInputPrivacyKeyPhoneCall]
 * * [inputPrivacyKeyPhoneNumber#352dafa][TLInputPrivacyKeyPhoneNumber]
 * * [inputPrivacyKeyPhoneP2P#db9e70d2][TLInputPrivacyKeyPhoneP2P]
 * * [inputPrivacyKeyProfilePhoto#5719bacc][TLInputPrivacyKeyProfilePhoto]
 * * [inputPrivacyKeyStatusTimestamp#4f96cb18][TLInputPrivacyKeyStatusTimestamp]
 * * [inputPrivacyKeyVoiceMessages#aee69d68][TLInputPrivacyKeyVoiceMessages]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPrivacyKey : TLObject()
