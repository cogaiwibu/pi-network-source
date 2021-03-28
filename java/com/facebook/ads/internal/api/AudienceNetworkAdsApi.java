package com.facebook.ads.internal.api;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;

public interface AudienceNetworkAdsApi {
    public static final int BANNER = 1;
    @Deprecated
    public static final int INSTREAM_VIDEO_MOBILE = 3;
    public static final int INTERSTITIAL = 2;
    public static final int NATIVE = 4;
    public static final int NATIVE_BANNER = 5;
    public static final int REWARDED_VIDEO = 6;
    public static final int UNKNOWN = 0;

    int getAdFormatForPlacement(String str);

    void initialize(Context context, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener);

    boolean isInitialized();

    void onContentProviderCreated(Context context);
}
