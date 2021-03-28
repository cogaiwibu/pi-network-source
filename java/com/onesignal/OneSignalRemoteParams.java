package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OneSignalRemoteParams {
    public static final int DEFAULT_INDIRECT_ATTRIBUTION_WINDOW = 1440;
    public static final int DEFAULT_NOTIFICATION_LIMIT = 10;
    private static final String DIRECT_PARAM = "direct";
    private static final String ENABLED_PARAM = "enabled";
    private static final String FCM_API_KEY = "api_key";
    private static final String FCM_APP_ID = "app_id";
    private static final String FCM_PARENT_PARAM = "fcm";
    private static final String FCM_PROJECT_ID = "project_id";
    private static final String IAM_ATTRIBUTION_PARAM = "in_app_message_attribution";
    private static final int INCREASE_BETWEEN_RETRIES = 10000;
    private static final String INDIRECT_PARAM = "indirect";
    private static final int MAX_WAIT_BETWEEN_RETRIES = 90000;
    private static final int MIN_WAIT_BETWEEN_RETRIES = 30000;
    private static final String NOTIFICATION_ATTRIBUTION_PARAM = "notification_attribution";
    private static final String OUTCOMES_V2_SERVICE_PARAM = "v2_enabled";
    private static final String OUTCOME_PARAM = "outcomes";
    private static final String UNATTRIBUTED_PARAM = "unattributed";
    private static int androidParamsRetries;

    /* access modifiers changed from: package-private */
    public interface CallBack {
        void complete(Params params);
    }

    static /* synthetic */ int access$008() {
        int i = androidParamsRetries;
        androidParamsRetries = i + 1;
        return i;
    }

    static class FCMParams {
        String apiKey;
        String appId;
        String projectId;

        FCMParams() {
        }
    }

    public static class InfluenceParams {
        boolean directEnabled = false;
        int iamLimit = 10;
        boolean indirectEnabled = false;
        int indirectIAMAttributionWindow = OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW;
        int indirectNotificationAttributionWindow = OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW;
        int notificationLimit = 10;
        boolean outcomesV2ServiceEnabled = false;
        boolean unattributedEnabled = false;

        public int getIndirectNotificationAttributionWindow() {
            return this.indirectNotificationAttributionWindow;
        }

        public int getNotificationLimit() {
            return this.notificationLimit;
        }

        public int getIndirectIAMAttributionWindow() {
            return this.indirectIAMAttributionWindow;
        }

        public int getIamLimit() {
            return this.iamLimit;
        }

        public boolean isDirectEnabled() {
            return this.directEnabled;
        }

        public boolean isIndirectEnabled() {
            return this.indirectEnabled;
        }

        public boolean isUnattributedEnabled() {
            return this.unattributedEnabled;
        }

        public String toString() {
            return "InfluenceParams{indirectNotificationAttributionWindow=" + this.indirectNotificationAttributionWindow + ", notificationLimit=" + this.notificationLimit + ", indirectIAMAttributionWindow=" + this.indirectIAMAttributionWindow + ", iamLimit=" + this.iamLimit + ", directEnabled=" + this.directEnabled + ", indirectEnabled=" + this.indirectEnabled + ", unattributedEnabled=" + this.unattributedEnabled + '}';
        }
    }

    /* access modifiers changed from: package-private */
    public static class Params {
        boolean clearGroupOnSummaryClick;
        boolean enterprise;
        FCMParams fcmParams;
        boolean firebaseAnalytics;
        String googleProjectNumber;
        InfluenceParams influenceParams;
        JSONArray notificationChannels;
        boolean receiveReceiptEnabled;
        boolean restoreTTLFilter;
        boolean useEmailAuth;
        boolean useUserIdAuth;

        Params() {
        }
    }

    static void makeAndroidParamsRequest(final CallBack callBack) {
        AnonymousClass1 r0 = new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRemoteParams.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                if (i == 403) {
                    OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "403 error getting OneSignal params, omitting further retries!");
                } else {
                    new Thread(new Runnable() {
                        /* class com.onesignal.OneSignalRemoteParams.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            int i = (OneSignalRemoteParams.androidParamsRetries * OneSignalRemoteParams.INCREASE_BETWEEN_RETRIES) + 30000;
                            if (i > OneSignalRemoteParams.MAX_WAIT_BETWEEN_RETRIES) {
                                i = OneSignalRemoteParams.MAX_WAIT_BETWEEN_RETRIES;
                            }
                            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.INFO;
                            OneSignal.Log(log_level, "Failed to get Android parameters, trying again in " + (i / 1000) + " seconds.");
                            OSUtils.sleep(i);
                            OneSignalRemoteParams.access$008();
                            OneSignalRemoteParams.makeAndroidParamsRequest(CallBack.this);
                        }
                    }, "OS_PARAMS_REQUEST").start();
                }
            }

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                OneSignalRemoteParams.processJson(str, CallBack.this);
            }
        };
        String str = "apps/" + OneSignal.appId + "/android_params.js";
        String userId = OneSignal.getUserId();
        if (userId != null) {
            str = str + "?player_id=" + userId;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Starting request to get Android parameters.");
        OneSignalRestClient.get(str, r0, "CACHE_KEY_REMOTE_PARAMS");
    }

    /* access modifiers changed from: private */
    public static void processJson(String str, CallBack callBack) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            callBack.complete(new Params() {
                /* class com.onesignal.OneSignalRemoteParams.AnonymousClass2 */

                {
                    this.enterprise = jSONObject.optBoolean("enterp", false);
                    this.useEmailAuth = jSONObject.optBoolean("require_email_auth", false);
                    this.useUserIdAuth = jSONObject.optBoolean("require_user_id_auth", false);
                    this.notificationChannels = jSONObject.optJSONArray("chnl_lst");
                    this.firebaseAnalytics = jSONObject.optBoolean("fba", false);
                    this.restoreTTLFilter = jSONObject.optBoolean("restore_ttl_filter", true);
                    this.googleProjectNumber = jSONObject.optString("android_sender_id", null);
                    this.clearGroupOnSummaryClick = jSONObject.optBoolean("clear_group_on_summary_click", true);
                    this.receiveReceiptEnabled = jSONObject.optBoolean("receive_receipts_enable", false);
                    this.influenceParams = new InfluenceParams();
                    if (jSONObject.has(OneSignalRemoteParams.OUTCOME_PARAM)) {
                        OneSignalRemoteParams.processOutcomeJson(jSONObject.optJSONObject(OneSignalRemoteParams.OUTCOME_PARAM), this.influenceParams);
                    }
                    this.fcmParams = new FCMParams();
                    if (jSONObject.has("fcm")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("fcm");
                        this.fcmParams.apiKey = optJSONObject.optString("api_key", null);
                        this.fcmParams.appId = optJSONObject.optString("app_id", null);
                        this.fcmParams.projectId = optJSONObject.optString(OneSignalRemoteParams.FCM_PROJECT_ID, null);
                    }
                }
            });
        } catch (NullPointerException | JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.FATAL, "Error parsing android_params!: ", e);
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.FATAL;
            OneSignal.Log(log_level, "Response that errored from android_params!: " + str);
        }
    }

    /* access modifiers changed from: private */
    public static void processOutcomeJson(JSONObject jSONObject, InfluenceParams influenceParams) {
        if (jSONObject.has(OUTCOMES_V2_SERVICE_PARAM)) {
            influenceParams.outcomesV2ServiceEnabled = jSONObject.optBoolean(OUTCOMES_V2_SERVICE_PARAM);
        }
        if (jSONObject.has(DIRECT_PARAM)) {
            influenceParams.directEnabled = jSONObject.optJSONObject(DIRECT_PARAM).optBoolean("enabled");
        }
        if (jSONObject.has(INDIRECT_PARAM)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(INDIRECT_PARAM);
            influenceParams.indirectEnabled = optJSONObject.optBoolean("enabled");
            if (optJSONObject.has(NOTIFICATION_ATTRIBUTION_PARAM)) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(NOTIFICATION_ATTRIBUTION_PARAM);
                influenceParams.indirectNotificationAttributionWindow = optJSONObject2.optInt("minutes_since_displayed", DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
                influenceParams.notificationLimit = optJSONObject2.optInt("limit", 10);
            }
            if (optJSONObject.has(IAM_ATTRIBUTION_PARAM)) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject(IAM_ATTRIBUTION_PARAM);
                influenceParams.indirectIAMAttributionWindow = optJSONObject3.optInt("minutes_since_displayed", DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
                influenceParams.iamLimit = optJSONObject3.optInt("limit", 10);
            }
        }
        if (jSONObject.has(UNATTRIBUTED_PARAM)) {
            influenceParams.unattributedEnabled = jSONObject.optJSONObject(UNATTRIBUTED_PARAM).optBoolean("enabled");
        }
    }
}
