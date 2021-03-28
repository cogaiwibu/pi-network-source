package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.onesignal.OneSignalDbContract;
import java.util.Map;
import java.util.TreeMap;

class NotificationLimitManager {
    private static final int MAX_NUMBER_OF_NOTIFICATIONS_INT = 49;
    static final String MAX_NUMBER_OF_NOTIFICATIONS_STR = Integer.toString(49);

    private static int getMaxNumberOfNotificationsInt() {
        return 49;
    }

    NotificationLimitManager() {
    }

    private static String getMaxNumberOfNotificationsString() {
        return MAX_NUMBER_OF_NOTIFICATIONS_STR;
    }

    static void clearOldestOverLimit(Context context, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                clearOldestOverLimitStandard(context, i);
            } else {
                clearOldestOverLimitFallback(context, i);
            }
        } catch (Throwable unused) {
            clearOldestOverLimitFallback(context, i);
        }
    }

    static void clearOldestOverLimitStandard(Context context, int i) throws Throwable {
        StatusBarNotification[] activeNotifications = OneSignalNotificationManager.getActiveNotifications(context);
        int length = (activeNotifications.length - getMaxNumberOfNotificationsInt()) + i;
        if (length >= 1) {
            TreeMap treeMap = new TreeMap();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (!isGroupSummary(statusBarNotification)) {
                    treeMap.put(Long.valueOf(statusBarNotification.getNotification().when), Integer.valueOf(statusBarNotification.getId()));
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                OneSignal.cancelNotification(((Integer) entry.getValue()).intValue());
                length--;
                if (length <= 0) {
                    return;
                }
            }
        }
    }

    static void clearOldestOverLimitFallback(Context context, int i) {
        OneSignalDbHelper instance = OneSignalDbHelper.getInstance(context);
        Cursor cursor = null;
        try {
            cursor = instance.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, OneSignalDbHelper.recentUninteractedWithNotificationsWhere().toString(), null, null, null, "_id", getMaxNumberOfNotificationsString() + i);
            int count = (cursor.getCount() - getMaxNumberOfNotificationsInt()) + i;
            if (count >= 1) {
                while (cursor.moveToNext()) {
                    OneSignal.cancelNotification(cursor.getInt(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID)));
                    count--;
                    if (count <= 0) {
                        break;
                    }
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    static boolean isGroupSummary(StatusBarNotification statusBarNotification) {
        return (statusBarNotification.getNotification().flags & 512) != 0;
    }
}
