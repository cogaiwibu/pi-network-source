package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.e.c;
import com.bytedance.sdk.openadsdk.g.l;

/* compiled from: TTAdManagerImpl */
public class p implements TTAdManager {
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "2.1.5.0";
    }

    /* renamed from: a */
    public p setAppId(String str) {
        g.b().a(str);
        c.a(j.e()).a();
        return this;
    }

    /* renamed from: b */
    public p setName(String str) {
        g.b().b(str);
        return this;
    }

    /* renamed from: a */
    public p setPaid(boolean z) {
        g.b().b(z);
        return this;
    }

    /* renamed from: c */
    public p setKeywords(String str) {
        g.b().c(str);
        return this;
    }

    /* renamed from: d */
    public p setData(String str) {
        g.b().d(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i) {
        g.b().d(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        l.b();
        n.a = true;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        g.b().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        g.b().n();
        return new q(context);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        g.b().d(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCoppa(int i) {
        g.b().a(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGdpr(int i) {
        g.b().b(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getGdpr() {
        return g.b().g();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void showPrivacyProtection() {
        TTDelegateActivity.a();
    }
}
