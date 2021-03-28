package com.ironsource.sdk.ISNAdView;

import org.json.JSONObject;

public interface ISNAdViewDelegate {
    void sendErrorMessageToController(String str, String str2, String str3);

    void sendMessageToController(String str, JSONObject jSONObject);
}
