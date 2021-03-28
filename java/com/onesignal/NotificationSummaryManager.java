package com.onesignal;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class NotificationSummaryManager {
    NotificationSummaryManager() {
    }

    static void updatePossibleDependentSummaryOnDismiss(Context context, OneSignalDb oneSignalDb, int i) {
        Cursor query = oneSignalDb.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{"group_id"}, "android_notification_id = " + i, null, null, null, null);
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("group_id"));
            query.close();
            if (string != null) {
                updateSummaryNotificationAfterChildRemoved(context, oneSignalDb, string, true);
                return;
            }
            return;
        }
        query.close();
    }

    static void updateSummaryNotificationAfterChildRemoved(Context context, OneSignalDb oneSignalDb, String str, boolean z) {
        try {
            Cursor internalUpdateSummaryNotificationAfterChildRemoved = internalUpdateSummaryNotificationAfterChildRemoved(context, oneSignalDb, str, z);
            if (internalUpdateSummaryNotificationAfterChildRemoved != null && !internalUpdateSummaryNotificationAfterChildRemoved.isClosed()) {
                internalUpdateSummaryNotificationAfterChildRemoved.close();
            }
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }

    private static Cursor internalUpdateSummaryNotificationAfterChildRemoved(Context context, OneSignalDb oneSignalDb, String str, boolean z) {
        Cursor query = oneSignalDb.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, null, null, "_id DESC");
        int count = query.getCount();
        if (count == 0) {
            query.close();
            Integer summaryNotificationId = getSummaryNotificationId(oneSignalDb, str);
            if (summaryNotificationId == null) {
                return query;
            }
            OneSignalNotificationManager.getNotificationManager(context).cancel(summaryNotificationId.intValue());
            ContentValues contentValues = new ContentValues();
            contentValues.put(z ? "dismissed" : OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, (Integer) 1);
            oneSignalDb.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "android_notification_id = " + summaryNotificationId, null);
            return query;
        } else if (count == 1) {
            query.close();
            if (getSummaryNotificationId(oneSignalDb, str) == null) {
                return query;
            }
            restoreSummary(context, str);
            return query;
        } else {
            try {
                query.moveToFirst();
                Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME)));
                query.close();
                if (getSummaryNotificationId(oneSignalDb, str) == null) {
                    return query;
                }
                NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
                notificationGenerationJob.restoring = true;
                notificationGenerationJob.shownTimeStamp = valueOf;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("grp", str);
                notificationGenerationJob.jsonPayload = jSONObject;
                GenerateNotification.updateSummaryNotification(notificationGenerationJob);
                return query;
            } catch (JSONException unused) {
            }
        }
    }

    private static void restoreSummary(Context context, String str) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = OneSignalDbHelper.getInstance(context).query(OneSignalDbContract.NotificationTable.TABLE_NAME, NotificationRestorer.COLUMNS_FOR_RESTORE, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, null, null, null);
            NotificationRestorer.showNotificationsFromCursor(context, cursor, 0);
            if (cursor == null || cursor.isClosed()) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer getSummaryNotificationId(com.onesignal.OneSignalDb r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationSummaryManager.getSummaryNotificationId(com.onesignal.OneSignalDb, java.lang.String):java.lang.Integer");
    }

    static void clearNotificationOnSummaryClick(Context context, OneSignalDbHelper oneSignalDbHelper, String str) {
        Integer summaryNotificationId = getSummaryNotificationId(oneSignalDbHelper, str);
        boolean equals = str.equals(OneSignalNotificationManager.getGrouplessSummaryKey());
        NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(context);
        Integer mostRecentNotifIdFromGroup = OneSignalNotificationManager.getMostRecentNotifIdFromGroup(oneSignalDbHelper, str, equals);
        if (mostRecentNotifIdFromGroup == null) {
            return;
        }
        if (OneSignal.getClearGroupSummaryClick()) {
            if (equals) {
                summaryNotificationId = Integer.valueOf(OneSignalNotificationManager.getGrouplessSummaryId());
            }
            if (summaryNotificationId != null) {
                notificationManager.cancel(summaryNotificationId.intValue());
                return;
            }
            return;
        }
        OneSignal.cancelNotification(mostRecentNotifIdFromGroup.intValue());
    }
}
