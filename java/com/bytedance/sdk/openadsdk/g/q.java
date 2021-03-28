package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SPUtils */
public class q {
    private static Map<String, q> a = new HashMap();
    private SharedPreferences b;

    public static q a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        q qVar = a.get(str);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(str, context);
        a.put(str, qVar2);
        return qVar2;
    }

    private q(String str, Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public void a(String str, int i) {
        try {
            this.b.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    public int b(String str, int i) {
        try {
            return this.b.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }
}
