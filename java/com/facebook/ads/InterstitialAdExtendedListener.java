package com.facebook.ads;

public interface InterstitialAdExtendedListener extends InterstitialAdListener, RewardedAdListener {
    void onInterstitialActivityDestroyed();
}
