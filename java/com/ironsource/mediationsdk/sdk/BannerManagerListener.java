package com.ironsource.mediationsdk.sdk;

import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface BannerManagerListener {
    void onBannerAdClicked(BannerSmash bannerSmash);

    void onBannerAdLeftApplication(BannerSmash bannerSmash);

    void onBannerAdLoadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash, boolean z);

    void onBannerAdLoaded(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams);

    void onBannerAdReloadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash, boolean z);

    void onBannerAdReloaded(BannerSmash bannerSmash, View view, FrameLayout.LayoutParams layoutParams, boolean z);

    void onBannerAdScreenDismissed(BannerSmash bannerSmash);

    void onBannerAdScreenPresented(BannerSmash bannerSmash);

    void onBannerAdShown(BannerSmash bannerSmash);
}
