package com.ironsource.sdk.listeners.internals;

public interface DSBannerListener extends DSAdProductListener {
    void onBannerLoadFail(String str, String str2);

    void onBannerLoadSuccess(String str);
}
