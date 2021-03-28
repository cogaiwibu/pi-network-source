package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzhz implements zzjg {
    private static final zzhz zza = new zzhz();

    private zzhz() {
    }

    public static zzhz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean zza(Class<?> cls) {
        return zzhy.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final zzjh zzb(Class<?> cls) {
        if (!zzhy.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzjh) zzhy.zza(cls.asSubclass(zzhy.class)).zza(zzhy.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
