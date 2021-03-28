package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.e.b;
import com.bytedance.sdk.openadsdk.g.n;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TTAdSdk {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        n.a(context, "Context is null, please check.");
        n.a(tTAdConfig, "TTAdConfig is null, please check.");
        if (!a.get()) {
            a(context, tTAdConfig);
            a.set(true);
        }
        return getAdManager();
    }

    public static TTAdManager getAdManager() {
        return TTAdManagerFactory.a();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            b.a(tTAdConfig.getHttpStack());
        }
        TTAdManager instance = TTAdManagerFactory.getInstance(context, tTAdConfig.isSupportMultiProcess());
        if (tTAdConfig.isDebug()) {
            instance.openDebugMode();
        }
        instance.setAppId(tTAdConfig.getAppId()).setCoppa(tTAdConfig.getCoppa()).setGdpr(tTAdConfig.getGDPR()).setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).isUseTextureView(tTAdConfig.isUseTextureView());
    }
}
