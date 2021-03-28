package com.anythink.reactnativejs;

import com.anythink.reactnativejs.rewardvide.RewardVideoHelper;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;

public class ATRewardedVideoRNSDKModule extends AnythinkReactContextBaseJavaModule {
    public static final String TAG = "ATRewardedVideoRNSDK";
    private static final HashMap<String, RewardVideoHelper> sHelperMap = new HashMap<>();

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    public ATRewardedVideoRNSDKModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadAd(String str, String str2) {
        RewardVideoHelper helper = getHelper(str);
        if (helper != null) {
            helper.loadRewardedVideo(str, str2);
        }
    }

    @ReactMethod
    public void showAd(String str) {
        showAdInScenario(str, "");
    }

    @ReactMethod
    public void showAdInScenario(String str, String str2) {
        RewardVideoHelper helper = getHelper(str);
        if (helper != null) {
            helper.showVideo(str2);
        }
    }

    @ReactMethod
    public void hasAdReady(String str, Promise promise) {
        RewardVideoHelper helper = getHelper(str);
        if (helper != null) {
            promise.resolve(Boolean.valueOf(helper.isAdReady()));
            return;
        }
        MsgTools.pirntMsg("RewardVideoHelper = null");
        promise.resolve(false);
    }

    @ReactMethod
    public void checkAdStatus(String str, Promise promise) {
        RewardVideoHelper helper = getHelper(str);
        if (helper != null) {
            promise.resolve(helper.checkAdStatus());
            return;
        }
        MsgTools.pirntMsg("RewardVideoHelper = null");
        promise.resolve("");
    }

    private RewardVideoHelper getHelper(String str) {
        if (sHelperMap.containsKey(str)) {
            return sHelperMap.get(str);
        }
        RewardVideoHelper rewardVideoHelper = new RewardVideoHelper(this);
        sHelperMap.put(str, rewardVideoHelper);
        return rewardVideoHelper;
    }
}
