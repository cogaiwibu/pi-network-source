package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzko implements zzky {
    final /* synthetic */ zzkl zza;

    zzko(zzkl zzkl) {
        this.zza = zzkl;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzk.zzq().zze().zza("AppId not known when logging error event");
        } else {
            this.zza.zzp().zza(new zzkq(this, str, bundle));
        }
    }
}
