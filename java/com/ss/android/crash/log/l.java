package com.ss.android.crash.log;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashUtils */
public class l {
    private static String a;
    private static Set<String> b = new HashSet();
    private static Set<String> c = new HashSet();

    /* access modifiers changed from: package-private */
    /* compiled from: CrashUtils */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int d;

        private a(int i) {
            this.d = i;
        }
    }

    static boolean a(Context context) {
        String b2 = b(context);
        if ((b2 == null || !b2.contains(":")) && b2 != null && b2.equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    static String b(Context context) {
        String str = a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str2 = runningAppProcessInfo.processName;
                    a = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String a2 = a();
        a = a2;
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0046 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0046 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r4.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x0046 }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0046 }
            r4.append(r5)     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0046 }
            r3.<init>(r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0046 }
            r1.<init>(r2)     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
        L_0x0031:
            int r3 = r1.read()     // Catch:{ all -> 0x0044 }
            if (r3 <= 0) goto L_0x003c
            char r3 = (char) r3     // Catch:{ all -> 0x0044 }
            r2.append(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0031
        L_0x003c:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0044 }
            r1.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            return r0
        L_0x0044:
            goto L_0x0047
        L_0x0046:
            r1 = r0
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.l.a():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String c(android.content.Context r3) throws java.lang.NullPointerException {
        /*
            if (r3 == 0) goto L_0x0049
            r0 = 0
            java.io.File r1 = r3.getCacheDir()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0013
            java.io.File r3 = r3.getCacheDir()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0039 }
        L_0x0011:
            r0 = r3
            goto L_0x003a
        L_0x0013:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "/data/data/"
            r1.append(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = r3.getPackageName()     // Catch:{ all -> 0x0039 }
            r1.append(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "/cache/"
            r1.append(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0039 }
            r2 = 0
            java.io.File r3 = r3.getDir(r1, r2)     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x003a
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0039 }
            goto L_0x0011
        L_0x0039:
        L_0x003a:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0041
            return r0
        L_0x0041:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Cannot Create Cache Dir"
            r3.<init>(r0)
            throw r3
        L_0x0049:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Context is NUll"
            r3.<init>(r0)
            goto L_0x0052
        L_0x0051:
            throw r3
        L_0x0052:
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.l.c(android.content.Context):java.lang.String");
    }

    static void a(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (context != null) {
                try {
                    context = context.getApplicationContext();
                } catch (Throwable unused) {
                    return;
                }
            }
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dalvikPrivateDirty", memoryInfo.dalvikPrivateDirty);
            jSONObject2.put("dalvikPss", memoryInfo.dalvikPss);
            jSONObject2.put("dalvikSharedDirty", memoryInfo.dalvikSharedDirty);
            jSONObject2.put("nativePrivateDirty", memoryInfo.nativePrivateDirty);
            jSONObject2.put("nativePss", memoryInfo.nativePss);
            jSONObject2.put("nativeSharedDirty", memoryInfo.nativeSharedDirty);
            jSONObject2.put("otherPrivateDirty", memoryInfo.otherPrivateDirty);
            jSONObject2.put("otherPss", memoryInfo.otherPss);
            jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
            jSONObject2.put("totalPrivateClean", m.a(memoryInfo));
            jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
            jSONObject2.put("totalPss", memoryInfo.getTotalPss());
            jSONObject2.put("totalSharedClean", m.b(memoryInfo));
            jSONObject2.put("totalSharedDirty", memoryInfo.getTotalSharedDirty());
            jSONObject2.put("totalSwappablePss", m.c(memoryInfo));
            jSONObject.put("memory_info", jSONObject2);
            ActivityManager activityManager = null;
            if (context != null) {
                JSONObject jSONObject3 = new JSONObject();
                ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
                ActivityManager activityManager2 = (ActivityManager) context.getSystemService("activity");
                activityManager2.getMemoryInfo(memoryInfo2);
                jSONObject3.put("availMem", memoryInfo2.availMem);
                jSONObject3.put("lowMemory", memoryInfo2.lowMemory);
                jSONObject3.put("threshold", memoryInfo2.threshold);
                jSONObject3.put("totalMem", o.a(memoryInfo2));
                jSONObject.put("sys_memory_info", jSONObject3);
                activityManager = activityManager2;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("native_heap_size", Debug.getNativeHeapSize());
            jSONObject4.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
            jSONObject4.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
            Runtime runtime = Runtime.getRuntime();
            jSONObject4.put("max_memory", runtime.maxMemory());
            jSONObject4.put("free_memory", runtime.freeMemory());
            jSONObject4.put("total_memory", runtime.totalMemory());
            if (activityManager != null) {
                jSONObject4.put("memory_class", activityManager.getMemoryClass());
                jSONObject4.put("large_memory_class", a(activityManager));
            }
            jSONObject.put("app_memory_info", jSONObject4);
        }
    }

    static int a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return activityManager.getLargeMemoryClass();
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    static boolean a(long j, String str, byte[] bArr, a aVar, String str2) throws Throwable {
        if (str == null) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str3 = null;
        if (a.GZIP == aVar && length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                str3 = "gzip";
            } catch (Throwable unused) {
                gZIPOutputStream.close();
                return false;
            }
        } else if (a.DEFLATER == aVar && length > 128) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(8192);
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[8192];
            while (!deflater.finished()) {
                byteArrayOutputStream2.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            bArr = byteArrayOutputStream2.toByteArray();
            str3 = "deflate";
        }
        return a(str, bArr, str2, str3, NativeEventsConstants.HTTP_METHOD_POST, true);
    }

    static boolean a(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (z) {
                httpURLConnection.setDoOutput(true);
            } else {
                httpURLConnection.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection.setRequestProperty(Events.CONTENT_TYPE, str2);
            }
            if (str3 != null) {
                httpURLConnection.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (str4 != null) {
                httpURLConnection.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                if (httpURLConnection.getResponseCode() == 200) {
                    if (httpURLConnection.getContentEncoding().equalsIgnoreCase("gzip")) {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                        a((InputStream) gZIPInputStream);
                        gZIPInputStream.close();
                    } else {
                        a(inputStream);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return true;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return false;
            }
            throw new IllegalArgumentException("request method is not null");
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean a(String str, Map map) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, b("http://log.snssdk.com/service/2/app_log_exception/", map), str.getBytes(), a.GZIP, "application/json; charset=utf-8");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String b(String str, Map map) {
        if (!TextUtils.isDigitsOnly(str) && map != null) {
            if (str.indexOf("?") < 0) {
                str = str + "?";
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        str = str.endsWith("?") ? str + a(entry.getKey().toString(), "UTF-8") + Constants.RequestParameters.EQUAL + a(map.get(entry.getKey()).toString(), "UTF-8") : str + Constants.RequestParameters.AMPERSAND + a(entry.getKey().toString(), "UTF-8") + Constants.RequestParameters.EQUAL + a(map.get(entry.getKey()).toString(), "UTF-8");
                    }
                }
            }
        }
        return str;
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static JSONObject a(Context context, Thread thread, Throwable th) {
        if (th == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                context = context.getApplicationContext();
            } catch (Throwable unused) {
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        Throwable cause = th.getCause();
        if (cause != null) {
            cause.printStackTrace(printWriter);
            Throwable cause2 = cause.getCause();
            if (cause2 != null) {
                cause2.printStackTrace(printWriter);
            }
        }
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        if (stringWriter2 == null) {
            return jSONObject;
        }
        jSONObject.put("data", stringWriter2);
        jSONObject.put("crash_time", System.currentTimeMillis());
        String str = "";
        if (context != null) {
            str = b(context);
            jSONObject.put("process_name", str);
            if (!a(context)) {
                jSONObject.put("remote_process", 1);
            }
        }
        if (context != null) {
            a(context, jSONObject);
        }
        if (a(th) || a(str, th)) {
            if (str != null && str.endsWith(":ad")) {
                jSONObject.put("data_files", d(context));
            }
            jSONObject.put("all_thread_stacks", b());
        }
        return jSONObject;
    }

    private static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return a(context.getFilesDir()).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static JSONArray a(File file) {
        JSONArray jSONArray = new JSONArray();
        if (file != null && file.exists()) {
            if (file.isFile()) {
                jSONArray.put(file.getName());
                return jSONArray;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return jSONArray;
            }
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    jSONArray.put(file2.getName());
                } else if (file2.isDirectory()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(file2.getName(), a(file2));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    private static boolean a(String str, Throwable th) {
        if (str != null && str.endsWith(":ad")) {
            int i = 0;
            while (th != null) {
                try {
                    if (th instanceof NullPointerException) {
                        return true;
                    }
                    if (i > 20) {
                        return false;
                    }
                    i++;
                    th = th.getCause();
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    private static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    static {
        b.add("ThreadPlus");
        b.add("ApiDispatcher");
        b.add("ApiLocalDispatcher");
        b.add("AsyncLoader");
        b.add("AsyncTask");
        b.add("Binder");
        b.add("PackageProcessor");
        b.add("SettingsObserver");
        b.add("WifiManager");
        b.add("JavaBridge");
        b.add("Compiler");
        b.add("Signal Catcher");
        b.add("GC");
        b.add("ReferenceQueueDaemon");
        b.add("FinalizerDaemon");
        b.add("FinalizerWatchdogDaemon");
        b.add("CookieSyncManager");
        b.add("RefQueueWorker");
        b.add("CleanupReference");
        b.add("VideoManager");
        b.add("DBHelper-AsyncOp");
        b.add("InstalledAppTracker2");
        b.add("AppData-AsyncOp");
        b.add("IdleConnectionMonitor");
        b.add("LogReaper");
        b.add("ActionReaper");
        b.add("Okio Watchdog");
        b.add("CheckWaitingQueue");
        c.add("com.facebook.imagepipeline.core.PriorityThreadFactory");
        c.add("com.ss.android.common.util.SimpleThreadFactory");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[Catch:{ all -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[Catch:{ all -> 0x00fe }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b() {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.l.b():java.lang.String");
    }
}
