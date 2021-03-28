package com.onesignal;

import android.os.SystemClock;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import com.onesignal.influence.model.OSInfluence;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class FocusTimeController {
    private static FocusTimeController sInstance;
    private List<FocusTimeProcessorBase> focusTimeProcessors = Arrays.asList(new FocusTimeProcessorUnattributed(), new FocusTimeProcessorAttributed());
    private Long timeFocusedAtMs;

    /* access modifiers changed from: private */
    public enum FocusEventType {
        BACKGROUND,
        END_SESSION
    }

    private FocusTimeController() {
    }

    public static synchronized FocusTimeController getInstance() {
        FocusTimeController focusTimeController;
        synchronized (FocusTimeController.class) {
            if (sInstance == null) {
                sInstance = new FocusTimeController();
            }
            focusTimeController = sInstance;
        }
        return focusTimeController;
    }

    /* access modifiers changed from: package-private */
    public void appForegrounded() {
        this.timeFocusedAtMs = Long.valueOf(SystemClock.elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    public void appBackgrounded() {
        giveProcessorsValidFocusTime(OneSignal.getSessionManager().getSessionInfluences(), FocusEventType.BACKGROUND);
        this.timeFocusedAtMs = null;
    }

    /* access modifiers changed from: package-private */
    public void onSessionEnded(List<OSInfluence> list) {
        FocusEventType focusEventType = FocusEventType.END_SESSION;
        if (!giveProcessorsValidFocusTime(list, focusEventType)) {
            for (FocusTimeProcessorBase focusTimeProcessorBase : this.focusTimeProcessors) {
                focusTimeProcessorBase.sendUnsentTimeNow(focusEventType);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void doBlockingBackgroundSyncOfUnsentTime() {
        if (!OneSignal.isForeground()) {
            for (FocusTimeProcessorBase focusTimeProcessorBase : this.focusTimeProcessors) {
                focusTimeProcessorBase.syncUnsentTimeFromSyncJob();
            }
        }
    }

    private boolean giveProcessorsValidFocusTime(List<OSInfluence> list, FocusEventType focusEventType) {
        Long timeFocusedElapsed = getTimeFocusedElapsed();
        if (timeFocusedElapsed == null) {
            return false;
        }
        for (FocusTimeProcessorBase focusTimeProcessorBase : this.focusTimeProcessors) {
            focusTimeProcessorBase.addTime(timeFocusedElapsed.longValue(), list, focusEventType);
        }
        return true;
    }

    private Long getTimeFocusedElapsed() {
        if (this.timeFocusedAtMs == null) {
            return null;
        }
        double elapsedRealtime = (double) (SystemClock.elapsedRealtime() - this.timeFocusedAtMs.longValue());
        Double.isNaN(elapsedRealtime);
        long j = (long) ((elapsedRealtime / 1000.0d) + 0.5d);
        if (j < 1 || j > 86400) {
            return null;
        }
        return Long.valueOf(j);
    }

    private static class FocusTimeProcessorUnattributed extends FocusTimeProcessorBase {
        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public void saveInfluences(List<OSInfluence> list) {
        }

        FocusTimeProcessorUnattributed() {
            super();
            this.MIN_ON_FOCUS_TIME_SEC = 60;
            this.PREF_KEY_FOR_UNSENT_TIME = OneSignalPrefs.PREFS_GT_UNSENT_ACTIVE_TIME;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public boolean timeTypeApplies(List<OSInfluence> list) {
            for (OSInfluence oSInfluence : list) {
                if (oSInfluence.getInfluenceType().isAttributed()) {
                    return false;
                }
            }
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, getClass().getSimpleName() + ":timeTypeApplies for influences: " + list.toString() + " true");
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public void sendTime(FocusEventType focusEventType) {
            if (!focusEventType.equals(FocusEventType.END_SESSION)) {
                syncUnsentTimeOnBackgroundEvent();
            }
        }
    }

    private static class FocusTimeProcessorAttributed extends FocusTimeProcessorBase {
        FocusTimeProcessorAttributed() {
            super();
            this.MIN_ON_FOCUS_TIME_SEC = 1;
            this.PREF_KEY_FOR_UNSENT_TIME = OneSignalPrefs.PREFS_OS_UNSENT_ATTRIBUTED_ACTIVE_TIME;
        }

        private List<OSInfluence> getInfluences() {
            ArrayList arrayList = new ArrayList();
            for (String str : OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_ATTRIBUTED_INFLUENCES, new HashSet())) {
                try {
                    arrayList.add(new OSInfluence(str));
                } catch (JSONException e) {
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                    OneSignal.Log(log_level, getClass().getSimpleName() + ": error generation OSInfluence from json object: " + e);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public void saveInfluences(List<OSInfluence> list) {
            HashSet hashSet = new HashSet();
            for (OSInfluence oSInfluence : list) {
                try {
                    hashSet.add(oSInfluence.toJSONString());
                } catch (JSONException e) {
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                    OneSignal.Log(log_level, getClass().getSimpleName() + ": error generation json object OSInfluence: " + e);
                }
            }
            OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_ATTRIBUTED_INFLUENCES, hashSet);
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public boolean timeTypeApplies(List<OSInfluence> list) {
            for (OSInfluence oSInfluence : list) {
                if (oSInfluence.getInfluenceType().isAttributed()) {
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                    OneSignal.Log(log_level, getClass().getSimpleName() + ":timeTypeApplies for influences: " + list.toString() + " true");
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public void additionalFieldsToAddToOnFocusPayload(JSONObject jSONObject) {
            OneSignal.getSessionManager().addSessionIds(jSONObject, getInfluences());
        }

        /* access modifiers changed from: protected */
        @Override // com.onesignal.FocusTimeController.FocusTimeProcessorBase
        public void sendTime(FocusEventType focusEventType) {
            if (focusEventType.equals(FocusEventType.END_SESSION)) {
                syncOnFocusTime();
            } else {
                OneSignalSyncServiceUtils.scheduleSyncTask(OneSignal.appContext);
            }
        }
    }

    /* access modifiers changed from: private */
    public static abstract class FocusTimeProcessorBase {
        protected long MIN_ON_FOCUS_TIME_SEC;
        protected String PREF_KEY_FOR_UNSENT_TIME;
        private final AtomicBoolean runningOnFocusTime;
        private Long unsentActiveTime;

        /* access modifiers changed from: protected */
        public void additionalFieldsToAddToOnFocusPayload(JSONObject jSONObject) {
        }

        /* access modifiers changed from: protected */
        public abstract void saveInfluences(List<OSInfluence> list);

        /* access modifiers changed from: protected */
        public abstract void sendTime(FocusEventType focusEventType);

        /* access modifiers changed from: protected */
        public abstract boolean timeTypeApplies(List<OSInfluence> list);

        private FocusTimeProcessorBase() {
            this.unsentActiveTime = null;
            this.runningOnFocusTime = new AtomicBoolean();
        }

        private long getUnsentActiveTime() {
            if (this.unsentActiveTime == null) {
                this.unsentActiveTime = Long.valueOf(OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, this.PREF_KEY_FOR_UNSENT_TIME, 0));
            }
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, getClass().getSimpleName() + ":getUnsentActiveTime: " + this.unsentActiveTime);
            return this.unsentActiveTime.longValue();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void saveUnsentActiveTime(long j) {
            this.unsentActiveTime = Long.valueOf(j);
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, getClass().getSimpleName() + ":saveUnsentActiveTime: " + this.unsentActiveTime);
            OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, this.PREF_KEY_FOR_UNSENT_TIME, j);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void addTime(long j, List<OSInfluence> list, FocusEventType focusEventType) {
            if (timeTypeApplies(list)) {
                saveInfluences(list);
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.Log(log_level, getClass().getSimpleName() + ":addTime with lastFocusTimeInfluences: " + list.toString());
                saveUnsentActiveTime(getUnsentActiveTime() + j);
                sendUnsentTimeNow(focusEventType);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void sendUnsentTimeNow(FocusEventType focusEventType) {
            if (OneSignal.hasUserId()) {
                sendTime(focusEventType);
            }
        }

        private boolean hasMinSyncTime() {
            return getUnsentActiveTime() >= this.MIN_ON_FOCUS_TIME_SEC;
        }

        /* access modifiers changed from: protected */
        public void syncUnsentTimeOnBackgroundEvent() {
            if (hasMinSyncTime()) {
                OneSignalSyncServiceUtils.scheduleSyncTask(OneSignal.appContext);
                syncOnFocusTime();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void syncUnsentTimeFromSyncJob() {
            if (hasMinSyncTime()) {
                syncOnFocusTime();
            }
        }

        /* access modifiers changed from: protected */
        public void syncOnFocusTime() {
            if (!this.runningOnFocusTime.get()) {
                synchronized (this.runningOnFocusTime) {
                    this.runningOnFocusTime.set(true);
                    if (hasMinSyncTime()) {
                        sendOnFocus(getUnsentActiveTime());
                    }
                    this.runningOnFocusTime.set(false);
                }
            }
        }

        private void sendOnFocusToPlayer(String str, JSONObject jSONObject) {
            AnonymousClass1 r0 = new OneSignalRestClient.ResponseHandler() {
                /* class com.onesignal.FocusTimeController.FocusTimeProcessorBase.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                public void onFailure(int i, String str, Throwable th) {
                    OneSignal.logHttpError("sending on_focus Failed", i, th, str);
                }

                /* access modifiers changed from: package-private */
                @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                public void onSuccess(String str) {
                    FocusTimeProcessorBase.this.saveUnsentActiveTime(0);
                }
            };
            OneSignalRestClient.postSync("players/" + str + "/on_focus", jSONObject, r0);
        }

        private JSONObject generateOnFocusPayload(long j) throws JSONException {
            JSONObject put = new JSONObject().put("app_id", OneSignal.getSavedAppId()).put("type", 1).put("state", "ping").put("active_time", j).put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new OSUtils().getDeviceType());
            OneSignal.addNetType(put);
            return put;
        }

        private void sendOnFocus(long j) {
            try {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.Log(log_level, getClass().getSimpleName() + ":sendOnFocus with totalTimeActive: " + j);
                JSONObject generateOnFocusPayload = generateOnFocusPayload(j);
                additionalFieldsToAddToOnFocusPayload(generateOnFocusPayload);
                sendOnFocusToPlayer(OneSignal.getUserId(), generateOnFocusPayload);
                if (OneSignal.hasEmailId()) {
                    sendOnFocusToPlayer(OneSignal.getEmailId(), generateOnFocusPayload(j));
                }
            } catch (JSONException e) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Generating on_focus:JSON Failed.", e);
            }
        }
    }
}
