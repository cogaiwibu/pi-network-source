package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.InterstitialSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface InterstitialManagerListener {
    void onInterstitialAdClicked(InterstitialSmash interstitialSmash);

    void onInterstitialAdClosed(InterstitialSmash interstitialSmash);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash, long j);

    void onInterstitialAdOpened(InterstitialSmash interstitialSmash);

    void onInterstitialAdReady(InterstitialSmash interstitialSmash, long j);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash);

    void onInterstitialAdShowSucceeded(InterstitialSmash interstitialSmash);

    void onInterstitialAdVisible(InterstitialSmash interstitialSmash);

    void onInterstitialInitFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash);

    void onInterstitialInitSuccess(InterstitialSmash interstitialSmash);
}
