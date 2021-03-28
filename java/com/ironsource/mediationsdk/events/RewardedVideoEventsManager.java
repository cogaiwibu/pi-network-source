package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.onesignal.outcomes.OSOutcomeTableProvider;

public class RewardedVideoEventsManager extends BaseEventsManager {
    private static RewardedVideoEventsManager sInstance;
    private String mCurrentOWPlacement = "";

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean shouldExtractCurrentPlacement(EventData eventData) {
        return false;
    }

    private RewardedVideoEventsManager() {
        this.mFormatterType = OSOutcomeTableProvider.OUTCOME_EVENT_TABLE;
        this.mAdUnitType = 3;
        this.mEventType = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    public static synchronized RewardedVideoEventsManager getInstance() {
        RewardedVideoEventsManager rewardedVideoEventsManager;
        synchronized (RewardedVideoEventsManager.class) {
            if (sInstance == null) {
                RewardedVideoEventsManager rewardedVideoEventsManager2 = new RewardedVideoEventsManager();
                sInstance = rewardedVideoEventsManager2;
                rewardedVideoEventsManager2.initState();
            }
            rewardedVideoEventsManager = sInstance;
        }
        return rewardedVideoEventsManager;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean shouldIncludeCurrentPlacement(EventData eventData) {
        return eventData.getEventId() == 305;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean isTriggerEvent(EventData eventData) {
        int eventId = eventData.getEventId();
        return eventId == 14 || eventId == 514 || eventId == 305 || eventId == 1003 || eventId == 1005 || eventId == 1203 || eventId == 1010 || eventId == 1301 || eventId == 1302;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public int getSessionDepth(EventData eventData) {
        if (eventData.getEventId() == 15 || (eventData.getEventId() >= 300 && eventData.getEventId() < 400)) {
            return SessionDepthManager.getInstance().getSessionDepth(0);
        }
        return SessionDepthManager.getInstance().getSessionDepth(1);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public void setCurrentPlacement(EventData eventData) {
        if (eventData.getEventId() == 15 || (eventData.getEventId() >= 300 && eventData.getEventId() < 400)) {
            this.mCurrentOWPlacement = eventData.getAdditionalDataJSON().optString(IronSourceConstants.EVENTS_PLACEMENT_NAME);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public String getCurrentPlacement(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.mCurrentOWPlacement : "";
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public void initConnectivitySensitiveEventsSet() {
        this.mConnectivitySensitiveEventsSet.add(1000);
        this.mConnectivitySensitiveEventsSet.add(1001);
        this.mConnectivitySensitiveEventsSet.add(1002);
        this.mConnectivitySensitiveEventsSet.add(1003);
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_READY_TRUE));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_READY_FALSE));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL));
    }
}
