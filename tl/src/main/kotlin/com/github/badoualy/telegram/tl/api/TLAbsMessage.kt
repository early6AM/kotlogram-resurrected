package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [message#85d6cbe2][TLMessage]
 * * [messageEmpty#90a6ca84][TLMessageEmpty]
 * * [messageService#2b085862][TLMessageService]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessage : TLObject() {
    abstract var id: Int
}
