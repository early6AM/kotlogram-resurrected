package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

val TLAbsMessageAction.title: String?
    get() = when (this) {
        is TLMessageActionChannelCreate -> title
        is TLMessageActionChatCreate -> title
        is TLMessageActionChatEditTitle -> title
        is TLMessageActionChannelMigrateFrom -> title
        else -> null
    }

val TLAbsMessageAction.userIdList: LongArray?
    get() = when (this) {
        is TLMessageActionChatAddUser -> users.toLongArray()
        is TLMessageActionChatCreate -> users.toLongArray()
        is TLMessageActionChatDeleteUser -> longArrayOf(userId)
        is TLMessageActionChatJoinedByLink -> longArrayOf(inviterId)
        else -> null
    }
