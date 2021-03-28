package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public interface zae extends IInterface {
    void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException;

    void zaa(zai zai, zac zac) throws RemoteException;

    void zam(int i) throws RemoteException;
}
