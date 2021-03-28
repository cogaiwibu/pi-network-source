package com.onesignal.influence;

import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.influence.model.OSInfluenceType;
import org.json.JSONArray;
import org.json.JSONException;

/* access modifiers changed from: package-private */
public class OSInfluenceDataRepository {
    protected static final String PREFS_OS_DIRECT_ENABLED = "PREFS_OS_DIRECT_ENABLED";
    protected static final String PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW = "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW";
    protected static final String PREFS_OS_IAM_LIMIT = "PREFS_OS_IAM_LIMIT";
    protected static final String PREFS_OS_INDIRECT_ENABLED = "PREFS_OS_INDIRECT_ENABLED";
    protected static final String PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN = "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN";
    protected static final String PREFS_OS_LAST_IAMS_RECEIVED = "PREFS_OS_LAST_IAMS_RECEIVED";
    protected static final String PREFS_OS_LAST_NOTIFICATIONS_RECEIVED = "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED";
    protected static final String PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW = "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW";
    protected static final String PREFS_OS_NOTIFICATION_LIMIT = "PREFS_OS_NOTIFICATION_LIMIT";
    protected static final String PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE";
    protected static final String PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_SESSION";
    protected static final String PREFS_OS_UNATTRIBUTED_ENABLED = "PREFS_OS_UNATTRIBUTED_ENABLED";
    private OSSharedPreferences preferences;

    public OSInfluenceDataRepository(OSSharedPreferences oSSharedPreferences) {
        this.preferences = oSSharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public void cacheNotificationInfluenceType(OSInfluenceType oSInfluenceType) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveString(oSSharedPreferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, oSInfluenceType.toString());
    }

    /* access modifiers changed from: package-private */
    public OSInfluenceType getNotificationCachedInfluenceType() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return OSInfluenceType.fromString(oSSharedPreferences.getString(oSSharedPreferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, OSInfluenceType.UNATTRIBUTED.toString()));
    }

    /* access modifiers changed from: package-private */
    public void cacheIAMInfluenceType(OSInfluenceType oSInfluenceType) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveString(oSSharedPreferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, oSInfluenceType.toString());
    }

    /* access modifiers changed from: package-private */
    public OSInfluenceType getIAMCachedInfluenceType() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return OSInfluenceType.fromString(oSSharedPreferences.getString(oSSharedPreferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, OSInfluenceType.UNATTRIBUTED.toString()));
    }

    /* access modifiers changed from: package-private */
    public void cacheNotificationOpenId(String str) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, str);
    }

    /* access modifiers changed from: package-private */
    public String getCachedNotificationOpenId() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, null);
    }

    /* access modifiers changed from: package-private */
    public void saveNotifications(JSONArray jSONArray) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, jSONArray.toString());
    }

    /* access modifiers changed from: package-private */
    public void saveIAMs(JSONArray jSONArray) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_IAMS_RECEIVED, jSONArray.toString());
    }

    /* access modifiers changed from: package-private */
    public JSONArray getLastNotificationsReceivedData() throws JSONException {
        JSONArray jSONArray;
        OSSharedPreferences oSSharedPreferences = this.preferences;
        if (oSSharedPreferences.getString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, "[]") == null) {
            jSONArray = new JSONArray();
        }
        return jSONArray;
    }

    /* access modifiers changed from: package-private */
    public JSONArray getLastIAMsReceivedData() throws JSONException {
        JSONArray jSONArray;
        OSSharedPreferences oSSharedPreferences = this.preferences;
        if (oSSharedPreferences.getString(oSSharedPreferences.getPreferencesName(), PREFS_OS_LAST_IAMS_RECEIVED, "[]") == null) {
            jSONArray = new JSONArray();
        }
        return jSONArray;
    }

    /* access modifiers changed from: package-private */
    public int getNotificationLimit() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getInt(oSSharedPreferences.getPreferencesName(), PREFS_OS_NOTIFICATION_LIMIT, 10);
    }

    /* access modifiers changed from: package-private */
    public int getIAMLimit() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getInt(oSSharedPreferences.getPreferencesName(), PREFS_OS_IAM_LIMIT, 10);
    }

    /* access modifiers changed from: package-private */
    public int getNotificationIndirectAttributionWindow() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getInt(oSSharedPreferences.getPreferencesName(), PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
    }

    /* access modifiers changed from: package-private */
    public int getIAMIndirectAttributionWindow() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getInt(oSSharedPreferences.getPreferencesName(), PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
    }

    /* access modifiers changed from: package-private */
    public boolean isDirectInfluenceEnabled() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getBool(oSSharedPreferences.getPreferencesName(), PREFS_OS_DIRECT_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public boolean isIndirectInfluenceEnabled() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getBool(oSSharedPreferences.getPreferencesName(), PREFS_OS_INDIRECT_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public boolean isUnattributedInfluenceEnabled() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getBool(oSSharedPreferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public void saveInfluenceParams(OneSignalRemoteParams.InfluenceParams influenceParams) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveBool(oSSharedPreferences.getPreferencesName(), PREFS_OS_DIRECT_ENABLED, influenceParams.isDirectEnabled());
        OSSharedPreferences oSSharedPreferences2 = this.preferences;
        oSSharedPreferences2.saveBool(oSSharedPreferences2.getPreferencesName(), PREFS_OS_INDIRECT_ENABLED, influenceParams.isIndirectEnabled());
        OSSharedPreferences oSSharedPreferences3 = this.preferences;
        oSSharedPreferences3.saveBool(oSSharedPreferences3.getPreferencesName(), PREFS_OS_UNATTRIBUTED_ENABLED, influenceParams.isUnattributedEnabled());
        OSSharedPreferences oSSharedPreferences4 = this.preferences;
        oSSharedPreferences4.saveInt(oSSharedPreferences4.getPreferencesName(), PREFS_OS_NOTIFICATION_LIMIT, influenceParams.getNotificationLimit());
        OSSharedPreferences oSSharedPreferences5 = this.preferences;
        oSSharedPreferences5.saveInt(oSSharedPreferences5.getPreferencesName(), PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW, influenceParams.getIndirectNotificationAttributionWindow());
        OSSharedPreferences oSSharedPreferences6 = this.preferences;
        oSSharedPreferences6.saveInt(oSSharedPreferences6.getPreferencesName(), PREFS_OS_IAM_LIMIT, influenceParams.getIamLimit());
        OSSharedPreferences oSSharedPreferences7 = this.preferences;
        oSSharedPreferences7.saveInt(oSSharedPreferences7.getPreferencesName(), PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW, influenceParams.getIndirectIAMAttributionWindow());
    }
}
