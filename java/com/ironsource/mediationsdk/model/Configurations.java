package com.ironsource.mediationsdk.model;

public class Configurations {
    private ApplicationConfigurations mApplicationConfig;
    private BannerConfigurations mBannerConfig;
    private InterstitialConfigurations mInterstitialConfig;
    private OfferwallConfigurations mOfferwallConfig;
    private RewardedVideoConfigurations mRewardedVideoConfig;

    public Configurations() {
    }

    public Configurations(RewardedVideoConfigurations rewardedVideoConfigurations, InterstitialConfigurations interstitialConfigurations, OfferwallConfigurations offerwallConfigurations, BannerConfigurations bannerConfigurations, ApplicationConfigurations applicationConfigurations) {
        if (rewardedVideoConfigurations != null) {
            this.mRewardedVideoConfig = rewardedVideoConfigurations;
        }
        if (interstitialConfigurations != null) {
            this.mInterstitialConfig = interstitialConfigurations;
        }
        if (offerwallConfigurations != null) {
            this.mOfferwallConfig = offerwallConfigurations;
        }
        if (bannerConfigurations != null) {
            this.mBannerConfig = bannerConfigurations;
        }
        this.mApplicationConfig = applicationConfigurations;
    }

    public ApplicationConfigurations getApplicationConfigurations() {
        return this.mApplicationConfig;
    }

    public RewardedVideoConfigurations getRewardedVideoConfigurations() {
        return this.mRewardedVideoConfig;
    }

    public InterstitialConfigurations getInterstitialConfigurations() {
        return this.mInterstitialConfig;
    }

    public OfferwallConfigurations getOfferwallConfigurations() {
        return this.mOfferwallConfig;
    }

    public BannerConfigurations getBannerConfigurations() {
        return this.mBannerConfig;
    }
}
