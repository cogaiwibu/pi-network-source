package com.bytedance.sdk.openadsdk.g;

import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: RomUtils */
public class p {
    public static boolean a = false;
    public static boolean b = false;
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";
    private static ExecutorService f = Executors.newSingleThreadExecutor();

    public static String a() {
        if (e()) {
            return l();
        }
        if (b()) {
            return o();
        }
        if (p()) {
            return q();
        }
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (g()) {
            return f();
        }
        if (h()) {
            return i();
        }
        if (d()) {
            return c();
        }
        String j = j();
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return Build.DISPLAY;
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    a = true;
                    b = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            b = true;
        }
        return a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (!k()) {
            return "";
        }
        return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (!e()) {
            return "";
        }
        return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static String o() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean p() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String q() {
        if (!p()) {
            return "";
        }
        return "coloros_" + d("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static boolean r() {
        try {
            if ((TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) && (TextUtils.isEmpty(Build.MANUFACTURER) || !Build.MANUFACTURER.toLowerCase().startsWith("huawei"))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || r();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b A[SYNTHETIC, Splitter:B:16:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.g.p.c(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "RomUtils#getSystemPropertyTask throw exception:"
            java.lang.String r2 = "RomUtils"
            com.bytedance.sdk.openadsdk.g.p$a r3 = new com.bytedance.sdk.openadsdk.g.p$a     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            r3.<init>(r6)     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            java.util.concurrent.FutureTask r6 = new java.util.concurrent.FutureTask     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            r6.<init>(r3)     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            java.util.concurrent.ExecutorService r3 = com.bytedance.sdk.openadsdk.g.p.f     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            r3.execute(r6)     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            r3 = 1
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            java.lang.Object r6 = r6.get(r3, r5)     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ InterruptedException -> 0x002a, ExecutionException -> 0x0025, TimeoutException -> 0x0020 }
            goto L_0x002f
        L_0x0020:
            r6 = move-exception
            com.bytedance.sdk.openadsdk.g.l.b(r2, r1, r6)
            goto L_0x002e
        L_0x0025:
            r6 = move-exception
            com.bytedance.sdk.openadsdk.g.l.b(r2, r1, r6)
            goto L_0x002e
        L_0x002a:
            r6 = move-exception
            com.bytedance.sdk.openadsdk.g.l.b(r2, r1, r6)
        L_0x002e:
            r6 = r0
        L_0x002f:
            if (r6 != 0) goto L_0x0032
            return r0
        L_0x0032:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.g.p.d(java.lang.String):java.lang.String");
    }

    /* compiled from: RomUtils */
    public static class a implements Callable<String> {
        private String a;

        public a(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c = p.c(this.a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            l.b("RomUtils", "property:" + c + ",getSystemProperty use time :" + currentTimeMillis2);
            return c;
        }
    }
}
