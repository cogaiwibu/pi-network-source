package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
import com.bytedance.sdk.openadsdk.b.j;
import com.bytedance.sdk.openadsdk.core.c.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.com.bytedance.overseas.sdk.download.b;

/* compiled from: WebHelper */
public class u {
    private static boolean a = false;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(Context context, g gVar, int i, c cVar, TTNativeAd tTNativeAd, String str, b bVar) {
        String str2;
        if (!(context == null || gVar == null || i == -1)) {
            d t = gVar.t();
            if (t != null) {
                String a2 = t.a();
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse(t.a());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (t.a(context, intent)) {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        try {
                            context.startActivity(intent);
                        } catch (Throwable th) {
                            l.b("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                        }
                        com.bytedance.sdk.openadsdk.b.d.b(context, gVar, str, "open_url_app");
                        j.a().a(gVar, str);
                        return true;
                    }
                }
                if (t.c() != 2 || gVar.v() == 5 || gVar.v() == 15) {
                    if (t.c() == 1) {
                        a2 = t.b();
                    } else {
                        a2 = gVar.i();
                    }
                } else if (bVar != null) {
                    if (bVar.d()) {
                        com.bytedance.sdk.openadsdk.b.d.b(context, gVar, str, "open_fallback_url");
                        return true;
                    } else if (bVar.c()) {
                        com.bytedance.sdk.openadsdk.b.d.b(context, gVar, str, "open_fallback_url");
                        return true;
                    } else {
                        com.bytedance.sdk.openadsdk.b.d.b(context, gVar, str, "open_fallback_url");
                        return false;
                    }
                }
                com.bytedance.sdk.openadsdk.b.d.b(context, gVar, str, "open_fallback_url");
                str2 = a2;
            } else {
                str2 = gVar.i();
            }
            if (!TextUtils.isEmpty(str2)) {
                if (gVar.g() != 2) {
                    try {
                        context.startActivity(a(context, str2, gVar, i, cVar, tTNativeAd, str));
                    } catch (Throwable th2) {
                        l.b("WebHelper", "openDetailPage() -> context.startActivity(intent) fail2 :", th2);
                    }
                    a = false;
                } else if (!m.a(str2)) {
                    return false;
                } else {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    try {
                        intent2.setData(Uri.parse(str2));
                        if (!(context instanceof Activity)) {
                            intent2.addFlags(268435456);
                        }
                        try {
                            context.startActivity(intent2);
                        } catch (Throwable th3) {
                            l.b("WebHelper", "openDetailPage() -> context.startActivity(intent) fail2 :", th3);
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static Intent a(Context context, String str, g gVar, int i, c cVar, TTNativeAd tTNativeAd, String str2) {
        Intent intent;
        if (tTNativeAd instanceof TTDrawFeedAd) {
            intent = new Intent(context, TTLandingPageActivity.class);
        } else if (gVar.v() != 5 || a) {
            intent = new Intent(context, TTLandingPageActivity.class);
        } else {
            intent = new Intent(context, TTVideoLandingPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("web_title", gVar.o());
        intent.putExtra("sdk_version", 2150);
        intent.putExtra("adid", gVar.r());
        intent.putExtra("log_extra", gVar.u());
        intent.putExtra("icon_url", gVar.h() == null ? null : gVar.h().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, gVar.C().toString());
        } else {
            o.a().h();
            o.a().a(gVar);
        }
        if (gVar.v() == 5) {
            if (cVar != null) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, a.a(cVar).a().toString());
                } else {
                    o.a().a(cVar);
                }
            } else if (!(tTNativeAd == null || tTNativeAd.getAdView() == null)) {
                c nativeVideoController = ((NativeVideoAdView) tTNativeAd.getAdView()).getNativeVideoController();
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    a a2 = a.a(nativeVideoController);
                    l.b("MultiProcess", "WebHelper:" + a2.toString());
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, a2.a().toString());
                } else {
                    o.a().a(nativeVideoController);
                }
            }
            if (!(tTNativeAd == null || tTNativeAd.getAdView() == null)) {
                intent.putExtra("video_is_auto_play", ((NativeVideoAdView) tTNativeAd.getAdView()).c());
            }
        }
        return intent;
    }
}
