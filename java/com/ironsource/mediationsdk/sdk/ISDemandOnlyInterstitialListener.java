package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface ISDemandOnlyInterstitialListener {
    void onInterstitialAdClicked(String str);

    void onInterstitialAdClosed(String str);

    void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError);

    void onInterstitialAdOpened(String str);

    void onInterstitialAdReady(String str);

    void onInterstitialAdShowFailed(String str, IronSourceError ironSourceError);
}
