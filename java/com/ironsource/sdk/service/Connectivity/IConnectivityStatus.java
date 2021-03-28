package com.ironsource.sdk.service.Connectivity;

import org.json.JSONObject;

public interface IConnectivityStatus {
    void onConnected(String str, JSONObject jSONObject);

    void onDisconnected();

    void onStatusChanged(String str, JSONObject jSONObject);
}
