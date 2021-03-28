package com.onesignal;

import org.json.JSONObject;

public class OSPermissionSubscriptionState {
    OSEmailSubscriptionState emailSubscriptionStatus;
    OSPermissionState permissionStatus;
    OSSubscriptionState subscriptionStatus;

    public OSPermissionState getPermissionStatus() {
        return this.permissionStatus;
    }

    public OSSubscriptionState getSubscriptionStatus() {
        return this.subscriptionStatus;
    }

    public OSEmailSubscriptionState getEmailSubscriptionStatus() {
        return this.emailSubscriptionStatus;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permissionStatus", this.permissionStatus.toJSONObject());
            jSONObject.put("subscriptionStatus", this.subscriptionStatus.toJSONObject());
            jSONObject.put("emailSubscriptionStatus", this.emailSubscriptionStatus.toJSONObject());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
