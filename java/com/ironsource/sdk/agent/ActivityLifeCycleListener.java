package com.ironsource.sdk.agent;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ironsource.sdk.utils.SDKUtils;

public class ActivityLifeCycleListener implements Application.ActivityLifecycleCallbacks {
    private OnPauseOnResumeHandler handler;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public ActivityLifeCycleListener(OnPauseOnResumeHandler onPauseOnResumeHandler) {
        this.handler = onPauseOnResumeHandler;
    }

    public void onActivityResumed(Activity activity) {
        if (!SDKUtils.isIronSourceActivity(activity)) {
            this.handler.handleOnResume(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (!SDKUtils.isIronSourceActivity(activity)) {
            this.handler.handleOnPause(activity);
        }
    }
}
