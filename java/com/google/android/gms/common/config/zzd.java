package com.google.android.gms.common.config;

import com.google.android.gms.common.config.GservicesValue;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
final class zzd extends GservicesValue<String> {
    zzd(String str, String str2) {
        super(str, str2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ String zzd(String str) {
        GservicesValue.zza zza = null;
        return zza.getString(this.mKey, (String) this.zzcc);
    }
}
