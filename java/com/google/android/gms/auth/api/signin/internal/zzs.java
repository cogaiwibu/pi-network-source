package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p001authapi.zzc;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public abstract class zzs extends zzc implements zzp {
    public zzs() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p001authapi.zzc
    public final boolean zzc(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzp();
        } else if (i != 2) {
            return false;
        } else {
            zzq();
        }
        return true;
    }
}
