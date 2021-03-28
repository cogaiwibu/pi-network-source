package com.ironsource.sdk.listeners.internals;

public interface DSRewardedVideoListener extends DSAdProductListener {
    void onRVAdCredited(String str, int i);

    void onRVNoMoreOffers(String str);

    void onRVShowFail(String str, String str2);
}
