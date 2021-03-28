package com.facebook.common.activitylistener;

import android.app.Activity;

public class BaseActivityListener implements ActivityListener {
    @Override // com.facebook.common.activitylistener.ActivityListener
    public int getPriority() {
        return 1;
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onActivityCreate(Activity activity) {
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onDestroy(Activity activity) {
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onPause(Activity activity) {
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onResume(Activity activity) {
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onStart(Activity activity) {
    }

    @Override // com.facebook.common.activitylistener.ActivityListener
    public void onStop(Activity activity) {
    }
}
