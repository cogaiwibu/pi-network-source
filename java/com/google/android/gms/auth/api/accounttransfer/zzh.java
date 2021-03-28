package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

final class zzh extends AccountTransferClient.zza<DeviceMetaData> {
    private final /* synthetic */ zzg zzas;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzh(zzg zzg, AccountTransferClient.zzb zzb) {
        super(zzb);
        this.zzas = zzg;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(DeviceMetaData deviceMetaData) {
        this.zzas.setResult(deviceMetaData);
    }
}
