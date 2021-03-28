package com.ironsource.sdk;

import android.app.Activity;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import java.util.Map;
import org.json.JSONObject;

public interface IronSourceNetworkAds {
    ISNAdView createBanner(Activity activity, ISAdSize iSAdSize);

    void getOfferWallCredits(OnOfferWallListener onOfferWallListener);

    void initBanner(String str, Map<String, String> map, OnBannerListener onBannerListener);

    void initOfferWall(Map<String, String> map, OnOfferWallListener onOfferWallListener);

    boolean isAdAvailable(IronSourceAdInstance ironSourceAdInstance);

    void loadAd(Activity activity, IronSourceAdInstance ironSourceAdInstance, Map<String, String> map);

    void loadBanner(JSONObject jSONObject);

    void showAd(IronSourceAdInstance ironSourceAdInstance, Map<String, String> map);

    void showOfferWall(Map<String, String> map);
}
