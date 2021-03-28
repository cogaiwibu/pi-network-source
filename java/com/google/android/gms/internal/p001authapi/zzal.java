package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* renamed from: com.google.android.gms.internal.auth-api.zzal  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class zzal extends zzd implements zzai {
    zzal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    @Override // com.google.android.gms.internal.p001authapi.zzai
    public final void zzc(zzaa zzaa, BeginSignInRequest beginSignInRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzaa);
        zzf.zzc(zzc, beginSignInRequest);
        zzc(1, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzai
    public final void zzc(IStatusCallback iStatusCallback, String str) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, iStatusCallback);
        zzc.writeString(str);
        zzc(2, zzc);
    }

    @Override // com.google.android.gms.internal.p001authapi.zzai
    public final void zzc(zzae zzae, GetSignInIntentRequest getSignInIntentRequest) throws RemoteException {
        Parcel zzc = zzc();
        zzf.zzc(zzc, zzae);
        zzf.zzc(zzc, getSignInIntentRequest);
        zzc(3, zzc);
    }
}
