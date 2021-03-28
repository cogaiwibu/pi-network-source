package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzgy {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzae zzg;
    boolean zzh = true;
    Long zzi;

    public zzgy(Context context, zzae zzae, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzae != null) {
            this.zzg = zzae;
            this.zzb = zzae.zzf;
            this.zzc = zzae.zze;
            this.zzd = zzae.zzd;
            this.zzh = zzae.zzc;
            this.zzf = zzae.zzb;
            if (zzae.zzg != null) {
                this.zze = Boolean.valueOf(zzae.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
