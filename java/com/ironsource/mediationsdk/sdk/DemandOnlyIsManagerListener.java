package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.DemandOnlyIsSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface DemandOnlyIsManagerListener {
    void onInterstitialAdClicked(DemandOnlyIsSmash demandOnlyIsSmash);

    void onInterstitialAdClosed(DemandOnlyIsSmash demandOnlyIsSmash);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError, DemandOnlyIsSmash demandOnlyIsSmash, long j);

    void onInterstitialAdOpened(DemandOnlyIsSmash demandOnlyIsSmash);

    void onInterstitialAdReady(DemandOnlyIsSmash demandOnlyIsSmash, long j);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError, DemandOnlyIsSmash demandOnlyIsSmash);

    void onInterstitialAdVisible(DemandOnlyIsSmash demandOnlyIsSmash);
}
