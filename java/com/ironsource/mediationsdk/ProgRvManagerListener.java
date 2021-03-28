package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface ProgRvManagerListener {
    void onLoadError(ProgRvSmash progRvSmash, String str);

    void onLoadSuccess(ProgRvSmash progRvSmash, String str);

    void onRewardedVideoAdClicked(ProgRvSmash progRvSmash, Placement placement);

    void onRewardedVideoAdClosed(ProgRvSmash progRvSmash);

    void onRewardedVideoAdEnded(ProgRvSmash progRvSmash);

    void onRewardedVideoAdOpened(ProgRvSmash progRvSmash);

    void onRewardedVideoAdRewarded(ProgRvSmash progRvSmash, Placement placement);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, ProgRvSmash progRvSmash);

    void onRewardedVideoAdStarted(ProgRvSmash progRvSmash);
}
