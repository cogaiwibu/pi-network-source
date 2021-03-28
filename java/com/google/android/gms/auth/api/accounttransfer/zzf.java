package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

final class zzf extends AccountTransferClient.zza<byte[]> {
    private final /* synthetic */ zze zzaq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(zze zze, AccountTransferClient.zzb zzb) {
        super(zzb);
        this.zzaq = zze;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(byte[] bArr) {
        this.zzaq.setResult(bArr);
    }
}
