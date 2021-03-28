package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.e;

/* compiled from: SPMultiHelper */
public class a {
    private static Context a;

    public static boolean a() {
        if (a != null && j.a() != null) {
            return true;
        }
        l.b("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context) {
        a = context == null ? j.a() : context.getApplicationContext();
    }

    private static Context c() {
        Context context = a;
        return context == null ? j.a() : context;
    }

    private static String d() {
        return e.b + "/" + "t_sp" + "/";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "boolean" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "int" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "long" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        b.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!a()) {
            return str3;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "string" + "/" + str2 + b(str)));
                return (type == null || type.equals("null")) ? str3 : type;
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(String str, String str2, int i) {
        if (!a()) {
            return i;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "int" + "/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Integer.parseInt(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (!a()) {
            return z;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "boolean" + "/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Boolean.parseBoolean(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long a(String str, String str2, long j) {
        if (!a()) {
            return j;
        }
        try {
            ContentResolver b = b();
            if (b != null) {
                String type = b.getType(Uri.parse(d() + "long" + "/" + str2 + b(str)));
                if (type != null) {
                    if (!type.equals("null")) {
                        return Long.parseLong(type);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver b = b();
                if (b != null) {
                    b.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
