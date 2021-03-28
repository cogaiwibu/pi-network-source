package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface ProgIsManagerListener {
    void onInterstitialAdClicked(ProgIsSmash progIsSmash);

    void onInterstitialAdClosed(ProgIsSmash progIsSmash);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError, ProgIsSmash progIsSmash, long j);

    void onInterstitialAdOpened(ProgIsSmash progIsSmash);

    void onInterstitialAdReady(ProgIsSmash progIsSmash, long j);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError, ProgIsSmash progIsSmash);

    void onInterstitialAdShowSucceeded(ProgIsSmash progIsSmash);

    void onInterstitialAdVisible(ProgIsSmash progIsSmash);

    void onInterstitialInitFailed(IronSourceError ironSourceError, ProgIsSmash progIsSmash);

    void onInterstitialInitSuccess(ProgIsSmash progIsSmash);
}
