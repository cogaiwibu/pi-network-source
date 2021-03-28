package com.google.firebase.messaging;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class Constants {
    public static final String FCM_WAKE_LOCK = "wake:com.google.firebase.messaging";
    public static final String IPC_BUNDLE_KEY_SEND_ERROR = "error";
    public static final String TAG = "FirebaseMessaging";
    public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(3);

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class AnalyticsKeys {
        public static final String ABT_EXPERIMENT = "google.c.a.abt";
        public static final String COMPOSER_ID = "google.c.a.c_id";
        public static final String COMPOSER_LABEL = "google.c.a.c_l";
        public static final String ENABLED = "google.c.a.e";
        public static final String MESSAGE_CHANNEL = "google.c.a.m_c";
        public static final String MESSAGE_LABEL = "google.c.a.m_l";
        public static final String MESSAGE_TIMESTAMP = "google.c.a.ts";
        public static final String MESSAGE_USE_DEVICE_TIME = "google.c.a.udt";
        public static final String PREFIX = "google.c.a.";
        public static final String TRACK_CONVERSIONS = "google.c.a.tc";

        private AnalyticsKeys() {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class FirelogAnalytics {
        public static final String FCM_LOG_SOURCE = "FCM_CLIENT_EVENT_LOGGING";
        public static final String PARAM_ANALYTICS_LABEL = "analyticsLabel";
        public static final String PARAM_CAMPAIGN_ID = "campaignId";
        public static final String PARAM_COLLAPSE_KEY = "collapseKey";
        public static final String PARAM_COMPOSER_LABEL = "composerLabel";
        public static final String PARAM_EVENT = "event";
        public static final String PARAM_INSTANCE_ID = "instanceId";
        public static final String PARAM_MESSAGE_ID = "messageId";
        public static final String PARAM_MESSAGE_TYPE = "messageType";
        public static final String PARAM_PACKAGE_NAME = "packageName";
        public static final String PARAM_PRIORITY = "priority";
        public static final String PARAM_PROJECT_NUMBER = "projectNumber";
        public static final String PARAM_SDK_PLATFORM = "sdkPlatform";
        public static final String PARAM_TOPIC = "topic";
        public static final String PARAM_TTL = "ttl";
        public static final String SDK_PLATFORM_ANDROID = "ANDROID";

        /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
        public @interface EventType {
            public static final String MESSAGE_DELIVERED = "MESSAGE_DELIVERED";
        }

        /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
        public @interface MessageType {
            public static final String DATA_MESSAGE = "DATA_MESSAGE";
            public static final String DISPLAY_NOTIFICATION = "DISPLAY_NOTIFICATION";
        }

        private FirelogAnalytics() {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class MessageNotificationKeys {
        public static final String BODY = "gcm.n.body";
        public static final String CHANNEL = "gcm.n.android_channel_id";
        public static final String CLICK_ACTION = "gcm.n.click_action";
        public static final String COLOR = "gcm.n.color";
        public static final String DEFAULT_LIGHT_SETTINGS = "gcm.n.default_light_settings";
        public static final String DEFAULT_SOUND = "gcm.n.default_sound";
        public static final String DEFAULT_VIBRATE_TIMINGS = "gcm.n.default_vibrate_timings";
        public static final String DO_NOT_PROXY = "gcm.n.dnp";
        public static final String ENABLE_NOTIFICATION = "gcm.n.e";
        public static final String EVENT_TIME = "gcm.n.event_time";
        public static final String ICON = "gcm.n.icon";
        public static final String IMAGE_URL = "gcm.n.image";
        public static final String LIGHT_SETTINGS = "gcm.n.light_settings";
        public static final String LINK = "gcm.n.link";
        public static final String LINK_ANDROID = "gcm.n.link_android";
        public static final String LOCAL_ONLY = "gcm.n.local_only";
        public static final String NOTIFICATION_COUNT = "gcm.n.notification_count";
        public static final String NOTIFICATION_PREFIX = "gcm.n.";
        public static final String NOTIFICATION_PREFIX_OLD = "gcm.notification.";
        public static final String NOTIFICATION_PRIORITY = "gcm.n.notification_priority";
        public static final String NO_UI = "gcm.n.noui";
        public static final String RESERVED_PREFIX = "gcm.";
        public static final String SOUND = "gcm.n.sound";
        public static final String SOUND_2 = "gcm.n.sound2";
        public static final String STICKY = "gcm.n.sticky";
        public static final String TAG = "gcm.n.tag";
        public static final String TEXT_ARGS_SUFFIX = "_loc_args";
        public static final String TEXT_RESOURCE_SUFFIX = "_loc_key";
        public static final String TICKER = "gcm.n.ticker";
        public static final String TITLE = "gcm.n.title";
        public static final String VIBRATE_TIMINGS = "gcm.n.vibrate_timings";
        public static final String VISIBILITY = "gcm.n.visibility";

        private MessageNotificationKeys() {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class MessageTypes {
        public static final String DELETED = "deleted_messages";
        public static final String MESSAGE = "gcm";
        public static final String SEND_ERROR = "send_error";
        public static final String SEND_EVENT = "send_event";

        private MessageTypes() {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class ScionAnalytics {
        public static final String EVENT_FIREBASE_CAMPAIGN = "_cmp";
        public static final String EVENT_NOTIFICATION_DISMISS = "_nd";
        public static final String EVENT_NOTIFICATION_FOREGROUND = "_nf";
        public static final String EVENT_NOTIFICATION_OPEN = "_no";
        public static final String EVENT_NOTIFICATION_RECEIVE = "_nr";
        public static final String ORIGIN_FCM = "fcm";
        public static final String PARAM_CAMPAIGN = "campaign";
        public static final String PARAM_LABEL = "label";
        public static final String PARAM_MEDIUM = "medium";
        public static final String PARAM_MESSAGE_CHANNEL = "message_channel";
        public static final String PARAM_MESSAGE_DEVICE_TIME = "_ndt";
        public static final String PARAM_MESSAGE_NAME = "_nmn";
        public static final String PARAM_MESSAGE_TIME = "_nmt";
        public static final String PARAM_MESSAGE_TYPE = "_nmc";
        public static final String PARAM_SOURCE = "source";
        public static final String PARAM_TOPIC = "_nt";
        public static final String USER_PROPERTY_FIREBASE_LAST_NOTIFICATION = "_ln";

        /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
        public @interface MessageType {
            public static final String DATA_MESSAGE = "data";
            public static final String DISPLAY_NOTIFICATION = "display";
        }

        private ScionAnalytics() {
        }
    }

    private Constants() {
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class MessagePayloadKeys {
        public static final String COLLAPSE_KEY = "collapse_key";
        public static final String DELIVERED_PRIORITY = "google.delivered_priority";
        public static final String FROM = "from";
        public static final String MESSAGE_TYPE = "message_type";
        public static final String MSGID = "google.message_id";
        public static final String MSGID_SERVER = "message_id";
        public static final String ORIGINAL_PRIORITY = "google.original_priority";
        public static final String PRIORITY_REDUCED_V19 = "google.priority_reduced";
        public static final String PRIORITY_V19 = "google.priority";
        public static final String RAW_DATA = "rawData";
        public static final String RESERVED_CLIENT_LIB_PREFIX = "google.c.";
        public static final String RESERVED_PREFIX = "google.";
        public static final String SENDER_ID = "google.c.sender.id";
        public static final String SENT_TIME = "google.sent_time";
        public static final String TO = "google.to";
        public static final String TTL = "google.ttl";

        public static ArrayMap<String, String> extractDeveloperDefinedPayload(Bundle bundle) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith(RESERVED_PREFIX) && !str.startsWith(MessageNotificationKeys.RESERVED_PREFIX) && !str.equals(FROM) && !str.equals(MESSAGE_TYPE) && !str.equals(COLLAPSE_KEY)) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            return arrayMap;
        }

        private MessagePayloadKeys() {
        }
    }
}
