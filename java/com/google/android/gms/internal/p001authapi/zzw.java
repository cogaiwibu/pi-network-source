package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zzw  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class zzw extends zzd implements zzx {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzv, CredentialRequest credentialRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzv);
        zzf.zzc(zzc, credentialRequest);
        zzc(1, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzv, zzz zzz) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzv);
        zzf.zzc(zzc, zzz);
        zzc(2, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzv, zzt zzt) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzv);
        zzf.zzc(zzc, zzt);
        zzc(3, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzx
    public final void zzc(zzv zzv) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzv);
        zzc(4, zzc);
    }
}
