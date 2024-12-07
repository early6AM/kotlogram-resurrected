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
 * * [messageActionBoostApply#cc02aa6d][TLMessageActionBoostApply]
 * * [messageActionBotAllowed#c516d679][TLMessageActionBotAllowed]
 * * [messageActionChannelCreate#95d2ac92][TLMessageActionChannelCreate]
 * * [messageActionChannelMigrateFrom#ea3948e9][TLMessageActionChannelMigrateFrom]
 * * [messageActionChatAddUser#15cefd00][TLMessageActionChatAddUser]
 * * [messageActionChatCreate#bd47cbad][TLMessageActionChatCreate]
 * * [messageActionChatDeletePhoto#95e3fbef][TLMessageActionChatDeletePhoto]
 * * [messageActionChatDeleteUser#a43f30cc][TLMessageActionChatDeleteUser]
 * * [messageActionChatEditPhoto#7fcb13a8][TLMessageActionChatEditPhoto]
 * * [messageActionChatEditTitle#b5a1ce5a][TLMessageActionChatEditTitle]
 * * [messageActionChatJoinedByLink#31224c3][TLMessageActionChatJoinedByLink]
 * * [messageActionChatJoinedByRequest#ebbca3cb][TLMessageActionChatJoinedByRequest]
 * * [messageActionChatMigrateTo#e1037f92][TLMessageActionChatMigrateTo]
 * * [messageActionContactSignUp#f3f25f76][TLMessageActionContactSignUp]
 * * [messageActionCustomAction#fae69f56][TLMessageActionCustomAction]
 * * [messageActionEmpty#b6aef7b0][TLMessageActionEmpty]
 * * [messageActionGameScore#92a72876][TLMessageActionGameScore]
 * * [messageActionGeoProximityReached#98e0d697][TLMessageActionGeoProximityReached]
 * * [messageActionGiftCode#678c2e09][TLMessageActionGiftCode]
 * * [messageActionGiftPremium#c83d6aec][TLMessageActionGiftPremium]
 * * [messageActionGiftStars#45d5b021][TLMessageActionGiftStars]
 * * [messageActionGiveawayLaunch#332ba9ed][TLMessageActionGiveawayLaunch]
 * * [messageActionGiveawayResults#2a9fadc5][TLMessageActionGiveawayResults]
 * * [messageActionGroupCall#7a0d7f42][TLMessageActionGroupCall]
 * * [messageActionGroupCallScheduled#b3a07661][TLMessageActionGroupCallScheduled]
 * * [messageActionHistoryClear#9fbab604][TLMessageActionHistoryClear]
 * * [messageActionInviteToGroupCall#502f92f7][TLMessageActionInviteToGroupCall]
 * * [messageActionPaymentRefunded#41b3e202][TLMessageActionPaymentRefunded]
 * * [messageActionPaymentSent#96163f56][TLMessageActionPaymentSent]
 * * [messageActionPaymentSentMe#8f31b327][TLMessageActionPaymentSentMe]
 * * [messageActionPhoneCall#80e11a7f][TLMessageActionPhoneCall]
 * * [messageActionPinMessage#94bd38ed][TLMessageActionPinMessage]
 * * [messageActionRequestedPeer#31518e9b][TLMessageActionRequestedPeer]
 * * [messageActionRequestedPeerSentMe#93b31848][TLMessageActionRequestedPeerSentMe]
 * * [messageActionScreenshotTaken#4792929b][TLMessageActionScreenshotTaken]
 * * [messageActionSecureValuesSent#d95c6154][TLMessageActionSecureValuesSent]
 * * [messageActionSecureValuesSentMe#1b287353][TLMessageActionSecureValuesSentMe]
 * * [messageActionSetChatTheme#aa786345][TLMessageActionSetChatTheme]
 * * [messageActionSetChatWallPaper#5060a3f4][TLMessageActionSetChatWallPaper]
 * * [messageActionSetMessagesTTL#3c134d7b][TLMessageActionSetMessagesTTL]
 * * [messageActionSuggestProfilePhoto#57de635e][TLMessageActionSuggestProfilePhoto]
 * * [messageActionTopicCreate#d999256][TLMessageActionTopicCreate]
 * * [messageActionTopicEdit#c0944820][TLMessageActionTopicEdit]
 * * [messageActionWebViewDataSent#b4c38cb5][TLMessageActionWebViewDataSent]
 * * [messageActionWebViewDataSentMe#47dd8079][TLMessageActionWebViewDataSentMe]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageAction : TLObject()
