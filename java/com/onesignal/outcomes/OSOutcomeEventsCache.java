package com.onesignal.outcomes;

import android.content.ContentValues;
import android.database.Cursor;
import com.onesignal.OSLogger;
import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignalDb;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.influence.model.OSInfluenceType;
import com.onesignal.outcomes.model.OSCachedUniqueOutcome;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import com.onesignal.outcomes.model.OSOutcomeSource;
import com.onesignal.outcomes.model.OSOutcomeSourceBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* access modifiers changed from: package-private */
public class OSOutcomeEventsCache {
    private static final String PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT = "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT";
    private OneSignalDb dbHelper;
    private OSLogger logger;
    private OSSharedPreferences preferences;

    OSOutcomeEventsCache(OSLogger oSLogger, OneSignalDb oneSignalDb, OSSharedPreferences oSSharedPreferences) {
        this.logger = oSLogger;
        this.dbHelper = oneSignalDb;
        this.preferences = oSSharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public boolean isOutcomesV2ServiceEnabled() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getBool(oSSharedPreferences.getPreferencesName(), this.preferences.getOutcomesV2KeyName(), false);
    }

    /* access modifiers changed from: package-private */
    public Set<String> getUnattributedUniqueOutcomeEventsSentByChannel() {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        return oSSharedPreferences.getStringSet(oSSharedPreferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, null);
    }

    /* access modifiers changed from: package-private */
    public void saveUnattributedUniqueOutcomeEventsSentByChannel(Set<String> set) {
        OSSharedPreferences oSSharedPreferences = this.preferences;
        oSSharedPreferences.saveStringSet(oSSharedPreferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, set);
    }

    /* access modifiers changed from: package-private */
    public synchronized void deleteOldOutcomeEvent(OSOutcomeEventParams oSOutcomeEventParams) {
        this.dbHelper.delete(OSOutcomeTableProvider.OUTCOME_EVENT_TABLE, "timestamp = ?", new String[]{String.valueOf(oSOutcomeEventParams.getTimestamp())});
    }

