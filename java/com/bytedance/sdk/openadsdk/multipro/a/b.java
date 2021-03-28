package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.a;

/* compiled from: DBMultiProviderImpl */
public class b implements a {
    private static final Object b = new Object();
    private Context a;

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            l.b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        Context context = this.a;
        return context == null ? j.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        l.b("DBMultiProviderImpl", "query: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null) {
                if (split.length >= 4) {
                    String str3 = split[2];
                    String str4 = split[3];
                    if (!"ttopensdk.db".equals(str3)) {
                        return null;
                    }
                    return e.a(c()).a().a(str4, strArr, str, strArr2, null, null, str2);
                }
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        l.b("DBMultiProviderImpl", "getType: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null) {
                if (split.length >= 5) {
                    String str = split[2];
                    String str2 = split[3];
                    String str3 = split[4];
                    if ("ttopensdk.db".equals(str)) {
                        if ("execSQL".equals(str3)) {
                            e.a(c()).a().a(uri.getQueryParameter("sql"));
                        } else if ("transactionBegin".equals(str3)) {
                            e.a(c()).a().a();
                        } else if ("transactionSetSuccess".equals(str3)) {
                            e.a(c()).a().b();
                        } else if ("transactionEnd".equals(str3)) {
                            e.a(c()).a().c();
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        l.b("DBMultiProviderImpl", "insert: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null) {
                if (split.length >= 4) {
                    String str = split[2];
                    String str2 = split[3];
                    if ("ttopensdk.db".equals(str)) {
                        e.a(c()).a().a(str2, (String) null, contentValues);
                    }
                    return null;
                }
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        l.b("DBMultiProviderImpl", "delete: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split("/");
            if (split != null) {
                if (split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return e.a(c()).a().a(str3, str, strArr);
                }
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        l.b("DBMultiProviderImpl", "update: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split("/");
            if (split != null) {
                if (split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return e.a(c()).a().a(str3, contentValues, str, strArr);
                }
            }
            return 0;
        }
    }
}
