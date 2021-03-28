package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import com.ironsource.sdk.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String CAMPAIGN_ID = Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID;
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = Constants.FeaturesManager.DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private Map<String, String> mOfferwallCustomParams;
    ProviderSettings mProviderSettings = new ProviderSettings(ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings("Mediation"));
    private Map<String, String> mRewardedVideoCustomParams;

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    private SupersonicConfig() {
    }

    public void setClientSideCallbacks(boolean z) {
        this.mProviderSettings.setRewardedVideoSettings("useClientSideCallbacks", String.valueOf(z));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.setRewardedVideoSettings("controllerUrl", str);
        this.mProviderSettings.setInterstitialSettings("controllerUrl", str);
        this.mProviderSettings.setBannerSettings("controllerUrl", str);
    }

    public void setDebugMode(int i) {
        this.mProviderSettings.setRewardedVideoSettings(Constants.FeaturesManager.DEBUG_MODE, Integer.valueOf(i));
        this.mProviderSettings.setInterstitialSettings(Constants.FeaturesManager.DEBUG_MODE, Integer.valueOf(i));
        this.mProviderSettings.setBannerSettings(Constants.FeaturesManager.DEBUG_MODE, Integer.valueOf(i));
    }

    public void setCampaignId(String str) {
        this.mProviderSettings.setRewardedVideoSettings(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, str);
    }

    public void setLanguage(String str) {
        this.mProviderSettings.setRewardedVideoSettings("language", str);
        this.mProviderSettings.setInterstitialSettings("language", str);
    }

    public void setRewardedVideoCustomParams(Map<String, String> map) {
        this.mRewardedVideoCustomParams = convertCustomParams(map);
    }

    public void setOfferwallCustomParams(Map<String, String> map) {
        this.mOfferwallCustomParams = convertCustomParams(map);
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                Set<String> keySet = map.keySet();
                if (keySet != null) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                hashMap.put("custom_" + str, str2);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e);
            }
        }
        return hashMap;
    }

    public boolean getClientSideCallbacks() {
        ProviderSettings providerSettings = this.mProviderSettings;
        if (providerSettings == null || providerSettings.getRewardedVideoSettings() == null || !this.mProviderSettings.getRewardedVideoSettings().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.getRewardedVideoSettings().optBoolean("useClientSideCallbacks", false);
    }

    public Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }
}
