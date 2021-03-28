package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzf;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzh implements zzj<Bundle> {
    private final /* synthetic */ Account zzo;

    zzh(Account account) {
        this.zzo = account;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Bundle zzb(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        return (Bundle) zzd.zza(zzf.zza(iBinder).zza(this.zzo));
    }
}
