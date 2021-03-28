package com.google.android.gms.common.config;

import com.google.android.gms.common.config.GservicesValue;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
final class zzc extends GservicesValue<Long> {
    zzc(String str, Long l) {
        super(str, l);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Long zzd(String str) {
        GservicesValue.zza zza = null;
        return zza.getLong(this.mKey, (Long) this.zzcc);
    }
}
