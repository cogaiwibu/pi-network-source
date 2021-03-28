package com.bytedance.sdk.openadsdk.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommonPermissionUtils */
public class e {
    private static final Map<String, a> a = Collections.synchronizedMap(new HashMap());
    private static IListenerManager b;

    /* compiled from: CommonPermissionUtils */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b.b()) {
                new Thread(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.g.e.AnonymousClass1 */

                    public void run() {
                        try {
                            l.b("MultiProcess", "handleYes-1，key=" + str);
                            e.b().broadcastPermissionListener(str, null);
                        } catch (Throwable unused) {
                        }
                    }
                }).start();
                return;
            }
            a b2 = b(str);
            if (b2 != null) {
                b2.a();
            }
        }
    }

    public static void a(final String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (b.b()) {
                new Thread(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.g.e.AnonymousClass2 */

                    public void run() {
                        try {
                            l.b("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                            e.b().broadcastPermissionListener(str, str2);
                        } catch (Throwable unused) {
                        }
                    }
                }).start();
                return;
            }
            a b2 = b(str);
            if (b2 != null) {
                b2.a(str2);
            }
        }
    }

    private static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    /* access modifiers changed from: private */
    public static IListenerManager b() {
        if (b == null) {
            b = c.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.a()).a(3));
        }
        return b;
    }
}
