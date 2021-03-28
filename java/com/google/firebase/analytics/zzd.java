package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzia;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
final class zzd implements zzia {
    private final /* synthetic */ zzag zza;

    zzd(zzag zzag) {
        this.zza = zzag;
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(zzgw zzgw) {
        this.zza.zza(zzgw);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(zzgz zzgz) {
        this.zza.zza(zzgz);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zzb(zzgz zzgz) {
        this.zza.zzb(zzgz);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final String zza() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final String zzb() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final String zzc() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final String zzd() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zzb(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zzb(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final int zzc(String str) {
        return this.zza.zzd(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzia
    public final Object zza(int i) {
        return this.zza.zza(i);
    }
}
