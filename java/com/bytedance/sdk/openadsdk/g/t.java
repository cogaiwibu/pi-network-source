package com.bytedance.sdk.openadsdk.g;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ToolUtils */
public class t {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static HashSet<String> f = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    public static String a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        if (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        String str = b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (l.a()) {
                        l.b("Process", "processName = " + runningAppProcessInfo.processName);
                    }
                    String str2 = runningAppProcessInfo.processName;
                    b = str2;
                    return str2;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String o = o();
        b = o;
        return o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[SYNTHETIC, Splitter:B:20:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String o() {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.g.t.o():java.lang.String");
    }

    public static boolean c(Context context, String str) {
        return g.b() != null && !g.b().c();
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static JSONObject a(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.c.g gVar) {
        return gVar != null && b(gVar.u()) == 9;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.c.g gVar) {
        return gVar != null && b(gVar.u()) == 7;
    }

    public static int b(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            return a2.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int c(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            return a2.optInt("rit", 0);
        }
        return 0;
    }

    public static long d(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            return a2.optLong("uid", 0);
        }
        return 0;
    }

    public static int e(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            return a2.optInt("ut", 0);
        }
        return 0;
    }

    public static double f(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            return a2.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static String c(com.bytedance.sdk.openadsdk.core.c.g gVar) {
        if (gVar == null || gVar.s() == null || TextUtils.isEmpty(gVar.s().a())) {
            return null;
        }
        return gVar.s().a();
    }

    public static String a() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            String substring2 = str.substring(i);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String b() {
        String str;
        String str2 = "unKnow";
        try {
            if (b.b()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "android_system_ua", str2);
            } else {
                str = d.a(j.a()).b("android_system_ua", str2);
            }
            if (str != null && !str2.equals(str)) {
                return str;
            }
            FutureTask futureTask = new FutureTask(new a(2));
            a.execute(futureTask);
            str2 = (String) futureTask.get(500, TimeUnit.MILLISECONDS);
            l.e("getUA", " getAndroidSystemUA userAgent" + str2);
            return str2;
        } catch (Exception unused) {
        }
    }

    public static String c() {
        String str;
        String str2 = "unKnow";
        try {
            if (b.b()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "webview_ua", str2);
            } else {
                str = d.a(j.a()).b("webview_ua", str2);
            }
            if (str == null || str2.equals(str)) {
                FutureTask futureTask = new FutureTask(new a(1));
                a.execute(futureTask);
                str2 = (String) futureTask.get(1000, TimeUnit.MILLISECONDS);
                l.b("getUA", "webview ua：" + str2);
                return str2;
            }
            l.b("getUA", "getWebViewUA5555---userAgent:" + str);
            return str;
        } catch (Exception e2) {
            l.e("getUA", "ee:" + e2.toString());
        }
    }

