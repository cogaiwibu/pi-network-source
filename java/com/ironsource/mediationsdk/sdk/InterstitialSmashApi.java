package com.ironsource.mediationsdk.sdk;

public interface InterstitialSmashApi {
    void initInterstitial(String str, String str2);

    boolean isInterstitialReady();

    void loadInterstitial();

    void setInterstitialManagerListener(InterstitialManagerListener interstitialManagerListener);

    void showInterstitial();
}
