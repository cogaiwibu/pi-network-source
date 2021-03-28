package com.onesignal;

import android.os.Build;

/* access modifiers changed from: package-private */
public class OSInAppMessageControllerFactory {
    private static final Object LOCK = new Object();
    private OSInAppMessageController controller;

    OSInAppMessageControllerFactory() {
    }

    public OSInAppMessageController getController(OneSignalDbHelper oneSignalDbHelper) {
        if (this.controller == null) {
            synchronized (LOCK) {
                if (this.controller == null) {
                    if (Build.VERSION.SDK_INT <= 18) {
                        this.controller = new OSInAppMessageDummyController(null);
                    } else {
                        this.controller = new OSInAppMessageController(oneSignalDbHelper);
                    }
                }
            }
        }
        return this.controller;
    }
}