    /* access modifiers changed from: package-private */
    public synchronized void saveOutcomeEvent(OSOutcomeEventParams oSOutcomeEventParams) {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        OSInfluenceType oSInfluenceType = OSInfluenceType.UNATTRIBUTED;
        OSInfluenceType oSInfluenceType2 = OSInfluenceType.UNATTRIBUTED;
        if (oSOutcomeEventParams.getOutcomeSource() != null) {
            OSOutcomeSource outcomeSource = oSOutcomeEventParams.getOutcomeSource();
            if (outcomeSource.getDirectBody() != null) {
                OSOutcomeSourceBody directBody = outcomeSource.getDirectBody();
                if (directBody.getNotificationIds() != null && directBody.getNotificationIds().length() > 0) {
                    oSInfluenceType = OSInfluenceType.DIRECT;
                    jSONArray = outcomeSource.getDirectBody().getNotificationIds();
                }
                if (directBody.getInAppMessagesIds() != null && directBody.getInAppMessagesIds().length() > 0) {
                    oSInfluenceType2 = OSInfluenceType.DIRECT;
                    jSONArray2 = outcomeSource.getDirectBody().getInAppMessagesIds();
                }
            }
            if (outcomeSource.getIndirectBody() != null) {
                OSOutcomeSourceBody indirectBody = outcomeSource.getIndirectBody();
                if (indirectBody.getNotificationIds() != null && indirectBody.getNotificationIds().length() > 0) {
                    OSInfluenceType oSInfluenceType3 = OSInfluenceType.INDIRECT;
                    oSInfluenceType = oSInfluenceType3;
                    jSONArray = outcomeSource.getIndirectBody().getNotificationIds();
                }
                if (indirectBody.getInAppMessagesIds() != null && indirectBody.getInAppMessagesIds().length() > 0) {
                    oSInfluenceType2 = OSInfluenceType.INDIRECT;
                    jSONArray2 = outcomeSource.getIndirectBody().getInAppMessagesIds();
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("notification_ids", jSONArray.toString());
        contentValues.put("iam_ids", jSONArray2.toString());
        contentValues.put("notification_influence_type", oSInfluenceType.toString().toLowerCase());
        contentValues.put("iam_influence_type", oSInfluenceType2.toString().toLowerCase());
        contentValues.put("name", oSOutcomeEventParams.getOutcomeId());
        contentValues.put("weight", oSOutcomeEventParams.getWeight());
        contentValues.put("timestamp", Long.valueOf(oSOutcomeEventParams.getTimestamp()));
        this.dbHelper.insert(OSOutcomeTableProvider.OUTCOME_EVENT_TABLE, null, contentValues);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<OSOutcomeEventParams> getAllEventsToSend() {
        ArrayList arrayList;
        OSOutcomeSource oSOutcomeSource;
        arrayList = new ArrayList();
        Cursor query = this.dbHelper.query(OSOutcomeTableProvider.OUTCOME_EVENT_TABLE, null, null, null, null, null, null);
        if (query.moveToFirst()) {
            do {
                OSInfluenceType fromString = OSInfluenceType.fromString(query.getString(query.getColumnIndex("notification_influence_type")));
                OSInfluenceType fromString2 = OSInfluenceType.fromString(query.getString(query.getColumnIndex("iam_influence_type")));
                String string = query.getString(query.getColumnIndex("notification_ids"));
                if (string == null) {
                    string = "[]";
                }
                String string2 = query.getString(query.getColumnIndex("iam_ids"));
                if (string2 == null) {
                    string2 = "[]";
                }
                String string3 = query.getString(query.getColumnIndex("name"));
                float f = query.getFloat(query.getColumnIndex("weight"));
                long j = query.getLong(query.getColumnIndex("timestamp"));
                try {
                    OSOutcomeSourceBody oSOutcomeSourceBody = new OSOutcomeSourceBody();
                    OSOutcomeSourceBody oSOutcomeSourceBody2 = new OSOutcomeSourceBody();
                    int i = AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType[fromString.ordinal()];
                    if (i == 1) {
                        oSOutcomeSourceBody.setNotificationIds(new JSONArray(string));
                        oSOutcomeSource = new OSOutcomeSource(oSOutcomeSourceBody, null);
                    } else if (i != 2) {
                        oSOutcomeSource = null;
                    } else {
                        oSOutcomeSourceBody2.setNotificationIds(new JSONArray(string));
                        oSOutcomeSource = new OSOutcomeSource(null, oSOutcomeSourceBody2);
                    }
                    int i2 = AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType[fromString2.ordinal()];
                    if (i2 == 1) {
                        oSOutcomeSourceBody.setInAppMessagesIds(new JSONArray(string2));
                        oSOutcomeSource = oSOutcomeSource == null ? new OSOutcomeSource(oSOutcomeSourceBody, null) : oSOutcomeSource.setDirectBody(oSOutcomeSourceBody);
                    } else if (i2 == 2) {
                        oSOutcomeSourceBody2.setInAppMessagesIds(new JSONArray(string2));
                        oSOutcomeSource = oSOutcomeSource == null ? new OSOutcomeSource(null, oSOutcomeSourceBody2) : oSOutcomeSource.setIndirectBody(oSOutcomeSourceBody2);
                    }
                    arrayList.add(new OSOutcomeEventParams(string3, oSOutcomeSource, f, j));
                } catch (JSONException e) {
                    this.logger.error("Generating JSONArray from notifications ids outcome:JSON Failed.", e);
                }
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    /* renamed from: com.onesignal.outcomes.OSOutcomeEventsCache$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$onesignal$influence$model$OSInfluenceType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.onesignal.influence.model.OSInfluenceType[] r0 = com.onesignal.influence.model.OSInfluenceType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.onesignal.outcomes.OSOutcomeEventsCache.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType = r0
                com.onesignal.influence.model.OSInfluenceType r1 = com.onesignal.influence.model.OSInfluenceType.DIRECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.onesignal.outcomes.OSOutcomeEventsCache.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.influence.model.OSInfluenceType r1 = com.onesignal.influence.model.OSInfluenceType.INDIRECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.onesignal.outcomes.OSOutcomeEventsCache.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.influence.model.OSInfluenceType r1 = com.onesignal.influence.model.OSInfluenceType.UNATTRIBUTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.onesignal.outcomes.OSOutcomeEventsCache.AnonymousClass1.$SwitchMap$com$onesignal$influence$model$OSInfluenceType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.influence.model.OSInfluenceType r1 = com.onesignal.influence.model.OSInfluenceType.DISABLED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.outcomes.OSOutcomeEventsCache.AnonymousClass1.<clinit>():void");
        }
    }

    private void addIdToListFromChannel(List<OSCachedUniqueOutcome> list, JSONArray jSONArray, OSInfluenceChannel oSInfluenceChannel) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    list.add(new OSCachedUniqueOutcome(jSONArray.getString(i), oSInfluenceChannel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addIdsToListFromSource(List<OSCachedUniqueOutcome> list, OSOutcomeSourceBody oSOutcomeSourceBody) {
        if (oSOutcomeSourceBody != null) {
            JSONArray inAppMessagesIds = oSOutcomeSourceBody.getInAppMessagesIds();
            JSONArray notificationIds = oSOutcomeSourceBody.getNotificationIds();
            addIdToListFromChannel(list, inAppMessagesIds, OSInfluenceChannel.IAM);
            addIdToListFromChannel(list, notificationIds, OSInfluenceChannel.NOTIFICATION);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void saveUniqueOutcomeEventParams(OSOutcomeEventParams oSOutcomeEventParams) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal saveUniqueOutcomeEventParams: " + oSOutcomeEventParams.toString());
        if (oSOutcomeEventParams.getOutcomeSource() != null) {
            String outcomeId = oSOutcomeEventParams.getOutcomeId();
            ArrayList arrayList = new ArrayList();
            OSOutcomeSourceBody directBody = oSOutcomeEventParams.getOutcomeSource().getDirectBody();
            OSOutcomeSourceBody indirectBody = oSOutcomeEventParams.getOutcomeSource().getIndirectBody();
            addIdsToListFromSource(arrayList, directBody);
            addIdsToListFromSource(arrayList, indirectBody);
            for (OSCachedUniqueOutcome oSCachedUniqueOutcome : arrayList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_INFLUENCE_ID, oSCachedUniqueOutcome.getInfluenceId());
                contentValues.put(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_TYPE, String.valueOf(oSCachedUniqueOutcome.getChannel()));
                contentValues.put("name", outcomeId);
                this.dbHelper.insert(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_TABLE, null, contentValues);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r3.isClosed() == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        if (r3.isClosed() == false) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.onesignal.influence.model.OSInfluence> getNotCachedUniqueInfluencesForOutcome(java.lang.String r21, java.util.List<com.onesignal.influence.model.OSInfluence> r22) {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.outcomes.OSOutcomeEventsCache.getNotCachedUniqueInfluencesForOutcome(java.lang.String, java.util.List):java.util.List");
    }
}
