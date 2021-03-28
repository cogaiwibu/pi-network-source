package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;

public class ProviderOrder {
    private ArrayList<String> mBannerProviderOrder = new ArrayList<>();
    private String mISBackFillProvider;
    private String mISPremiumProvider;
    private ArrayList<String> mInterstitialProviderOrder = new ArrayList<>();
    private String mRVBackFillProvider;
    private String mRVPremiumProvider;
    private ArrayList<String> mRewardedVideoProviderOrder = new ArrayList<>();

    public ArrayList<String> getRewardedVideoProviderOrder() {
        return this.mRewardedVideoProviderOrder;
    }

    public ArrayList<String> getInterstitialProviderOrder() {
        return this.mInterstitialProviderOrder;
    }

    public ArrayList<String> getBannerProviderOrder() {
        return this.mBannerProviderOrder;
    }

    public void addRewardedVideoProvider(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRewardedVideoProviderOrder.add(str);
        }
    }

    public void addInterstitialProvider(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mInterstitialProviderOrder.add(str);
        }
    }

    public void addBannerProvider(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mBannerProviderOrder.add(str);
        }
    }

    public String getRVBackFillProvider() {
        return this.mRVBackFillProvider;
    }

    public void setRVBackFillProvider(String str) {
        this.mRVBackFillProvider = str;
    }

    public String getRVPremiumProvider() {
        return this.mRVPremiumProvider;
    }

    public void setRVPremiumProvider(String str) {
        this.mRVPremiumProvider = str;
    }

    public String getISBackFillProvider() {
        return this.mISBackFillProvider;
    }

    public void setISBackFillProvider(String str) {
        this.mISBackFillProvider = str;
    }

    public String getISPremiumProvider() {
        return this.mISPremiumProvider;
    }

    public void setISPremiumProvider(String str) {
        this.mISPremiumProvider = str;
    }
}
