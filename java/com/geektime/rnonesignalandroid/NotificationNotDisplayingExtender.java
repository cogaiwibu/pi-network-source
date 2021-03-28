package com.geektime.rnonesignalandroid;

import android.util.Log;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationNotDisplayingExtender extends NotificationExtenderService {
    /* access modifiers changed from: protected */
    @Override // com.onesignal.NotificationExtenderService
    public boolean onNotificationProcessing(OSNotificationReceivedResult oSNotificationReceivedResult) {
        JSONObject jSONObject = oSNotificationReceivedResult.payload.additionalData;
        try {
            if (jSONObject.has("hidden")) {
                return jSONObject.getBoolean("hidden");
            }
            return false;
        } catch (JSONException e) {
            Log.e("OneSignal", "onNotificationProcessing Failure: " + e.getMessage());
            return false;
        }
    }
}
