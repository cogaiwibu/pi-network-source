package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

final class zzo implements WorkAccountApi.AddAccountResult {
    private final Status mStatus;
    private final Account zzk;

    public zzo(Status status, Account account) {
        this.mStatus = status;
        this.zzk = account;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult
    public final Account getAccount() {
        return this.zzk;
    }
}
