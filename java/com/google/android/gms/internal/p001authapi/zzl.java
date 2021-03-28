package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzl  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
final class zzl extends zzh {
    private final /* synthetic */ zzi zzap;

    zzl(zzi zzi) {
        this.zzap = zzi;
    }

    @Override // com.google.android.gms.internal.p001authapi.zzh, com.google.android.gms.internal.p001authapi.zzv
    public final void zzc(Status status, Credential credential) {
        this.zzap.setResult((Result) new zzg(status, credential));
    }

    @Override // com.google.android.gms.internal.p001authapi.zzh, com.google.android.gms.internal.p001authapi.zzv
    public final void zzd(Status status) {
        this.zzap.setResult((Result) zzg.zzc(status));
    }
}
