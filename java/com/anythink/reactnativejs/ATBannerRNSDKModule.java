package com.anythink.reactnativejs;

import com.anythink.reactnativejs.banner.BannerHelper;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;

public class ATBannerRNSDKModule extends AnythinkReactContextBaseJavaModule {
    public final String TAG = "ATBannerRNSDK";
    private final HashMap<String, BannerHelper> sHelperMap = new HashMap<>();

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ATBannerRNSDK";
    }

    public ATBannerRNSDKModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadAd(String str, String str2) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.loadBanner(str, str2);
        }
    }

    @ReactMethod
    public void showAdInRectangle(String str, String str2) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.showBannerWithRect(str2);
        }
    }

    @ReactMethod
    public void showAdInPosition(String str, String str2) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.showBannerWithPosition(str2);
        }
    }

    @ReactMethod
    public void hideAd(String str) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.hideBanner();
        }
    }

    @ReactMethod
    public void reShowAd(String str) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.reshowBanner();
        }
    }

    @ReactMethod
    public void removeAd(String str) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            helper.removeBanner();
        }
    }

    @ReactMethod
    public void hasAdReady(String str, Promise promise) {
        BannerHelper helper = getHelper(str);
        if (helper != null) {
            promise.resolve(Boolean.valueOf(helper.isAdReady()));
            return;
        }
        MsgTools.pirntMsg("BannerHelper = null");
        promise.resolve(false);
    }

    private BannerHelper getHelper(String str) {
        if (this.sHelperMap.containsKey(str)) {
            return this.sHelperMap.get(str);
        }
        BannerHelper bannerHelper = new BannerHelper(this);
        this.sHelperMap.put(str, bannerHelper);
        return bannerHelper;
    }
}
