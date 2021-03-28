package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzf implements zzj<Void> {
    private final /* synthetic */ Bundle val$extras;
    private final /* synthetic */ String zzq;

    zzf(String str, Bundle bundle) {
        this.zzq = str;
        this.val$extras = bundle;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Void zzb(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzd.zza(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.zzq, this.val$extras));
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
