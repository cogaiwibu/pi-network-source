package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.DemandOnlyRvSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface DemandOnlyRvManagerListener {
    void onRewardedVideoAdClicked(DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoAdClosed(DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError, DemandOnlyRvSmash demandOnlyRvSmash, long j);

    void onRewardedVideoAdOpened(DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoAdRewarded(DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoAdVisible(DemandOnlyRvSmash demandOnlyRvSmash);

    void onRewardedVideoLoadSuccess(DemandOnlyRvSmash demandOnlyRvSmash, long j);
}
