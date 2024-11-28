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
 * * [privacyKeyAbout#a486b761][TLPrivacyKeyAbout]
 * * [privacyKeyAddedByPhone#42ffd42b][TLPrivacyKeyAddedByPhone]
 * * [privacyKeyChatInvite#500e6dfa][TLPrivacyKeyChatInvite]
 * * [privacyKeyForwards#69ec56a3][TLPrivacyKeyForwards]
 * * [privacyKeyPhoneCall#3d662b7b][TLPrivacyKeyPhoneCall]
 * * [privacyKeyPhoneNumber#d19ae46d][TLPrivacyKeyPhoneNumber]
 * * [privacyKeyPhoneP2P#39491cc8][TLPrivacyKeyPhoneP2P]
 * * [privacyKeyProfilePhoto#96151fed][TLPrivacyKeyProfilePhoto]
 * * [privacyKeyStatusTimestamp#bc2eab30][TLPrivacyKeyStatusTimestamp]
 * * [privacyKeyVoiceMessages#697f414][TLPrivacyKeyVoiceMessages]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPrivacyKey : TLObject()
