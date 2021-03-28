package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzeo extends zzet<Map.Entry<K, V>> {
    private final /* synthetic */ zzem zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeo(zzem zzem) {
        super(zzem, null);
        this.zza = zzem;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzet
    public final /* synthetic */ Object zza(int i) {
        return new zzev(this.zza, i);
    }
}
