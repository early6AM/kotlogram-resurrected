package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.api.account.TLAbsChatThemes
import com.github.badoualy.telegram.tl.api.account.TLAbsResetPasswordResult
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
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.api.contacts.TLFound
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsCountriesList
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsPassportConfig
import com.github.badoualy.telegram.tl.api.help.TLAbsPromoData
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsUserInfo
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.help.TLSupportName
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers
import com.github.badoualy.telegram.tl.api.messages.TLAffectedFoundMessages
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.api.messages.TLChatAdminsWithInvites
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters
import com.github.badoualy.telegram.tl.api.messages.TLCheckedHistoryImportPeer
import com.github.badoualy.telegram.tl.api.messages.TLDiscussionMessage
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites
import com.github.badoualy.telegram.tl.api.messages.TLHighScores
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImport
import com.github.badoualy.telegram.tl.api.messages.TLHistoryImportParsed
import com.github.badoualy.telegram.tl.api.messages.TLInactiveChats
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData
import com.github.badoualy.telegram.tl.api.messages.TLMessageViews
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs
import com.github.badoualy.telegram.tl.api.messages.TLSearchCounter
import com.github.badoualy.telegram.tl.api.messages.TLSponsoredMessages
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.api.messages.TLVotesList
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.api.payments.TLBankCardData
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.api.payments.TLPaymentReceipt
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.api.phone.TLExportedGroupCallInvite
import com.github.badoualy.telegram.tl.api.phone.TLGroupCall
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants
import com.github.badoualy.telegram.tl.api.phone.TLJoinAsPeers
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.stats.TLBroadcastStats
import com.github.badoualy.telegram.tl.api.stats.TLMegagroupStats
import com.github.badoualy.telegram.tl.api.stats.TLMessageStats
import com.github.badoualy.telegram.tl.api.stickers.TLSuggestedShortName
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLBytesVector
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import io.reactivex.Single

interface TelegramApi {
    fun accountAcceptAuthorization(
            botId: Long,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): Single<TLBool>

    fun accountCancelPasswordEmail(): Single<TLBool>

    fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser>

    fun accountCheckUsername(username: String): Single<TLBool>

    fun accountConfirmPasswordEmail(code: String): Single<TLBool>

    fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool>

    fun accountCreateTheme(
            slug: String,
            title: String,
            document: TLAbsInputDocument?,
            settings: TLInputThemeSettings?
    ): Single<TLTheme>

    fun accountDeclinePasswordReset(): Single<TLBool>

    fun accountDeleteAccount(reason: String): Single<TLBool>

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

    fun accountGetChatThemes(hash: Int): Single<TLAbsChatThemes>

    fun accountGetContactSignUpNotification(): Single<TLBool>

    fun accountGetContentSettings(): Single<TLContentSettings>

    fun accountGetGlobalPrivacySettings(): Single<TLGlobalPrivacySettings>

    fun accountGetMultiWallPapers(wallpapers: TLObjectVector<TLAbsInputWallPaper>): Single<TLObjectVector<TLAbsWallPaper>>

    fun accountGetNotifyExceptions(compareSound: Boolean, peer: TLAbsInputNotifyPeer?): Single<TLAbsUpdates>

    fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLPeerNotifySettings>

    fun accountGetPassword(): Single<TLPassword>

    fun accountGetPasswordSettings(password: TLAbsInputCheckPasswordSRP): Single<TLPasswordSettings>

    fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules>

    fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLObjectVector<TLSecureValue>>

