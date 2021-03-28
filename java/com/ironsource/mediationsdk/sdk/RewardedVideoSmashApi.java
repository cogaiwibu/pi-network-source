package com.ironsource.mediationsdk.sdk;

public interface RewardedVideoSmashApi {
    void fetchRewardedVideo();

    void initRewardedVideo(String str, String str2);

    boolean isRewardedVideoAvailable();

    void setRewardedVideoManagerListener(RewardedVideoManagerListener rewardedVideoManagerListener);

    void showRewardedVideo();
}
