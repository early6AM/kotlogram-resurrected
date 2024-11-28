package com.github.badoualy.telegram.tl.api.auth

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
 * * [auth.sentCodeTypeApp#3dbb5986][TLSentCodeTypeApp]
 * * [auth.sentCodeTypeCall#5353e5a7][TLSentCodeTypeCall]
 * * [auth.sentCodeTypeEmailCode#f450f59b][TLSentCodeTypeEmailCode]
 * * [auth.sentCodeTypeFirebaseSms#e57b1432][TLSentCodeTypeFirebaseSms]
 * * [auth.sentCodeTypeFlashCall#ab03c6d9][TLSentCodeTypeFlashCall]
 * * [auth.sentCodeTypeFragmentSms#d9565c39][TLSentCodeTypeFragmentSms]
 * * [auth.sentCodeTypeMissedCall#82006484][TLSentCodeTypeMissedCall]
 * * [auth.sentCodeTypeSetUpEmailRequired#a5491dea][TLSentCodeTypeSetUpEmailRequired]
 * * [auth.sentCodeTypeSms#c000bba2][TLSentCodeTypeSms]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSentCodeType : TLObject()
