package com.ironsource.sdk;

import android.app.Activity;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
public interface SSAPublisher {
    ISNAdView createBanner(Activity activity, ISAdSize iSAdSize);

    void getOfferWallCredits(String str, String str2, OnOfferWallListener onOfferWallListener);

    void initBanner(String str, String str2, String str3, Map<String, String> map, OnBannerListener onBannerListener);

    void initInterstitial(String str, String str2, String str3, Map<String, String> map, OnInterstitialListener onInterstitialListener);

    void initOfferWall(String str, String str2, Map<String, String> map, OnOfferWallListener onOfferWallListener);

    void initRewardedVideo(String str, String str2, String str3, Map<String, String> map, OnRewardedVideoListener onRewardedVideoListener);

    boolean isInterstitialAdAvailable(String str);

    void loadBanner(JSONObject jSONObject);

    void loadInterstitial(JSONObject jSONObject);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void release(Activity activity);

    void setMediationState(String str, String str2, int i);

    void showInterstitial(JSONObject jSONObject);

    void showOfferWall(Map<String, String> map);

    void showRewardedVideo(JSONObject jSONObject);

    void updateConsentInfo(JSONObject jSONObject);
}
