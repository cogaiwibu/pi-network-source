package com.onesignal;

import android.content.Context;
import com.onesignal.OneSignalDbContract;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.outcomes.OSOutcomeTableProvider;

/* access modifiers changed from: package-private */
public class OneSignalCacheCleaner {
    private static final long NOTIFICATION_CACHE_DATA_LIFETIME = 604800;
    private static final String OS_DELETE_CACHED_NOTIFICATIONS_THREAD = "OS_DELETE_CACHED_NOTIFICATIONS_THREAD";
    private static final String OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD = "OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD";

    OneSignalCacheCleaner() {
    }

    static void cleanOldCachedData(Context context) {
        OneSignalDbHelper instance = OneSignalDbHelper.getInstance(context);
        cleanNotificationCache(instance);
        cleanCachedInAppMessages(instance);
    }

    static synchronized void cleanNotificationCache(final OneSignalDbHelper oneSignalDbHelper) {
        synchronized (OneSignalCacheCleaner.class) {
            new Thread(new Runnable() {
                /* class com.onesignal.OneSignalCacheCleaner.AnonymousClass1 */

                public void run() {
                    Thread.currentThread().setPriority(10);
                    OneSignalCacheCleaner.cleanCachedNotifications(OneSignalDbHelper.this);
                    OneSignalCacheCleaner.cleanCachedUniqueOutcomeEventNotifications(OneSignalDbHelper.this);
                }
            }, OS_DELETE_CACHED_NOTIFICATIONS_THREAD).start();
        }
    }

    static synchronized void cleanCachedInAppMessages(final OneSignalDbHelper oneSignalDbHelper) {
        synchronized (OneSignalCacheCleaner.class) {
            new Thread(new Runnable() {
                /* class com.onesignal.OneSignalCacheCleaner.AnonymousClass2 */

                public void run() {
                    Thread.currentThread().setPriority(10);
                    OneSignal.getInAppMessageController().getInAppMessageRepository(OneSignalDbHelper.this).cleanCachedInAppMessages();
                }
            }, OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD).start();
        }
    }

    /* access modifiers changed from: private */
    public static void cleanCachedNotifications(OneSignalDbHelper oneSignalDbHelper) {
        oneSignalDbHelper.delete(OneSignalDbContract.NotificationTable.TABLE_NAME, "created_time < ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - NOTIFICATION_CACHE_DATA_LIFETIME)});
    }

    /* access modifiers changed from: private */
    public static void cleanCachedUniqueOutcomeEventNotifications(OneSignalDbHelper oneSignalDbHelper) {
        oneSignalDbHelper.delete(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_TABLE, "NOT EXISTS(SELECT NULL FROM notification n WHERE n.notification_id = channel_influence_id AND channel_type = \"" + OSInfluenceChannel.NOTIFICATION.toString().toLowerCase() + "\")", null);
    }
}
