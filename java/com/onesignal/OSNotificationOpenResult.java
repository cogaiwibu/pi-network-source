package com.onesignal;

import com.onesignal.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

public class OSNotificationOpenResult {
    public OSNotificationAction action;
    public OSNotification notification;

    @Deprecated
    public String stringify() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("actionID", this.action.actionID);
            jSONObject2.put("type", this.action.type.ordinal());
            jSONObject.put("action", jSONObject2);
            jSONObject.put(OneSignalDbContract.NotificationTable.TABLE_NAME, new JSONObject(this.notification.stringify()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("actionID", this.action.actionID);
            jSONObject2.put("type", this.action.type.ordinal());
            jSONObject.put("action", jSONObject2);
            jSONObject.put(OneSignalDbContract.NotificationTable.TABLE_NAME, this.notification.toJSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
