package com.facebook.react.devsupport;

import android.os.Build;

class WindowOverlayCompat {
    private static final int ANDROID_OREO = 26;
    private static final int TYPE_APPLICATION_OVERLAY = 2038;
    static final int TYPE_SYSTEM_ALERT;
    static final int TYPE_SYSTEM_OVERLAY;

    WindowOverlayCompat() {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = TYPE_APPLICATION_OVERLAY;
        TYPE_SYSTEM_ALERT = i < 26 ? 2003 : TYPE_APPLICATION_OVERLAY;
        if (Build.VERSION.SDK_INT < 26) {
            i2 = 2006;
        }
        TYPE_SYSTEM_OVERLAY = i2;
    }
}
