package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: AdPreference */
public class d {
    private static volatile d a;
    private final SharedPreferences b;

    private d(Context context) {
        this.b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        if (b.b()) {
            a.a("ttopenadsdk", str, str2);
        } else {
            this.b.edit().putString(str, str2).apply();
        }
    }

    public String b(String str, String str2) {
        if (b.b()) {
            return a.b("ttopenadsdk", str, str2);
        }
        return this.b.getString(str, str2);
    }

    public void a(String str, int i) {
        if (b.b()) {
            a.a("ttopenadsdk", str, Integer.valueOf(i));
        } else {
            this.b.edit().putInt(str, i).apply();
        }
    }

    public int b(String str, int i) {
        if (b.b()) {
            return a.a("ttopenadsdk", str, i);
        }
        return this.b.getInt(str, i);
    }

    public void a(String str, boolean z) {
        if (b.b()) {
            a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.b.edit().putBoolean(str, z).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (b.b()) {
            return a.a("ttopenadsdk", str, z);
        }
        return this.b.getBoolean(str, z);
    }
}
