package com.onesignal.outcomes;

import com.onesignal.OSLogger;
import com.onesignal.OneSignalApiResponseHandler;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.outcomes.domain.OutcomeEventsService;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public abstract class OSOutcomeEventsRepository implements com.onesignal.outcomes.domain.OSOutcomeEventsRepository {
    static final String APP_ID = "app_id";
    static final String DEVICE_TYPE = "device_type";
    protected final OSLogger logger;
    private final OSOutcomeEventsCache outcomeEventsCache;
    final OutcomeEventsService outcomeEventsService;

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public abstract void requestMeasureOutcomeEvent(String str, int i, OSOutcomeEventParams oSOutcomeEventParams, OneSignalApiResponseHandler oneSignalApiResponseHandler);

    OSOutcomeEventsRepository(OSLogger oSLogger, OSOutcomeEventsCache oSOutcomeEventsCache, OutcomeEventsService outcomeEventsService2) {
        this.logger = oSLogger;
        this.outcomeEventsCache = oSOutcomeEventsCache;
        this.outcomeEventsService = outcomeEventsService2;
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public List<OSOutcomeEventParams> getSavedOutcomeEvents() {
        return this.outcomeEventsCache.getAllEventsToSend();
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public void saveOutcomeEvent(OSOutcomeEventParams oSOutcomeEventParams) {
        this.outcomeEventsCache.saveOutcomeEvent(oSOutcomeEventParams);
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public void removeEvent(OSOutcomeEventParams oSOutcomeEventParams) {
        this.outcomeEventsCache.deleteOldOutcomeEvent(oSOutcomeEventParams);
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public void saveUniqueOutcomeNotifications(OSOutcomeEventParams oSOutcomeEventParams) {
        this.outcomeEventsCache.saveUniqueOutcomeEventParams(oSOutcomeEventParams);
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public List<OSInfluence> getNotCachedUniqueOutcome(String str, List<OSInfluence> list) {
        List<OSInfluence> notCachedUniqueInfluencesForOutcome = this.outcomeEventsCache.getNotCachedUniqueInfluencesForOutcome(str, list);
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal getNotCachedUniqueOutcome influences: " + notCachedUniqueInfluencesForOutcome);
        return notCachedUniqueInfluencesForOutcome;
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public Set<String> getUnattributedUniqueOutcomeEventsSent() {
        Set<String> unattributedUniqueOutcomeEventsSentByChannel = this.outcomeEventsCache.getUnattributedUniqueOutcomeEventsSentByChannel();
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal getUnattributedUniqueOutcomeEventsSentByChannel: " + unattributedUniqueOutcomeEventsSentByChannel);
        return unattributedUniqueOutcomeEventsSentByChannel;
    }

    @Override // com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public void saveUnattributedUniqueOutcomeEventsSent(Set<String> set) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal save unattributedUniqueOutcomeEvents: " + set);
        this.outcomeEventsCache.saveUnattributedUniqueOutcomeEventsSentByChannel(set);
    }
}
