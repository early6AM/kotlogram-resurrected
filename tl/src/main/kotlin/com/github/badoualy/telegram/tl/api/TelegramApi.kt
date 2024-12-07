package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLAbsEmailVerified
import com.github.badoualy.telegram.tl.api.account.TLAbsEmojiStatuses
import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtone
import com.github.badoualy.telegram.tl.api.account.TLAbsSavedRingtones
import com.github.badoualy.telegram.tl.api.account.TLAbsThemes
import com.github.badoualy.telegram.tl.api.account.TLAbsWallPapers
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations
import com.github.badoualy.telegram.tl.api.account.TLContentSettings
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode
import com.github.badoualy.telegram.tl.api.account.TLTakeout
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword
import com.github.badoualy.telegram.tl.api.account.TLWebAuthorizations
import com.github.badoualy.telegram.tl.api.auth.TLAbsAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLAbsLoginToken
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLLoggedOut
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.api.bots.TLBotInfo
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.channels.TLSendAsPeers
import com.github.badoualy.telegram.tl.api.chatlists.TLAbsChatlistInvite
import com.github.badoualy.telegram.tl.api.chatlists.TLChatlistUpdates
import com.github.badoualy.telegram.tl.api.chatlists.TLExportedInvites
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.api.contacts.TLFound
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.api.help.TLAbsAppConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsPassportConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsPeerColors
import com.github.badoualy.telegram.tl.api.help.TLAbsPromoData
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLPremiumPromo
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.help.TLSupportName
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsAvailableReactions
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsEmojiGroups
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsReactions
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.api.messages.TLAbsSponsoredMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers
import com.github.badoualy.telegram.tl.api.messages.TLAffectedFoundMessages
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers
import com.github.badoualy.telegram.tl.api.messages.TLBotApp
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.api.messages.TLChatAdminsWithInvites
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters
import com.github.badoualy.telegram.tl.api.messages.TLCheckedHistoryImportPeer
import com.github.badoualy.telegram.tl.api.messages.TLDiscussionMessage
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics
import com.github.badoualy.telegram.tl.api.messages.TLHighScores
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImport
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImportParsed
import com.github.badoualy.telegram.tl.api.messages.TLInactiveChats
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData
import com.github.badoualy.telegram.tl.api.messages.TLMessageReactionsList
import com.github.badoualy.telegram.tl.api.messages.TLMessageViews
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs
import com.github.badoualy.telegram.tl.api.messages.TLPeerSettings
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsCalendar
import com.github.badoualy.telegram.tl.api.messages.TLSearchResultsPositions
import com.github.badoualy.telegram.tl.api.messages.TLTranscribedAudio
import com.github.badoualy.telegram.tl.api.messages.TLTranslateResult
import com.github.badoualy.telegram.tl.api.messages.TLVotesList
import com.github.badoualy.telegram.tl.api.messages.TLWebPage
import com.github.badoualy.telegram.tl.api.payments.TLAbsGiveawayInfo
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.api.payments.TLBankCardData
import com.github.badoualy.telegram.tl.api.payments.TLCheckedGiftCode
import com.github.badoualy.telegram.tl.api.payments.TLExportedInvoice
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.api.payments.TLPaymentReceipt
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamChannels
import com.github.badoualy.telegram.tl.api.phone.TLGroupCallStreamRtmpUrl
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants
import com.github.badoualy.telegram.tl.api.phone.TLJoinAsPeers
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.premium.TLBoostsList
import com.github.badoualy.telegram.tl.api.premium.TLBoostsStatus
import com.github.badoualy.telegram.tl.api.premium.TLMyBoosts
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastStats
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats
import com.github.badoualy.telegram.tl.api.stats.TLPublicForwards
import com.github.badoualy.telegram.tl.api.stats.TLStoryStats
import com.github.badoualy.telegram.tl.api.stickers.TLSuggestedShortName
import com.github.badoualy.telegram.tl.api.stories.TLAbsAllStories
import com.github.badoualy.telegram.tl.api.stories.TLPeerStories
import com.github.badoualy.telegram.tl.api.stories.TLStories
import com.github.badoualy.telegram.tl.api.stories.TLStoryReactionsList
import com.github.badoualy.telegram.tl.api.stories.TLStoryViews
import com.github.badoualy.telegram.tl.api.stories.TLStoryViewsList
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.api.users.TLUserFull
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import io.reactivex.rxjava3.core.Single
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String

interface TelegramApi {
    fun accountAcceptAuthorization(
            botId: Long,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): Single<TLBool>

    fun accountCancelPasswordEmail(): Single<TLBool>

    fun accountChangeAuthorizationSettings(
            confirmed: Boolean,
            hash: Long,
            encryptedRequestsDisabled: Boolean?,
            callRequestsDisabled: Boolean?
    ): Single<TLBool>

    fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser>

    fun accountCheckUsername(username: String): Single<TLBool>

    fun accountClearRecentEmojiStatuses(): Single<TLBool>

    fun accountConfirmPasswordEmail(code: String): Single<TLBool>

    fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool>

    fun accountCreateTheme(
            slug: String,
            title: String,
            document: TLAbsInputDocument?,
            settings: TLObjectVector<TLInputThemeSettings>?
    ): Single<TLTheme>

    fun accountDeclinePasswordReset(): Single<TLBool>

    fun accountDeleteAccount(reason: String, password: TLAbsInputCheckPasswordSRP?): Single<TLBool>

    fun accountDeleteAutoSaveExceptions(): Single<TLBool>

    fun accountDeleteSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLBool>

    fun accountFinishTakeoutSession(success: Boolean): Single<TLBool>

    fun accountGetAccountTTL(): Single<TLAccountDaysTTL>

    fun accountGetAllSecureValues(): Single<TLObjectVector<TLSecureValue>>

    fun accountGetAuthorizationForm(
            botId: Long,
            scope: String,
            publicKey: String
    ): Single<TLAuthorizationForm>

    fun accountGetAuthorizations(): Single<TLAuthorizations>

    fun accountGetAutoDownloadSettings(): Single<com.github.badoualy.telegram.tl.api.account.TLAutoDownloadSettings>

    fun accountGetAutoSaveSettings(): Single<com.github.badoualy.telegram.tl.api.account.TLAutoSaveSettings>

    fun accountGetChannelDefaultEmojiStatuses(hash: Long): Single<TLAbsEmojiStatuses>

    fun accountGetChannelRestrictedStatusEmojis(hash: Long): Single<TLAbsEmojiList>

    fun accountGetChatThemes(hash: Long): Single<TLAbsThemes>

    fun accountGetContactSignUpNotification(): Single<TLBool>

    fun accountGetContentSettings(): Single<TLContentSettings>

    fun accountGetDefaultBackgroundEmojis(hash: Long): Single<TLAbsEmojiList>

    fun accountGetDefaultEmojiStatuses(hash: Long): Single<TLAbsEmojiStatuses>

    fun accountGetDefaultGroupPhotoEmojis(hash: Long): Single<TLAbsEmojiList>

    fun accountGetDefaultProfilePhotoEmojis(hash: Long): Single<TLAbsEmojiList>

    fun accountGetGlobalPrivacySettings(): Single<TLGlobalPrivacySettings>

    fun accountGetMultiWallPapers(wallpapers: TLObjectVector<TLAbsInputWallPaper>): Single<TLObjectVector<TLAbsWallPaper>>

    fun accountGetNotifyExceptions(
            compareSound: Boolean,
            compareStories: Boolean,
            peer: TLAbsInputNotifyPeer?
    ): Single<TLAbsUpdates>

    fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLPeerNotifySettings>

    fun accountGetPassword(): Single<TLPassword>

    fun accountGetPasswordSettings(password: TLAbsInputCheckPasswordSRP): Single<TLPasswordSettings>

    fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules>

    fun accountGetRecentEmojiStatuses(hash: Long): Single<TLAbsEmojiStatuses>

    fun accountGetSavedRingtones(hash: Long): Single<TLAbsSavedRingtones>

    fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLObjectVector<TLSecureValue>>

    fun accountGetTheme(format: String, theme: TLAbsInputTheme): Single<TLTheme>

    fun accountGetThemes(format: String, hash: Long): Single<TLAbsThemes>

    fun accountGetTmpPassword(password: TLAbsInputCheckPasswordSRP, period: Int): Single<TLTmpPassword>

    fun accountGetWallPaper(wallpaper: TLAbsInputWallPaper): Single<TLAbsWallPaper>

    fun accountGetWallPapers(hash: Long): Single<TLAbsWallPapers>

    fun accountGetWebAuthorizations(): Single<TLWebAuthorizations>

    fun accountInitTakeoutSession(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Long?
    ): Single<TLTakeout>

    fun accountInstallTheme(
            dark: Boolean,
            theme: TLAbsInputTheme?,
            format: String?,
            baseTheme: TLAbsBaseTheme?
    ): Single<TLBool>

    fun accountInstallWallPaper(wallpaper: TLAbsInputWallPaper, settings: TLWallPaperSettings): Single<TLBool>

    fun accountInvalidateSignInCodes(codes: TLStringVector): Single<TLBool>

    fun accountRegisterDevice(
            noMuted: Boolean,
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLLongVector
    ): Single<TLBool>

    fun accountReorderUsernames(order: TLStringVector): Single<TLBool>

    fun accountReportPeer(
            peer: TLAbsInputPeer,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool>

    fun accountReportProfilePhoto(
            peer: TLAbsInputPeer,
            photoId: TLAbsInputPhoto,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool>

    fun accountResendPasswordEmail(): Single<TLBool>

    fun accountResetAuthorization(hash: Long): Single<TLBool>

    fun accountResetNotifySettings(): Single<TLBool>

    fun accountResetPassword(): Single<TLAbsResetPasswordResult>

    fun accountResetWallPapers(): Single<TLBool>

    fun accountResetWebAuthorization(hash: Long): Single<TLBool>

    fun accountResetWebAuthorizations(): Single<TLBool>

    fun accountSaveAutoDownloadSettings(
            low: Boolean,
            high: Boolean,
            settings: TLAutoDownloadSettings
    ): Single<TLBool>

    fun accountSaveAutoSaveSettings(
            users: Boolean,
            chats: Boolean,
            broadcasts: Boolean,
            peer: TLAbsInputPeer?,
            settings: TLAutoSaveSettings
    ): Single<TLBool>

    fun accountSaveRingtone(id: TLAbsInputDocument, unsave: Boolean): Single<TLAbsSavedRingtone>

    fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): Single<TLSecureValue>

    fun accountSaveTheme(theme: TLAbsInputTheme, unsave: Boolean): Single<TLBool>

    fun accountSaveWallPaper(
            wallpaper: TLAbsInputWallPaper,
            unsave: Boolean,
            settings: TLWallPaperSettings
    ): Single<TLBool>

    fun accountSendChangePhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLAbsSentCode>

    fun accountSendConfirmPhoneCode(hash: String, settings: TLCodeSettings): Single<TLAbsSentCode>

    fun accountSendVerifyEmailCode(purpose: TLAbsEmailVerifyPurpose, email: String): Single<TLSentEmailCode>

    fun accountSendVerifyPhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLAbsSentCode>

    fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool>

    fun accountSetAuthorizationTTL(authorizationTtlDays: Int): Single<TLBool>

    fun accountSetContactSignUpNotification(silent: Boolean): Single<TLBool>

    fun accountSetContentSettings(sensitiveEnabled: Boolean): Single<TLBool>

    fun accountSetGlobalPrivacySettings(settings: TLGlobalPrivacySettings): Single<TLGlobalPrivacySettings>

    fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules>

    fun accountToggleUsername(username: String, active: Boolean): Single<TLBool>

    fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLLongVector
    ): Single<TLBool>

    fun accountUpdateColor(
            forProfile: Boolean,
            color: Int?,
            backgroundEmojiId: Long?
    ): Single<TLBool>

    fun accountUpdateDeviceLocked(period: Int): Single<TLBool>

    fun accountUpdateEmojiStatus(emojiStatus: TLAbsEmojiStatus): Single<TLBool>

    fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool>

    fun accountUpdatePasswordSettings(password: TLAbsInputCheckPasswordSRP, newSettings: TLPasswordInputSettings): Single<TLBool>

    fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser>

    fun accountUpdateStatus(offline: Boolean): Single<TLBool>

    fun accountUpdateTheme(
            format: String,
            theme: TLAbsInputTheme,
            slug: String?,
            title: String?,
            document: TLAbsInputDocument?,
            settings: TLObjectVector<TLInputThemeSettings>?
    ): Single<TLTheme>

    fun accountUpdateUsername(username: String): Single<TLAbsUser>

    fun accountUploadRingtone(
            file: TLAbsInputFile,
            fileName: String,
            mimeType: String
    ): Single<TLAbsDocument>

    fun accountUploadTheme(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            fileName: String,
            mimeType: String
    ): Single<TLAbsDocument>

    fun accountUploadWallPaper(
            forChat: Boolean,
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ): Single<TLAbsWallPaper>

    fun accountVerifyEmail(purpose: TLAbsEmailVerifyPurpose, verification: TLAbsEmailVerification): Single<TLAbsEmailVerified>

    fun accountVerifyPhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLBool>

    fun authAcceptLoginToken(token: TLBytes): Single<TLAuthorization>

    fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool>

    fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool>

    fun authCheckPassword(password: TLAbsInputCheckPasswordSRP): Single<TLAbsAuthorization>

    fun authCheckRecoveryPassword(code: String): Single<TLBool>

    fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool>

    fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization>

    fun authExportLoginToken(
            apiId: Int,
            apiHash: String,
            exceptIds: TLLongVector
    ): Single<TLAbsLoginToken>

    fun authImportAuthorization(id: Long, bytes: TLBytes): Single<TLAbsAuthorization>

    fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAbsAuthorization>

    fun authImportLoginToken(token: TLBytes): Single<TLAbsLoginToken>

    fun authImportWebTokenAuthorization(
            apiId: Int,
            apiHash: String,
            webAuthToken: String
    ): Single<TLAbsAuthorization>

    fun authLogOut(): Single<TLLoggedOut>

    fun authRecoverPassword(code: String, newSettings: TLPasswordInputSettings?): Single<TLAbsAuthorization>

    fun authRequestFirebaseSms(
            phoneNumber: String,
            phoneCodeHash: String,
            safetyNetToken: String?,
            iosPushSecret: String?
    ): Single<TLBool>

    fun authRequestPasswordRecovery(): Single<TLPasswordRecovery>

    fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLAbsSentCode>

    fun authResetAuthorizations(): Single<TLBool>

    fun authResetLoginEmail(phoneNumber: String, phoneCodeHash: String): Single<TLAbsSentCode>

    fun authSendCode(
            phoneNumber: String,
            apiId: Int,
            apiHash: String,
            settings: TLCodeSettings
    ): Single<TLAbsSentCode>

    fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String?,
            emailVerification: TLAbsEmailVerification?
    ): Single<TLAbsAuthorization>

    fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            firstName: String,
            lastName: String
    ): Single<TLAbsAuthorization>

    fun botsAllowSendMessage(bot: TLAbsInputUser): Single<TLAbsUpdates>

    fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool>

    fun botsCanSendMessage(bot: TLAbsInputUser): Single<TLBool>

    fun botsGetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLObjectVector<TLBotCommand>>

    fun botsGetBotInfo(bot: TLAbsInputUser?, langCode: String): Single<TLBotInfo>

    fun botsGetBotMenuButton(userId: TLAbsInputUser): Single<TLAbsBotMenuButton>

    fun botsInvokeWebViewCustomMethod(
            bot: TLAbsInputUser,
            customMethod: String,
            params: TLDataJSON
    ): Single<TLDataJSON>

    fun botsReorderUsernames(bot: TLAbsInputUser, order: TLStringVector): Single<TLBool>

    fun botsResetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLBool>

    fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON>

    fun botsSetBotBroadcastDefaultAdminRights(adminRights: TLChatAdminRights): Single<TLBool>

    fun botsSetBotCommands(
            scope: TLAbsBotCommandScope,
            langCode: String,
            commands: TLObjectVector<TLBotCommand>
    ): Single<TLBool>

    fun botsSetBotGroupDefaultAdminRights(adminRights: TLChatAdminRights): Single<TLBool>

    fun botsSetBotInfo(
            bot: TLAbsInputUser?,
            langCode: String,
            name: String?,
            about: String?,
            description: String?
    ): Single<TLBool>

    fun botsSetBotMenuButton(userId: TLAbsInputUser, button: TLAbsBotMenuButton): Single<TLBool>

    fun botsToggleUsername(
            bot: TLAbsInputUser,
            username: String,
            active: Boolean
    ): Single<TLBool>

    fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun channelsClickSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): Single<TLBool>

    fun channelsConvertToGigagroup(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            forum: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?,
            ttlPeriod: Int?
    ): Single<TLAbsUpdates>

    fun channelsCreateForumTopic(
            channel: TLAbsInputChannel,
            title: String,
            iconColor: Int?,
            iconEmojiId: Long?,
            randomId: Long,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun channelsDeactivateAllUsernames(channel: TLAbsInputChannel): Single<TLBool>

    fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsDeleteHistory(
            forEveryone: Boolean,
            channel: TLAbsInputChannel,
            maxId: Int
    ): Single<TLAbsUpdates>

    fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages>

    fun channelsDeleteParticipantHistory(channel: TLAbsInputChannel, participant: TLAbsInputPeer): Single<TLAffectedHistory>

    fun channelsDeleteTopicHistory(channel: TLAbsInputChannel, topMsgId: Int): Single<TLAffectedHistory>

    fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChatAdminRights,
            rank: String
    ): Single<TLAbsUpdates>

    fun channelsEditBanned(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            bannedRights: TLChatBannedRights
    ): Single<TLAbsUpdates>

    fun channelsEditCreator(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            password: TLAbsInputCheckPasswordSRP
    ): Single<TLAbsUpdates>

    fun channelsEditForumTopic(
            channel: TLAbsInputChannel,
            topicId: Int,
            title: String?,
            iconEmojiId: Long?,
            closed: Boolean?,
            hidden: Boolean?
    ): Single<TLAbsUpdates>

    fun channelsEditLocation(
            channel: TLAbsInputChannel,
            geoPoint: TLAbsInputGeoPoint,
            address: String
    ): Single<TLBool>

    fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates>

    fun channelsExportMessageLink(
            grouped: Boolean,
            thread: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLExportedMessageLink>

    fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults>

    fun channelsGetAdminedPublicChannels(byLocation: Boolean, checkLimit: Boolean): Single<TLAbsChats>

    fun channelsGetChannelRecommendations(channel: TLAbsInputChannel): Single<TLAbsChats>

    fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats>

    fun channelsGetForumTopics(
            channel: TLAbsInputChannel,
            q: String?,
            offsetDate: Int,
            offsetId: Int,
            offsetTopic: Int,
            limit: Int
    ): Single<TLForumTopics>

    fun channelsGetForumTopicsByID(channel: TLAbsInputChannel, topics: TLIntVector): Single<TLForumTopics>

    fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull>

    fun channelsGetGroupsForDiscussion(): Single<TLAbsChats>

    fun channelsGetInactiveChannels(): Single<TLInactiveChats>

    fun channelsGetLeftChannels(offset: Int): Single<TLAbsChats>

    fun channelsGetMessages(channel: TLAbsInputChannel, id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages>

    fun channelsGetParticipant(channel: TLAbsInputChannel, participant: TLAbsInputPeer): Single<TLChannelParticipant>

    fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsChannelParticipants>

    fun channelsGetSendAs(peer: TLAbsInputPeer): Single<TLSendAsPeers>

    fun channelsGetSponsoredMessages(channel: TLAbsInputChannel): Single<TLAbsSponsoredMessages>

    fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool>

    fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool>

    fun channelsReorderPinnedForumTopics(
            force: Boolean,
            channel: TLAbsInputChannel,
            order: TLIntVector
    ): Single<TLAbsUpdates>

    fun channelsReorderUsernames(channel: TLAbsInputChannel, order: TLStringVector): Single<TLBool>

    fun channelsReportAntiSpamFalsePositive(channel: TLAbsInputChannel, msgId: Int): Single<TLBool>

    fun channelsReportSpam(
            channel: TLAbsInputChannel,
            participant: TLAbsInputPeer,
            id: TLIntVector
    ): Single<TLBool>

    fun channelsSetDiscussionGroup(broadcast: TLAbsInputChannel, group: TLAbsInputChannel): Single<TLBool>

    fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun channelsToggleAntiSpam(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleForum(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleJoinRequest(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleJoinToSend(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleParticipantsHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleSlowMode(channel: TLAbsInputChannel, seconds: Int): Single<TLAbsUpdates>

    fun channelsToggleUsername(
            channel: TLAbsInputChannel,
            username: String,
            active: Boolean
    ): Single<TLBool>

    fun channelsToggleViewForumAsMessages(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsUpdateColor(
            forProfile: Boolean,
            channel: TLAbsInputChannel,
            color: Int?,
            backgroundEmojiId: Long?
    ): Single<TLAbsUpdates>

    fun channelsUpdateEmojiStatus(channel: TLAbsInputChannel, emojiStatus: TLAbsEmojiStatus): Single<TLAbsUpdates>

    fun channelsUpdatePinnedForumTopic(
            channel: TLAbsInputChannel,
            topicId: Int,
            pinned: Boolean
    ): Single<TLAbsUpdates>

    fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun channelsViewSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): Single<TLBool>

    fun chatlistsCheckChatlistInvite(slug: String): Single<TLAbsChatlistInvite>

    fun chatlistsDeleteExportedInvite(chatlist: TLInputChatlistDialogFilter, slug: String): Single<TLBool>

    fun chatlistsEditExportedInvite(
            chatlist: TLInputChatlistDialogFilter,
            slug: String,
            title: String?,
            peers: TLObjectVector<TLAbsInputPeer>?
    ): Single<TLExportedChatlistInvite>

    fun chatlistsExportChatlistInvite(
            chatlist: TLInputChatlistDialogFilter,
            title: String,
            peers: TLObjectVector<TLAbsInputPeer>
    ): Single<com.github.badoualy.telegram.tl.api.chatlists.TLExportedChatlistInvite>

    fun chatlistsGetChatlistUpdates(chatlist: TLInputChatlistDialogFilter): Single<TLChatlistUpdates>

    fun chatlistsGetExportedInvites(chatlist: TLInputChatlistDialogFilter): Single<TLExportedInvites>

    fun chatlistsGetLeaveChatlistSuggestions(chatlist: TLInputChatlistDialogFilter): Single<TLObjectVector<TLAbsPeer>>

    fun chatlistsHideChatlistUpdates(chatlist: TLInputChatlistDialogFilter): Single<TLBool>

    fun chatlistsJoinChatlistInvite(slug: String, peers: TLObjectVector<TLAbsInputPeer>): Single<TLAbsUpdates>

    fun chatlistsJoinChatlistUpdates(chatlist: TLInputChatlistDialogFilter, peers: TLObjectVector<TLAbsInputPeer>): Single<TLAbsUpdates>

    fun chatlistsLeaveChatlist(chatlist: TLInputChatlistDialogFilter, peers: TLObjectVector<TLAbsInputPeer>): Single<TLAbsUpdates>

    fun contactsAcceptContact(id: TLAbsInputUser): Single<TLAbsUpdates>

    fun contactsAddContact(
            addPhonePrivacyException: Boolean,
            id: TLAbsInputUser,
            firstName: String,
            lastName: String,
            phone: String
    ): Single<TLAbsUpdates>

    fun contactsBlock(myStoriesFrom: Boolean, id: TLAbsInputPeer): Single<TLBool>

    fun contactsBlockFromReplies(
            deleteMessage: Boolean,
            deleteHistory: Boolean,
            reportSpam: Boolean,
            msgId: Int
    ): Single<TLAbsUpdates>

    fun contactsDeleteByPhones(phones: TLStringVector): Single<TLBool>

    fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun contactsEditCloseFriends(id: TLLongVector): Single<TLBool>

    fun contactsExportContactToken(): Single<TLExportedContactToken>

    fun contactsGetBlocked(
            myStoriesFrom: Boolean,
            offset: Int,
            limit: Int
    ): Single<TLAbsBlocked>

    fun contactsGetContactIDs(hash: Long): Single<TLIntVector>

    fun contactsGetContacts(hash: Long): Single<TLAbsContacts>

    fun contactsGetLocated(
            background: Boolean,
            geoPoint: TLAbsInputGeoPoint,
            selfExpires: Int?
    ): Single<TLAbsUpdates>

    fun contactsGetSaved(): Single<TLObjectVector<TLSavedPhoneContact>>

    fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>>

    fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            forwardUsers: Boolean,
            forwardChats: Boolean,
            groups: Boolean,
            channels: Boolean,
            botsApp: Boolean,
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsTopPeers>

    fun contactsImportContactToken(token: String): Single<TLAbsUser>

    fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts>

    fun contactsResetSaved(): Single<TLBool>

    fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool>

    fun contactsResolvePhone(phone: String): Single<TLResolvedPeer>

    fun contactsResolveUsername(username: String): Single<TLResolvedPeer>

    fun contactsSearch(q: String, limit: Int): Single<TLFound>

    fun contactsSetBlocked(
            myStoriesFrom: Boolean,
            id: TLObjectVector<TLAbsInputPeer>,
            limit: Int
    ): Single<TLBool>

    fun contactsToggleTopPeers(enabled: Boolean): Single<TLBool>

    fun contactsUnblock(myStoriesFrom: Boolean, id: TLAbsInputPeer): Single<TLBool>

    fun foldersEditPeerFolders(folderPeers: TLObjectVector<TLInputFolderPeer>): Single<TLAbsUpdates>

    fun helpAcceptTermsOfService(id: TLDataJSON): Single<TLBool>

    fun helpDismissSuggestion(peer: TLAbsInputPeer, suggestion: String): Single<TLBool>

    fun helpEditUserInfo(
            userId: TLAbsInputUser,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>
    ): Single<TLAbsUserInfo>

    fun helpGetAppConfig(hash: Int): Single<TLAbsAppConfig>

    fun helpGetAppUpdate(source: String): Single<TLAbsAppUpdate>

    fun helpGetCdnConfig(): Single<TLCdnConfig>

    fun helpGetConfig(): Single<TLConfig>

    fun helpGetCountriesList(langCode: String, hash: Int): Single<TLAbsCountriesList>

    fun helpGetDeepLinkInfo(path: String): Single<TLAbsDeepLinkInfo>

    fun helpGetInviteText(): Single<TLInviteText>

    fun helpGetNearestDc(): Single<TLNearestDc>

    fun helpGetPassportConfig(hash: Int): Single<TLAbsPassportConfig>

    fun helpGetPeerColors(hash: Int): Single<TLAbsPeerColors>

    fun helpGetPeerProfileColors(hash: Int): Single<TLAbsPeerColors>

    fun helpGetPremiumPromo(): Single<TLPremiumPromo>

    fun helpGetPromoData(): Single<TLAbsPromoData>

    fun helpGetRecentMeUrls(referer: String): Single<TLRecentMeUrls>

    fun helpGetSupport(): Single<TLSupport>

    fun helpGetSupportName(): Single<TLSupportName>

    fun helpGetTermsOfServiceUpdate(): Single<TLAbsTermsOfServiceUpdate>

    fun helpGetUserInfo(userId: TLAbsInputUser): Single<TLAbsUserInfo>

    fun helpHidePromoData(peer: TLAbsInputPeer): Single<TLBool>

    fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool>

    fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool>

    fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            proxy: TLInputClientProxy?,
            params: TLAbsJSONValue?,
            query: TLMethod<T>?
    ): Single<T>

    fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithMessagesRange(range: TLMessageRange, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithTakeout(takeoutId: Long, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T>

    fun langpackGetDifference(
            langPack: String,
            langCode: String,
            fromVersion: Int
    ): Single<TLLangPackDifference>

    fun langpackGetLangPack(langPack: String, langCode: String): Single<TLLangPackDifference>

    fun langpackGetLanguage(langPack: String, langCode: String): Single<TLLangPackLanguage>

    fun langpackGetLanguages(langPack: String): Single<TLObjectVector<TLLangPackLanguage>>

    fun langpackGetStrings(
            langPack: String,
            langCode: String,
            keys: TLStringVector
    ): Single<TLObjectVector<TLAbsLangPackString>>

    fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat>

    fun messagesAcceptUrlAuth(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): Single<TLAbsUrlAuthResult>

    fun messagesAddChatUser(
            chatId: Long,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates>

    fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite>

    fun messagesCheckHistoryImport(importHead: String): Single<TLHistoryImportParsed>

    fun messagesCheckHistoryImportPeer(peer: TLAbsInputPeer): Single<TLCheckedHistoryImportPeer>

    fun messagesClearAllDrafts(): Single<TLBool>

    fun messagesClearRecentReactions(): Single<TLBool>

    fun messagesClearRecentStickers(attached: Boolean): Single<TLBool>

    fun messagesCreateChat(
            users: TLObjectVector<TLAbsInputUser>,
            title: String,
            ttlPeriod: Int?
    ): Single<TLAbsUpdates>

    fun messagesDeleteChat(chatId: Long): Single<TLBool>

    fun messagesDeleteChatUser(
            revokeHistory: Boolean,
            chatId: Long,
            userId: TLAbsInputUser
    ): Single<TLAbsUpdates>

    fun messagesDeleteExportedChatInvite(peer: TLAbsInputPeer, link: String): Single<TLBool>

    fun messagesDeleteHistory(
            justClear: Boolean,
            revoke: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int,
            minDate: Int?,
            maxDate: Int?
    ): Single<TLAffectedHistory>

    fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages>

    fun messagesDeletePhoneCallHistory(revoke: Boolean): Single<TLAffectedFoundMessages>

    fun messagesDeleteRevokedExportedChatInvites(peer: TLAbsInputPeer, adminId: TLAbsInputUser): Single<TLBool>

    fun messagesDeleteSavedHistory(
            peer: TLAbsInputPeer,
            maxId: Int,
            minDate: Int?,
            maxDate: Int?
    ): Single<TLAffectedHistory>

    fun messagesDeleteScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates>

    fun messagesDiscardEncryption(deleteHistory: Boolean, chatId: Int): Single<TLBool>

    fun messagesEditChatAbout(peer: TLAbsInputPeer, about: String): Single<TLBool>

    fun messagesEditChatAdmin(
            chatId: Long,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool>

    fun messagesEditChatDefaultBannedRights(peer: TLAbsInputPeer, bannedRights: TLChatBannedRights): Single<TLAbsUpdates>

    fun messagesEditChatPhoto(chatId: Long, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    fun messagesEditChatTitle(chatId: Long, title: String): Single<TLAbsUpdates>

    fun messagesEditExportedChatInvite(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            link: String,
            expireDate: Int?,
            usageLimit: Int?,
            requestNeeded: Boolean?,
            title: String?
    ): Single<com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite>

    fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            invertMedia: Boolean,
            id: TLAbsInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool>

    fun messagesEditMessage(
            noWebpage: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesExportChatInvite(
            legacyRevokePermanent: Boolean,
            requestNeeded: Boolean,
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?,
            title: String?
    ): Single<TLAbsExportedChatInvite>

    fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool>

    fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            dropAuthor: Boolean,
            dropMediaCaptions: Boolean,
            noforwards: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer,
            topMsgId: Int?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun messagesGetAdminsWithInvites(peer: TLAbsInputPeer): Single<TLChatAdminsWithInvites>

    fun messagesGetAllDrafts(): Single<TLAbsUpdates>

    fun messagesGetAllStickers(hash: Long): Single<TLAbsAllStickers>

    fun messagesGetArchivedStickers(
            masks: Boolean,
            emojis: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers>

    fun messagesGetAttachMenuBot(bot: TLAbsInputUser): Single<TLAttachMenuBotsBot>

    fun messagesGetAttachMenuBots(hash: Long): Single<TLAbsAttachMenuBots>

    fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>>

    fun messagesGetAvailableReactions(hash: Int): Single<TLAbsAvailableReactions>

    fun messagesGetBotApp(app: TLAbsInputBotApp, hash: Long): Single<TLBotApp>

    fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?,
            password: TLAbsInputCheckPasswordSRP?
    ): Single<TLBotCallbackAnswer>

    fun messagesGetChatInviteImporters(
            requested: Boolean,
            subscriptionExpired: Boolean,
            peer: TLAbsInputPeer,
            link: String?,
            q: String?,
            offsetDate: Int,
            offsetUser: TLAbsInputUser,
            limit: Int
    ): Single<TLChatInviteImporters>

    fun messagesGetChats(id: TLLongVector): Single<TLAbsChats>

    fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Long,
            limit: Int
    ): Single<TLAbsChats>

    fun messagesGetCustomEmojiDocuments(documentId: TLLongVector): Single<TLObjectVector<TLAbsDocument>>

    fun messagesGetDefaultHistoryTTL(): Single<TLDefaultHistoryTTL>

    fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig>

    fun messagesGetDialogFilters(): Single<TLObjectVector<TLAbsDialogFilter>>

    fun messagesGetDialogUnreadMarks(): Single<TLObjectVector<TLAbsDialogPeer>>

    fun messagesGetDialogs(
            excludePinned: Boolean,
            folderId: Int?,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): Single<TLAbsDialogs>

    fun messagesGetDiscussionMessage(peer: TLAbsInputPeer, msgId: Int): Single<TLDiscussionMessage>

    fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Long,
            mimeType: String
    ): Single<TLAbsDocument>

    fun messagesGetEmojiGroups(hash: Int): Single<TLAbsEmojiGroups>

    fun messagesGetEmojiKeywords(langCode: String): Single<TLEmojiKeywordsDifference>

    fun messagesGetEmojiKeywordsDifference(langCode: String, fromVersion: Int): Single<TLEmojiKeywordsDifference>

    fun messagesGetEmojiKeywordsLanguages(langCodes: TLStringVector): Single<TLObjectVector<TLEmojiLanguage>>

    fun messagesGetEmojiProfilePhotoGroups(hash: Int): Single<TLAbsEmojiGroups>

    fun messagesGetEmojiStatusGroups(hash: Int): Single<TLAbsEmojiGroups>

    fun messagesGetEmojiStickers(hash: Long): Single<TLAbsAllStickers>

    fun messagesGetEmojiURL(langCode: String): Single<TLEmojiURL>

    fun messagesGetExportedChatInvite(peer: TLAbsInputPeer, link: String): Single<com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite>

    fun messagesGetExportedChatInvites(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            adminId: TLAbsInputUser,
            offsetDate: Int?,
            offsetLink: String?,
            limit: Int
    ): Single<TLExportedChatInvites>

    fun messagesGetExtendedMedia(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates>

    fun messagesGetFavedStickers(hash: Long): Single<TLAbsFavedStickers>

    fun messagesGetFeaturedEmojiStickers(hash: Long): Single<TLAbsFeaturedStickers>

    fun messagesGetFeaturedStickers(hash: Long): Single<TLAbsFeaturedStickers>

    fun messagesGetFullChat(chatId: Long): Single<TLChatFull>

    fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores>

    fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): Single<TLAbsMessages>

    fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults>

    fun messagesGetInlineGameHighScores(id: TLAbsInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores>

    fun messagesGetMaskStickers(hash: Long): Single<TLAbsAllStickers>

    fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData>

    fun messagesGetMessageReactionsList(
            peer: TLAbsInputPeer,
            id: Int,
            reaction: TLAbsReaction?,
            offset: String?,
            limit: Int
    ): Single<TLMessageReactionsList>

    fun messagesGetMessageReadParticipants(peer: TLAbsInputPeer, msgId: Int): Single<TLObjectVector<TLReadParticipantDate>>

    fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages>

    fun messagesGetMessagesReactions(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates>

    fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLMessageViews>

    fun messagesGetOldFeaturedStickers(
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsFeaturedStickers>

    fun messagesGetOnlines(peer: TLAbsInputPeer): Single<TLChatOnlines>

    fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputDialogPeer>): Single<TLPeerDialogs>

    fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings>

    fun messagesGetPinnedDialogs(folderId: Int): Single<TLPeerDialogs>

    fun messagesGetPinnedSavedDialogs(): Single<TLAbsSavedDialogs>

    fun messagesGetPollResults(peer: TLAbsInputPeer, msgId: Int): Single<TLAbsUpdates>

    fun messagesGetPollVotes(
            peer: TLAbsInputPeer,
            id: Int,
            option: TLBytes?,
            offset: String?,
            limit: Int
    ): Single<TLVotesList>

    fun messagesGetRecentLocations(
            peer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): Single<TLAbsMessages>

    fun messagesGetRecentReactions(limit: Int, hash: Long): Single<TLAbsReactions>

    fun messagesGetRecentStickers(attached: Boolean, hash: Long): Single<TLAbsRecentStickers>

    fun messagesGetReplies(
            peer: TLAbsInputPeer,
            msgId: Int,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): Single<TLAbsMessages>

    fun messagesGetSavedDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Long
    ): Single<TLAbsSavedDialogs>

    fun messagesGetSavedGifs(hash: Long): Single<TLAbsSavedGifs>

    fun messagesGetSavedHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): Single<TLAbsMessages>

    fun messagesGetScheduledHistory(peer: TLAbsInputPeer, hash: Long): Single<TLAbsMessages>

    fun messagesGetScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsMessages>

    fun messagesGetSearchCounters(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            topMsgId: Int?,
            filters: TLObjectVector<TLAbsMessagesFilter>
    ): Single<TLObjectVector<TLSearchCounter>>

    fun messagesGetSearchResultsCalendar(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            filter: TLAbsMessagesFilter,
            offsetId: Int,
            offsetDate: Int
    ): Single<TLSearchResultsCalendar>

    fun messagesGetSearchResultsPositions(
            peer: TLAbsInputPeer,
            savedPeerId: TLAbsInputPeer?,
            filter: TLAbsMessagesFilter,
            offsetId: Int,
            limit: Int
    ): Single<TLSearchResultsPositions>

    fun messagesGetSplitRanges(): Single<TLObjectVector<TLMessageRange>>

    fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet, hash: Int): Single<TLAbsStickerSet>

    fun messagesGetStickers(emoticon: String, hash: Long): Single<TLAbsStickers>

    fun messagesGetSuggestedDialogFilters(): Single<TLObjectVector<TLDialogFilterSuggested>>

    fun messagesGetTopReactions(limit: Int, hash: Long): Single<TLAbsReactions>

    fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    fun messagesGetUnreadReactions(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    fun messagesGetWebPage(url: String, hash: Int): Single<TLWebPage>

    fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): Single<TLAbsMessageMedia>

    fun messagesHideAllChatJoinRequests(
            approved: Boolean,
            peer: TLAbsInputPeer,
            link: String?
    ): Single<TLAbsUpdates>

    fun messagesHideChatJoinRequest(
            approved: Boolean,
            peer: TLAbsInputPeer,
            userId: TLAbsInputUser
    ): Single<TLAbsUpdates>

    fun messagesHidePeerSettingsBar(peer: TLAbsInputPeer): Single<TLBool>

    fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates>

    fun messagesInitHistoryImport(
            peer: TLAbsInputPeer,
            file: TLAbsInputFile,
            mediaCount: Int
    ): Single<TLHistoryImport>

    fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult>

    fun messagesMarkDialogUnread(unread: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool>

    fun messagesMigrateChat(chatId: Long): Single<TLAbsUpdates>

    fun messagesProlongWebView(
            silent: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            queryId: Long,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ): Single<TLBool>

    fun messagesRateTranscribedAudio(
            peer: TLAbsInputPeer,
            msgId: Int,
            transcriptionId: Long,
            good: Boolean
    ): Single<TLBool>

    fun messagesReadDiscussion(
            peer: TLAbsInputPeer,
            msgId: Int,
            readMaxId: Int
    ): Single<TLBool>

    fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool>

    fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool>

    fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages>

    fun messagesReadMentions(peer: TLAbsInputPeer, topMsgId: Int?): Single<TLAffectedHistory>

    fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages>

    fun messagesReadReactions(peer: TLAbsInputPeer, topMsgId: Int?): Single<TLAffectedHistory>

    fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>>

    fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector>

    fun messagesReorderPinnedDialogs(
            force: Boolean,
            folderId: Int,
            order: TLObjectVector<TLAbsInputDialogPeer>
    ): Single<TLBool>

    fun messagesReorderPinnedSavedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputDialogPeer>): Single<TLBool>

    fun messagesReorderStickerSets(
            masks: Boolean,
            emojis: Boolean,
            order: TLLongVector
    ): Single<TLBool>

    fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool>

    fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool>

    fun messagesReportReaction(
            peer: TLAbsInputPeer,
            id: Int,
            reactionPeer: TLAbsInputPeer
    ): Single<TLBool>

    fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool>

    fun messagesRequestAppWebView(
            writeAllowed: Boolean,
            peer: TLAbsInputPeer,
            app: TLAbsInputBotApp,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ): Single<TLAppWebViewResultUrl>

    fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat>

    fun messagesRequestSimpleWebView(
            fromSwitchWebview: Boolean,
            fromSideMenu: Boolean,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String
    ): Single<TLSimpleWebViewResultUrl>

    fun messagesRequestUrlAuth(
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): Single<TLAbsUrlAuthResult>

    fun messagesRequestWebView(
            fromBotMenu: Boolean,
            silent: Boolean,
            peer: TLAbsInputPeer,
            bot: TLAbsInputUser,
            url: String?,
            startParam: String?,
            themeParams: TLDataJSON?,
            platform: String,
            replyTo: TLAbsInputReplyTo?,
            sendAs: TLAbsInputPeer?
    ): Single<TLWebViewResultUrl>

    fun messagesSaveDefaultSendAs(peer: TLAbsInputPeer, sendAs: TLAbsInputPeer): Single<TLBool>

    fun messagesSaveDraft(
            noWebpage: Boolean,
            invertMedia: Boolean,
            replyTo: TLAbsInputReplyTo?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            media: TLAbsInputMedia?
    ): Single<TLBool>

    fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool>

    fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool>

    fun messagesSearch(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputPeer?,
            savedPeerId: TLAbsInputPeer?,
            topMsgId: Int?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Long
    ): Single<TLAbsMessages>

    fun messagesSearchCustomEmoji(emoticon: String, hash: Long): Single<TLAbsEmojiList>

    fun messagesSearchEmojiStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): Single<TLAbsFoundStickerSets>

    fun messagesSearchGlobal(
            broadcastsOnly: Boolean,
            folderId: Int?,
            q: String,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages>

    fun messagesSearchSentMedia(
            q: String,
            filter: TLAbsMessagesFilter,
            limit: Int
    ): Single<TLAbsMessages>

    fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): Single<TLAbsFoundStickerSets>

    fun messagesSendBotRequestedPeer(
            peer: TLAbsInputPeer,
            msgId: Int,
            buttonId: Int,
            requestedPeers: TLObjectVector<TLAbsInputPeer>
    ): Single<TLAbsUpdates>

    fun messagesSendEncrypted(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

    fun messagesSendEncryptedFile(
            silent: Boolean,
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage>

    fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

    fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            hideVia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            randomId: Long,
            queryId: Long,
            id: String,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            media: TLAbsInputMedia,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            noforwards: Boolean,
            updateStickersetsOrder: Boolean,
            invertMedia: Boolean,
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?,
            sendAs: TLAbsInputPeer?
    ): Single<TLAbsUpdates>

    fun messagesSendReaction(
            big: Boolean,
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            reaction: TLObjectVector<TLAbsReaction>?
    ): Single<TLAbsUpdates>

    fun messagesSendScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates>

    fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyTo: TLAbsInputReplyTo,
            randomId: Long
    ): Single<TLAbsUpdates>

    fun messagesSendVote(
            peer: TLAbsInputPeer,
            msgId: Int,
            options: TLBytesVector
    ): Single<TLAbsUpdates>

    fun messagesSendWebViewData(
            bot: TLAbsInputUser,
            randomId: Long,
            buttonText: String,
            data: String
    ): Single<TLAbsUpdates>

    fun messagesSendWebViewResultMessage(botQueryId: String, result: TLAbsInputBotInlineResult): Single<TLWebViewMessageSent>

    fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool>

    fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool>

    fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool>

    fun messagesSetChatAvailableReactions(peer: TLAbsInputPeer, availableReactions: TLAbsChatReactions): Single<TLAbsUpdates>

    fun messagesSetChatTheme(peer: TLAbsInputPeer, emoticon: String): Single<TLAbsUpdates>

    fun messagesSetChatWallPaper(
            forBoth: Boolean,
            revert: Boolean,
            peer: TLAbsInputPeer,
            wallpaper: TLAbsInputWallPaper?,
            settings: TLWallPaperSettings?,
            id: Int?
    ): Single<TLAbsUpdates>

    fun messagesSetDefaultHistoryTTL(period: Int): Single<TLBool>

    fun messagesSetDefaultReaction(reaction: TLAbsReaction): Single<TLBool>

    fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool>

    fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates>

    fun messagesSetHistoryTTL(peer: TLAbsInputPeer, period: Int): Single<TLAbsUpdates>

    fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?,
            switchWebview: TLInlineBotWebView?
    ): Single<TLBool>

    fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLAbsInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool>

    fun messagesSetTyping(
            peer: TLAbsInputPeer,
            topMsgId: Int?,
            action: TLAbsSendMessageAction
    ): Single<TLBool>

    fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates>

    fun messagesStartHistoryImport(peer: TLAbsInputPeer, importId: Long): Single<TLBool>

    fun messagesToggleBotInAttachMenu(
            writeAllowed: Boolean,
            bot: TLAbsInputUser,
            enabled: Boolean
    ): Single<TLBool>

    fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool>

    fun messagesToggleNoForwards(peer: TLAbsInputPeer, enabled: Boolean): Single<TLAbsUpdates>

    fun messagesTogglePeerTranslations(disabled: Boolean, peer: TLAbsInputPeer): Single<TLBool>

    fun messagesToggleSavedDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool>

    fun messagesToggleStickerSets(
            uninstall: Boolean,
            archive: Boolean,
            unarchive: Boolean,
            stickersets: TLObjectVector<TLAbsInputStickerSet>
    ): Single<TLBool>

    fun messagesTranscribeAudio(peer: TLAbsInputPeer, msgId: Int): Single<TLTranscribedAudio>

    fun messagesTranslateText(
            peer: TLAbsInputPeer?,
            id: TLIntVector?,
            text: TLObjectVector<TLTextWithEntities>?,
            toLang: String
    ): Single<TLTranslateResult>

    fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun messagesUnpinAllMessages(peer: TLAbsInputPeer, topMsgId: Int?): Single<TLAffectedHistory>

    fun messagesUpdateDialogFilter(id: Int, filter: TLAbsDialogFilter?): Single<TLBool>

    fun messagesUpdateDialogFiltersOrder(order: TLIntVector): Single<TLBool>

    fun messagesUpdatePinnedMessage(
            silent: Boolean,
            unpin: Boolean,
            pmOneside: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ): Single<TLAbsUpdates>

    fun messagesUploadEncryptedFile(peer: TLInputEncryptedChat, file: TLAbsInputEncryptedFile): Single<TLAbsEncryptedFile>

    fun messagesUploadImportedMedia(
            peer: TLAbsInputPeer,
            importId: Long,
            fileName: String,
            media: TLAbsInputMedia
    ): Single<TLAbsMessageMedia>

    fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia>

    fun paymentsApplyGiftCode(slug: String): Single<TLAbsUpdates>

    fun paymentsAssignAppStoreTransaction(receipt: TLBytes, purpose: TLAbsInputStorePaymentPurpose): Single<TLAbsUpdates>

    fun paymentsAssignPlayMarketTransaction(receipt: TLDataJSON, purpose: TLAbsInputStorePaymentPurpose): Single<TLAbsUpdates>

    fun paymentsCanPurchasePremium(purpose: TLAbsInputStorePaymentPurpose): Single<TLBool>

    fun paymentsCheckGiftCode(slug: String): Single<TLCheckedGiftCode>

    fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool>

    fun paymentsExportInvoice(invoiceMedia: TLAbsInputMedia): Single<TLExportedInvoice>

    fun paymentsGetBankCardData(number: String): Single<TLBankCardData>

    fun paymentsGetGiveawayInfo(peer: TLAbsInputPeer, msgId: Int): Single<TLAbsGiveawayInfo>

    fun paymentsGetPaymentForm(invoice: TLAbsInputInvoice, themeParams: TLDataJSON?): Single<TLPaymentForm>

    fun paymentsGetPaymentReceipt(peer: TLAbsInputPeer, msgId: Int): Single<TLPaymentReceipt>

    fun paymentsGetPremiumGiftCodeOptions(boostPeer: TLAbsInputPeer?): Single<TLObjectVector<TLPremiumGiftCodeOption>>

    fun paymentsGetSavedInfo(): Single<TLSavedInfo>

    fun paymentsLaunchPrepaidGiveaway(
            peer: TLAbsInputPeer,
            giveawayId: Long,
            purpose: TLAbsInputStorePaymentPurpose
    ): Single<TLAbsUpdates>

    fun paymentsSendPaymentForm(
            formId: Long,
            invoice: TLAbsInputInvoice,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ): Single<TLAbsPaymentResult>

    fun paymentsValidateRequestedInfo(
            save: Boolean,
            invoice: TLAbsInputInvoice,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo>

    fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneCheckGroupCall(call: TLInputGroupCall, sources: TLIntVector): Single<TLIntVector>

    fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneCreateGroupCall(
            rtmpStream: Boolean,
            peer: TLAbsInputPeer,
            randomId: Int,
            title: String?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun phoneDiscardCall(
            video: Boolean,
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates>

    fun phoneDiscardGroupCall(call: TLInputGroupCall): Single<TLAbsUpdates>

    fun phoneEditGroupCallParticipant(
            call: TLInputGroupCall,
            participant: TLAbsInputPeer,
            muted: Boolean?,
            volume: Int?,
            raiseHand: Boolean?,
            videoStopped: Boolean?,
            videoPaused: Boolean?,
            presentationPaused: Boolean?
    ): Single<TLAbsUpdates>

    fun phoneEditGroupCallTitle(call: TLInputGroupCall, title: String): Single<TLAbsUpdates>

    fun phoneExportGroupCallInvite(canSelfUnmute: Boolean, call: TLInputGroupCall): Single<TLExportedGroupCallInvite>

    fun phoneGetCallConfig(): Single<TLDataJSON>

    fun phoneGetGroupCall(call: TLInputGroupCall, limit: Int): Single<TLGroupCall>

    fun phoneGetGroupCallJoinAs(peer: TLAbsInputPeer): Single<TLJoinAsPeers>

    fun phoneGetGroupCallStreamChannels(call: TLInputGroupCall): Single<TLGroupCallStreamChannels>

    fun phoneGetGroupCallStreamRtmpUrl(peer: TLAbsInputPeer, revoke: Boolean): Single<TLGroupCallStreamRtmpUrl>

    fun phoneGetGroupParticipants(
            call: TLInputGroupCall,
            ids: TLObjectVector<TLAbsInputPeer>,
            sources: TLIntVector,
            offset: String,
            limit: Int
    ): Single<TLGroupParticipants>

    fun phoneInviteToGroupCall(call: TLInputGroupCall, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun phoneJoinGroupCall(
            muted: Boolean,
            videoStopped: Boolean,
            call: TLInputGroupCall,
            joinAs: TLAbsInputPeer,
            inviteHash: String?,
            params: TLDataJSON
    ): Single<TLAbsUpdates>

    fun phoneJoinGroupCallPresentation(call: TLInputGroupCall, params: TLDataJSON): Single<TLAbsUpdates>

    fun phoneLeaveGroupCall(call: TLInputGroupCall, source: Int): Single<TLAbsUpdates>

    fun phoneLeaveGroupCallPresentation(call: TLInputGroupCall): Single<TLAbsUpdates>

    fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool>

    fun phoneRequestCall(
            video: Boolean,
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool>

    fun phoneSaveCallLog(peer: TLInputPhoneCall, file: TLAbsInputFile): Single<TLBool>

    fun phoneSaveDefaultGroupCallJoinAs(peer: TLAbsInputPeer, joinAs: TLAbsInputPeer): Single<TLBool>

    fun phoneSendSignalingData(peer: TLInputPhoneCall, data: TLBytes): Single<TLBool>

    fun phoneSetCallRating(
            userInitiative: Boolean,
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates>

    fun phoneStartScheduledGroupCall(call: TLInputGroupCall): Single<TLAbsUpdates>

    fun phoneToggleGroupCallRecord(
            start: Boolean,
            video: Boolean,
            call: TLInputGroupCall,
            title: String?,
            videoPortrait: Boolean?
    ): Single<TLAbsUpdates>

    fun phoneToggleGroupCallSettings(
            resetInviteHash: Boolean,
            call: TLInputGroupCall,
            joinMuted: Boolean?
    ): Single<TLAbsUpdates>

    fun phoneToggleGroupCallStartSubscription(call: TLInputGroupCall, subscribed: Boolean): Single<TLAbsUpdates>

    fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector>

    fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos>

    fun photosUpdateProfilePhoto(
            fallback: Boolean,
            bot: TLAbsInputUser?,
            id: TLAbsInputPhoto
    ): Single<TLPhoto>

    fun photosUploadContactProfilePhoto(
            suggest: Boolean,
            save: Boolean,
            userId: TLAbsInputUser,
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?,
            videoEmojiMarkup: TLAbsVideoSize?
    ): Single<TLPhoto>

    fun photosUploadProfilePhoto(
            fallback: Boolean,
            bot: TLAbsInputUser?,
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?,
            videoEmojiMarkup: TLAbsVideoSize?
    ): Single<TLPhoto>

    fun premiumApplyBoost(slots: TLIntVector?, peer: TLAbsInputPeer): Single<TLMyBoosts>

    fun premiumGetBoostsList(
            gifts: Boolean,
            peer: TLAbsInputPeer,
            offset: String,
            limit: Int
    ): Single<TLBoostsList>

    fun premiumGetBoostsStatus(peer: TLAbsInputPeer): Single<TLBoostsStatus>

    fun premiumGetMyBoosts(): Single<TLMyBoosts>

    fun premiumGetUserBoosts(peer: TLAbsInputPeer, userId: TLAbsInputUser): Single<TLBoostsList>

    fun statsGetBroadcastStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLBroadcastStats>

    fun statsGetMegagroupStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLMegagroupStats>

    fun statsGetMessagePublicForwards(
            channel: TLAbsInputChannel,
            msgId: Int,
            offset: String,
            limit: Int
    ): Single<TLPublicForwards>

    fun statsGetMessageStats(
            dark: Boolean,
            channel: TLAbsInputChannel,
            msgId: Int
    ): Single<TLMessageStats>

    fun statsGetStoryPublicForwards(
            peer: TLAbsInputPeer,
            id: Int,
            offset: String,
            limit: Int
    ): Single<TLPublicForwards>

    fun statsGetStoryStats(
            dark: Boolean,
            peer: TLAbsInputPeer,
            id: Int
    ): Single<TLStoryStats>

    fun statsLoadAsyncGraph(token: String, x: Long?): Single<TLAbsStatsGraph>

    fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLAbsStickerSet>

    fun stickersChangeSticker(
            sticker: TLAbsInputDocument,
            emoji: String?,
            maskCoords: TLMaskCoords?,
            keywords: String?
    ): Single<TLAbsStickerSet>

    fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLAbsStickerSet>

    fun stickersCheckShortName(shortName: String): Single<TLBool>

    fun stickersCreateStickerSet(
            masks: Boolean,
            animated: Boolean,
            videos: Boolean,
            emojis: Boolean,
            textColor: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            thumb: TLAbsInputDocument?,
            stickers: TLObjectVector<TLInputStickerSetItem>,
            software: String?
    ): Single<TLAbsStickerSet>

    fun stickersDeleteStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLAbsStickerSet>

    fun stickersRenameStickerSet(stickerset: TLAbsInputStickerSet, title: String): Single<TLAbsStickerSet>

    fun stickersSetStickerSetThumb(
            stickerset: TLAbsInputStickerSet,
            thumb: TLAbsInputDocument?,
            thumbDocumentId: Long?
    ): Single<TLAbsStickerSet>

    fun stickersSuggestShortName(title: String): Single<TLSuggestedShortName>

    fun storiesActivateStealthMode(past: Boolean, future: Boolean): Single<TLAbsUpdates>

    fun storiesCanSendStory(peer: TLAbsInputPeer): Single<TLBool>

    fun storiesDeleteStories(peer: TLAbsInputPeer, id: TLIntVector): Single<TLIntVector>

    fun storiesEditStory(
            peer: TLAbsInputPeer,
            id: Int,
            media: TLAbsInputMedia?,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>?
    ): Single<TLAbsUpdates>

    fun storiesExportStoryLink(peer: TLAbsInputPeer, id: Int): Single<TLExportedStoryLink>

    fun storiesGetAllReadPeerStories(): Single<TLAbsUpdates>

    fun storiesGetAllStories(
            next: Boolean,
            hidden: Boolean,
            state: String?
    ): Single<TLAbsAllStories>

    fun storiesGetChatsToSend(): Single<TLAbsChats>

    fun storiesGetPeerMaxIDs(id: TLObjectVector<TLAbsInputPeer>): Single<TLIntVector>

    fun storiesGetPeerStories(peer: TLAbsInputPeer): Single<TLPeerStories>

    fun storiesGetPinnedStories(
            peer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLStories>

    fun storiesGetStoriesArchive(
            peer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLStories>

    fun storiesGetStoriesByID(peer: TLAbsInputPeer, id: TLIntVector): Single<TLStories>

    fun storiesGetStoriesViews(peer: TLAbsInputPeer, id: TLIntVector): Single<TLStoryViews>

    fun storiesGetStoryReactionsList(
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            reaction: TLAbsReaction?,
            offset: String?,
            limit: Int
    ): Single<TLStoryReactionsList>

    fun storiesGetStoryViewsList(
            justContacts: Boolean,
            reactionsFirst: Boolean,
            forwardsFirst: Boolean,
            peer: TLAbsInputPeer,
            q: String?,
            id: Int,
            offset: String,
            limit: Int
    ): Single<TLStoryViewsList>

    fun storiesIncrementStoryViews(peer: TLAbsInputPeer, id: TLIntVector): Single<TLBool>

    fun storiesReadStories(peer: TLAbsInputPeer, maxId: Int): Single<TLIntVector>

    fun storiesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool>

    fun storiesSendReaction(
            addToRecent: Boolean,
            peer: TLAbsInputPeer,
            storyId: Int,
            reaction: TLAbsReaction
    ): Single<TLAbsUpdates>

    fun storiesSendStory(
            pinned: Boolean,
            noforwards: Boolean,
            fwdModified: Boolean,
            peer: TLAbsInputPeer,
            media: TLAbsInputMedia,
            mediaAreas: TLObjectVector<TLAbsMediaArea>?,
            caption: String?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            privacyRules: TLObjectVector<TLAbsInputPrivacyRule>,
            randomId: Long,
            period: Int?,
            fwdFromId: TLAbsInputPeer?,
            fwdFromStory: Int?
    ): Single<TLAbsUpdates>

    fun storiesToggleAllStoriesHidden(hidden: Boolean): Single<TLBool>

    fun storiesTogglePeerStoriesHidden(peer: TLAbsInputPeer, hidden: Boolean): Single<TLBool>

    fun storiesTogglePinned(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            pinned: Boolean
    ): Single<TLIntVector>

    fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference>

    fun updatesGetDifference(
            pts: Int,
            ptsLimit: Int?,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int,
            qtsLimit: Int?
    ): Single<TLAbsDifference>

    fun updatesGetState(): Single<TLState>

    fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Long,
            limit: Int
    ): Single<TLAbsCdnFile>

    fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Long): Single<TLObjectVector<TLFileHash>>

    fun uploadGetFile(
            precise: Boolean,
            cdnSupported: Boolean,
            location: TLAbsInputFileLocation,
            offset: Long,
            limit: Int
    ): Single<TLAbsFile>

    fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Long): Single<TLObjectVector<TLFileHash>>

    fun uploadGetWebFile(
            location: TLAbsInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile>

    fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLFileHash>>

    fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool>

    fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool>

    fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull>

    fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>>

    fun usersSetSecureValueErrors(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>): Single<TLBool>
}
