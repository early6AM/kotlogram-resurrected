package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [privacyValueAllowAll#65427b82][TLPrivacyValueAllowAll]
 * * [privacyValueAllowChatParticipants#6b134e8e][TLPrivacyValueAllowChatParticipants]
 * * [privacyValueAllowContacts#fffe1bac][TLPrivacyValueAllowContacts]
 * * [privacyValueAllowUsers#b8905fb2][TLPrivacyValueAllowUsers]
 * * [privacyValueDisallowAll#8b73e763][TLPrivacyValueDisallowAll]
 * * [privacyValueDisallowChatParticipants#41c87565][TLPrivacyValueDisallowChatParticipants]
 * * [privacyValueDisallowContacts#f888fa1a][TLPrivacyValueDisallowContacts]
 * * [privacyValueDisallowUsers#e4621141][TLPrivacyValueDisallowUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPrivacyRule : TLObject()
