package com.bytedance.sdk.openadsdk;

public interface TTFeedAd extends TTNativeAd {

    public interface VideoAdListener {
        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i, int i2);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    void setVideoAdListener(VideoAdListener videoAdListener);
}
