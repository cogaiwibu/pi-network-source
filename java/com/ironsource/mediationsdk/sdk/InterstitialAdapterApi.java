package com.ironsource.mediationsdk.sdk;

import org.json.JSONObject;

public interface InterstitialAdapterApi {
    void addInterstitialListener(InterstitialSmashListener interstitialSmashListener);

    void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener);

    boolean isInterstitialReady(JSONObject jSONObject);

    void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener);

    void removeInterstitialListener(InterstitialSmashListener interstitialSmashListener);

    void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener);
}
