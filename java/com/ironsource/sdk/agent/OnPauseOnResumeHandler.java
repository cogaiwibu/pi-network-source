package com.ironsource.sdk.agent;

import android.app.Activity;

public interface OnPauseOnResumeHandler {
    void handleOnPause(Activity activity);

    void handleOnResume(Activity activity);
}
