package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfi {
    private final String zza;
    private final String zzb = null;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzfc zze;

    public zzfi(zzfc zzfc, String str, String str2) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getString(this.zza, null);
        }
        return this.zzd;
    }

    public final void zza(String str) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putString(this.zza, str);
        edit.apply();
        this.zzd = str;
    }
}
