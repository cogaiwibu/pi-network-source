package com.ss.android.crash.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.crash.log.j;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashUploadManager */
public class k {
    private static final Object f = new Object();
    private static final FilenameFilter g = new FilenameFilter() {
        /* class com.ss.android.crash.log.k.AnonymousClass1 */

        public boolean accept(File file, String str) {
            return str != null && str.startsWith("ss_native_crash-");
        }
    };
    private volatile Context a;
    private j.a b;
    private SharedPreferences c;
    private volatile String d;
    private volatile boolean e;
    private String h = null;

    k(Context context, j.a aVar) {
        if (aVar == null || context == null) {
            throw new IllegalArgumentException("context and ICommonParams must not be null");
        }
        this.b = aVar;
        this.a = context.getApplicationContext();
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("app_crash_copy", 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.getString("header", null);
        c();
    }

    public void a() {
        if (!this.e && this.b.a() != null && this.b.a().containsKey("device_id")) {
            Map<String, Object> a2 = this.b.a();
            JSONObject jSONObject = new JSONObject();
            for (String str : a2.keySet()) {
                try {
                    jSONObject.put(str, a2.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.c.edit().putString("header", jSONObject.toString()).apply();
            this.e = true;
        }
    }

    private void c() {
        p.a().a(new Runnable() {
            /* class com.ss.android.crash.log.k.AnonymousClass2 */

            public void run() {
                try {
                    k.this.d();
                    k.this.e();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() throws IOException {
        String b2;
        File file = new File(l.c(this.a), "tt_crash_log_dir");
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            Arrays.sort(listFiles, Collections.reverseOrder());
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = listFiles[i];
                if (i < 5) {
                    try {
                        synchronized (f) {
                            b2 = n.b(file2.getAbsolutePath());
                        }
                        l.a(b2, this.b.a());
                    } catch (Exception unused) {
                        continue;
                    }
                }
                file2.delete();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r7 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ExcHandler: all (unused java.lang.Throwable), SYNTHETIC, Splitter:B:25:0x0069] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
        // Method dump skipped, instructions count: 323
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.k.e():void");
    }

    public void a(final JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                Map<String, Object> a2 = this.b.a();
                for (String str : a2.keySet()) {
                    jSONObject2.put(str, a2.get(str));
                }
                jSONObject.put("header", jSONObject2);
                final String a3 = a(jSONObject.toString(), String.valueOf(System.currentTimeMillis()));
                p.a().a(new Runnable() {
                    /* class com.ss.android.crash.log.k.AnonymousClass3 */

                    public void run() {
                        if (l.a(jSONObject.toString(), k.this.b.a())) {
                            synchronized (k.f) {
                                n.a(a3);
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    private String a(String str, String str2) throws IOException {
        String absolutePath;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (f) {
            File file = new File(l.c(this.a), "tt_crash_log_dir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            n.a(file2, str);
            absolutePath = file2.getAbsolutePath();
        }
        return absolutePath;
    }
}
