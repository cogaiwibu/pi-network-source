package com.bytedance.sdk.openadsdk.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommonDialogHelper */
public class d {
    private static final Map<String, a> a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* compiled from: CommonDialogHelper */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(String str) {
        a(str, 1);
    }

    public static void b(String str) {
        a(str, 2);
    }

    public static void c(String str) {
        a(str, 3);
    }

    public static a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    private static void a(final String str, final int i) {
        if (!TextUtils.isEmpty(str)) {
            if (b.b()) {
                new Thread(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.g.d.AnonymousClass1 */

                    public void run() {
                        try {
                            d.b().broadcastDialogListener(str, i);
                        } catch (Throwable unused) {
                        }
                    }
                }).start();
                return;
            }
            a d = d(str);
            if (d != null) {
                if (i == 1) {
                    d.a();
                } else if (i == 2) {
                    d.b();
                } else if (i != 3) {
                    d.c();
                } else {
                    d.c();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.a()).a(2));
        }
        return b;
    }
}
