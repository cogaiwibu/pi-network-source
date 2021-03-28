package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface LWSRvManagerListener {
    void onLoadError(LWSProgRvSmash lWSProgRvSmash);

    void onLoadSuccess(LWSProgRvSmash lWSProgRvSmash);

    void onRewardedVideoAdClicked(LWSProgRvSmash lWSProgRvSmash, Placement placement);

    void onRewardedVideoAdClosed(LWSProgRvSmash lWSProgRvSmash);

    void onRewardedVideoAdEnded(LWSProgRvSmash lWSProgRvSmash);

    void onRewardedVideoAdOpened(LWSProgRvSmash lWSProgRvSmash);

    void onRewardedVideoAdRewarded(LWSProgRvSmash lWSProgRvSmash, Placement placement);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, LWSProgRvSmash lWSProgRvSmash);

    void onRewardedVideoAdStarted(LWSProgRvSmash lWSProgRvSmash);
}
