package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zzv  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public interface zzv extends IInterface {
    void zzc(Status status, Credential credential) throws RemoteException;

    void zzc(Status status, String str) throws RemoteException;

    void zzd(Status status) throws RemoteException;
}
