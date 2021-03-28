package com.anythink.reactnativejs.utils;

public class Const {
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BANNER_AD_SIZE = "banner_ad_size";
    public static final String BANNER_POSITION_BOTTOM = "bottom";
    public static final String BANNER_POSITION_TOP = "top";
    public static final boolean DEBUG = true;
    public static final String HEIGHT = "height";
    public static final String SCENARIO = "Scenario";
    public static final String TEXT_COLOR = "textColor";
    public static final String TEXT_SIZE = "textSize";
    public static final String USER_DATA = "media_ext";
    public static final String USER_ID = "userID";
    public static final String WIDTH = "width";
    public static final String X = "x";
    public static final String Y = "y";
    public static final String adLogo = "adLogo";
    public static final String cta = "cta";
    public static final String desc = "desc";
    public static final String icon = "icon";
    public static final String mainImage = "mainImage";
    public static final String parent = "parent";
    public static final String title = "title";

    public static class Banner {
        public static final String AdaptiveOrientation = "adaptive_orientation";
        public static final String AdaptiveType = "adaptive_type";
        public static final String AdaptiveWidth = "adaptive_width";
        public static final String InlineAdaptiveOrientation = "inline_adaptive_orientation";
        public static final String InlineAdaptiveWidth = "inline_adaptive_width";
    }

    public static class BannerCallback {
        public static final String ClickCallbackKey = "ATBannerClick";
        public static final String CloseCallbackKey = "ATBannerCloseButtonTapped";
        public static final String LoadFailCallbackKey = "ATBannerLoadFail";
        public static final String LoadedCallbackKey = "ATBannerLoaded";
        public static final String RefreshCallbackKey = "ATBannerRefresh";
        public static final String RefreshFailCallbackKey = "ATBannerRefreshFail";
        public static final String ShowCallbackKey = "ATBannerShow";
    }

    public static class CallbackKey {
        public static final String AdInfo = "adCallbackInfo";
        public static final String ErrorMsg = "errorMsg";
        public static final String PlacementId = "placementId";
    }

    public static class Interstital {
        public static final String UseRewardedVideoAsInterstitial = "UseRewardedVideoAsInterstitial";
    }

    public static class InterstitialCallback {
        public static final String ClickCallbackKey = "ATInterstitialClick";
        public static final String CloseCallbackKey = "ATInterstitialClose";
        public static final String LoadFailCallbackKey = "ATInterstitialLoadFail";
        public static final String LoadedCallbackKey = "ATInterstitialLoaded";
        public static final String PlayEndCallbackKey = "ATInterstitialPlayEnd";
        public static final String PlayFailCallbackKey = "ATInterstitialPlayFail";
        public static final String PlayStartCallbackKey = "ATInterstitialPlayStart";
        public static final String ShowCallbackKey = "ATInterstitialAdShow";
    }

    public static class NativeCallback {
        public static final String ClickCallbackKey = "NativeClick";
        public static final String CloseCallbackKey = "NativeCloseButtonTapped";
        public static final String LoadFailCallbackKey = "NativeLoadFail";
        public static final String LoadedCallbackKey = "NativeLoaded";
        public static final String ShowCallbackKey = "NativeShow";
        public static final String VideoEndKey = "NativeVideoEnd";
        public static final String VideoProgressKey = "NativeVideoProgress";
        public static final String VideoStartKey = "NativeVideoStart";
    }

    public static class RewardVideoCallback {
        public static final String ClickCallbackKey = "ATRewardedVideoClick";
        public static final String CloseCallbackKey = "ATRewardedVideoClose";
        public static final String LoadFailCallbackKey = "ATRewardedVideoLoadFail";
        public static final String LoadedCallbackKey = "ATRewardedVideoLoaded";
        public static final String PlayEndCallbackKey = "ATRewardedVideoPlayEnd";
        public static final String PlayFailCallbackKey = "ATRewardedVideoPlayFail";
        public static final String PlayStartCallbackKey = "ATRewardedVideoPlayStart";
        public static final String RewardCallbackKey = "ATRewardedVideoReward";
    }
}
