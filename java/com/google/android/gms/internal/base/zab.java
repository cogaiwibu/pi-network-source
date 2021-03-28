package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class zab implements IInterface {
    private final IBinder zab;
    private final String zac;

    protected zab(IBinder iBinder, String str) {
        this.zab = iBinder;
        this.zac = str;
    }

    public IBinder asBinder() {
        return this.zab;
    }

    /* access modifiers changed from: protected */
    public final Parcel zaa() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zac);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel zaa(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.zab.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zab(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zab.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zac(int i, Parcel parcel) throws RemoteException {
        try {
            this.zab.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
