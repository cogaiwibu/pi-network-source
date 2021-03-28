package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.eventsTracker.EventsConfiguration;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.ISNEventsUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.listeners.OnBannerListener;
import com.ironsource.sdk.listeners.OnNetworkSDKInitListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.service.TokenService;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONObject;

public class IronSourceNetwork {
    static final String TAG = "IronSourceNetwork";
    private static OnNetworkSDKInitListener initSDKListener;
    private static IronSourceNetworkAPI ironSourceNetwork;
    private static JSONObject mConsentParams;

    public static synchronized void initSDK(Context context, String str, String str2, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            if (TextUtils.isEmpty(str)) {
                Logger.e(TAG, "applicationKey is NULL");
                return;
            }
            if (ironSourceNetwork == null) {
                SDKUtils.setInitSDKParams(map);
                try {
                    JSONObject optJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject("events");
                    if (optJSONObject != null) {
                        initSDK5EventTracker(context, optJSONObject, str2, str, map);
                    }
                } catch (Exception e) {
                    Logger.e(TAG, "Failed to init event tracker: " + e.getMessage());
                }
                ironSourceNetwork = IronSourceAdsPublisherAgent.createInstance(context, str, str2);
                applyConsentInfo(mConsentParams);
            }
        }
    }

    public static synchronized void setInitListener(OnNetworkSDKInitListener onNetworkSDKInitListener) {
        synchronized (IronSourceNetwork.class) {
            initSDKListener = onNetworkSDKInitListener;
        }
    }

    public static OnNetworkSDKInitListener getInitListener() {
        return initSDKListener;
    }

    private static void initSDK5EventTracker(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        EventsConfiguration createConfigurations = ISNEventsUtils.createConfigurations(jSONObject);
        if (createConfigurations.areEventsEnabled()) {
            ISNEventsTracker.init(createConfigurations, ISNEventsUtils.createEventsBaseData(context, str, str2, map));
        }
    }

    private static synchronized void validateInitSDK() throws Exception {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork == null) {
                throw new NullPointerException("Call initSDK first");
            }
        }
    }

    public static synchronized void loadAd(Activity activity, IronSourceAdInstance ironSourceAdInstance, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.loadAd(activity, ironSourceAdInstance, map);
        }
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void loadAd(Activity activity, IronSourceAdInstance ironSourceAdInstance) throws Exception {
        synchronized (IronSourceNetwork.class) {
            loadAd(activity, ironSourceAdInstance, null);
        }
    }

    public static synchronized void showAd(IronSourceAdInstance ironSourceAdInstance, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.showAd(ironSourceAdInstance, map);
        }
    }

    public static synchronized void showAd(IronSourceAdInstance ironSourceAdInstance) throws Exception {
        synchronized (IronSourceNetwork.class) {
            showAd(ironSourceAdInstance, null);
        }
    }

    public static synchronized boolean isAdAvailableForInstance(IronSourceAdInstance ironSourceAdInstance) {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork == null) {
                return false;
            }
            return ironSourceNetwork.isAdAvailable(ironSourceAdInstance);
        }
    }

    public static synchronized void onPause(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork != null) {
                ironSourceNetwork.onPause(activity);
            }
        }
    }

    public static synchronized void onResume(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork != null) {
                ironSourceNetwork.onResume(activity);
            }
        }
    }

    public static synchronized void updateConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            mConsentParams = jSONObject;
            applyConsentInfo(jSONObject);
        }
    }

    public static synchronized void applyConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork != null) {
                if (jSONObject != null) {
                    ironSourceNetwork.updateConsentInfo(jSONObject);
                }
            }
        }
    }

    public static synchronized void updateMetadata(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            TokenService.getInstance().updateMetaData(jSONObject);
        }
    }

    public static synchronized void release(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            if (ironSourceNetwork != null) {
                ironSourceNetwork.release(activity);
            }
        }
    }

    public static synchronized String getToken(Context context) {
        String token;
        synchronized (IronSourceNetwork.class) {
            token = TokenService.getInstance().getToken(context);
        }
        return token;
    }

    public static synchronized JSONObject getRawToken(Context context) {
        JSONObject rawToken;
        synchronized (IronSourceNetwork.class) {
            rawToken = TokenService.getInstance().getRawToken(context);
        }
        return rawToken;
    }

    public static synchronized void initOfferWall(Map<String, String> map, OnOfferWallListener onOfferWallListener) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.initOfferWall(map, onOfferWallListener);
        }
    }

    public static synchronized void showOfferWall(Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.showOfferWall(map);
        }
    }

    public static synchronized void getOfferWallCredits(OnOfferWallListener onOfferWallListener) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.getOfferWallCredits(onOfferWallListener);
        }
    }

    public static synchronized void initBanner(String str, Map<String, String> map, OnBannerListener onBannerListener) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.initBanner(str, map, onBannerListener);
        }
    }

    public static synchronized void loadBanner(JSONObject jSONObject) throws Exception {
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            ironSourceNetwork.loadBanner(jSONObject);
        }
    }

    public static synchronized ISNAdView createBanner(Activity activity, ISAdSize iSAdSize) throws Exception {
        ISNAdView createBanner;
        synchronized (IronSourceNetwork.class) {
            validateInitSDK();
            createBanner = ironSourceNetwork.createBanner(activity, iSAdSize);
        }
        return createBanner;
    }
}
