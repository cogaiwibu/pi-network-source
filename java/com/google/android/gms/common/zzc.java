package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

/* access modifiers changed from: package-private */
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public final class zzc {
    private static Context zzaa;
    private static volatile zzn zzy;
    private static final Object zzz = new Object();

    static synchronized void zza(Context context) {
        synchronized (zzc.class) {
            if (zzaa != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzaa = context.getApplicationContext();
            }
        }
    }

    static zzl zza(String str, zzd zzd, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzb(str, zzd, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzl zzb(String str, zzd zzd, boolean z, boolean z2) {
        try {
            if (zzy == null) {
                Preconditions.checkNotNull(zzaa);
                synchronized (zzz) {
                    if (zzy == null) {
                        zzy = zzm.zzc(DynamiteModule.load(zzaa, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(zzaa);
            try {
                if (zzy.zza(new zzj(str, zzd, z, z2), ObjectWrapper.wrap(zzaa.getPackageManager()))) {
                    return zzl.zze();
                }
                return zzl.zza(new zze(z, str, zzd));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzl.zza("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return zzl.zza(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }

    static final /* synthetic */ String zza(boolean z, String str, zzd zzd) throws Exception {
        boolean z2 = true;
        if (z || !zzb(str, zzd, true, false).zzap) {
            z2 = false;
        }
        return zzl.zzc(str, zzd, z, z2);
    }
}
