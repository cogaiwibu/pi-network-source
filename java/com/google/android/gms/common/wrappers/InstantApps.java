package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class InstantApps {
    private static Context zzim;
    private static Boolean zzin;

    public static synchronized boolean isInstantApp(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzim == null || zzin == null || zzim != applicationContext) {
                zzin = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzin = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzin = true;
                    } catch (ClassNotFoundException unused) {
                        zzin = false;
                    }
                }
                zzim = applicationContext;
                return zzin.booleanValue();
            }
            return zzin.booleanValue();
        }
    }
}
