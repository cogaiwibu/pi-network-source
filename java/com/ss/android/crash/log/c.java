package com.ss.android.crash.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.ironsource.sdk.constants.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ANRManager */
public class c {
    private a a;
    private HandlerThread b = null;
    private b c;
    private d d;
    private final Context e;
    private volatile long f;
    private volatile boolean g = false;
    private final SharedPreferences h;

    public c(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.e = applicationContext;
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("anr_monitor_table", 0);
            this.h = sharedPreferences;
            this.f = sharedPreferences.getLong("trace_anr_happen_time", 0);
            return;
        }
        throw new IllegalArgumentException("context is not be null");
    }

    public void a() {
        if (!this.g) {
            HandlerThread handlerThread = new HandlerThread("anr_monitor");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new b(this, this.b.getLooper());
            if (Build.VERSION.SDK_INT < 21) {
                a aVar = new a(this, "/data/anr/", 8);
                this.a = aVar;
                aVar.startWatching();
            } else {
                d dVar = new d(this, 5000);
                this.d = dVar;
                dVar.start();
            }
            this.g = true;
        }
    }

    public void a(int i, String str) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.obtainMessage(i, str).sendToTarget();
        }
    }

    public void b(int i, String str) {
        try {
            if (this.e != null) {
                JSONObject jSONObject = new JSONObject();
                String packageName = this.e.getPackageName();
                if (e.a(this.e, packageName)) {
                    int myPid = Process.myPid();
                    if (TextUtils.isEmpty(packageName)) {
                        return;
                    }
                    if (myPid > 0) {
                        if (i == 200) {
                            jSONObject = a(str, myPid, packageName);
                        } else if (i == 100) {
                            jSONObject = e.a();
                        }
                        if (jSONObject != null && jSONObject.length() > 0) {
                            jSONObject.put("pid", myPid);
                            jSONObject.put("package", packageName);
                            jSONObject.put("is_remote_process", 0);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("data", jSONObject.toString());
                            jSONObject2.put("is_anr", 1);
                            jSONObject2.put("anr_time", System.currentTimeMillis());
                            i.b().a(jSONObject2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject a(String str, int i, String str2) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                char c2 = 0;
                Object[] a2 = a(bufferedReader, compile);
                if (a2 == null) {
                    return null;
                }
                long parseLong = Long.parseLong(a2[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(a2[1].toString().split("\\s")[4] + " " + a2[1].toString().split("\\s")[5]).getTime();
                Object[] a3 = a(bufferedReader, compile3);
                if (a3 == null) {
                    return null;
                }
                String str3 = a3[1].toString().split("\\s")[2];
                if (parseLong == ((long) i)) {
                    if (str3.equalsIgnoreCase(str2)) {
                        if (this.f != 0 && Math.abs(this.f - time) < 20000) {
                            return null;
                        }
                        this.f = time;
                        if (this.h != null) {
                            this.h.edit().putLong("trace_anr_happen_time", this.f).apply();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("anrTime", time);
                        JSONArray jSONArray = new JSONArray();
                        boolean z = false;
                        int i3 = 0;
                        int i4 = 2;
                        while (true) {
                            Pattern[] patternArr = new Pattern[i4];
                            patternArr[c2] = compile2;
                            patternArr[1] = compile4;
                            Object[] a4 = a(bufferedReader, patternArr);
                            if (a4 == null || a4[c2] != compile4) {
                                jSONObject.put("allThreadStack", jSONArray);
                            } else {
                                String str4 = "";
                                Matcher matcher = Pattern.compile("\".+\"").matcher(a4[1].toString());
                                if (matcher.find()) {
                                    str4 = matcher.group().substring(1, matcher.group().length() - 1);
                                }
                                Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(a4[1].toString());
                                if (matcher2.find()) {
                                    String group = matcher2.group();
                                    i2 = Integer.parseInt(group.substring(group.indexOf(Constants.RequestParameters.EQUAL) + 1));
                                } else {
                                    i2 = -1;
                                }
                                String a5 = a(bufferedReader);
                                if (i2 != -1 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(a5)) {
                                    if (str4.equalsIgnoreCase(Constants.ParametersKeys.MAIN)) {
                                        jSONObject.put("mainStackFromTrace", a5);
                                        z = true;
                                    }
                                    i3++;
                                    if (((long) i3) <= 5) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("id", i2);
                                        jSONObject2.put("name", str4);
                                        jSONObject2.put("stack", a5);
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                                i4 = 2;
                                c2 = 0;
                            }
                        }
                        jSONObject.put("allThreadStack", jSONArray);
                        if (!z) {
                            jSONObject.put(Constants.ParametersKeys.MAIN, b());
                        }
                        jSONObject.put("thread_number", i3);
                        return jSONObject;
                    }
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r5.matcher(r1).matches() == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        if (r9.length > 0) goto L_0x0009;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r1 = r8.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r1 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = r9.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r4 >= r2) goto L_0x0009;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r5 = r9[r4];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object[] a(java.io.BufferedReader r8, java.util.regex.Pattern... r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x002c
            if (r9 == 0) goto L_0x002c
            int r1 = r9.length
            if (r1 > 0) goto L_0x0009
            goto L_0x002c
        L_0x0009:
            java.lang.String r1 = r8.readLine()
            if (r1 == 0) goto L_0x002c
            int r2 = r9.length
            r3 = 0
            r4 = 0
        L_0x0012:
            if (r4 >= r2) goto L_0x0009
            r5 = r9[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)
            boolean r6 = r6.matches()
            if (r6 == 0) goto L_0x0029
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r3] = r5
            r9 = 1
            r8[r9] = r1
            return r8
        L_0x0029:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.crash.log.c.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                sb.append(readLine);
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
        }
        return sb.toString();
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.getClassName());
            sb.append(".");
            sb.append(stackTraceElement.getMethodName());
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(")\n");
        }
        return sb.toString();
    }
}
