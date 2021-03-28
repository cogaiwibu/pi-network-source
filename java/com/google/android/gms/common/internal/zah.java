package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zah extends zab implements ISignInButtonCreator {
    zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, iObjectWrapper);
        zaa.writeInt(i);
        zaa.writeInt(i2);
        Parcel zaa2 = zaa(1, zaa);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zaa2.readStrongBinder());
        zaa2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, iObjectWrapper);
        zad.zaa(zaa, signInButtonConfig);
        Parcel zaa2 = zaa(2, zaa);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zaa2.readStrongBinder());
        zaa2.recycle();
        return asInterface;
    }
}
