package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzan {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzap zze;
    private final String zzf;

    private zzan(zzfu zzfu, String str, String str2, String str3, long j, long j2, zzap zzap) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzap);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfu.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId, name", zzeq.zza(str2), zzeq.zza(str3));
        }
        this.zze = zzap;
    }

    zzan(zzfu zzfu, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzap zzap;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzfu.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId", zzeq.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzap = new zzap(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfu.zzq().zze().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzfu.zzh().zza(next, bundle2.get(next));
                    if (zza2 == null) {
                        zzfu.zzq().zzh().zza("Param value can't be null", zzfu.zzi().zzb(next));
                        it.remove();
                    } else {
                        zzfu.zzh().zza(bundle2, next, zza2);
                    }
                }
            }
            zzap = new zzap(bundle2);
        }
        this.zze = zzap;
    }

    /* access modifiers changed from: package-private */
    public final zzan zza(zzfu zzfu, long j) {
        return new zzan(zzfu, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
