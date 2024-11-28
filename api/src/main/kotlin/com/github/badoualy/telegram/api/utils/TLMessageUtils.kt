package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

val TLAbsMessage?.date: Int
    get() = when (this) {
        is TLMessage -> date
        is TLMessageService -> date
        else -> 0
    }

val TLAbsMessage?.fromId: Long?
    get() = when (this) {
        is TLMessage -> fromId?.id
        is TLMessageService -> fromId?.id
        else -> null
    }

fun TLAbsMessage?.getMessageOrEmpty() = when (this) {
    is TLMessage -> message
    else -> ""
}

val TLAbsMessage?.toId: TLAbsPeer?
    get() = when (this) {
        is TLMessage -> peerId
        is TLMessageService -> peerId
        else -> null
    }

val TLAbsMessage.isReply: Boolean
    get() = this is TLMessage && replyToMsgId != null
val TLAbsMessage.replyToMsgId: TLAbsMessageReplyHeader?
    get() = if (this is TLMessage) replyTo else null

val TLMessage.isForward: Boolean
    get() = fwdFrom != null
val TLAbsMessage.isSticker: Boolean
    get() {
        if (this !is TLMessage) return false
        if (media == null || media !is TLMessageMediaDocument) return false
        val media = this.media as TLMessageMediaDocument
        if (media.document?.isEmpty() == true) return false
        return media.document?.asDocument()?.attributes?.any { it is TLDocumentAttributeSticker } ?: false
    }

fun TLAbsMessage.getStickerAlt() = when (isSticker) {
    true -> ((this as? TLMessage)?.media as? TLMessageMediaDocument)?.document?.asDocument()?.attributes
            ?.filterIsInstance<TLDocumentAttributeSticker>()?.first()?.alt
    false -> null
}

fun TLAbsMessage.getSticker(): TLDocument? = when (isSticker) {
    true -> ((this as? TLMessage)?.media as? TLMessageMediaDocument)?.document?.asDocument()
    false -> null
}