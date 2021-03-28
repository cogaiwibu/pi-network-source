package com.ironsource.sdk;

import org.json.JSONObject;

public class IronSourceNetworkAPIUtils {
    static String manual_rewarded_instance_prefix = "ManRewInst_";

    public static String generateInstanceId(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return manual_rewarded_instance_prefix + jSONObject.optString("name");
    }

    public static String generateInstanceUniqueId() {
        return String.valueOf(System.currentTimeMillis());
    }
}
