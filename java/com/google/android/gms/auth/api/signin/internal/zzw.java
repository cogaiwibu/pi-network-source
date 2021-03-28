package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p001authapi.zzd;
import com.google.android.gms.internal.p001authapi.zzf;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class zzw extends zzd implements zzt {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzc(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzr);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(101, zzc);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzd(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzr);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(102, zzc);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zze(zzr zzr, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzr);
        zzf.zzc(zzc, googleSignInOptions);
        zzc(103, zzc);
    }
}
