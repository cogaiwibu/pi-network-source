package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class zzdr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzdo zza;

    zzdr(zzdo zzdo) {
        this.zza = zzdo;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
