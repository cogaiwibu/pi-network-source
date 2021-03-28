package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzs;

/* access modifiers changed from: package-private */
public final class zzk extends zzs {
    private final /* synthetic */ AccountTransferClient.zzc zzay;

    zzk(AccountTransferClient.zzc zzc) {
        this.zzay = zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zzd() {
        this.zzay.setResult(null);
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void onFailure(Status status) {
        this.zzay.zza(status);
    }
}
