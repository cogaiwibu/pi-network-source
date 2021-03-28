package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzk extends zzn {
    private final /* synthetic */ zzj zzaf;

    zzk(zzj zzj) {
        this.zzaf = zzj;
    }

    @Override // com.google.android.gms.internal.auth.zzn, com.google.android.gms.auth.account.zza
    public final void zzc(Account account) {
        this.zzaf.setResult((Result) new zzo(account != null ? Status.RESULT_SUCCESS : zzh.zzad, account));
    }
}
