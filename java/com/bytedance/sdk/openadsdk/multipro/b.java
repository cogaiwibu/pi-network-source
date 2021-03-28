package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: MultiGlobalInfo */
public class b {
    public static boolean a;
    public static boolean b;

    public static void a() {
        a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        a = true;
        b = true;
    }

    public static boolean b() {
        if (!b) {
            a = a.a("sp_multi_info", "is_support_multi_process", false);
            b = true;
        }
        return a;
    }
}
