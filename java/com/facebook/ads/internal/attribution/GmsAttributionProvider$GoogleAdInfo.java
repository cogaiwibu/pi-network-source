package com.facebook.ads.internal.attribution;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Arrays;

public final class GmsAttributionProvider$GoogleAdInfo implements IInterface {
    public static byte[] A01;
    public static String[] A02;
    public IBinder A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "";
            strArr2[3] = "";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 80);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{11, 23, 21, -42, 15, 23, 23, 15, 20, 13, -42, 9, 22, 12, 26, 23, 17, 12, -42, 15, 21, 27, -42, 9, 12, 27, -42, 17, 12, 13, 22, 28, 17, 14, 17, 13, 26, -42, 17, 22, 28, 13, 26, 22, 9, 20, -42, -15, -23, 12, 30, 13, 26, 28, 17, 27, 17, 22, 15, -15, 12, -5, 13, 26, 30, 17, 11, 13};
    }

    public static void A02() {
        A02 = new String[]{"", "dlCQJjSx2v0yIAE7uR5", "YVJONne7N3U8xm", "", "eKTK4BSI8P33PVYq98zfXeBzSnXDY", "", "Oc9p6kWmaRe51UGQv0AehnzsYEIJ", "vamZVSY5oxMc9Fm9XA4FwhL"};
    }

    public GmsAttributionProvider$GoogleAdInfo(IBinder iBinder) {
        this.A00 = iBinder;
    }

    public final String A03() throws RemoteException {
        Parcel reply = Parcel.obtain();
        Parcel obtain = Parcel.obtain();
        try {
            reply.writeInterfaceToken(A00(0, 68, 88));
            this.A00.transact(1, reply, obtain, 0);
            obtain.readException();
            return obtain.readString();
        } finally {
            obtain.recycle();
            reply.recycle();
        }
    }

    public final boolean A04() throws RemoteException {
        Parcel reply = Parcel.obtain();
        Parcel obtain = Parcel.obtain();
        try {
            reply.writeInterfaceToken(A00(0, 68, 88));
            boolean z = true;
            reply.writeInt(1);
            this.A00.transact(2, reply, obtain, 0);
            obtain.readException();
            if (obtain.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain.recycle();
            reply.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.A00;
    }
}
