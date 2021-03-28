package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.SessionDepthManager;

public class InterstitialEventsManager extends BaseEventsManager {
    private static InterstitialEventsManager sInstance;
    private String mCurrentISPlacement = "";

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean shouldExtractCurrentPlacement(EventData eventData) {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean shouldIncludeCurrentPlacement(EventData eventData) {
        return false;
    }

    private InterstitialEventsManager() {
        this.mFormatterType = "ironbeast";
        this.mAdUnitType = 2;
        this.mEventType = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    public static synchronized InterstitialEventsManager getInstance() {
        InterstitialEventsManager interstitialEventsManager;
        synchronized (InterstitialEventsManager.class) {
            if (sInstance == null) {
                InterstitialEventsManager interstitialEventsManager2 = new InterstitialEventsManager();
                sInstance = interstitialEventsManager2;
                interstitialEventsManager2.initState();
            }
            interstitialEventsManager = sInstance;
        }
        return interstitialEventsManager;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public boolean isTriggerEvent(EventData eventData) {
        int eventId = eventData.getEventId();
        return eventId == 2204 || eventId == 2004 || eventId == 2005 || eventId == 2301 || eventId == 2300 || eventId == 3005 || eventId == 3015;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public int getSessionDepth(EventData eventData) {
        return SessionDepthManager.getInstance().getSessionDepth(eventData.getEventId() >= 3000 && eventData.getEventId() < 4000 ? 3 : 2);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public void setCurrentPlacement(EventData eventData) {
        this.mCurrentISPlacement = eventData.getAdditionalDataJSON().optString(IronSourceConstants.EVENTS_PLACEMENT_NAME);
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public String getCurrentPlacement(int i) {
        return this.mCurrentISPlacement;
    }

    /* access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.events.BaseEventsManager
    public void initConnectivitySensitiveEventsSet() {
        this.mConnectivitySensitiveEventsSet.add(2001);
        this.mConnectivitySensitiveEventsSet.add(2002);
        this.mConnectivitySensitiveEventsSet.add(2003);
        this.mConnectivitySensitiveEventsSet.add(2004);
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.IS_INSTANCE_LOAD_FAILED));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.IS_INSTANCE_READY_TRUE));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.IS_INSTANCE_READY_FALSE));
        this.mConnectivitySensitiveEventsSet.add(3001);
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_CALLBACK_LOAD_ERROR));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_RELOAD));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_RELOAD_FAILED));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS));
        this.mConnectivitySensitiveEventsSet.add(3002);
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_RELOAD));
        this.mConnectivitySensitiveEventsSet.add(3005);
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_LOAD_ERROR));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS));
        this.mConnectivitySensitiveEventsSet.add(Integer.valueOf((int) IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS));
    }
}
