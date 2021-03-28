package com.facebook.common.activitylistener;

public interface ListenableActivity {
    void addActivityListener(ActivityListener activityListener);

    void removeActivityListener(ActivityListener activityListener);
}
