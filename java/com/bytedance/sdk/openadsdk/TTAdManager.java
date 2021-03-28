package com.bytedance.sdk.openadsdk;

import android.content.Context;

public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    int getGdpr();

    String getSDKVersion();

    @Deprecated
    TTAdManager isUseTextureView(boolean z);

    @Deprecated
    TTAdManager openDebugMode();

    void requestPermissionIfNecessary(Context context);

    @Deprecated
    TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z);

    @Deprecated
    TTAdManager setAppId(String str);

    @Deprecated
    TTAdManager setCoppa(int i);

    @Deprecated
    TTAdManager setData(String str);

    @Deprecated
    TTAdManager setGdpr(int i);

    @Deprecated
    TTAdManager setKeywords(String str);

    @Deprecated
    TTAdManager setName(String str);

    @Deprecated
    TTAdManager setPaid(boolean z);

    @Deprecated
    TTAdManager setTitleBarTheme(int i);

    void showPrivacyProtection();
}
