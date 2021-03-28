package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SPMultiHelperImpl */
class b {
    private static SoftReference<Map<String, Map<String, Object>>> a;

    private static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(a(str), 0);
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object a(String str, String str2) {
        Map<String, Map<String, Object>> map;
        Map<String, Object> map2;
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference == null || (map = softReference.get()) == null || (map2 = map.get(a(str))) == null) {
            return null;
        }
        return map2.get(str2);
    }

    private static void a(String str, String str2, Object obj) {
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null) {
            a = new SoftReference<>(new HashMap());
        }
        String a2 = a(str);
        Map<String, Map<String, Object>> map = a.get();
        if (map.get(a2) == null) {
            map.put(a2, new HashMap());
        }
        map.get(a2).put(str2, obj);
    }

    private static void b(String str) {
        Map<String, Object> map;
        SoftReference<Map<String, Map<String, Object>>> softReference = a;
        if (softReference != null && softReference.get() != null && (map = a.get().get(a(str))) != null) {
            map.clear();
        }
    }

    static synchronized <T> void a(Context context, String str, String str2, T t) {
        synchronized (b.class) {
            SharedPreferences c = c(context, str);
            if (c != null) {
                if (!t.equals(a(str, str2))) {
                    SharedPreferences.Editor edit = c.edit();
                    if (t instanceof Boolean) {
                        edit.putBoolean(str2, t.booleanValue());
                    }
                    if (t instanceof String) {
                        edit.putString(str2, t);
                    }
                    if (t instanceof Integer) {
                        edit.putInt(str2, t.intValue());
                    }
                    if (t instanceof Long) {
                        edit.putLong(str2, t.longValue());
                    }
                    if (t instanceof Float) {
                        edit.putFloat(str2, t.floatValue());
                    }
                    edit.apply();
                    a(str, str2, t);
                }
            }
        }
    }

    static String a(Context context, String str, String str2, String str3) {
        Object a2 = a(str, str2);
        if (a2 != null) {
            return a2 + "";
        }
        Object b = b(context, str, str2, str3);
        a(str, str2, b);
        return b + "";
    }

    private static Object b(Context context, String str, String str2, String str3) {
        String a2 = a(str);
        if (!a(context, a2, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return c(context, a2, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(a(context, a2, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(a(context, a2, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(a(context, a2, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(a(context, a2, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return c(context, a2, str2, null);
        }
        return null;
    }

    private static String c(Context context, String str, String str2, String str3) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return str3;
        }
        return c.getString(str2, str3);
    }

    private static int a(Context context, String str, String str2, int i) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return i;
        }
        return c.getInt(str2, i);
    }

    private static float a(Context context, String str, String str2, float f) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return f;
        }
        return c.getFloat(str2, f);
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return z;
        }
        return c.getBoolean(str2, z);
    }

    private static long a(Context context, String str, String str2, long j) {
        SharedPreferences c = c(context, str);
        if (c == null) {
            return j;
        }
        return c.getLong(str2, j);
    }

    static boolean a(Context context, String str, String str2) {
        SharedPreferences c = c(context, str);
        return c != null && c.contains(str2);
    }

    static void b(Context context, String str, String str2) {
        SharedPreferences c = c(context, str);
        if (c != null) {
            SharedPreferences.Editor edit = c.edit();
            edit.remove(str2);
            edit.apply();
        }
    }

    static void a(Context context, String str) {
        SharedPreferences.Editor edit = c(context, str).edit();
        edit.clear();
        edit.apply();
        b(str);
    }

    static Map<String, ?> b(Context context, String str) {
        return c(context, str).getAll();
    }
}
