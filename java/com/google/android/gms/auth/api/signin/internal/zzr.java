package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public interface zzr extends IInterface {
    void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void zze(Status status) throws RemoteException;

    void zzf(Status status) throws RemoteException;
}
