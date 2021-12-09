package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [phoneConnection#9d4c17c0][TLPhoneConnection]
 * * [phoneConnectionWebrtc#635fe375][TLPhoneConnectionWebrtc]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhoneConnection : TLObject() {
    abstract var id: Long

    abstract var ip: String

    abstract var ipv6: String

    abstract var port: Int
}
