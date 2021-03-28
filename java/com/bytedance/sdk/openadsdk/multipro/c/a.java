package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.b.f;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.multipro.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdEventProviderImpl */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {
    private Context a;

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    private static ContentResolver f() {
        try {
            if (j.a() != null) {
                return j.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c() {
        if (j.a() != null) {
            try {
                ContentResolver f = f();
                if (f != null) {
                    f.getType(Uri.parse(g() + "adEventStart"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver f = f();
                if (f != null) {
                    String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                    f.getType(Uri.parse(g() + "adEventDispatch" + "?event=" + a2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str));
                    sb.append(",");
                }
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString());
                String str2 = "?track=" + String.valueOf(a2);
                ContentResolver f = f();
                if (f != null) {
                    f.getType(Uri.parse(g() + "trackUrl" + str2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d() {
        try {
            ContentResolver f = f();
            if (f != null) {
                f.getType(Uri.parse(g() + "trackFailed"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        try {
            ContentResolver f = f();
            if (f != null) {
                f.getType(Uri.parse(g() + "logStatusInit"));
            }
        } catch (Throwable unused) {
        }
    }

    private static String g() {
        return e.b + "/" + "t_event_ad_event" + "/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("adEventStart".equals(str)) {
            l.b("AdEventProviderImpl", "====ad event function will be start====");
            b.a().a();
            return null;
        } else if ("adEventDispatch".equals(str)) {
            com.bytedance.sdk.openadsdk.b.a a2 = com.bytedance.sdk.openadsdk.b.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a2 == null) {
                return null;
            }
            b.a().a(a2);
            return null;
        } else if ("trackUrl".equals(str)) {
            try {
                String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("track")).split(",");
                if (split.length <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (String str2 : split) {
                    String b2 = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                    if (!TextUtils.isEmpty(b2)) {
                        arrayList.add(b2);
                    }
                }
                d.a().a(arrayList);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        } else if ("trackFailed".equals(str)) {
            d.a().a();
            l.b("AdEventProviderImpl", "track failed: ");
            return null;
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
            return null;
        } else if (!"logStatusUpload".equals(str)) {
            return null;
        } else {
            String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (TextUtils.isEmpty(b3)) {
                return null;
            }
            c.a().a(C0009a.b(b3));
            return null;
        }
    }

    /* compiled from: AdEventProviderImpl */
    private static class b {
        private static volatile com.bytedance.sdk.openadsdk.b.b<com.bytedance.sdk.openadsdk.b.a> a;

        static com.bytedance.sdk.openadsdk.b.b<com.bytedance.sdk.openadsdk.b.a> a() {
            if (a == null) {
                synchronized (j.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.b.b<>(new f(j.a()), j.c(), g.b.a(), new g.a() {
                            /* class com.bytedance.sdk.openadsdk.multipro.c.a.b.AnonymousClass1 */

                            @Override // com.bytedance.sdk.openadsdk.b.g.a
                            public boolean a() {
                                return m.a(j.a());
                            }
                        });
                    }
                }
            }
            return a;
        }
    }

    /* compiled from: AdEventProviderImpl */
    private static class d {
        private static volatile com.bytedance.sdk.openadsdk.f.a a;

        public static com.bytedance.sdk.openadsdk.f.a a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.f.a.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.f.b(j.a(), new com.bytedance.sdk.openadsdk.f.g(j.a()));
                    }
                }
            }
            return a;
        }
    }

    /* compiled from: AdEventProviderImpl */
    private static class c {
        private static volatile com.bytedance.sdk.openadsdk.d.b.c a;

        public static com.bytedance.sdk.openadsdk.d.b.c a() {
            if (a == null) {
                synchronized (com.bytedance.sdk.openadsdk.d.b.c.class) {
                    if (a == null) {
                        a = new com.bytedance.sdk.openadsdk.d.b.c();
                    }
                }
            }
            return a;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* compiled from: AdEventProviderImpl */
    private static class C0009a implements com.bytedance.sdk.openadsdk.d.a.a {
        JSONObject a;

        /* access modifiers changed from: private */
        public static C0009a b(String str) {
            return new C0009a(str);
        }

        private C0009a(String str) {
            try {
                this.a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.d.a.a
        public JSONObject a() {
            return this.a;
        }
    }
}
