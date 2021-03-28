package com.ss.android.crash.log;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.ironsource.sdk.constants.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ANRUtils */
public class e {
    public static void a(long j) {
        if (j > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("duration not be minus");
        }
    }

    public static JSONObject a() throws JSONException {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null || allStackTraces.size() <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", allStackTraces.size());
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        boolean z = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            int i2 = i + 1;
            if (((long) i2) > 5) {
                break;
            }
            JSONObject jSONObject2 = new JSONObject();
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] value = entry.getValue();
            for (StackTraceElement stackTraceElement : value) {
                if (sb.length() <= 15000) {
                    sb.append(stackTraceElement.toString());
                    sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                }
            }
            try {
                if (entry.getKey().getName().equalsIgnoreCase(Constants.ParametersKeys.MAIN)) {
                    jSONObject.put("mainStackFromTrace", sb.toString());
                    z = true;
                }
                jSONObject2.put("id", entry.getKey().getId());
                jSONObject2.put("name", entry.getKey().getName());
                jSONObject2.put("stack", sb.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject2);
            i = i2;
        }
        if (!z) {
            jSONObject.put("mainStackFromTrace", b());
        }
        jSONObject.put("allThreadStack", jSONArray);
        jSONObject.put("anrTime", System.currentTimeMillis());
        return jSONObject;
    }

    private static String b() {
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

    public static boolean a(Context context, String str) {
        ComponentName componentName;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (Build.VERSION.SDK_INT < 21) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !str.equals(componentName.getPackageName())) {
                        return false;
                    }
                    return true;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance == 100) {
                        return str.equals(runningAppProcessInfo.pkgList[0]);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
