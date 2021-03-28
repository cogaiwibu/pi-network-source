package com.onesignal.influence;

import com.onesignal.OSLogger;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.influence.model.OSInfluenceType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSNotificationTracker extends OSChannelTracker {
    private static final String DIRECT_TAG = "direct";
    private static final String NOTIFICATIONS_IDS = "notification_ids";
    private static final String NOTIFICATION_ID = "notification_id";
    public static final String TAG = OSNotificationTracker.class.getCanonicalName();

    @Override // com.onesignal.influence.OSChannelTracker
    public String getIdTag() {
        return "notification_id";
    }

    OSNotificationTracker(OSInfluenceDataRepository oSInfluenceDataRepository, OSLogger oSLogger) {
        super(oSInfluenceDataRepository, oSLogger);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public JSONArray getLastChannelObjectsReceivedByNewId(String str) {
        try {
            return getLastChannelObjects();
        } catch (JSONException e) {
            this.logger.error("Generating Notification tracker getLastChannelObjects JSONObject ", e);
            return new JSONArray();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public JSONArray getLastChannelObjects() throws JSONException {
        return this.dataRepository.getLastNotificationsReceivedData();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public OSInfluenceChannel getChannelType() {
        return OSInfluenceChannel.NOTIFICATION;
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public int getChannelLimit() {
        return this.dataRepository.getNotificationLimit();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public int getIndirectAttributionWindow() {
        return this.dataRepository.getNotificationIndirectAttributionWindow();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public void saveChannelObjects(JSONArray jSONArray) {
        this.dataRepository.saveNotifications(jSONArray);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public void initInfluencedTypeFromCache() {
        OSInfluenceType notificationCachedInfluenceType = this.dataRepository.getNotificationCachedInfluenceType();
        setInfluenceType(notificationCachedInfluenceType);
        if (notificationCachedInfluenceType.isIndirect()) {
            setIndirectIds(getLastReceivedIds());
        } else if (notificationCachedInfluenceType.isDirect()) {
            setDirectId(this.dataRepository.getCachedNotificationOpenId());
        }
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal NotificationTracker initInfluencedTypeFromCache: " + toString());
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.influence.OSChannelTracker
    public void addSessionData(JSONObject jSONObject, OSInfluence oSInfluence) {
        if (oSInfluence.getInfluenceType().isAttributed()) {
            try {
                jSONObject.put(DIRECT_TAG, oSInfluence.getInfluenceType().isDirect());
                jSONObject.put(NOTIFICATIONS_IDS, oSInfluence.getIds());
            } catch (JSONException e) {
                this.logger.error("Generating notification tracker addSessionData JSONObject ", e);
            }
        }
    }

    @Override // com.onesignal.influence.OSChannelTracker
    public void cacheState() {
        this.dataRepository.cacheNotificationInfluenceType(this.influenceType == null ? OSInfluenceType.UNATTRIBUTED : this.influenceType);
        this.dataRepository.cacheNotificationOpenId(this.directId);
    }
}
