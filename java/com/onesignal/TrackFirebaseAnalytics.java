package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import com.onesignal.OneSignalDbContract;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/* access modifiers changed from: package-private */
public class TrackFirebaseAnalytics {
    private static final String EVENT_NOTIFICATION_INFLUENCE_OPEN = "os_notification_influence_open";
    private static final String EVENT_NOTIFICATION_OPENED = "os_notification_opened";
    private static final String EVENT_NOTIFICATION_RECEIVED = "os_notification_received";
    private static Class<?> FirebaseAnalyticsClass;
    private static AtomicLong lastOpenedTime;
    private static OSNotificationPayload lastReceivedPayload;
    private static AtomicLong lastReceivedTime;
    private Context appContext;
    private Object mFirebaseAnalyticsInstance;

    TrackFirebaseAnalytics(Context context) {
        this.appContext = context;
    }

    static boolean CanTrack() {
        try {
            FirebaseAnalyticsClass = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void trackInfluenceOpenEvent() {
        if (lastReceivedTime != null && lastReceivedPayload != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastReceivedTime.get() <= 120000) {
                AtomicLong atomicLong = lastOpenedTime;
                if (atomicLong == null || currentTimeMillis - atomicLong.get() >= 30000) {
                    try {
                        Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance(this.appContext);
                        Method trackMethod = getTrackMethod(FirebaseAnalyticsClass);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "OneSignal");
                        bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
                        bundle.putString("notification_id", lastReceivedPayload.notificationID);
                        bundle.putString("campaign", getCampaignNameFromPayload(lastReceivedPayload));
                        trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_INFLUENCE_OPEN, bundle);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void trackOpenedEvent(OSNotificationOpenResult oSNotificationOpenResult) {
        if (lastOpenedTime == null) {
            lastOpenedTime = new AtomicLong();
        }
        lastOpenedTime.set(System.currentTimeMillis());
        try {
            Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance(this.appContext);
            Method trackMethod = getTrackMethod(FirebaseAnalyticsClass);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
            bundle.putString("notification_id", oSNotificationOpenResult.notification.payload.notificationID);
            bundle.putString("campaign", getCampaignNameFromPayload(oSNotificationOpenResult.notification.payload));
            trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_OPENED, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void trackReceivedEvent(OSNotificationOpenResult oSNotificationOpenResult) {
        try {
            Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance(this.appContext);
            Method trackMethod = getTrackMethod(FirebaseAnalyticsClass);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
            bundle.putString("notification_id", oSNotificationOpenResult.notification.payload.notificationID);
            bundle.putString("campaign", getCampaignNameFromPayload(oSNotificationOpenResult.notification.payload));
            trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_RECEIVED, bundle);
            if (lastReceivedTime == null) {
                lastReceivedTime = new AtomicLong();
            }
            lastReceivedTime.set(System.currentTimeMillis());
            lastReceivedPayload = oSNotificationOpenResult.notification.payload;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String getCampaignNameFromPayload(OSNotificationPayload oSNotificationPayload) {
        if (oSNotificationPayload.templateName.isEmpty() || oSNotificationPayload.templateId.isEmpty()) {
            return oSNotificationPayload.title != null ? oSNotificationPayload.title.substring(0, Math.min(10, oSNotificationPayload.title.length())) : "";
        }
        return oSNotificationPayload.templateName + " - " + oSNotificationPayload.templateId;
    }

    private Object getFirebaseAnalyticsInstance(Context context) {
        if (this.mFirebaseAnalyticsInstance == null) {
            try {
                this.mFirebaseAnalyticsInstance = getInstanceMethod(FirebaseAnalyticsClass).invoke(null, context);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.mFirebaseAnalyticsInstance;
    }

    private static Method getTrackMethod(Class cls) {
        try {
            return cls.getMethod("logEvent", String.class, Bundle.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Method getInstanceMethod(Class cls) {
        try {
            return cls.getMethod("getInstance", Context.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
