package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.utils.AuctionSettings;

public class BannerData {
    private String mAppKey;
    private BannerConfigurations mBannerConfigurations;
    private String mUserId;

    BannerData(String str, String str2, BannerConfigurations bannerConfigurations) {
        this.mAppKey = str;
        this.mUserId = str2;
        this.mBannerConfigurations = bannerConfigurations;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isAuctionEnabled() {
        return this.mBannerConfigurations.getBannerAuctionSettings().getNumOfMaxTrials() > 0;
    }

    public long getTimeToWaitBeforeFirstAuctionInMillis() {
        return this.mBannerConfigurations.getBannerAuctionSettings().getTimeToWaitBeforeFirstAuctionMs();
    }

    public int getBannerDelayLoadFailureInSeconds() {
        return this.mBannerConfigurations.getBannerDelayLoadFailure();
    }

    public long getBannerLoadTimeOutInMillis() {
        return this.mBannerConfigurations.getBannerAdaptersSmartLoadTimeout();
    }

    public int getBannerRefreshIntervalInSeconds() {
        return this.mBannerConfigurations.getBannerRefreshInterval();
    }

    public AuctionSettings getAuctionSettings() {
        return this.mBannerConfigurations.getBannerAuctionSettings();
    }

    public BannerConfigurations getBannerConfigurations() {
        return this.mBannerConfigurations;
    }
}
