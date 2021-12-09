package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLStatsAbsValueAndPrev
import com.github.badoualy.telegram.tl.api.TLStatsDateRangeDays
import com.github.badoualy.telegram.tl.api.TLStatsGraphAsync
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopAdmin
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopInviter
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopPoster
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * stats.megagroupStats#ef7ff916
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMegagroupStats() : TLObject() {
    var period: TLStatsDateRangeDays = TLStatsDateRangeDays()

    var members: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var messages: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var viewers: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var posters: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var growthGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var membersGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var newMembersBySourceGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var languagesGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var messagesGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var actionsGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var topHoursGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var weekdaysGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var topPosters: TLObjectVector<TLStatsGroupTopPoster> = TLObjectVector()

    var topAdmins: TLObjectVector<TLStatsGroupTopAdmin> = TLObjectVector()

    var topInviters: TLObjectVector<TLStatsGroupTopInviter> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "stats.megagroupStats#ef7ff916"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            period: TLStatsDateRangeDays,
            members: TLStatsAbsValueAndPrev,
            messages: TLStatsAbsValueAndPrev,
            viewers: TLStatsAbsValueAndPrev,
            posters: TLStatsAbsValueAndPrev,
            growthGraph: TLAbsStatsGraph,
            membersGraph: TLAbsStatsGraph,
            newMembersBySourceGraph: TLAbsStatsGraph,
            languagesGraph: TLAbsStatsGraph,
            messagesGraph: TLAbsStatsGraph,
            actionsGraph: TLAbsStatsGraph,
            topHoursGraph: TLAbsStatsGraph,
            weekdaysGraph: TLAbsStatsGraph,
            topPosters: TLObjectVector<TLStatsGroupTopPoster>,
            topAdmins: TLObjectVector<TLStatsGroupTopAdmin>,
            topInviters: TLObjectVector<TLStatsGroupTopInviter>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.period = period
        this.members = members
        this.messages = messages
        this.viewers = viewers
        this.posters = posters
        this.growthGraph = growthGraph
        this.membersGraph = membersGraph
        this.newMembersBySourceGraph = newMembersBySourceGraph
        this.languagesGraph = languagesGraph
        this.messagesGraph = messagesGraph
        this.actionsGraph = actionsGraph
        this.topHoursGraph = topHoursGraph
        this.weekdaysGraph = weekdaysGraph
        this.topPosters = topPosters
        this.topAdmins = topAdmins
        this.topInviters = topInviters
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(period)
        writeTLObject(members)
        writeTLObject(messages)
        writeTLObject(viewers)
        writeTLObject(posters)
        writeTLObject(growthGraph)
        writeTLObject(membersGraph)
        writeTLObject(newMembersBySourceGraph)
        writeTLObject(languagesGraph)
        writeTLObject(messagesGraph)
        writeTLObject(actionsGraph)
        writeTLObject(topHoursGraph)
        writeTLObject(weekdaysGraph)
        writeTLVector(topPosters)
        writeTLVector(topAdmins)
        writeTLVector(topInviters)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        period = readTLObject<TLStatsDateRangeDays>(TLStatsDateRangeDays::class, TLStatsDateRangeDays.CONSTRUCTOR_ID)
        members = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        messages = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        viewers = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        posters = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        growthGraph = readTLObject<TLAbsStatsGraph>()
        membersGraph = readTLObject<TLAbsStatsGraph>()
        newMembersBySourceGraph = readTLObject<TLAbsStatsGraph>()
        languagesGraph = readTLObject<TLAbsStatsGraph>()
        messagesGraph = readTLObject<TLAbsStatsGraph>()
        actionsGraph = readTLObject<TLAbsStatsGraph>()
        topHoursGraph = readTLObject<TLAbsStatsGraph>()
        weekdaysGraph = readTLObject<TLAbsStatsGraph>()
        topPosters = readTLVector<TLStatsGroupTopPoster>()
        topAdmins = readTLVector<TLStatsGroupTopAdmin>()
        topInviters = readTLVector<TLStatsGroupTopInviter>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += period.computeSerializedSize()
        size += members.computeSerializedSize()
        size += messages.computeSerializedSize()
        size += viewers.computeSerializedSize()
        size += posters.computeSerializedSize()
        size += growthGraph.computeSerializedSize()
        size += membersGraph.computeSerializedSize()
        size += newMembersBySourceGraph.computeSerializedSize()
        size += languagesGraph.computeSerializedSize()
        size += messagesGraph.computeSerializedSize()
        size += actionsGraph.computeSerializedSize()
        size += topHoursGraph.computeSerializedSize()
        size += weekdaysGraph.computeSerializedSize()
        size += topPosters.computeSerializedSize()
        size += topAdmins.computeSerializedSize()
        size += topInviters.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMegagroupStats) return false
        if (other === this) return true

        return period == other.period
                && members == other.members
                && messages == other.messages
                && viewers == other.viewers
                && posters == other.posters
                && growthGraph == other.growthGraph
                && membersGraph == other.membersGraph
                && newMembersBySourceGraph == other.newMembersBySourceGraph
                && languagesGraph == other.languagesGraph
                && messagesGraph == other.messagesGraph
                && actionsGraph == other.actionsGraph
                && topHoursGraph == other.topHoursGraph
                && weekdaysGraph == other.weekdaysGraph
                && topPosters == other.topPosters
                && topAdmins == other.topAdmins
                && topInviters == other.topInviters
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xef7ff916.toInt()
    }
}
