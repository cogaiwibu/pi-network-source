package com.anythink.reactnativejs;

import com.anythink.reactnativejs.interstitial.InterstitialHelper;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;

public class ATInterstitialRNSDKModule extends AnythinkReactContextBaseJavaModule {
    public static final String TAG = "ATInterstitialRNSDK";
    private static final HashMap<String, InterstitialHelper> sHelperMap = new HashMap<>();

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public ATInterstitialRNSDKModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadAd(String str, String str2) {
        InterstitialHelper helper = getHelper(str);
        if (helper != null) {
            helper.loadInterstitial(str, str2);
        }
    }

    @ReactMethod
    public void showAd(String str) {
        showAdInScenario(str, "");
    }

    @ReactMethod
    public void showAdInScenario(String str, String str2) {
        InterstitialHelper helper = getHelper(str);
        if (helper != null) {
            helper.showInterstitial(str2);
        }
    }

    @ReactMethod
    public void hasAdReady(String str, Promise promise) {
        InterstitialHelper helper = getHelper(str);
        if (helper != null) {
            promise.resolve(Boolean.valueOf(helper.isAdReady()));
            return;
        }
        MsgTools.pirntMsg("RewardVideoHelper = null");
        promise.resolve(false);
    }

    @ReactMethod
    public void checkAdStatus(String str, Promise promise) {
        InterstitialHelper helper = getHelper(str);
        if (helper != null) {
            promise.resolve(helper.checkAdStatus());
            return;
        }
        MsgTools.pirntMsg("InterstitialHelper = null");
        promise.resolve("");
    }

    private InterstitialHelper getHelper(String str) {
        if (sHelperMap.containsKey(str)) {
            return sHelperMap.get(str);
        }
        InterstitialHelper interstitialHelper = new InterstitialHelper(this);
        sHelperMap.put(str, interstitialHelper);
        return interstitialHelper;
    }
}
