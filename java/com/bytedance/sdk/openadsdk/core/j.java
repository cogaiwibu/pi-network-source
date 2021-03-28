package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.b.a;
import com.bytedance.sdk.openadsdk.b.b;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.b.f;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.e.d;
import com.bytedance.sdk.openadsdk.f.g;
import com.bytedance.sdk.openadsdk.g.m;

/* compiled from: InternalContainer */
public class j {
    private static volatile b<a> a;
    private static volatile k<a> b;
    private static volatile com.bytedance.sdk.openadsdk.f.a c;
    private static volatile com.bytedance.sdk.openadsdk.d.b.a d;
    private static volatile Context e;
    private static volatile d f;

    public static Context a() {
        return e;
    }

    public static synchronized void a(Context context) {
        synchronized (j.class) {
            if (e == null && context != null) {
                e = context.getApplicationContext();
            }
        }
    }

    public static b<a> b() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        a = new c();
                    } else {
                        a = new b<>(new f(e), c(), g(), b(e));
                    }
                }
            }
        }
        return a;
    }

    public static k<a> c() {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new l(e);
                }
            }
        }
        return b;
    }

    public static com.bytedance.sdk.openadsdk.f.a d() {
        if (c == null) {
            synchronized (com.bytedance.sdk.openadsdk.f.a.class) {
                if (c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        c = new com.bytedance.sdk.openadsdk.f.c();
                    } else {
                        c = new com.bytedance.sdk.openadsdk.f.b(e, new g(e));
                    }
                }
            }
        }
        return c;
    }

    private static g.b g() {
        return g.b.a();
    }

    private static g.a b(final Context context) {
        return new g.a() {
            /* class com.bytedance.sdk.openadsdk.core.j.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.b.g.a
            public boolean a() {
                return m.a(context);
            }
        };
    }

    public static d e() {
        if (f == null) {
            synchronized (d.class) {
                if (f == null) {
                    f = new d();
                    f.a();
                }
            }
        }
        return f;
    }

    public static com.bytedance.sdk.openadsdk.d.b.a f() {
        if (d == null) {
            synchronized (com.bytedance.sdk.openadsdk.d.b.c.class) {
                if (d == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        d = new com.bytedance.sdk.openadsdk.d.b.d();
                    } else {
                        d = new com.bytedance.sdk.openadsdk.d.b.c();
                    }
                }
            }
        }
        return d;
    }
}
