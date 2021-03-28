package com.ironsource.sdk;

import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceAdInstanceBuilder {
    private Map<String, String> mExtraParams;
    private boolean mInAppBidding = false;
    private OnInterstitialListener mInterstitialListener;
    private String mName;
    private boolean mRewarded = false;

    public IronSourceAdInstanceBuilder(String str, OnInterstitialListener onInterstitialListener) throws NullPointerException {
        this.mName = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.mInterstitialListener = (OnInterstitialListener) SDKUtils.requireNonNull(onInterstitialListener, "InterstitialListener name can't be null");
    }

    public IronSourceAdInstanceBuilder setRewarded() {
        this.mRewarded = true;
        return this;
    }

    public IronSourceAdInstanceBuilder setInAppBidding() {
        this.mInAppBidding = true;
        return this;
    }

    public IronSourceAdInstanceBuilder setExtraParams(Map<String, String> map) {
        this.mExtraParams = map;
        return this;
    }

    public IronSourceAdInstance build() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            jSONObject.put("rewarded", this.mRewarded);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new IronSourceAdInstance(this.mInAppBidding ? IronSourceNetworkAPIUtils.generateInstanceUniqueId() : IronSourceNetworkAPIUtils.generateInstanceId(jSONObject), this.mName, this.mRewarded, this.mInAppBidding, this.mExtraParams, this.mInterstitialListener);
    }
}
