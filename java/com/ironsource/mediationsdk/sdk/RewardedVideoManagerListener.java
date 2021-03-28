package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.RewardedVideoSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface RewardedVideoManagerListener {
    void onRewardedVideoAdClicked(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdClosed(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdEnded(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdOpened(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdRewarded(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdStarted(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAdVisible(RewardedVideoSmash rewardedVideoSmash);

    void onRewardedVideoAvailabilityChanged(boolean z, RewardedVideoSmash rewardedVideoSmash);
}
