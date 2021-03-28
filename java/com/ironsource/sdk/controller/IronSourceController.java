package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.internals.DSBannerListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import java.util.Map;
import org.json.JSONObject;

public interface IronSourceController {
    void destroy();

    void enterBackground();

    void enterForeground();

    void getOfferWallCredits(String str, String str2, OnOfferWallListener onOfferWallListener);

    ISNEnums.ControllerType getType();

    void initBanner(String str, String str2, DemandSource demandSource, DSBannerListener dSBannerListener);

    void initInterstitial(String str, String str2, DemandSource demandSource, DSInterstitialListener dSInterstitialListener);

    void initOfferWall(String str, String str2, Map<String, String> map, OnOfferWallListener onOfferWallListener);

    void initRewardedVideo(String str, String str2, DemandSource demandSource, DSRewardedVideoListener dSRewardedVideoListener);

    boolean isInterstitialAdAvailable(String str);

    void loadBanner(JSONObject jSONObject, DSBannerListener dSBannerListener);

    void loadInterstitial(DemandSource demandSource, Map<String, String> map, DSInterstitialListener dSInterstitialListener);

    void loadInterstitial(String str, DSInterstitialListener dSInterstitialListener);

    void registerConnectionReceiver(Context context);

    @Deprecated
    void restoreSavedState();

    void setCommunicationWithAdView(ISNAdView iSNAdView);

    void showInterstitial(DemandSource demandSource, Map<String, String> map, DSInterstitialListener dSInterstitialListener);

    void showInterstitial(JSONObject jSONObject, DSInterstitialListener dSInterstitialListener);

    void showOfferWall(Map<String, String> map);

    void showRewardedVideo(JSONObject jSONObject, DSRewardedVideoListener dSRewardedVideoListener);

    void unregisterConnectionReceiver(Context context);

    void updateConsentInfo(JSONObject jSONObject);
}
