package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zzl extends BaseImplementation.ApiMethodImpl<Result, zzr> {
    private final /* synthetic */ Account zzo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(zzh zzh, Api api, GoogleApiClient googleApiClient, Account account) {
        super(api, googleApiClient);
        this.zzo = account;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return new zzq(status);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzr zzr) throws RemoteException {
        ((zzc) zzr.getService()).zza(new zzm(this), this.zzo);
    }
}
