package com.onesignal;

import android.os.Build;

/* compiled from: BundleCompat */
class BundleCompatFactory {
    BundleCompatFactory() {
    }

    static BundleCompat getInstance() {
        if (Build.VERSION.SDK_INT >= 22) {
            return new BundleCompatPersistableBundle();
        }
        return new BundleCompatBundle();
    }
}
