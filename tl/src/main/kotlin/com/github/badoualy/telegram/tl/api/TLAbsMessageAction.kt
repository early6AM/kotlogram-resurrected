package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messageActionBotAllowed#abe9affe][TLMessageActionBotAllowed]
 * * [messageActionChannelCreate#95d2ac92][TLMessageActionChannelCreate]
 * * [messageActionChannelMigrateFrom#ea3948e9][TLMessageActionChannelMigrateFrom]
 * * [messageActionChatAddUser#15cefd00][TLMessageActionChatAddUser]
 * * [messageActionChatCreate#bd47cbad][TLMessageActionChatCreate]
 * * [messageActionChatDeletePhoto#95e3fbef][TLMessageActionChatDeletePhoto]
 * * [messageActionChatDeleteUser#a43f30cc][TLMessageActionChatDeleteUser]
 * * [messageActionChatEditPhoto#7fcb13a8][TLMessageActionChatEditPhoto]
 * * [messageActionChatEditTitle#b5a1ce5a][TLMessageActionChatEditTitle]
 * * [messageActionChatJoinedByLink#31224c3][TLMessageActionChatJoinedByLink]
 * * [messageActionChatMigrateTo#e1037f92][TLMessageActionChatMigrateTo]
 * * [messageActionContactSignUp#f3f25f76][TLMessageActionContactSignUp]
 * * [messageActionCustomAction#fae69f56][TLMessageActionCustomAction]
 * * [messageActionEmpty#b6aef7b0][TLMessageActionEmpty]
 * * [messageActionGameScore#92a72876][TLMessageActionGameScore]
 * * [messageActionGeoProximityReached#98e0d697][TLMessageActionGeoProximityReached]
 * * [messageActionGroupCall#7a0d7f42][TLMessageActionGroupCall]
 * * [messageActionGroupCallScheduled#b3a07661][TLMessageActionGroupCallScheduled]
 * * [messageActionHistoryClear#9fbab604][TLMessageActionHistoryClear]
 * * [messageActionInviteToGroupCall#502f92f7][TLMessageActionInviteToGroupCall]
 * * [messageActionPaymentSent#40699cd0][TLMessageActionPaymentSent]
 * * [messageActionPaymentSentMe#8f31b327][TLMessageActionPaymentSentMe]
 * * [messageActionPhoneCall#80e11a7f][TLMessageActionPhoneCall]
 * * [messageActionPinMessage#94bd38ed][TLMessageActionPinMessage]
 * * [messageActionScreenshotTaken#4792929b][TLMessageActionScreenshotTaken]
 * * [messageActionSecureValuesSent#d95c6154][TLMessageActionSecureValuesSent]
 * * [messageActionSecureValuesSentMe#1b287353][TLMessageActionSecureValuesSentMe]
 * * [messageActionSetChatTheme#aa786345][TLMessageActionSetChatTheme]
 * * [messageActionSetMessagesTTL#aa1afbfd][TLMessageActionSetMessagesTTL]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageAction : TLObject()
