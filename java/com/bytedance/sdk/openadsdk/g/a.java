package com.bytedance.sdk.openadsdk.g;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.g;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ActivityLifecycleListener */
public class a implements Application.ActivityLifecycleCallbacks {
    private AtomicInteger a = new AtomicInteger(0);

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityStarted:activity.name=");
        sb.append(activity != null ? activity.getComponentName() : null);
        l.c("ActivityLifecycleListener", sb.toString());
        if (this.a.incrementAndGet() > 0 && g.b() != null) {
            g.b().a(false);
            l.c("ActivityLifecycleListener", "onActivityStarted:AppIsBackground=" + g.b().c());
        }
    }

    public void onActivityStopped(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityStopped:activity.name=");
        sb.append(activity != null ? activity.getComponentName() : null);
        l.c("ActivityLifecycleListener", sb.toString());
        if (this.a.decrementAndGet() == 0 && g.b() != null) {
            g.b().a(true);
            l.c("ActivityLifecycleListener", "onActivityStopped:AppIsBackground=" + g.b().c());
        }
    }
}
