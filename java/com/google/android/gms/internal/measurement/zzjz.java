package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzjz implements zzjh {
    private final zzjj zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzjz(zzjj zzjj, String str, Object[] objArr) {
        this.zza = zzjj;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.zzd = i | (charAt2 << i2);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final zzjj zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzju.zza : zzju.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzjh
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
