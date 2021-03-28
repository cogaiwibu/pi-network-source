package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zziy implements zzjg {
    private zzjg[] zza;

    zziy(zzjg... zzjgArr) {
        this.zza = zzjgArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean zza(Class<?> cls) {
        for (zzjg zzjg : this.zza) {
            if (zzjg.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final zzjh zzb(Class<?> cls) {
        zzjg[] zzjgArr = this.zza;
        for (zzjg zzjg : zzjgArr) {
            if (zzjg.zza(cls)) {
                return zzjg.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
