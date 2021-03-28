package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.influence.OSChannelTracker;
import com.onesignal.influence.OSTrackerFactory;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.influence.model.OSInfluenceType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class OSSessionManager {
    private static final String OS_END_CURRENT_SESSION = "OS_END_CURRENT_SESSION";
    private OSLogger logger;
    private SessionListener sessionListener;
    protected OSTrackerFactory trackerFactory;

    public interface SessionListener {
        void onSessionEnding(List<OSInfluence> list);
    }

    public OSSessionManager(SessionListener sessionListener2, OSTrackerFactory oSTrackerFactory, OSLogger oSLogger) {
        this.sessionListener = sessionListener2;
        this.trackerFactory = oSTrackerFactory;
        this.logger = oSLogger;
    }

    /* access modifiers changed from: package-private */
    public void initSessionFromCache() {
        this.logger.debug("OneSignal SessionManager initSessionFromCache");
        this.trackerFactory.initFromCache();
    }

    /* access modifiers changed from: package-private */
    public void addSessionIds(JSONObject jSONObject, List<OSInfluence> list) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager addSessionData with influences: " + list.toString());
        this.trackerFactory.addSessionData(jSONObject, list);
        OSLogger oSLogger2 = this.logger;
        oSLogger2.debug("OneSignal SessionManager addSessionIds on jsonObject: " + jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void restartSessionIfNeeded(OneSignal.AppEntryAction appEntryAction) {
        boolean z;
        List<OSChannelTracker> channelsToResetByEntryAction = this.trackerFactory.getChannelsToResetByEntryAction(appEntryAction);
        ArrayList arrayList = new ArrayList();
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager restartSessionIfNeeded with entryAction: " + appEntryAction + "\n channelTrackers: " + channelsToResetByEntryAction.toString());
        for (OSChannelTracker oSChannelTracker : channelsToResetByEntryAction) {
            JSONArray lastReceivedIds = oSChannelTracker.getLastReceivedIds();
            OSLogger oSLogger2 = this.logger;
            oSLogger2.debug("OneSignal SessionManager restartSessionIfNeeded lastIds: " + lastReceivedIds);
            OSInfluence currentSessionInfluence = oSChannelTracker.getCurrentSessionInfluence();
            if (lastReceivedIds.length() > 0) {
                z = setSession(oSChannelTracker, OSInfluenceType.INDIRECT, null, lastReceivedIds);
            } else {
                z = setSession(oSChannelTracker, OSInfluenceType.UNATTRIBUTED, null, null);
            }
            if (z) {
                arrayList.add(currentSessionInfluence);
            }
        }
        sendSessionEndingWithInfluences(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void onInAppMessageReceived(String str) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager onInAppMessageReceived messageId: " + str);
        OSChannelTracker iAMChannelTracker = this.trackerFactory.getIAMChannelTracker();
        iAMChannelTracker.saveLastId(str);
        iAMChannelTracker.resetAndInitInfluence();
    }

    /* access modifiers changed from: package-private */
    public void onDirectInfluenceFromIAMClick(String str) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager onDirectInfluenceFromIAMClick messageId: " + str);
        setSession(this.trackerFactory.getIAMChannelTracker(), OSInfluenceType.DIRECT, str, null);
    }

    /* access modifiers changed from: package-private */
    public void onDirectInfluenceFromIAMClickFinished() {
        this.logger.debug("OneSignal SessionManager onDirectInfluenceFromIAMClickFinished");
        this.trackerFactory.getIAMChannelTracker().resetAndInitInfluence();
    }

    /* access modifiers changed from: package-private */
    public void onNotificationReceived(String str) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager onNotificationReceived notificationId: " + str);
        if (str != null && !str.isEmpty()) {
            this.trackerFactory.getNotificationChannelTracker().saveLastId(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDirectInfluenceFromNotificationOpen(OneSignal.AppEntryAction appEntryAction, String str) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager onDirectInfluenceFromNotificationOpen notificationId: " + str);
        if (str != null && !str.isEmpty()) {
            attemptSessionUpgrade(appEntryAction, str);
        }
    }

    /* access modifiers changed from: package-private */
    public List<OSInfluence> getInfluences() {
        return this.trackerFactory.getInfluences();
    }

    /* access modifiers changed from: package-private */
    public List<OSInfluence> getSessionInfluences() {
        return this.trackerFactory.getSessionInfluences();
    }

    /* access modifiers changed from: package-private */
    public void attemptSessionUpgrade(OneSignal.AppEntryAction appEntryAction) {
        attemptSessionUpgrade(appEntryAction, null);
    }

    private void attemptSessionUpgrade(OneSignal.AppEntryAction appEntryAction, String str) {
        boolean z;
        OSInfluence oSInfluence;
        this.logger.debug("OneSignal SessionManager attemptSessionUpgrade with entryAction: " + appEntryAction);
        OSChannelTracker channelByEntryAction = this.trackerFactory.getChannelByEntryAction(appEntryAction);
        List<OSChannelTracker> channelsToResetByEntryAction = this.trackerFactory.getChannelsToResetByEntryAction(appEntryAction);
        ArrayList arrayList = new ArrayList();
        if (channelByEntryAction != null) {
            oSInfluence = channelByEntryAction.getCurrentSessionInfluence();
            OSInfluenceType oSInfluenceType = OSInfluenceType.DIRECT;
            if (str == null) {
                str = channelByEntryAction.getDirectId();
            }
            z = setSession(channelByEntryAction, oSInfluenceType, str, null);
        } else {
            z = false;
            oSInfluence = null;
        }
        if (z) {
            this.logger.debug("OneSignal SessionManager attemptSessionUpgrade channel updated, search for ending direct influences on channels: " + channelsToResetByEntryAction);
            arrayList.add(oSInfluence);
            for (OSChannelTracker oSChannelTracker : channelsToResetByEntryAction) {
                if (oSChannelTracker.getInfluenceType().isDirect()) {
                    arrayList.add(oSChannelTracker.getCurrentSessionInfluence());
                    oSChannelTracker.resetAndInitInfluence();
                }
            }
        }
        this.logger.debug("OneSignal SessionManager attemptSessionUpgrade try UNATTRIBUTED to INDIRECT upgrade");
        for (OSChannelTracker oSChannelTracker2 : channelsToResetByEntryAction) {
            if (oSChannelTracker2.getInfluenceType().isUnattributed()) {
                JSONArray lastReceivedIds = oSChannelTracker2.getLastReceivedIds();
                if (lastReceivedIds.length() > 0 && !appEntryAction.isAppClose()) {
                    OSInfluence currentSessionInfluence = oSChannelTracker2.getCurrentSessionInfluence();
                    if (setSession(oSChannelTracker2, OSInfluenceType.INDIRECT, null, lastReceivedIds)) {
                        arrayList.add(currentSessionInfluence);
                    }
                }
            }
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Trackers after update attempt: " + this.trackerFactory.getChannels().toString());
        sendSessionEndingWithInfluences(arrayList);
    }

    private boolean setSession(OSChannelTracker oSChannelTracker, OSInfluenceType oSInfluenceType, String str, JSONArray jSONArray) {
        if (!willChangeSession(oSChannelTracker, oSInfluenceType, str, jSONArray)) {
            return false;
        }
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "OSChannelTracker changed: " + oSChannelTracker.getIdTag() + "\nfrom:\ninfluenceType: " + oSChannelTracker.getInfluenceType() + ", directNotificationId: " + oSChannelTracker.getDirectId() + ", indirectNotificationIds: " + oSChannelTracker.getIndirectIds() + "\nto:\ninfluenceType: " + oSInfluenceType + ", directNotificationId: " + str + ", indirectNotificationIds: " + jSONArray);
        oSChannelTracker.setInfluenceType(oSInfluenceType);
        oSChannelTracker.setDirectId(str);
        oSChannelTracker.setIndirectIds(jSONArray);
        oSChannelTracker.cacheState();
        OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Trackers changed to: ");
        sb.append(this.trackerFactory.getChannels().toString());
        OneSignal.Log(log_level2, sb.toString());
        return true;
    }

    private boolean willChangeSession(OSChannelTracker oSChannelTracker, OSInfluenceType oSInfluenceType, String str, JSONArray jSONArray) {
        if (!oSInfluenceType.equals(oSChannelTracker.getInfluenceType())) {
            return true;
        }
        OSInfluenceType influenceType = oSChannelTracker.getInfluenceType();
        if (influenceType.isDirect() && oSChannelTracker.getDirectId() != null && !oSChannelTracker.getDirectId().equals(str)) {
            return true;
        }
        if (!influenceType.isIndirect() || oSChannelTracker.getIndirectIds() == null || oSChannelTracker.getIndirectIds().length() <= 0 || JSONUtils.compareJSONArrays(oSChannelTracker.getIndirectIds(), jSONArray)) {
            return false;
        }
        return true;
    }

    private void sendSessionEndingWithInfluences(final List<OSInfluence> list) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal SessionManager sendSessionEndingWithInfluences with influences: " + list);
        if (list.size() > 0) {
            new Thread(new Runnable() {
                /* class com.onesignal.OSSessionManager.AnonymousClass1 */

                public void run() {
                    Thread.currentThread().setPriority(10);
                    OSSessionManager.this.sessionListener.onSessionEnding(list);
                }
            }, OS_END_CURRENT_SESSION).start();
        }
    }
}
