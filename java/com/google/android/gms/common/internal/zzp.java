package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public final class zzp {
    private static Object sLock = new Object();
    private static boolean zzez;
    private static String zzfa;
    private static int zzfb;

    public static String zzc(Context context) {
        zze(context);
        return zzfa;
    }

    public static int zzd(Context context) {
        zze(context);
        return zzfb;
    }

    private static void zze(Context context) {
        synchronized (sLock) {
            if (!zzez) {
                zzez = true;
                try {
                    Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzfa = bundle.getString("com.google.app.id");
                        zzfb = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
