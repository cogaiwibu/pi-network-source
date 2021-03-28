package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cloudmessaging.IMessengerCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzq();
    private Messenger zzad;
    private zzl zzcd;

    public MessengerCompat(IBinder iBinder) {
        zzl zzl;
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzad = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzl = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMessengerCompat.DESCRIPTOR);
            if (queryLocalInterface instanceof zzl) {
                zzl = (zzl) queryLocalInterface;
            } else {
                zzl = new zzm(iBinder);
            }
        }
        this.zzcd = zzl;
    }

    public int describeContents() {
        return 0;
    }

    public final void send(Message message) throws RemoteException {
        Messenger messenger = this.zzad;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzcd.send(message);
        }
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzad;
        return messenger != null ? messenger.getBinder() : this.zzcd.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzad;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzcd.asBinder());
        }
    }
}
