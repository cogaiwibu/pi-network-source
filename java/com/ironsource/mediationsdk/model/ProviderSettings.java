package com.ironsource.mediationsdk.model;

import org.json.JSONException;
import org.json.JSONObject;

public class ProviderSettings {
    private String mAdSourceNameForEvents;
    private JSONObject mApplicationSettings;
    private JSONObject mBannerSettings;
    private JSONObject mInterstitialSettings;
    private boolean mIsMultipleInstances;
    private int mProviderBNPriority;
    private int mProviderISPriority;
    private String mProviderInstanceName;
    private String mProviderName;
    private int mProviderRVPriority;
    private String mProviderTypeForReflection;
    private JSONObject mRewardedVideoSettings;
    private String mSubProviderId;

    public ProviderSettings(String str) {
        this.mProviderName = str;
        this.mProviderInstanceName = str;
        this.mProviderTypeForReflection = str;
        this.mRewardedVideoSettings = new JSONObject();
        this.mInterstitialSettings = new JSONObject();
        this.mBannerSettings = new JSONObject();
        this.mApplicationSettings = new JSONObject();
        this.mProviderRVPriority = -1;
        this.mProviderISPriority = -1;
        this.mProviderBNPriority = -1;
    }

    public ProviderSettings(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.mProviderName = str;
        this.mProviderInstanceName = str;
        this.mProviderTypeForReflection = str2;
        this.mRewardedVideoSettings = jSONObject2;
        this.mInterstitialSettings = jSONObject3;
        this.mBannerSettings = jSONObject4;
        this.mApplicationSettings = jSONObject;
        this.mProviderRVPriority = -1;
        this.mProviderISPriority = -1;
        this.mProviderBNPriority = -1;
    }

    public ProviderSettings(ProviderSettings providerSettings) {
        this.mProviderName = providerSettings.getProviderName();
        this.mProviderInstanceName = providerSettings.getProviderName();
        this.mProviderTypeForReflection = providerSettings.getProviderTypeForReflection();
        this.mRewardedVideoSettings = providerSettings.getRewardedVideoSettings();
        this.mInterstitialSettings = providerSettings.getInterstitialSettings();
        this.mBannerSettings = providerSettings.getBannerSettings();
        this.mApplicationSettings = providerSettings.getApplicationSettings();
        this.mProviderRVPriority = providerSettings.getRewardedVideoPriority();
        this.mProviderISPriority = providerSettings.getInterstitialPriority();
        this.mProviderBNPriority = providerSettings.getBannerPriority();
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public JSONObject getRewardedVideoSettings() {
        return this.mRewardedVideoSettings;
    }

    public String getProviderTypeForReflection() {
        return this.mProviderTypeForReflection;
    }

    public void setRewardedVideoSettings(JSONObject jSONObject) {
        this.mRewardedVideoSettings = jSONObject;
    }

    public void setRewardedVideoSettings(String str, Object obj) {
        try {
            this.mRewardedVideoSettings.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getInterstitialSettings() {
        return this.mInterstitialSettings;
    }

    public void setInterstitialSettings(JSONObject jSONObject) {
        this.mInterstitialSettings = jSONObject;
    }

    public void setInterstitialSettings(String str, Object obj) {
        try {
            this.mInterstitialSettings.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getBannerSettings() {
        return this.mBannerSettings;
    }

    public void setBannerSettings(JSONObject jSONObject) {
        this.mBannerSettings = jSONObject;
    }

    public void setBannerSettings(String str, Object obj) {
        try {
            this.mBannerSettings.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setAdSourceNameForEvents(String str) {
        this.mAdSourceNameForEvents = str;
    }

    public String getAdSourceNameForEvents() {
        return this.mAdSourceNameForEvents;
    }

    public void setSubProviderId(String str) {
        this.mSubProviderId = str;
    }

    public String getSubProviderId() {
        return this.mSubProviderId;
    }

    public void setIsMultipleInstances(boolean z) {
        this.mIsMultipleInstances = z;
    }

    public boolean isMultipleInstances() {
        return this.mIsMultipleInstances;
    }

    public String getProviderInstanceName() {
        return this.mProviderInstanceName;
    }

    public JSONObject getApplicationSettings() {
        return this.mApplicationSettings;
    }

    public void setBannerPriority(int i) {
        this.mProviderBNPriority = i;
    }

    public void setInterstitialPriority(int i) {
        this.mProviderISPriority = i;
    }

    public void setRewardedVideoPriority(int i) {
        this.mProviderRVPriority = i;
    }

    public int getBannerPriority() {
        return this.mProviderBNPriority;
    }

    public int getInterstitialPriority() {
        return this.mProviderISPriority;
    }

    public int getRewardedVideoPriority() {
        return this.mProviderRVPriority;
    }
}
