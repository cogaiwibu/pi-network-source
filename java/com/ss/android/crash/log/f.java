package com.ss.android.crash.log;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ActivityManager */
public class f {
    private Application a;
    private Context b;
    private List<String> c = new ArrayList();
    private List<String> d = new ArrayList();
    private String e;
    private String f;
    private a g;
    private final Application.ActivityLifecycleCallbacks h = new Application.ActivityLifecycleCallbacks() {
        /* class com.ss.android.crash.log.f.AnonymousClass1 */

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            f.this.c.add(name);
            f fVar = f.this;
            fVar.e = name + "(" + String.valueOf(System.currentTimeMillis()) + ")";
        }

        public void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            f fVar = f.this;
            fVar.f = name + "(" + String.valueOf(System.currentTimeMillis()) + ")";
            if (f.this.g != null) {
                f.this.g.a();
            }
        }

        public void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            f.this.c.remove(name);
            f.this.d.add(name);
        }
    };

    /* compiled from: ActivityManager */
    public interface a {
        void a();
    }

    f(Context context, a aVar) {
        this.a = (Application) context.getApplicationContext();
        this.b = context.getApplicationContext();
        this.g = aVar;
        e();
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.a.registerActivityLifecycleCallbacks(this.h);
        }
    }

    public String a() {
        List<String> list = this.c;
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (String str : this.c) {
                    if (i < this.c.size() - 1) {
                        sb.append(str);
                        sb.append("|");
                    } else {
                        sb.append(str);
                    }
                    i++;
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        Context context = this.b;
        if (context == null) {
            return "";
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(5);
            if (runningTasks == null) {
                return "";
            }
            String packageName = this.b.getPackageName();
            StringBuilder sb = new StringBuilder();
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (!(runningTaskInfo == null || runningTaskInfo.baseActivity == null)) {
                    if (packageName.equals(runningTaskInfo.baseActivity.getPackageName())) {
                        sb.append("id = ");
                        sb.append(runningTaskInfo.id);
                        sb.append(" ");
                        sb.append("description = ");
                        sb.append(runningTaskInfo.description);
                        sb.append(" ");
                        sb.append("number_of_activities = ");
                        sb.append(runningTaskInfo.numActivities);
                        sb.append(" ");
                        sb.append("number_of_running_activities = ");
                        sb.append(runningTaskInfo.numRunning);
                        sb.append(" ");
                        sb.append("topActivity = ");
                        sb.append(runningTaskInfo.topActivity.toString());
                        sb.append(" ");
                        sb.append("baseActivity = ");
                        sb.append(runningTaskInfo.baseActivity.toString());
                        return sb.toString();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
        }
    }
}