    /* access modifiers changed from: private */
    public static String p() {
        try {
            String userAgentString = new WebView(j.a()).getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    d.a(j.a()).a("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            l.e("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    /* compiled from: ToolUtils */
    public static class a implements Callable<String> {
        int a = 1;

        a(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public synchronized String call() throws Exception {
            String str;
            str = "unKnow";
            if (this.a == 1) {
                str = c();
            }
            if (this.a == 2) {
                str = b();
            }
            return str;
        }

        private String b() {
            String str;
            Throwable th;
            try {
                str = System.getProperty("http.agent");
                if (str != null) {
                    try {
                        if (!"unKnow".equals(str)) {
                            if (b.b()) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "android_system_ua", str);
                            } else {
                                d.a(j.a()).a("android_system_ua", str);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        l.e("getUA", "e:" + th.getMessage());
                        return str;
                    }
                }
            } catch (Throwable th3) {
                str = "unKnow";
                th = th3;
                l.e("getUA", "e:" + th.getMessage());
                return str;
            }
            return str;
        }

        private synchronized String c() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.g.t.a.AnonymousClass1 */

                public void run() {
                    strArr[0] = t.p();
                    l.b("getUA", "webview ua：" + strArr[0]);
                }
            });
            while ("unKnow".equals(strArr[0])) {
            }
            return strArr[0];
        }
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    public static String e() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return g.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized String f() {
        String str;
        synchronized (t.class) {
            if (TextUtils.isEmpty(c) && j.a() != null) {
                try {
                    c = j.a().getPackageName();
                } catch (Throwable th) {
                    l.b("ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
            str = c;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (t.class) {
            if (TextUtils.isEmpty(d) && j.a() != null) {
                try {
                    PackageInfo packageInfo = j.a().getPackageManager().getPackageInfo(f(), 0);
                    d = String.valueOf(packageInfo.versionCode);
                    e = packageInfo.versionName;
                } catch (Throwable th) {
                    l.b("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = d;
        }
        return str;
    }

    public static synchronized String h() {
        String str;
        synchronized (t.class) {
            if (TextUtils.isEmpty(e) && j.a() != null) {
                try {
                    PackageInfo packageInfo = j.a().getPackageManager().getPackageInfo(f(), 0);
                    d = String.valueOf(packageInfo.versionCode);
                    e = packageInfo.versionName;
                } catch (Throwable th) {
                    l.b("ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = e;
        }
        return str;
    }

    public static String b(Context context) {
        String b2 = d.a(context).b("total_memory", (String) null);
        if (b2 != null) {
            return b2;
        }
        String e2 = e(context, "MemTotal");
        d.a(context).a("total_memory", e2);
        return e2;
    }

    public static String e(Context context, String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.contains(str));
            bufferedReader.close();
            if (readLine == null) {
                return null;
            }
            String[] split = readLine.split("\\s+");
            l.b("ToolUtils", "getTotalMemory = " + split[1]);
            return split[1];
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String g(String str) {
        String str2;
        StringBuilder sb;
        String g = j.e().g();
        if (TextUtils.isEmpty(g)) {
            if (i()) {
                sb = new StringBuilder();
                sb.append("https://");
                str2 = "pangolin16.sgsnssdk.com";
            } else {
                sb = new StringBuilder();
                sb.append("https://");
                str2 = "is.snssdk.com";
            }
            sb.append(str2);
            sb.append(str);
            return sb.toString();
        }
        return "https://" + g + str;
    }

    public static boolean i() {
        return !k();
    }

    public static String j() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            l.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static boolean k() {
        try {
            return f.contains(TimeZone.getDefault().getID());
        } catch (Exception e2) {
            l.e("ToolUtils", e2.toString());
            return false;
        }
    }

    public static int l() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String m() {
        int i = -l();
        if (i >= 0) {
            return "Etc/GMT+" + i;
        }
        return "Etc/GMT" + i;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.c.g gVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", gVar.r());
        hashMap.put("load_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.c.j e2 = gVar.e();
        if (e2 != null) {
            hashMap.put("video_size", Long.valueOf(e2.c()));
            hashMap.put("video_resolution", e2.e());
        }
        if (!z) {
            hashMap.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
        }
        return hashMap;
    }

    public static Map<String, Object> a(long j, com.bytedance.sdk.openadsdk.core.c.g gVar, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (gVar != null) {
            if (!TextUtils.isEmpty(gVar.r())) {
                hashMap.put("creative_id", gVar.r());
            }
            com.bytedance.sdk.openadsdk.core.c.j e2 = gVar.e();
            if (e2 != null) {
                hashMap.put("video_resolution", e2.e());
                hashMap.put("video_size", Long.valueOf(e2.c()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.c.g gVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", gVar.r());
        hashMap.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.core.c.j e2 = gVar.e();
        if (e2 != null) {
            hashMap.put("video_size", Long.valueOf(e2.c()));
            hashMap.put("video_resolution", e2.e());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.c.g gVar, long j, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", gVar.r());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.c.j e2 = gVar.e();
        if (e2 != null) {
            hashMap.put("video_size", Long.valueOf(e2.c()));
            hashMap.put("video_resolution", e2.e());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        if (!map.containsKey("video_resolution") && dVar != null) {
            try {
                if (dVar.a() != null) {
                    int videoWidth = dVar.a().getVideoWidth();
                    int videoHeight = dVar.a().getVideoHeight();
                    map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(videoWidth), Integer.valueOf(videoHeight)));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.put("message", r8.toString());
        r2.put("cypher", 0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(org.json.JSONObject r8) {
        /*
            java.lang.String r0 = "cypher"
            java.lang.String r1 = "message"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            if (r8 != 0) goto L_0x000c
            return r2
        L_0x000c:
            r3 = 0
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.a.a()     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.a(r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.core.a.a(r6, r5)     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r6.<init>()     // Catch:{ all -> 0x0048 }
            r7 = 2
            r6.append(r7)     // Catch:{ all -> 0x0048 }
            r6.append(r4)     // Catch:{ all -> 0x0048 }
            r6.append(r5)     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0048 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x003d
            r2.put(r1, r4)     // Catch:{ all -> 0x0048 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0052
        L_0x003d:
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0048 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0048 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0048 }
            goto L_0x0052
        L_0x0048:
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0052 }
            r2.put(r1, r8)     // Catch:{ all -> 0x0052 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0052 }
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.g.t.a(org.json.JSONObject):org.json.JSONObject");
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), i(str.substring(1, 17)));
    }

    private static String i(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str != null) {
            return a2;
        }
        String a3 = com.bytedance.sdk.openadsdk.core.b.a();
        return a3.concat(a3).substring(8, 24);
    }
}
