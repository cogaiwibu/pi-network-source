package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.core.e.c;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.p;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.com.bytedance.overseas.sdk.a.a;
import com.facebook.internal.NativeProtocol;
import com.ironsource.sdk.constants.Constants;
import com.ss.android.crash.log.h;
import com.ss.android.crash.log.j;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InitHelper */
public class i {
    private static AtomicBoolean a = new AtomicBoolean(false);

    public static void a(Context context) {
        if (!a.get()) {
            synchronized (TTAdManagerFactory.class) {
                if (!a.get()) {
                    b(context);
                    a.set(true);
                }
            }
        }
    }

    private static void b(Context context) {
        j.a(context.getApplicationContext());
        c();
        u.a(context);
        c(context);
        j.b().a();
        j.f().a();
        d(context);
        d.a(context);
        b();
        a();
        if (!TextUtils.isEmpty(h.a(context))) {
            j.d().a();
        }
    }

    private static void a() {
        t.b();
        t.c();
    }

    private static void b() {
        a.a().d();
    }

    private static void c() {
        c.a(j.e()).a();
    }

    private static void c(Context context) {
        d.a(context).a("uuid", UUID.randomUUID().toString());
    }

    private static void d(final Context context) {
        j.a((Application) context.getApplicationContext()).a(new j.a() {
            /* class com.bytedance.sdk.openadsdk.core.i.AnonymousClass1 */

            @Override // com.ss.android.crash.log.j.a
            public Map<String, Object> a() {
                HashMap hashMap = new HashMap();
                String a2 = h.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("device_id", a2);
                }
                hashMap.put("ac", m.f(context));
                hashMap.put("aid", 1181);
                hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, "openadsdk");
                hashMap.put("version_code", 2150);
                hashMap.put("update_version_code", 2150);
                hashMap.put("version_name", "2.1.5.0");
                hashMap.put("device_platform", "android");
                hashMap.put("os", Constants.JAVASCRIPT_INTERFACE_NAME);
                hashMap.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, Build.MODEL);
                hashMap.put("device_mode", Build.MODEL);
                hashMap.put("rom", p.a());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", h.c(context));
                hashMap.put("dpi", String.valueOf(u.e(context)));
                hashMap.put("resolution", u.b(context) + "*" + u.c(context));
                return hashMap;
            }
        }, true, false, false);
        h.a(new h.a() {
            /* class com.bytedance.sdk.openadsdk.core.i.AnonymousClass2 */

            @Override // com.ss.android.crash.log.h.a
            public boolean a(Throwable th) {
                String name = AdSlot.class.getPackage().getName();
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (stackTraceElement.getClassName().contains(name)) {
                        return false;
                    }
                }
                return true;
            }
        });
    }
}
