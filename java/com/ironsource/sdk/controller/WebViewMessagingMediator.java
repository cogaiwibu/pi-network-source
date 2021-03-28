package com.ironsource.sdk.controller;

import org.json.JSONObject;

public interface WebViewMessagingMediator {
    void sendMessageToController(String str, JSONObject jSONObject);
}
