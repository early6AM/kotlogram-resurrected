package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messageUserVote#34d247b4][TLMessageUserVote]
 * * [messageUserVoteInputOption#3ca5b0ec][TLMessageUserVoteInputOption]
 * * [messageUserVoteMultiple#8a65e557][TLMessageUserVoteMultiple]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageUserVote : TLObject() {
    abstract var userId: Long

    abstract var date: Int
}
