package com.facebook.login;

import android.app.Activity;
import android.content.Intent;

/* access modifiers changed from: package-private */
public interface StartActivityDelegate {
    Activity getActivityContext();

    void startActivityForResult(Intent intent, int i);
}
