package com.onesignal.influence;

import com.onesignal.OSLogger;
import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.influence.model.OSInfluence;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class OSTrackerFactory {
    private OSInfluenceDataRepository dataRepository;
    private ConcurrentHashMap<String, OSChannelTracker> trackers = new ConcurrentHashMap<>();

    public OSTrackerFactory(OSSharedPreferences oSSharedPreferences, OSLogger oSLogger) {
        this.dataRepository = new OSInfluenceDataRepository(oSSharedPreferences);
        this.trackers.put(OSInAppMessageTracker.TAG, new OSInAppMessageTracker(this.dataRepository, oSLogger));
        this.trackers.put(OSNotificationTracker.TAG, new OSNotificationTracker(this.dataRepository, oSLogger));
    }

    public void saveInfluenceParams(OneSignalRemoteParams.InfluenceParams influenceParams) {
        this.dataRepository.saveInfluenceParams(influenceParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.onesignal.influence.OSTrackerFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$onesignal$influence$model$OSInfluenceChannel;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.onesignal.influence.model.OSInfluenceChannel[] r0 = com.onesignal.influence.model.OSInfluenceChannel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.onesignal.influence.OSTrackerFactory.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceChannel = r0
                com.onesignal.influence.model.OSInfluenceChannel r1 = com.onesignal.influence.model.OSInfluenceChannel.NOTIFICATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.onesignal.influence.OSTrackerFactory.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceChannel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.influence.model.OSInfluenceChannel r1 = com.onesignal.influence.model.OSInfluenceChannel.IAM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.influence.OSTrackerFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public void addSessionData(JSONObject jSONObject, List<OSInfluence> list) {
        for (OSInfluence oSInfluence : list) {
            if (AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceChannel[oSInfluence.getInfluenceChannel().ordinal()] == 1) {
                getNotificationChannelTracker().addSessionData(jSONObject, oSInfluence);
            }
        }
    }

    public void initFromCache() {
        for (OSChannelTracker oSChannelTracker : this.trackers.values()) {
            oSChannelTracker.initInfluencedTypeFromCache();
        }
    }

    public List<OSInfluence> getInfluences() {
        ArrayList arrayList = new ArrayList();
        for (OSChannelTracker oSChannelTracker : this.trackers.values()) {
            arrayList.add(oSChannelTracker.getCurrentSessionInfluence());
        }
        return arrayList;
    }

    public List<OSInfluence> getSessionInfluences() {
        ArrayList arrayList = new ArrayList();
        for (OSChannelTracker oSChannelTracker : this.trackers.values()) {
            if (!(oSChannelTracker instanceof OSInAppMessageTracker)) {
                arrayList.add(oSChannelTracker.getCurrentSessionInfluence());
            }
        }
        return arrayList;
    }

    public OSChannelTracker getIAMChannelTracker() {
        return this.trackers.get(OSInAppMessageTracker.TAG);
    }

    public OSChannelTracker getNotificationChannelTracker() {
        return this.trackers.get(OSNotificationTracker.TAG);
    }

    public OSChannelTracker getChannelByEntryAction(OneSignal.AppEntryAction appEntryAction) {
        if (appEntryAction.isNotificationClick()) {
            return getNotificationChannelTracker();
        }
        return null;
    }

    public List<OSChannelTracker> getChannels() {
        ArrayList arrayList = new ArrayList();
        OSChannelTracker notificationChannelTracker = getNotificationChannelTracker();
        if (notificationChannelTracker != null) {
            arrayList.add(notificationChannelTracker);
        }
        OSChannelTracker iAMChannelTracker = getIAMChannelTracker();
        if (iAMChannelTracker != null) {
            arrayList.add(iAMChannelTracker);
        }
        return arrayList;
    }

    public List<OSChannelTracker> getChannelsToResetByEntryAction(OneSignal.AppEntryAction appEntryAction) {
        OSChannelTracker notificationChannelTracker;
        ArrayList arrayList = new ArrayList();
        if (appEntryAction.isAppClose()) {
            return arrayList;
        }
        if (appEntryAction.isAppOpen() && (notificationChannelTracker = getNotificationChannelTracker()) != null) {
            arrayList.add(notificationChannelTracker);
        }
        OSChannelTracker iAMChannelTracker = getIAMChannelTracker();
        if (iAMChannelTracker != null) {
            arrayList.add(iAMChannelTracker);
        }
        return arrayList;
    }
}
