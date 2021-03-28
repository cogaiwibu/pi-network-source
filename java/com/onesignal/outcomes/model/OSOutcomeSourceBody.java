package com.onesignal.outcomes.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OSOutcomeSourceBody {
    private static final String IAM_IDS = "in_app_message_ids";
    private static final String NOTIFICATION_IDS = "notification_ids";
    private JSONArray inAppMessagesIds;
    private JSONArray notificationIds;

    public OSOutcomeSourceBody() {
        this(new JSONArray(), new JSONArray());
    }

    public OSOutcomeSourceBody(JSONArray jSONArray, JSONArray jSONArray2) {
        this.notificationIds = jSONArray;
        this.inAppMessagesIds = jSONArray2;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NOTIFICATION_IDS, this.notificationIds);
        jSONObject.put(IAM_IDS, this.inAppMessagesIds);
        return jSONObject;
    }

    public JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    public void setNotificationIds(JSONArray jSONArray) {
        this.notificationIds = jSONArray;
    }

    public JSONArray getInAppMessagesIds() {
        return this.inAppMessagesIds;
    }

    public void setInAppMessagesIds(JSONArray jSONArray) {
        this.inAppMessagesIds = jSONArray;
    }

    public String toString() {
        return "OSOutcomeSourceBody{notificationIds=" + this.notificationIds + ", inAppMessagesIds=" + this.inAppMessagesIds + '}';
    }
}
