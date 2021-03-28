package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSReceiveReceiptRepository {
    private static final String APP_ID = "app_id";
    private static final String PLAYER_ID = "player_id";

    OSReceiveReceiptRepository() {
    }

    /* access modifiers changed from: package-private */
    public void sendReceiveReceipt(String str, String str2, String str3, OneSignalRestClient.ResponseHandler responseHandler) {
        try {
            JSONObject put = new JSONObject().put("app_id", str).put(PLAYER_ID, str2);
            OneSignalRestClient.put("notifications/" + str3 + "/report_received", put, responseHandler);
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Generating direct receive receipt:JSON Failed.", e);
        }
    }
}
