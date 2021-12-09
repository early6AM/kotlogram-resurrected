package com.github.badoualy.telegram.tl.api.stats

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph
import com.github.badoualy.telegram.tl.api.TLMessageInteractionCounters
import com.github.badoualy.telegram.tl.api.TLStatsAbsValueAndPrev
import com.github.badoualy.telegram.tl.api.TLStatsDateRangeDays
import com.github.badoualy.telegram.tl.api.TLStatsGraphAsync
import com.github.badoualy.telegram.tl.api.TLStatsPercentValue
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * stats.broadcastStats#bdf78394
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBroadcastStats() : TLObject() {
    var period: TLStatsDateRangeDays = TLStatsDateRangeDays()

    var followers: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var viewsPerPost: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var sharesPerPost: TLStatsAbsValueAndPrev = TLStatsAbsValueAndPrev()

    var enabledNotifications: TLStatsPercentValue = TLStatsPercentValue()

    var growthGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var followersGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var muteGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var topHoursGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var interactionsGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var ivInteractionsGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var viewsBySourceGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var newFollowersBySourceGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var languagesGraph: TLAbsStatsGraph = TLStatsGraphAsync()

    var recentMessageInteractions: TLObjectVector<TLMessageInteractionCounters> = TLObjectVector()

    private val _constructor: String = "stats.broadcastStats#bdf78394"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            period: TLStatsDateRangeDays,
            followers: TLStatsAbsValueAndPrev,
            viewsPerPost: TLStatsAbsValueAndPrev,
            sharesPerPost: TLStatsAbsValueAndPrev,
            enabledNotifications: TLStatsPercentValue,
            growthGraph: TLAbsStatsGraph,
            followersGraph: TLAbsStatsGraph,
            muteGraph: TLAbsStatsGraph,
            topHoursGraph: TLAbsStatsGraph,
            interactionsGraph: TLAbsStatsGraph,
            ivInteractionsGraph: TLAbsStatsGraph,
            viewsBySourceGraph: TLAbsStatsGraph,
            newFollowersBySourceGraph: TLAbsStatsGraph,
            languagesGraph: TLAbsStatsGraph,
            recentMessageInteractions: TLObjectVector<TLMessageInteractionCounters>
    ) : this() {
        this.period = period
        this.followers = followers
        this.viewsPerPost = viewsPerPost
        this.sharesPerPost = sharesPerPost
        this.enabledNotifications = enabledNotifications
        this.growthGraph = growthGraph
        this.followersGraph = followersGraph
        this.muteGraph = muteGraph
        this.topHoursGraph = topHoursGraph
        this.interactionsGraph = interactionsGraph
        this.ivInteractionsGraph = ivInteractionsGraph
        this.viewsBySourceGraph = viewsBySourceGraph
        this.newFollowersBySourceGraph = newFollowersBySourceGraph
        this.languagesGraph = languagesGraph
        this.recentMessageInteractions = recentMessageInteractions
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(period)
        writeTLObject(followers)
        writeTLObject(viewsPerPost)
        writeTLObject(sharesPerPost)
        writeTLObject(enabledNotifications)
        writeTLObject(growthGraph)
        writeTLObject(followersGraph)
        writeTLObject(muteGraph)
        writeTLObject(topHoursGraph)
        writeTLObject(interactionsGraph)
        writeTLObject(ivInteractionsGraph)
        writeTLObject(viewsBySourceGraph)
        writeTLObject(newFollowersBySourceGraph)
        writeTLObject(languagesGraph)
        writeTLVector(recentMessageInteractions)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        period = readTLObject<TLStatsDateRangeDays>(TLStatsDateRangeDays::class, TLStatsDateRangeDays.CONSTRUCTOR_ID)
        followers = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        viewsPerPost = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        sharesPerPost = readTLObject<TLStatsAbsValueAndPrev>(TLStatsAbsValueAndPrev::class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID)
        enabledNotifications = readTLObject<TLStatsPercentValue>(TLStatsPercentValue::class, TLStatsPercentValue.CONSTRUCTOR_ID)
        growthGraph = readTLObject<TLAbsStatsGraph>()
        followersGraph = readTLObject<TLAbsStatsGraph>()
        muteGraph = readTLObject<TLAbsStatsGraph>()
        topHoursGraph = readTLObject<TLAbsStatsGraph>()
        interactionsGraph = readTLObject<TLAbsStatsGraph>()
        ivInteractionsGraph = readTLObject<TLAbsStatsGraph>()
        viewsBySourceGraph = readTLObject<TLAbsStatsGraph>()
        newFollowersBySourceGraph = readTLObject<TLAbsStatsGraph>()
        languagesGraph = readTLObject<TLAbsStatsGraph>()
        recentMessageInteractions = readTLVector<TLMessageInteractionCounters>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += period.computeSerializedSize()
        size += followers.computeSerializedSize()
        size += viewsPerPost.computeSerializedSize()
        size += sharesPerPost.computeSerializedSize()
        size += enabledNotifications.computeSerializedSize()
        size += growthGraph.computeSerializedSize()
        size += followersGraph.computeSerializedSize()
        size += muteGraph.computeSerializedSize()
        size += topHoursGraph.computeSerializedSize()
        size += interactionsGraph.computeSerializedSize()
        size += ivInteractionsGraph.computeSerializedSize()
        size += viewsBySourceGraph.computeSerializedSize()
        size += newFollowersBySourceGraph.computeSerializedSize()
        size += languagesGraph.computeSerializedSize()
        size += recentMessageInteractions.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBroadcastStats) return false
        if (other === this) return true

        return period == other.period
                && followers == other.followers
                && viewsPerPost == other.viewsPerPost
                && sharesPerPost == other.sharesPerPost
                && enabledNotifications == other.enabledNotifications
                && growthGraph == other.growthGraph
                && followersGraph == other.followersGraph
                && muteGraph == other.muteGraph
                && topHoursGraph == other.topHoursGraph
                && interactionsGraph == other.interactionsGraph
                && ivInteractionsGraph == other.ivInteractionsGraph
                && viewsBySourceGraph == other.viewsBySourceGraph
                && newFollowersBySourceGraph == other.newFollowersBySourceGraph
                && languagesGraph == other.languagesGraph
                && recentMessageInteractions == other.recentMessageInteractions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbdf78394.toInt()
    }
}
