package com.bytedance.sdk.openadsdk.core.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.f;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.r;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.tapjoy.TapjoyConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SdkSettingsHelper */
public class c implements Runnable {
    private static final AtomicLong d = new AtomicLong(0);
    private static volatile c e;
    private static boolean f = true;
    private final b a;
    private final Context b;
    private final Executor c;

    public static c a(b bVar) {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c(bVar);
                }
            }
        }
        return e;
    }

    private c(b bVar) {
        this.a = bVar == null ? j.e() : bVar;
        this.b = j.a();
        this.c = Executors.newSingleThreadExecutor();
        if (b.b()) {
            try {
                this.b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: SdkSettingsHelper */
    private class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("b_msg_id", -1);
                if (intExtra == 1) {
                    long longExtra = intent.getLongExtra("b_msg_time", -1);
                    if (longExtra > 0) {
                        c.d.set(longExtra);
                    }
                } else if (intExtra == 2) {
                    String stringExtra = intent.getStringExtra("b_msg_data");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        try {
                            JSONObject jSONObject = new JSONObject(stringExtra);
                            if (c.this.a != null) {
                                c.this.a.a(jSONObject);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str) && j.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                intent.putExtra("b_msg_data", str);
                j.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(long j) {
        if (j > 0 && j.a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                j.a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public void a() {
        try {
            if (!c()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d.get() >= 600000) {
                    d.set(currentTimeMillis);
                    if (b.b()) {
                        a(currentTimeMillis);
                    }
                    this.c.execute(this);
                }
            }
        } catch (Throwable th) {
            l.a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean c() {
        return TextUtils.isEmpty(g.b().d());
    }

    public void run() {
        if (!m.a(this.b)) {
            this.a.a();
        } else if (!c()) {
            new f(1, t.g("/api/ad/union/sdk/settings/"), c(d()), new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.e.c.AnonymousClass1 */

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v9, types: [org.json.JSONObject] */
                /* JADX WARN: Type inference failed for: r0v13, types: [org.json.JSONObject] */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
                /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Unknown variable types count: 2 */
                @Override // com.bytedance.sdk.adnet.core.m.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.adnet.core.m<org.json.JSONObject> r6) {
                    /*
                    // Method dump skipped, instructions count: 154
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.e.c.AnonymousClass1.a(com.bytedance.sdk.adnet.core.m):void");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(com.bytedance.sdk.adnet.core.m<JSONObject> mVar) {
                    c.this.a.a();
                }
            }).build(com.bytedance.sdk.openadsdk.e.b.a(this.b).c());
        }
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            int g = g.b().g();
            l.b("setting", "Settings().isGdprUser =" + j.e().b());
            int b2 = j.e().b();
            int i = 1;
            if (b2 != -1) {
                if (b2 == 0) {
                    a(jSONObject);
                } else if (b2 == 1) {
                    if (g == 0) {
                        b(jSONObject);
                    }
                }
            } else if (g == 0 || g == -1) {
                a(jSONObject);
            }
            jSONObject.put("gdrp", g);
            jSONObject.put("coppa", g.b().f());
            jSONObject.put("MCC", r.b());
            jSONObject.put("conn_type", com.bytedance.sdk.openadsdk.g.m.c(this.b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", "2.1.5.0");
            jSONObject.put("language", h.b());
            jSONObject.put("time_zone", t.m());
            jSONObject.put("package_name", t.f());
            boolean c2 = t.c(this.b, t.f());
            l.c("isApplicationForeground", "isApplicationForeground:" + c2);
            if (!c2) {
                i = 2;
            }
            jSONObject.put("position", i);
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, t.h());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(TapjoyConstants.TJC_ANDROID_ID, h.c(this.b));
            jSONObject.put("uuid", h.d(this.b));
            if (!(g.b() == null || g.b().d() == null)) {
                jSONObject.put("app_id", g.b().d());
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (!(g.b() == null || g.b().d() == null)) {
                str = g.b().d().concat(String.valueOf(currentTimeMillis)).concat("2.1.5.0");
            }
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.g.g.a(str));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject) throws JSONException {
        if (g.b() != null && g.b().h() != 1) {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.g.f.a(true));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", t.j());
            jSONObject.put("gaid", com.com.bytedance.overseas.sdk.a.a.a().c());
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        jSONObject.put("ip", com.bytedance.sdk.openadsdk.g.f.a(true));
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("device_city", t.j());
        jSONObject.put("gaid", com.com.bytedance.overseas.sdk.a.a.a().c());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.put("message", r9.toString());
        r2.put("cypher", 0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject c(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "cypher"
            java.lang.String r1 = "message"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            if (r9 != 0) goto L_0x000c
            return r2
        L_0x000c:
            r3 = 0
            boolean r4 = com.bytedance.sdk.openadsdk.core.e.c.f     // Catch:{ Exception -> 0x004c }
            if (r4 == 0) goto L_0x0058
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.a.a()     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.a(r4)     // Catch:{ Exception -> 0x004c }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.a(r6, r5)     // Catch:{ Exception -> 0x004c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c }
            r6.<init>()     // Catch:{ Exception -> 0x004c }
            r7 = 2
            r6.append(r7)     // Catch:{ Exception -> 0x004c }
            r6.append(r4)     // Catch:{ Exception -> 0x004c }
            r6.append(r5)     // Catch:{ Exception -> 0x004c }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x004c }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x004c }
            if (r5 != 0) goto L_0x0041
            r2.put(r1, r4)     // Catch:{ Exception -> 0x004c }
            r2.put(r0, r7)     // Catch:{ Exception -> 0x004c }
            goto L_0x0058
        L_0x0041:
            java.lang.String r4 = r9.toString()     // Catch:{ Exception -> 0x004c }
            r2.put(r1, r4)     // Catch:{ Exception -> 0x004c }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x004c }
            goto L_0x0058
        L_0x004c:
            java.lang.String r4 = r9.toString()     // Catch:{ Exception -> 0x0057 }
            r2.put(r1, r4)     // Catch:{ Exception -> 0x0057 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0058
        L_0x0057:
        L_0x0058:
            boolean r0 = com.bytedance.sdk.openadsdk.core.e.c.f
            if (r0 == 0) goto L_0x005d
            r9 = r2
        L_0x005d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.e.c.c(org.json.JSONObject):org.json.JSONObject");
    }
}
