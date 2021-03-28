package com.bytedance.sdk.openadsdk.g;

import android.util.Log;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: Logger */
public class l {
    static int a = a.a("sp_multi_info", "debug_level", 4);
    private static boolean b = true;
    private static boolean c = a.a("sp_multi_info", "is_debug", false);

    static {
        if (b.b() && !b) {
        }
    }

    public static void a(int i) {
        a = i;
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void b() {
        c = true;
        a(3);
        if (b.b()) {
            b = true;
            a.a("sp_multi_info", "is_debug", Boolean.valueOf(c));
            a.a("sp_multi_info", "debug_level", (Integer) 3);
        }
    }

    public static boolean c() {
        return c;
    }

    public static void a(String str, String str2) {
        if (c() && str2 != null && a <= 2) {
            Log.v(str, str2);
        }
    }

    public static void a(String str) {
        if (c()) {
            b("Logger", str);
        }
    }

    public static void b(String str, String str2) {
        if (c() && str2 != null && a <= 3) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && a <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void c(String str, String str2) {
        if (c() && str2 != null && a <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (c() && str2 != null && a <= 5) {
            Log.w(str, str2);
        }
    }

    public static void b(String str) {
        if (c()) {
            e("Logger", str);
        }
    }

    public static void e(String str, String str2) {
        if (c() && str2 != null && a <= 6) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && a <= 6) {
                Log.e(str, str2, th);
            }
        }
    }
}