    fun accountGetTheme(
            format: String,
            theme: TLAbsInputTheme,
            documentId: Long
    ): Single<TLTheme>

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
            fileMaxSize: Int?
    ): Single<TLTakeout>

    fun accountInstallTheme(
            dark: Boolean,
            format: String?,
            theme: TLAbsInputTheme?
    ): Single<TLBool>

    fun accountInstallWallPaper(wallpaper: TLAbsInputWallPaper, settings: TLWallPaperSettings): Single<TLBool>

    fun accountRegisterDevice(
            noMuted: Boolean,
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLLongVector
    ): Single<TLBool>

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

    fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): Single<TLSecureValue>

    fun accountSaveTheme(theme: TLAbsInputTheme, unsave: Boolean): Single<TLBool>

    fun accountSaveWallPaper(
            wallpaper: TLAbsInputWallPaper,
            unsave: Boolean,
            settings: TLWallPaperSettings
    ): Single<TLBool>

    fun accountSendChangePhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLSentCode>

    fun accountSendConfirmPhoneCode(hash: String, settings: TLCodeSettings): Single<TLSentCode>

    fun accountSendVerifyEmailCode(email: String): Single<TLSentEmailCode>

    fun accountSendVerifyPhoneCode(phoneNumber: String, settings: TLCodeSettings): Single<TLSentCode>

    fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool>

    fun accountSetContactSignUpNotification(silent: Boolean): Single<TLBool>

    fun accountSetContentSettings(sensitiveEnabled: Boolean): Single<TLBool>

    fun accountSetGlobalPrivacySettings(settings: TLGlobalPrivacySettings): Single<TLGlobalPrivacySettings>

    fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules>

    fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLLongVector
    ): Single<TLBool>

    fun accountUpdateDeviceLocked(period: Int): Single<TLBool>

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
            settings: TLInputThemeSettings?
    ): Single<TLTheme>

    fun accountUpdateUsername(username: String): Single<TLAbsUser>

    fun accountUploadTheme(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            fileName: String,
            mimeType: String
    ): Single<TLAbsDocument>

    fun accountUploadWallPaper(
            file: TLAbsInputFile,
            mimeType: String,
            settings: TLWallPaperSettings
    ): Single<TLAbsWallPaper>

    fun accountVerifyEmail(email: String, code: String): Single<TLBool>

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

    fun authLogOut(): Single<TLBool>

    fun authRecoverPassword(code: String, newSettings: TLPasswordInputSettings?): Single<TLAbsAuthorization>

    fun authRequestPasswordRecovery(): Single<TLPasswordRecovery>

    fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode>

    fun authResetAuthorizations(): Single<TLBool>

    fun authSendCode(
            phoneNumber: String,
            apiId: Int,
            apiHash: String,
            settings: TLCodeSettings
    ): Single<TLSentCode>

    fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsAuthorization>

    fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            firstName: String,
            lastName: String
    ): Single<TLAbsAuthorization>

    fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool>

    fun botsGetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLObjectVector<TLBotCommand>>

    fun botsResetBotCommands(scope: TLAbsBotCommandScope, langCode: String): Single<TLBool>

    fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON>

    fun botsSetBotCommands(
            scope: TLAbsBotCommandScope,
            langCode: String,
            commands: TLObjectVector<TLBotCommand>
    ): Single<TLBool>

    fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun channelsConvertToGigagroup(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            forImport: Boolean,
            title: String,
            about: String,
            geoPoint: TLAbsInputGeoPoint?,
            address: String?
    ): Single<TLAbsUpdates>

    fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool>

    fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages>

    fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory>

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

    fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats>

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

    fun channelsGetSponsoredMessages(channel: TLAbsInputChannel): Single<TLSponsoredMessages>

    fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool>

    fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool>

    fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool>

    fun channelsSetDiscussionGroup(broadcast: TLAbsInputChannel, group: TLAbsInputChannel): Single<TLBool>

    fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleSlowMode(channel: TLAbsInputChannel, seconds: Int): Single<TLAbsUpdates>

    fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun channelsViewSponsoredMessage(channel: TLAbsInputChannel, randomId: TLBytes): Single<TLBool>

    fun contactsAcceptContact(id: TLAbsInputUser): Single<TLAbsUpdates>

    fun contactsAddContact(
            addPhonePrivacyException: Boolean,
            id: TLAbsInputUser,
            firstName: String,
            lastName: String,
            phone: String
    ): Single<TLAbsUpdates>

    fun contactsBlock(id: TLAbsInputPeer): Single<TLBool>

    fun contactsBlockFromReplies(
            deleteMessage: Boolean,
            deleteHistory: Boolean,
            reportSpam: Boolean,
            msgId: Int
    ): Single<TLAbsUpdates>

    fun contactsDeleteByPhones(phones: TLStringVector): Single<TLBool>

    fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked>

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
            offset: Int,
            limit: Int,
            hash: Long
    ): Single<TLAbsTopPeers>

    fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts>

    fun contactsResetSaved(): Single<TLBool>

    fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool>

    fun contactsResolveUsername(username: String): Single<TLResolvedPeer>

    fun contactsSearch(q: String, limit: Int): Single<TLFound>

    fun contactsToggleTopPeers(enabled: Boolean): Single<TLBool>

    fun contactsUnblock(id: TLAbsInputPeer): Single<TLBool>

    fun foldersDeleteFolder(folderId: Int): Single<TLAbsUpdates>

    fun foldersEditPeerFolders(folderPeers: TLObjectVector<TLInputFolderPeer>): Single<TLAbsUpdates>

    fun helpAcceptTermsOfService(id: TLDataJSON): Single<TLBool>

    fun helpDismissSuggestion(peer: TLAbsInputPeer, suggestion: String): Single<TLBool>

    fun helpEditUserInfo(
            userId: TLAbsInputUser,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>
    ): Single<TLAbsUserInfo>

    fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates>

    fun helpGetAppConfig(): Single<TLAbsJSONValue>

    fun helpGetAppUpdate(source: String): Single<TLAbsAppUpdate>

    fun helpGetCdnConfig(): Single<TLCdnConfig>

    fun helpGetConfig(): Single<TLConfig>

    fun helpGetCountriesList(langCode: String, hash: Int): Single<TLAbsCountriesList>

    fun helpGetDeepLinkInfo(path: String): Single<TLAbsDeepLinkInfo>

    fun helpGetInviteText(): Single<TLInviteText>

    fun helpGetNearestDc(): Single<TLNearestDc>

    fun helpGetPassportConfig(hash: Int): Single<TLAbsPassportConfig>

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

    fun messagesClearRecentStickers(attached: Boolean): Single<TLBool>

    fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates>

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
            maxId: Int
    ): Single<TLAffectedHistory>

    fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages>

    fun messagesDeletePhoneCallHistory(revoke: Boolean): Single<TLAffectedFoundMessages>

    fun messagesDeleteRevokedExportedChatInvites(peer: TLAbsInputPeer, adminId: TLAbsInputUser): Single<TLBool>

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
            usageLimit: Int?
    ): Single<TLAbsExportedChatInvite>

    fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLAbsInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool>

    fun messagesEditMessage(
            noWebpage: Boolean,
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
            peer: TLAbsInputPeer,
            expireDate: Int?,
            usageLimit: Int?
    ): Single<TLChatInviteExported>

    fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool>

    fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            dropAuthor: Boolean,
            dropMediaCaptions: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesGetAdminsWithInvites(peer: TLAbsInputPeer): Single<TLChatAdminsWithInvites>

    fun messagesGetAllChats(exceptIds: TLLongVector): Single<TLAbsChats>

    fun messagesGetAllDrafts(): Single<TLAbsUpdates>

    fun messagesGetAllStickers(hash: Long): Single<TLAbsAllStickers>

    fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers>

    fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>>

    fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?,
            password: TLAbsInputCheckPasswordSRP?
    ): Single<TLBotCallbackAnswer>

    fun messagesGetChatInviteImporters(
            peer: TLAbsInputPeer,
            link: String,
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

    fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig>

    fun messagesGetDialogFilters(): Single<TLObjectVector<TLDialogFilter>>

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
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument>

    fun messagesGetEmojiKeywords(langCode: String): Single<TLEmojiKeywordsDifference>

    fun messagesGetEmojiKeywordsDifference(langCode: String, fromVersion: Int): Single<TLEmojiKeywordsDifference>

    fun messagesGetEmojiKeywordsLanguages(langCodes: TLStringVector): Single<TLObjectVector<TLEmojiLanguage>>

    fun messagesGetEmojiURL(langCode: String): Single<TLEmojiURL>

    fun messagesGetExportedChatInvite(peer: TLAbsInputPeer, link: String): Single<TLAbsExportedChatInvite>

    fun messagesGetExportedChatInvites(
            revoked: Boolean,
            peer: TLAbsInputPeer,
            adminId: TLAbsInputUser,
            offsetDate: Int?,
            offsetLink: String?,
            limit: Int
    ): Single<TLExportedChatInvites>

    fun messagesGetFavedStickers(hash: Long): Single<TLAbsFavedStickers>

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

    fun messagesGetMessageReadParticipants(peer: TLAbsInputPeer, msgId: Int): Single<TLLongVector>

    fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages>

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

    fun messagesGetSavedGifs(hash: Long): Single<TLAbsSavedGifs>

    fun messagesGetScheduledHistory(peer: TLAbsInputPeer, hash: Long): Single<TLAbsMessages>

    fun messagesGetScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsMessages>

    fun messagesGetSearchCounters(peer: TLAbsInputPeer, filters: TLObjectVector<TLAbsMessagesFilter>): Single<TLObjectVector<TLSearchCounter>>

    fun messagesGetSplitRanges(): Single<TLObjectVector<TLMessageRange>>

    fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet>

    fun messagesGetStickers(emoticon: String, hash: Long): Single<TLAbsStickers>

    fun messagesGetSuggestedDialogFilters(): Single<TLObjectVector<TLDialogFilterSuggested>>

    fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage>

    fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): Single<TLAbsMessageMedia>

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

    fun messagesReadDiscussion(
            peer: TLAbsInputPeer,
            msgId: Int,
            readMaxId: Int
    ): Single<TLBool>

    fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool>

    fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool>

    fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages>

    fun messagesReadMentions(peer: TLAbsInputPeer): Single<TLAffectedHistory>

    fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages>

    fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>>

    fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector>

    fun messagesReorderPinnedDialogs(
            force: Boolean,
            folderId: Int,
            order: TLObjectVector<TLAbsInputDialogPeer>
    ): Single<TLBool>

    fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool>

    fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason,
            message: String
    ): Single<TLBool>

    fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool>

    fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool>

    fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat>

    fun messagesRequestUrlAuth(
            peer: TLAbsInputPeer?,
            msgId: Int?,
            buttonId: Int?,
            url: String?
    ): Single<TLAbsUrlAuthResult>

    fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
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

    fun messagesSearchGlobal(
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

    fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Long
    ): Single<TLAbsFoundStickerSets>

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
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            multiMedia: TLObjectVector<TLInputSingleMedia>,
            scheduleDate: Int?
    ): Single<TLAbsUpdates>

    fun messagesSendScheduledMessages(peer: TLAbsInputPeer, id: TLIntVector): Single<TLAbsUpdates>

    fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates>

    fun messagesSendVote(
            peer: TLAbsInputPeer,
            msgId: Int,
            options: TLBytesVector
    ): Single<TLAbsUpdates>

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

    fun messagesSetChatTheme(peer: TLAbsInputPeer, emoticon: String): Single<TLAbsUpdates>

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
            switchPm: TLInlineBotSwitchPM?
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

    fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputDialogPeer): Single<TLBool>

    fun messagesToggleStickerSets(
            uninstall: Boolean,
            archive: Boolean,
            unarchive: Boolean,
            stickersets: TLObjectVector<TLAbsInputStickerSet>
    ): Single<TLBool>

    fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun messagesUnpinAllMessages(peer: TLAbsInputPeer): Single<TLAffectedHistory>

    fun messagesUpdateDialogFilter(id: Int, filter: TLDialogFilter?): Single<TLBool>

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

    fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool>

    fun paymentsGetBankCardData(number: String): Single<TLBankCardData>

    fun paymentsGetPaymentForm(
            peer: TLAbsInputPeer,
            msgId: Int,
            themeParams: TLDataJSON?
    ): Single<TLPaymentForm>

    fun paymentsGetPaymentReceipt(peer: TLAbsInputPeer, msgId: Int): Single<TLPaymentReceipt>

    fun paymentsGetSavedInfo(): Single<TLSavedInfo>

    fun paymentsSendPaymentForm(
            formId: Long,
            peer: TLAbsInputPeer,
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials,
            tipAmount: Long?
    ): Single<TLAbsPaymentResult>

    fun paymentsValidateRequestedInfo(
            save: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
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

    fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLPhoto>

    fun photosUploadProfilePhoto(
            file: TLAbsInputFile?,
            video: TLAbsInputFile?,
            videoStartTs: Double?
    ): Single<TLPhoto>

    fun statsGetBroadcastStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLBroadcastStats>

    fun statsGetMegagroupStats(dark: Boolean, channel: TLAbsInputChannel): Single<TLMegagroupStats>

    fun statsGetMessagePublicForwards(
            channel: TLAbsInputChannel,
            msgId: Int,
            offsetRate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages>

    fun statsGetMessageStats(
            dark: Boolean,
            channel: TLAbsInputChannel,
            msgId: Int
    ): Single<TLMessageStats>

    fun statsLoadAsyncGraph(token: String, x: Long?): Single<TLAbsStatsGraph>

    fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet>

    fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet>

    fun stickersCheckShortName(shortName: String): Single<TLBool>

    fun stickersCreateStickerSet(
            masks: Boolean,
            animated: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            thumb: TLAbsInputDocument?,
            stickers: TLObjectVector<TLInputStickerSetItem>,
            software: String?
    ): Single<TLStickerSet>

    fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet>

    fun stickersSetStickerSetThumb(stickerset: TLAbsInputStickerSet, thumb: TLAbsInputDocument): Single<TLStickerSet>

    fun stickersSuggestShortName(title: String): Single<TLSuggestedShortName>

    fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference>

    fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference>

    fun updatesGetState(): Single<TLState>

    fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile>

    fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLFileHash>>

    fun uploadGetFile(
            precise: Boolean,
            cdnSupported: Boolean,
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile>

    fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Int): Single<TLObjectVector<TLFileHash>>

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
