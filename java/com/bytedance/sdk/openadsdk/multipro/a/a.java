package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.multipro.e;

/* compiled from: DBMultiAdapter */
public class a {
    private static ContentResolver a(Context context) {
        if (context == null) {
            try {
                context = j.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String a() {
        return e.b + "/" + "t_db" + "/" + "ttopensdk.db" + "/";
    }

    public static synchronized void a(Context context, String str, ContentValues contentValues) {
        synchronized (a.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        ContentResolver a = a(context);
                        if (a != null) {
                            a.insert(Uri.parse(a() + str), contentValues);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static synchronized int a(Context context, String str, String str2, String[] strArr) {
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                ContentResolver a = a(context);
                if (a != null) {
                    return a.delete(Uri.parse(a() + str), str2, strArr);
                }
            } catch (Throwable unused) {
            }
            return 0;
        }
    }

    public static synchronized int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        synchronized (a.class) {
            if (contentValues != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        ContentResolver a = a(context);
                        if (a != null) {
                            return a.update(Uri.parse(a() + str), contentValues, str2, strArr);
                        }
                    } catch (Throwable unused) {
                    }
                    return 0;
                }
            }
            return 0;
        }
    }

    public static synchronized Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                ContentResolver a = a(context);
                if (a != null) {
                    return a.query(Uri.parse(a() + str), strArr, str2, strArr2, str5);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    ContentResolver a = a(context);
                    if (a != null) {
                        a.getType(Uri.parse(a() + "unknown" + "/" + "execSQL" + "?sql=" + str));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
