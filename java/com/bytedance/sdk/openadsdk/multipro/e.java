package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.j;

/* compiled from: TTPathConst */
public class e {
    public static String a = "com.bytedance.openadsdk";
    public static String b = ("content://" + a + ".TTMultiProvider");

    static {
        a();
    }

    public static void a() {
        if (j.a() != null) {
            a = j.a().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}
