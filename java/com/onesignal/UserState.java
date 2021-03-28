package com.onesignal;

import com.onesignal.LocationController;
import io.invertase.firebase.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public abstract class UserState {
    public static final int DEVICE_TYPE_ANDROID = 1;
    public static final int DEVICE_TYPE_EMAIL = 11;
    public static final int DEVICE_TYPE_FIREOS = 2;
    public static final int DEVICE_TYPE_HUAWEI = 13;
    private static final String[] LOCATION_FIELDS = {"lat", "long", "loc_acc", "loc_type", "loc_bg", "loc_time_stamp", "ad_id"};
    private static final Set<String> LOCATION_FIELDS_SET = new HashSet(Arrays.asList(LOCATION_FIELDS));
    private static final Object LOCK = new Object();
    static final int PUSH_STATUS_FIREBASE_FCM_ERROR_IOEXCEPTION = -11;
    static final int PUSH_STATUS_FIREBASE_FCM_ERROR_MISC_EXCEPTION = -12;
    static final int PUSH_STATUS_FIREBASE_FCM_ERROR_SERVICE_NOT_AVAILABLE = -9;
    static final int PUSH_STATUS_FIREBASE_FCM_INIT_ERROR = -8;
    public static final int PUSH_STATUS_HMS_API_EXCEPTION_OTHER = -27;
    public static final int PUSH_STATUS_HMS_ARGUMENTS_INVALID = -26;
    public static final int PUSH_STATUS_HMS_TOKEN_TIMEOUT = -25;
    static final int PUSH_STATUS_INVALID_FCM_SENDER_ID = -6;
    static final int PUSH_STATUS_MISSING_ANDROID_SUPPORT_LIBRARY = -3;
    static final int PUSH_STATUS_MISSING_FIREBASE_FCM_LIBRARY = -4;
    public static final int PUSH_STATUS_MISSING_HMS_PUSHKIT_LIBRARY = -28;
    static final int PUSH_STATUS_NO_PERMISSION = 0;
    static final int PUSH_STATUS_OUTDATED_ANDROID_SUPPORT_LIBRARY = -5;
    static final int PUSH_STATUS_OUTDATED_GOOGLE_PLAY_SERVICES_APP = -7;
    public static final int PUSH_STATUS_SUBSCRIBED = 1;
    static final int PUSH_STATUS_UNSUBSCRIBE = -2;
    public static final String TAGS = "tags";
    private JSONObject dependValues;
    private String persistKey;
    private JSONObject syncValues;

    /* access modifiers changed from: protected */
    public abstract void addDependFields();

    /* access modifiers changed from: package-private */
    public abstract boolean isSubscribed();

    /* access modifiers changed from: package-private */
    public abstract UserState newInstance(String str);

    public ImmutableJSONObject getDependValues() {
        try {
            return new ImmutableJSONObject(getDependValuesCopy());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ImmutableJSONObject();
        }
    }

    /* access modifiers changed from: package-private */
    public void setDependValues(JSONObject jSONObject) {
        synchronized (LOCK) {
            this.dependValues = jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject getDependValuesCopy() throws JSONException {
        JSONObject jSONObject;
        synchronized (LOCK) {
            jSONObject = new JSONObject(this.dependValues.toString());
        }
        return jSONObject;
    }

    public ImmutableJSONObject getSyncValues() {
        try {
            return new ImmutableJSONObject(getSyncValuesCopy());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ImmutableJSONObject();
        }
    }

    public JSONObject getSyncValuesCopy() throws JSONException {
        JSONObject jSONObject;
        synchronized (LOCK) {
            jSONObject = new JSONObject(this.syncValues.toString());
        }
        return jSONObject;
    }

    public void setSyncValues(JSONObject jSONObject) {
        synchronized (LOCK) {
            this.syncValues = jSONObject;
        }
    }

    UserState(String str, boolean z) {
        this.persistKey = str;
        if (z) {
            loadState();
            return;
        }
        this.dependValues = new JSONObject();
        this.syncValues = new JSONObject();
    }

    /* access modifiers changed from: package-private */
    public UserState deepClone(String str) {
        UserState newInstance = newInstance(str);
        try {
            newInstance.dependValues = getDependValuesCopy();
            newInstance.syncValues = getSyncValuesCopy();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newInstance;
    }

    private Set<String> getGroupChangeFields(UserState userState) {
        try {
            if (this.dependValues.optLong("loc_time_stamp") == userState.dependValues.getLong("loc_time_stamp")) {
                return null;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("loc_bg", userState.dependValues.opt("loc_bg"));
            hashMap.put("loc_time_stamp", userState.dependValues.opt("loc_time_stamp"));
            putValues(userState.syncValues, hashMap);
            return LOCATION_FIELDS_SET;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void putOnSyncValues(String str, Object obj) throws JSONException {
        synchronized (LOCK) {
            this.syncValues.put(str, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void putOnDependValues(String str, Object obj) throws JSONException {
        synchronized (LOCK) {
            this.dependValues.put(str, obj);
        }
    }

    private void putValues(JSONObject jSONObject, HashMap<String, Object> hashMap) throws JSONException {
        synchronized (LOCK) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFromSyncValues(String str) {
        synchronized (LOCK) {
            this.syncValues.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFromSyncValues(List<String> list) {
        synchronized (LOCK) {
            for (String str : list) {
                this.syncValues.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFromDependValues(String str) {
        synchronized (LOCK) {
            this.dependValues.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFromDependValues(List<String> list) {
        synchronized (LOCK) {
            for (String str : list) {
                this.dependValues.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setLocation(LocationController.LocationPoint locationPoint) {
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("lat", locationPoint.lat);
            hashMap.put("long", locationPoint.log);
            hashMap.put("loc_acc", locationPoint.accuracy);
            hashMap.put("loc_type", locationPoint.type);
            putValues(this.syncValues, hashMap);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("loc_bg", locationPoint.bg);
            hashMap2.put("loc_time_stamp", locationPoint.timeStamp);
            putValues(this.dependValues, hashMap2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearLocation() {
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("lat", null);
            hashMap.put("long", null);
            hashMap.put("loc_acc", null);
            hashMap.put("loc_type", null);
            hashMap.put("loc_bg", null);
            hashMap.put("loc_time_stamp", null);
            putValues(this.syncValues, hashMap);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("loc_bg", null);
            hashMap2.put("loc_time_stamp", null);
            putValues(this.dependValues, hashMap2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject generateJsonDiff(UserState userState, boolean z) {
        addDependFields();
        userState.addDependFields();
        JSONObject generateJsonDiff = generateJsonDiff(this.syncValues, userState.syncValues, null, getGroupChangeFields(userState));
        if (!z && generateJsonDiff.toString().equals(BuildConfig.FIREBASE_JSON_RAW)) {
            return null;
        }
        try {
            if (!generateJsonDiff.has("app_id")) {
                generateJsonDiff.put("app_id", this.syncValues.optString("app_id"));
            }
            if (this.syncValues.has("email_auth_hash")) {
                generateJsonDiff.put("email_auth_hash", this.syncValues.optString("email_auth_hash"));
            }
            if (this.syncValues.has("external_user_id_auth_hash")) {
                generateJsonDiff.put("external_user_id_auth_hash", this.syncValues.optString("external_user_id_auth_hash"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return generateJsonDiff;
    }

    private void loadState() {
        JSONObject jSONObject;
        int i;
        boolean z;
        String str = OneSignalPrefs.PREFS_ONESIGNAL;
        String string = OneSignalPrefs.getString(str, OneSignalPrefs.PREFS_ONESIGNAL_USERSTATE_DEPENDVALYES_ + this.persistKey, null);
        if (string == null) {
            setDependValues(new JSONObject());
            try {
                int i2 = 1;
                if (this.persistKey.equals("CURRENT_STATE")) {
                    i = OneSignalPrefs.getInt(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_SUBSCRIPTION, 1);
                } else {
                    i = OneSignalPrefs.getInt(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_SYNCED_SUBSCRIPTION, 1);
                }
                if (i == -2) {
                    z = false;
                } else {
                    i2 = i;
                    z = true;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("subscribableStatus", Integer.valueOf(i2));
                hashMap.put("userSubscribePref", Boolean.valueOf(z));
                putValues(this.dependValues, hashMap);
            } catch (JSONException unused) {
            }
        } else {
            try {
                setDependValues(new JSONObject(string));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String str2 = OneSignalPrefs.PREFS_ONESIGNAL;
        String string2 = OneSignalPrefs.getString(str2, OneSignalPrefs.PREFS_ONESIGNAL_USERSTATE_SYNCVALYES_ + this.persistKey, null);
        if (string2 == null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("identifier", OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_REGISTRATION_ID, null));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            jSONObject = new JSONObject(string2);
        }
        setSyncValues(jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void persistState() {
        synchronized (LOCK) {
            String str = OneSignalPrefs.PREFS_ONESIGNAL;
            OneSignalPrefs.saveString(str, OneSignalPrefs.PREFS_ONESIGNAL_USERSTATE_SYNCVALYES_ + this.persistKey, this.syncValues.toString());
            String str2 = OneSignalPrefs.PREFS_ONESIGNAL;
            OneSignalPrefs.saveString(str2, OneSignalPrefs.PREFS_ONESIGNAL_USERSTATE_DEPENDVALYES_ + this.persistKey, this.dependValues.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void persistStateAfterSync(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            JSONObject jSONObject3 = this.dependValues;
            generateJsonDiff(jSONObject3, jSONObject, jSONObject3, null);
        }
        if (jSONObject2 != null) {
            JSONObject jSONObject4 = this.syncValues;
            generateJsonDiff(jSONObject4, jSONObject2, jSONObject4, null);
            mergeTags(jSONObject2, null);
        }
        if (jSONObject != null || jSONObject2 != null) {
            persistState();
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeTags(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        if (jSONObject.has(TAGS)) {
            try {
                JSONObject syncValuesCopy = getSyncValuesCopy();
                if (syncValuesCopy.has(TAGS)) {
                    try {
                        jSONObject3 = new JSONObject(syncValuesCopy.optString(TAGS));
                    } catch (JSONException unused) {
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    jSONObject3 = new JSONObject();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(TAGS);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("".equals(optJSONObject.optString(next))) {
                        jSONObject3.remove(next);
                    } else if (jSONObject2 == null || !jSONObject2.has(next)) {
                        jSONObject3.put(next, optJSONObject.optString(next));
                    }
                }
                synchronized (LOCK) {
                    if (jSONObject3.toString().equals(BuildConfig.FIREBASE_JSON_RAW)) {
                        this.syncValues.remove(TAGS);
                    } else {
                        this.syncValues.put(TAGS, jSONObject3);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject generateJsonDiffFromIntoSyncValued(JSONObject jSONObject, Set<String> set) {
        JSONObject generateJsonDiff;
        synchronized (LOCK) {
            generateJsonDiff = JSONUtils.generateJsonDiff(this.syncValues, jSONObject, this.syncValues, set);
        }
        return generateJsonDiff;
    }

    /* access modifiers changed from: package-private */
    public JSONObject generateJsonDiffFromSyncValued(UserState userState, Set<String> set) {
        JSONObject generateJsonDiff;
        synchronized (LOCK) {
            generateJsonDiff = JSONUtils.generateJsonDiff(this.syncValues, userState.syncValues, null, set);
        }
        return generateJsonDiff;
    }

    /* access modifiers changed from: package-private */
    public JSONObject generateJsonDiffFromIntoDependValues(JSONObject jSONObject, Set<String> set) {
        JSONObject generateJsonDiff;
        synchronized (LOCK) {
            generateJsonDiff = JSONUtils.generateJsonDiff(this.dependValues, jSONObject, this.dependValues, set);
        }
        return generateJsonDiff;
    }

    /* access modifiers changed from: package-private */
    public JSONObject generateJsonDiffFromDependValues(UserState userState, Set<String> set) {
        JSONObject generateJsonDiff;
        synchronized (LOCK) {
            generateJsonDiff = JSONUtils.generateJsonDiff(this.dependValues, userState.dependValues, null, set);
        }
        return generateJsonDiff;
    }

    private static JSONObject generateJsonDiff(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        JSONObject generateJsonDiff;
        synchronized (LOCK) {
            generateJsonDiff = JSONUtils.generateJsonDiff(jSONObject, jSONObject2, jSONObject3, set);
        }
        return generateJsonDiff;
    }
}
