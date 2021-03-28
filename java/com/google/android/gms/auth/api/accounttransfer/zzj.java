package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzz;

final class zzj extends AccountTransferClient.zzc {
    private final /* synthetic */ zzab zzau;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzj(AccountTransferClient accountTransferClient, zzab zzab) {
        super(null);
        this.zzau = zzab;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb
    public final void zza(zzz zzz) throws RemoteException {
        zzz.zza(this.zzax, this.zzau);
    }
}
