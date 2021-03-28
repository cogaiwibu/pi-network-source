package com.ironsource.sdk.listeners;

public interface OnBannerListener extends OnAdProductListener {
    void onBannerClick();

    void onBannerInitFailed(String str);

    void onBannerInitSuccess();

    void onBannerLoadFail(String str);

    void onBannerLoadSuccess();
}
